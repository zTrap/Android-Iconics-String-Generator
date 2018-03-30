package ru.ztrap.iconics;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * @author pa.gulko zTrap (29.03.2018)
 */
@RunWith(JUnit4.class)
public class TestStringGenerator extends IconicsStringGenerator {

    @Test
    public void generateGoogleMaterial() throws TransformerException, ParserConfigurationException {
        generateIconsFrom(new GoogleMaterial());
    }

    @Override
    protected FileCreationStrategy fileCreationStrategy() {
        return FileCreationStrategy.SAVE_ONLY_CURRENT;
    }
}
