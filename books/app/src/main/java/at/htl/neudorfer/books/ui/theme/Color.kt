package at.htl.neudorfer.books.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Colors.topAppBarBackground: Color
    get() = if (isLight) primary else Color.LightGray

val Colors.topAppBarColor: Color
    get() = if (isLight) Color.White else Color.Black