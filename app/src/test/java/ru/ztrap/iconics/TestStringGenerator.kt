package ru.ztrap.iconics

import com.mikepenz.google_material_typeface_library.GoogleMaterial
import org.junit.Ignore

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import ru.ztrap.iconics.IconicsStringGenerator.FileCreationStrategy.SAVE_ONLY_CURRENT

/**
 * @author pa.gulko zTrap (29.03.2018)
 */
@Ignore
@RunWith(JUnit4::class)
class TestStringGenerator : IconicsStringGenerator() {

    @Test fun generateGoogleMaterial() {
        generateIconsFrom(GoogleMaterial())
    }

    override val fileCreationStrategy: FileCreationStrategy get() = SAVE_ONLY_CURRENT

    override val modifierCurrent: String get() = ""
}
