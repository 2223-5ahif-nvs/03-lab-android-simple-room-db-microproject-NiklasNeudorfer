package at.htl.neudorfer.books.data

import androidx.compose.ui.graphics.Color

enum class Genre(val color: Color) {
    FANTASY(Color(0xFF8BC34A)),
    SCIENCE_FICTION(Color(0xFF00FFFF)),
    ROMANCE(Color(0xFFFFC0CB)),
    HORROR(Color(0xFF000000)),
    THRILLER(Color(0xFFE91E63)),
    MYSTERY(Color(0xFFA9A9A9)),
    DRAMA(Color(0xFFE6E6FA)),
    COMEDY(Color(0xFFE6E600)),
    BIOGRAPHY(Color(0xFFE6E6FA)),
    HISTORY(Color(0xFF8B4513)),
    GUIDE(Color(0xFFE6E6E6)),
    TRAVEL(Color(0xFFE6E6FA)),
    CHILDREN(Color(0xFF00FF7F)),
    YOUNG_ADULT(Color(0xFF00BFFF)),
    POETRY(Color(0xFF8A2BE2)),
    ENCYCLOPEDIA(Color(0xFFA52A2A)),
    DICTIONARY(Color(0xFFDEB887)),
    TEXTBOOK(Color(0xFF5F9EA0)),
    RELIGION(Color(0xFF7FFF00)),
    SCIENCE(Color(0xFFFF7F50)),
    HEALTH(Color(0xFF6495ED)),
    COOKBOOK(Color(0xFFFF4500)),
    JOURNAL(Color(0xFFDC143C)),
    PRAYER(Color(0xFF00FFFF)),
    SERIES(Color(0xFF00008B)),
    TRILLOGY(Color(0xFF008B8B)),
    QUADROLOGY(Color(0xFFB8860B)),
    OTHER(Color(0xFFA9A9A9));
}