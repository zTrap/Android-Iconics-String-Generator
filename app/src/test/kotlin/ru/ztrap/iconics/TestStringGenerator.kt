package ru.ztrap.iconics

import com.mikepenz.iconics.typeface.library.googlematerial.GoogleMaterial
import org.junit.Ignore

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import ru.ztrap.iconics.IconicsStringGenerator.FileCreationStrategy.SAVE_OLD

/**
 * @author pa.gulko zTrap (29.03.2018)
 */
@RunWith(JUnit4::class)
class TestStringGenerator : IconicsStringGenerator() {

    @Test fun generateGoogleMaterial() {
        GoogleMaterial.generateIcons()
    }

    override val fileCreationStrategy: FileCreationStrategy = SAVE_OLD
}
