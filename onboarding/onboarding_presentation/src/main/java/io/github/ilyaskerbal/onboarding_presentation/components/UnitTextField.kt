package io.github.ilyaskerbal.onboarding_presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import io.github.ilyaskerbal.core_ui.LocalSpacing
import io.github.ilyaskerbal.core_ui.theme.CaloryTrackerTheme

@Composable
fun UnitTextField(
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colors.primaryVariant,
        fontSize = 70.sp
    )
){
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline),
            textStyle = textStyle
        )
        Spacer(
            modifier = Modifier.width(spacing.spaceSmall)
        )
        Text(
            text = unit,
            modifier = Modifier.alignBy(LastBaseline)
        )
    }
}

@Preview(name = "Age preview")
@Composable
private fun PreviewUnitTextFieldAge() {
    CaloryTrackerTheme {
        UnitTextField(value = "27", onValueChange = {}, unit = "Years")
    }
}

@Preview(name = "Height preview")
@Composable
private fun PreviewUnitTextFieldHeight() {
    CaloryTrackerTheme {
        UnitTextField(value = "180", onValueChange = {}, unit = "Cm")
    }
}