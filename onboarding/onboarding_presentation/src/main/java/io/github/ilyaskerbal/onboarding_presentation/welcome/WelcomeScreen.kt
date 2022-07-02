package io.github.ilyaskerbal.onboarding_presentation.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import io.github.ilyaskerbal.core.R
import io.github.ilyaskerbal.core.navigation.Route
import io.github.ilyaskerbal.core.util.UIEvent
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.onboarding_presentation.components.ActionButton

@Composable
fun WelcomeScreen(
    onNavigate: (UIEvent.Navigate) -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNavigate(UIEvent.Navigate(Route.AGE)) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}