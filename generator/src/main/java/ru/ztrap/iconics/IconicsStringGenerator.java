package ru.ztrap.iconics;

import com.mikepenz.iconics.typeface.ITypeface;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * @author pa.gulko zTrap (29.03.2018)
 */
public class IconicsStringGenerator {
    protected static final Pattern UPPERCASE_PATTERN = Pattern.compile("(?=\\p{Lu})");
    protected static final String WORD_DELIMITER = "_";
    protected static final String XML = "xml";

    /**
     * @return modifier for mark file as current-version file
     * */
    protected String modifierCurrent() {
        return "_current_";
    }

    /**
     * @return directory path for generated .xml file
     * */
    protected String outputDirectory() {
        return "src" + File.separator + "main" + File.separator + "res" + File.separator + "values";
    }

    /**
     * Magic live here
     * */
    protected void generateIconsFrom(ITypeface typeface) throws ParserConfigurationException, TransformerException {
        final String handledClassName = handleWords(typeface.getFontName()) + "_v";

        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        Element resources = doc.createElement("resources");
        doc.appendChild(resources);

        for (String icon : typeface.getIcons()) {
            Element iconElement = doc.createElement("string");
            iconElement.setAttribute("name", icon);
            iconElement.setTextContent(icon);
            resources.appendChild(iconElement);
        }

        String fileName = handledClassName + typeface.getVersion() + "." + XML;

        //region renaming old file
        File fontDirectory = new File(outputDirectory());
        File[] files = fontDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().matches(
                        modifierCurrent()
                                + handledClassName
                                + ".+\\."
                                + XML
                );
            }
        });

        if (files != null && files.length > 0){
            File current = files[0];
            File renamed = new File(fontDirectory, current.getName().replace(modifierCurrent(), ""));
            if (!current.renameTo(renamed)) {
                throw new IllegalArgumentException(String.format(
                        "Unable to rename file from %1$s to %2$s. Probably file %2$s is already exist.",
                        current.getName(), renamed.getName()));
            }
        }
        //endregion

        File newFile = new File(fontDirectory, modifierCurrent() + fileName);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        transformer.transform(new DOMSource(doc), new StreamResult(newFile));
    }

    protected String handleWords(String fieldName) {
        fieldName = fieldName.replace(" ", "");
        String[] words = UPPERCASE_PATTERN.split(fieldName);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(WORD_DELIMITER);
            }
            sb.append(word.toLowerCase());
        }
        return sb.toString();
    }
}