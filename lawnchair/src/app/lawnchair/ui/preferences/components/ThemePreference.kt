package app.lawnchair.ui.preferences.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import app.lawnchair.preferences.getAdapter
import app.lawnchair.preferences.preferenceManager
import com.android.launcher3.R
import com.android.launcher3.Utilities

object ThemeChoice {
    const val LIGHT = "light"
    const val DARK = "dark"
    const val SYSTEM = "system"
}

val themeEntries = listOf(
    ListPreferenceEntry(ThemeChoice.LIGHT) { stringResource(id = R.string.theme_light) },
    ListPreferenceEntry(ThemeChoice.DARK) { stringResource(id = R.string.theme_dark) },
    ListPreferenceEntry(ThemeChoice.SYSTEM) {
        stringResource(id = if (Utilities.ATLEAST_Q) R.string.theme_system_default else R.string.theme_follow_wallpaper)
    }
)

@ExperimentalMaterialApi
@Composable
fun ThemePreference(showDivider: Boolean = false) {
    ListPreference(
        adapter = preferenceManager().launcherTheme.getAdapter(),
        entries = themeEntries,
        label = stringResource(id = R.string.theme_label),
        showDivider = showDivider
    )
}
