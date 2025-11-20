package id.antasari.p7_modern_ui_230104040122.ui.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.antasari.p7_modern_ui_230104040122.R
// Import kotlinx.coroutines.delay dihilangkan karena tidak digunakan
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

// -------------------------------------------------------------
// KONSTANTA WARNA SPOTIFY
// -------------------------------------------------------------
private val AppGreen = Color(0xFF1DB954)         // Hijau Spotify (Aksen Utama)
private val DarkGreen = Color(0xFF138A3D)        // Hijau lebih gelap (Untuk Gradien)
private val LightGreen = Color(0xFF81C784)       // Hijau lebih terang (Untuk Pola/Pesan)
private val White = Color(0xFFFFFFFF)
private val Black = Color(0xFF000000)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {}
) {
    // ---------------- PERUBAHAN UTAMA: Langsung panggil konten Login ----------------
    AppLoginContent(onLoginSuccess)
}

// ---------------------------------------------------------------------
// 1. KONTEN LOGIN UTAMA (Form Kartu Putih + Header Hijau)
// ---------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLoginContent(onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            // Menggunakan Gradien Hijau
            .background(Brush.verticalGradient(listOf(AppGreen, DarkGreen)))
            .systemBarsPadding()
    ) {

        // --- Header (Pola/Pesan di area Hijau) ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.TopCenter)
        ) {
            // Ikon Header di kiri atas
            Icon(
                Icons.Default.MusicNote,
                contentDescription = "App Logo",
                modifier = Modifier
                    .padding(24.dp)
                    .size(48.dp)
                    .align(Alignment.TopStart),
                tint = White
            )

            Column(
                modifier = Modifier.align(Alignment.BottomStart).padding(24.dp)
            ) {
                Text(
                    "Selamat Datang Kembali",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = White,
                )
                Text(
                    "Masuk untuk melanjutkan",
                    fontSize = 18.sp,
                    color = White.copy(alpha = 0.8f),
                )
            }
        }

        // --- Konten Login (White Card) ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(White)
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .verticalScroll(rememberScrollState())
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Login",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier.padding(bottom = 32.dp).align(Alignment.Start)
            )

            // Email Field
            ModernTextFieldGreen(
                value = email,
                onValueChange = { email = it },
                label = "Alamat Email",
                leadingIcon = Icons.Default.Email,
                isPassword = false
            )

            Spacer(Modifier.height(16.dp))

            // Password Field
            ModernTextFieldGreen(
                value = password,
                onValueChange = { password = it },
                label = "Kata Sandi",
                leadingIcon = Icons.Default.Lock,
                isPassword = true,
                showPassword = showPassword,
                onTogglePassword = { showPassword = !showPassword }
            )

            // Forgot Password
            AlignEndTextButton(
                text = "Lupa kata sandi?",
                onClick = { /* Handle forgot password */ },
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
                textColor = AppGreen // Link berwarna Hijau
            )

            // Error Message
            if (errorMessage.isNotEmpty()) {
                Spacer(Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            // Login Button
            Button(
                onClick = {
                    if (email == "1" && password == "1") {
                        onLoginSuccess()
                    } else {
                        errorMessage = "Email atau kata sandi salah!"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AppGreen) // Tombol Hijau
            ) {
                Text("MASUK", style = MaterialTheme.typography.titleMedium, color = White)
            }

            Spacer(Modifier.height(16.dp))

            // Sign Up Text
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Belum punya akun?", color = Color.Gray)
                TextButton(onClick = { /* navigate to register */ }) {
                    Text("Daftar", color = AppGreen) // Link Daftar Hijau
                }
            }
        }
    }
}

// -------------------------------------------------------------
// FUNGSI MODERN TEXT FIELD (VERSI TEMA TERANG - AKSEN HIJAU)
// -------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModernTextFieldGreen(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    isPassword: Boolean,
    showPassword: Boolean = false,
    onTogglePassword: (() -> Unit)? = null
) {
    val TextDark = Color(0xFF1F1F1F)
    val Gray = Color(0xFF888888)

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Gray) },
        leadingIcon = { Icon(leadingIcon, contentDescription = null, tint = Gray) },
        visualTransformation = if (isPassword && !showPassword) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = if (isPassword && onTogglePassword != null) {
            {
                val icon = if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility
                IconButton(onClick = onTogglePassword) {
                    Icon(icon, contentDescription = null, tint = Gray)
                }
            }
        } else null,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = TextDark,
            unfocusedTextColor = TextDark,
            // Aksen Hijau
            focusedBorderColor = AppGreen,
            unfocusedBorderColor = Gray.copy(alpha = 0.5f),
            focusedLabelColor = AppGreen,
            unfocusedLabelColor = Gray,
            focusedLeadingIconColor = AppGreen,
            unfocusedLeadingIconColor = Gray,
            focusedTrailingIconColor = AppGreen,
            unfocusedTrailingIconColor = Gray,
            cursorColor = AppGreen,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            errorContainerColor = Color.White
        )
    )
}

// -------------------------------------------------------------
// FUNGSI TOMBOL TEKS
// -------------------------------------------------------------

@Composable
fun AlignEndTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(modifier = modifier) {
        TextButton(
            onClick = onClick,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Text(text, color = textColor)
        }
    }
}