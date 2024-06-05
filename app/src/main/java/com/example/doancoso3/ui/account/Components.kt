package com.example.doancoso3.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BackButton(
    icon: ImageVector,
    iconDescription: String?,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.White, CircleShape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription
        )
    }
}

@Composable
fun TitleSection(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier.padding(start = 4.dp)
    ) {
        Text(
            text = title,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(text = description, color = MaterialTheme.colorScheme.primary, fontSize = 16.sp)
    }
}



@Composable
fun ContinueButtonSection(
    text: String,
    icon: ImageVector,
    iconDescription: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )
        Surface(
            color = MaterialTheme.colorScheme.primary,
            shape = CircleShape,
//            elevation = 8.dp
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = iconDescription,
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun RedirectSection(
    text: String,
    isForgotPassword: Boolean = false,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable(onClick = onClick)
        )
        if (isForgotPassword) {
            Text(text = "Forget password?", fontSize = 16.sp)
        }
    }
}