package io.github.ilyaskerbal.onboarding_presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.core_ui.theme.CaloryTrackerTheme

@Composable
fun SelectableButton(
    text: String,
    isSelected: Boolean,
    color: Color,
    selectedTextColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.button.copy(
        fontWeight = FontWeight.Normal
    )
) {
    val roundedCornerShape = RoundedCornerShape(100.dp)
    Box(
        modifier = modifier
            .clip(roundedCornerShape)
            .border(2.dp, color, shape = roundedCornerShape)
            .background(
                color = if (isSelected) color else Color.Transparent,
                shape = roundedCornerShape
            )
            .clickable { onClick() }
            .padding(LocalSpacing.current.spaceMedium)
    ){
        Text(
            text = text,
            style = textStyle,
            color = if (isSelected) selectedTextColor else color
        )
    }
}

@Preview(name = "Button not selected")
@Composable
private fun PreviewSelectableButtonNotSelected() {
    CaloryTrackerTheme {
        SelectableButton(
            text = "Not Selected",
            isSelected = false,
            color = MaterialTheme.colors.primaryVariant,
            selectedTextColor = Color.White,
            onClick = { /*TODO*/ })
    }
}

@Preview(name = "Button selected")
@Composable
private fun PreviewSelectableButtonSelected() {
    CaloryTrackerTheme {
        SelectableButton(
            text = "Selected ✅",
            isSelected = true,
            color = MaterialTheme.colors.primaryVariant,
            selectedTextColor = Color.White,
            onClick = { /*TODO*/ })
    }
}