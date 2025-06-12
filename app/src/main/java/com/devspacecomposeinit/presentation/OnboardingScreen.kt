package com.devspacecomposeinit.presentation

import android.annotation.SuppressLint
import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.devspacecomposeinit.R
import com.devspacecomposeinit.core.Routes
import com.devspacecomposeinit.ui.theme.Purple40
import com.devspacecomposeinit.ui.theme.Purple80
import com.devspacecomposeinit.ui.theme.radius_large

@SuppressLint("SuspiciousIndentation")
@Composable
fun OnboardingScreen(
    navController: NavController
){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.artistanimation))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp))
            {
                LottieAnimation(
                    composition = composition,
                    progress = progress,
                    modifier = Modifier.size(480.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate(Routes.HOME) },
                    colors = ButtonDefaults.buttonColors(containerColor = Purple40),
                    shape = RoundedCornerShape(radius_large),
                    modifier = Modifier.fillMaxWidth())
                {
                Text(
                    text = "Continuar")
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    val navController = rememberNavController()
    OnboardingScreen(navController)
}