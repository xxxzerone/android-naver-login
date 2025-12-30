package com.example.naverlogin.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.naverlogin.R
import com.example.naverlogin.R.*

@Composable
fun LoginButton(
    backgroundColor: Color,
    iconResId: Int?,
    contentDescription: String,
    buttonText: String,
    textColor: Color,
    onClick: () -> Unit = {},
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(color = backgroundColor)
            .fillMaxWidth(),
    ) {
        iconResId?.let {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = contentDescription,
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = buttonText,
            color = textColor
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginButtonPreview() {
    val naverBackground = Color(0xFF03A94D)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LoginButton(
            backgroundColor = naverBackground,
            iconResId = drawable.ico_naver_18x18,
            contentDescription = stringResource(string.login_naver),
            buttonText = stringResource(string.login_naver),
            textColor = Color.White
        )
    }
}