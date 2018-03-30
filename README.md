# Android-Iconics-String-Generator
Icons fields generator for [Android-Iconics Library](https://github.com/mikepenz/Android-Iconics)

[ ![Download](https://api.bintray.com/packages/ztrap/maven/string-generator/images/download.svg) ](https://bintray.com/ztrap/maven/string-generator/_latestVersion)

## Install

```groove
testImplementation 'junit:junit:4.12' // required
testImplementation 'ru.ztrap.iconics:string-generator:1.0.2'
```

## Usage

1. Create some test-class in `test` directory

```java
@RunWith(JUnit4.class)
public class TestStringGenerator {
}
```

2. Make this extends from `IconicsStringGenerator`

```java
@RunWith(JUnit4.class)
public class TestStringGenerator extends IconicsStringGenerator {
}
```

3. Implement method for definition file creation strategy

```java
@RunWith(JUnit4.class)
public class TestStringGenerator extends IconicsStringGenerator {
    @Override
    protected FileCreationStrategy fileCreationStrategy() {
        return FileCreationStrategy.SAVE_ONLY_CURRENT; // or FileCreationStrategy.SAVE_OLD
    }
}
```

4. Create `@Test`-method wich will generate fields from your font

```java
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
```

5. Run test

## Optional settings

You can override this methods as you need:

```java
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
```

## Developed By

 - Peter Gulko
 - contacts@ztrap.ru
 - [paypal.me/zTrap](https://www.paypal.me/zTrap)

## License

       Copyright 2018 zTrap

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
