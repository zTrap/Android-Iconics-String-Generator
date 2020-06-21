# Android-Iconics String Generator
Icons fields generator for [Android-Iconics Library](https://github.com/mikepenz/Android-Iconics)

[ ![Download](https://api.bintray.com/packages/ztrap/maven/string-generator/images/download.svg) ](https://bintray.com/ztrap/maven/string-generator/_latestVersion)

## Install

```gradle
testImplementation 'junit:junit:4.12' // required
testImplementation 'ru.ztrap.iconics:string-generator:1.0.8'
```

## Compatibility

`string-generator v1.0.5` compatible with `iconics v3.2.x`

`string-generator v1.0.7` compatible with `iconics v4.x.x`

`string-generator v1.0.8` compatible with `iconics v5.x.x`

## Usage

1. Create some test-class in `test` directory

```kotlin
@RunWith(JUnit4::class)
class TestStringGenerator
```

2. Make it extends from `IconicsStringGenerator`

```kotlin
@RunWith(JUnit4::class)
class TestStringGenerator : IconicsStringGenerator
```

3. Override field for definition file creation strategy

```kotlin
@RunWith(JUnit4::class)
class TestStringGenerator : IconicsStringGenerator {
    override val fileCreationStrategy: FileCreationStrategy 
        get() = FileCreationStrategy.SAVE_ONLY_CURRENT // or FileCreationStrategy.SAVE_OLD
}
```

4. Create `@Test`-method which will generate fields from your font

```kotlin
@RunWith(JUnit4::class)
class TestStringGenerator : IconicsStringGenerator {
    
    @Test fun generateGoogleMaterial() {
        generateIconsFrom(GoogleMaterial) // or GoogleMaterial.generateIcons()
    }

    override val fileCreationStrategy: FileCreationStrategy 
        get() = FileCreationStrategy.SAVE_ONLY_CURRENT
}
```

5. Run test

## Optional settings

You can override this fields as you need:

```kotlin
/** @return modifier for mark file as current-version file */
protected open val modifierCurrent: String get() =  "_current_"

/** @return modifier for mark file as old-version file */
protected open val modifierOld: String get() =  "_old_"

/** @return directory path for generated .xml file */
protected open val outputDirectory: String
    get() = "src${File.separator}main${File.separator}res${File.separator}values"
```

## Developed By

 - Peter Gulko
 - ztrap.developer@gmail.com
 - [paypal.me/zTrap](https://www.paypal.me/zTrap)

## License

       Copyright 2018-2020 zTrap

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
