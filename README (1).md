# 📱 Modern UI Spotify-Style App  
**Project UTS Pemrograman Mobile — Jetpack Compose**

Aplikasi ini merupakan implementasi desain UI modern dengan inspirasi tampilan Spotify menggunakan Jetpack Compose. Aplikasi ini memiliki fitur login, navigasi antar halaman, bottom navigation bar custom, dark mode, serta beberapa tampilan antarmuka modern lainnya.

## ✨ Fitur Utama

### 🔐 Login Screen  
- Background gradient hijau ala Spotify  
- Input teks modern dengan ikon  
- Validasi login sederhana (email: **1**, password: **1**)  
- Tombol "MASUK" modern dengan rounded corner  

### 🏠 Home Screen  
- Top bar “Selamat Malam”  
- Chips kategori ala Spotify  
- Horizontal scrolling playlist & rekomendasi  
- Card responsif dengan gambar album/artis  

### 🔍 Search Screen  
- Search bar adaptif (dark/light mode)  
- Grid kategori dengan warna berbeda  
- Horizontal recommendation card  
- Layout ala Spotify Search  

### 👤 Profile Screen  
- Foto profil dengan glow Spotify  
- Username & handle  
- Statistik (Followers, Following, Playlist)  
- Daftar Top Artists  
- Tombol Edit Profile  

### ⚙ Settings Screen  
- Mode gelap (Switch Material 3)  
- Item pengaturan modular ala Spotify  
- Pengaturan akun & tampilan  
- Informasi aplikasi  

### 🎵 Spotify Bottom Navigation Bar  
- Rounded corner top bar  
- Highlight indicator animasi (scale + top bar)  
- Navigasi ke: **Home**, **Search**, **Profile**, **Settings**  

## 🛠 Teknologi yang Digunakan
- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **Scaffold & Surface**
- **Custom Composable Architecture**

## 📁 Struktur Folder
```
app/
 ├── manifests/
 │    └── AndroidManifest.xml
 │
 ├── kotlin+java/
 │    └── id.antasari.p7_modern_ui_230104040122/
 │         ├── MainActivity.kt
 │         └── ui/
 │             ├── components/
 │             │     ├── AppCard.kt
 │             │     ├── AppTextField.kt
 │             │     └── SpotifyBottomBar.kt
 │             │
 │             ├── screen/
 │             │     ├── HomeScreen.kt
 │             │     ├── LoginScreen.kt
 │             │     ├── ProfileScreen.kt
 │             │     ├── SearchScreen.kt
 │             │     └── SettingsScreen.kt
 │             │
 │             └── theme/
 │                   ├── Color.kt
 │                   ├── Shape.kt
 │                   ├── Theme.kt
 │                   └── Type.kt
 │
 ├── res/
 │    ├── drawable/
 │    │    ├── about.png
 │    │    ├── aboutyou.jpg
 │    │    ├── cewe1.jpg
 │    │    ├── images.jpg
 │    │    ├── images2.jpg
 │    │    ├── kucing.jpg
 │    │    ├── lany.jpg
 │    │    ├── profile.png
 │    │    ├── sheila.jpg
 │    │    └── tulus.png
 │    │
 │    ├── mipmap/
 │    └── values/
 │
 └── Gradle Scripts/
      ├── build.gradle.kts (Project)
      └── build.gradle.kts (Module)
```

## ▶ Cara Menjalankan Project
1. Clone repository  
2. Buka project di **Android Studio**  
3. Jalankan pada emulator atau device  
4. Login menggunakan:  
```
Email: 1
Password: 1
```

## 🎥 Video Penjelasan (Untuk UTS)
Video berdurasi ± 1 menit harus menjelaskan:
- Tujuan aplikasi  
- Penjelasan setiap screen  
- Desain modern (Material 3 + Spotify UI)  
- Navigasi dan Bottom Bar  
- Dark Mode  
- Struktur folder  
- Kenapa aplikasi memenuhi standar “Modern UI”  

## 👨‍💻 Dibuat Oleh
**Husin Nafarin**  
NIM: 230104040122  
Universitas Islam Negeri Antasari  
