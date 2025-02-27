//package com.example.jetpackcomposeexample.instagram.ui
//
//import android.app.Activity
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.WindowInsets
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.safeContentPadding
//import androidx.compose.foundation.layout.safeDrawing
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.Divider
//import androidx.compose.material.Icon
//import androidx.compose.material.IconButton
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.livedata.observeAsState
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.jetpackcomposeexample.R
//
//@Composable
//fun LoginScreen(loginViewModel: LoginViewModel) {
//    val insets = WindowInsets.safeDrawing
//
//    Box(
//        Modifier
//            .fillMaxSize().safeContentPadding().padding(start =  16.dp, end = 16.dp)
//
//
//    ) {
//        Header(Modifier.align(Alignment.TopEnd))
//        Body(Modifier.align(Alignment.Center), loginViewModel)
//        Footer(Modifier.align(Alignment.BottomCenter))
//    }
//}
//
//@Composable
//fun Footer(modifier: Modifier) {
//    Column(modifier = modifier.fillMaxWidth()) {
//        Divider(
//            Modifier
//                .background(Color(0xFFF9F9F9))
//                .height(1.dp)
//                .fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.size(24.dp))
//        SignUp()
//        Spacer(modifier = Modifier.size(24.dp))
//    }
//}
//
//@Composable
//fun SignUp() {
//    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//        Text(
//            text = "Don't have an account?", fontSize = 12.sp, color = Color(0xFFB5B5B5)
//        )
//        Text(
//            text = "Sign up.",
//            Modifier.padding(horizontal = 8.dp),
//            fontSize = 12.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFF4EA8E9),
//        )
//    }
//}
//
//@Composable
//fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
//    val email:String by loginViewModel.email.observeAsState(initial = "")
//    val password:String by loginViewModel.password.observeAsState(initial = "")
//    val isLoginEnable:Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)
//
//    Column(modifier = modifier) {
//        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
//        Spacer(modifier = Modifier.size(16.dp))
//        Email(email) {
//            loginViewModel.onLoginChanged(email = it, password = password)
//        }
//        Spacer(modifier = Modifier.size(4.dp))
//        Password(password) {
//            loginViewModel.onLoginChanged(email = email, password = it)
//        }
//        Spacer(modifier = Modifier.size(8.dp))
//        ForgotPassword(Modifier.align(Alignment.End))
//        Spacer(modifier = Modifier.size(16.dp))
//        LoginButton(isLoginEnable)
//        Spacer(modifier = Modifier.size(16.dp))
//        LoginDivider()
//        Spacer(modifier = Modifier.size(32.dp))
//        SocialLogin()
//    }
//}
//
//@Composable
//fun SocialLogin() {
//    Row(
//        Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.fb),
//            contentDescription = "Social login fb",
//            modifier = Modifier.size(16.dp)
//        )
//        Text(
//            text = "Continue as Aris",
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(horizontal = 8.dp),
//            color = Color(0xFF4EA8E9)
//        )
//    }
//}
//
//@Composable
//fun LoginDivider() {
//    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//        Divider(
//            Modifier
//                .background(Color(0xFFF9F9F9))
//                .height(1.dp)
//                .weight(1f)
//        )
//        Text(
//            text = "OR",
//            modifier = Modifier.padding(horizontal = 18.dp),
//            fontSize = 12.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color(0xFFB5B5B5)
//        )
//        Divider(
//            Modifier
//                .background(Color(0xFFF9F9F9))
//                .height(1.dp)
//                .weight(1f)
//        )
//    }
//}
//
//@Composable
//fun LoginButton(loginEnable: Boolean) {
//    Button(
//        onClick = { },
//        enabled = loginEnable,
//        modifier = Modifier.fillMaxWidth(),
//        colors = ButtonDefaults.buttonColors(
//            contentColor = Color.White,
//            containerColor = Color(0xFF4EA8E9),
//            disabledContentColor = Color.White,
//            disabledContainerColor = Color(0xFF78C8F9)
//        )
//    ) {
//        Text(text = "Log In")
//    }
//}
//
//@Composable
//fun ForgotPassword(modifier: Modifier) {
//    Text(
//        text = "Forgot password?",
//        fontSize = 12.sp,
//        fontWeight = FontWeight.Bold,
//        color = Color(0xFF4EA8E9),
//        modifier = modifier
//    )
//}
//
//@Composable
//fun Password(password: String, onTextChanged: (String) -> Unit) {
//    var passwordVisibility by remember { mutableStateOf(false) }
//    TextField(
//        value = password,
//        onValueChange = { onTextChanged(it) },
//        modifier = Modifier.fillMaxWidth(),
//        placeholder = { Text("Password") },
//        colors = TextFieldDefaults.colors(
//
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        ),
//        singleLine = true,
//        maxLines = 1,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//        trailingIcon = {
//            val imagen = if (passwordVisibility) {
//                Icons.Filled.Close
//            } else {
//                Icons.Filled.Email
//            }
//            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
//                Icon(imageVector = imagen, contentDescription = "show password")
//            }
//        },
//        visualTransformation = if (passwordVisibility) {
//            VisualTransformation.None
//        } else {
//            PasswordVisualTransformation()
//        }
//    )
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Email(email: String, onTextChanged: (String) -> Unit) {
//    TextField(
//        value = email,
//        onValueChange = { onTextChanged(it) },
//        modifier = Modifier.fillMaxWidth(),
//        placeholder = { Text(text = "Email") },
//        maxLines = 1,
//        singleLine = true,
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//        colors = TextFieldDefaults.colors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent
//        )
//    )
//}
//
//@Composable
//fun ImageLogo(modifier: Modifier) {
//    Image(
//        painter = painterResource(id = R.drawable.insta),
//        contentDescription = "logo",
//        modifier = modifier
//    )
//}
//
//@Composable
//fun Header(modifier: Modifier) {
//    val activity = LocalContext.current as Activity
//    Icon(
//        imageVector = Icons.Default.Close,
//        contentDescription = "close app",
//        modifier = modifier.clickable { activity.finish() })
//}