package de.hammwerk.material.color.util

import de.hammwerk.material.color.colorspaces.RgbColor

fun String.toRgbColorOrNull() = toUIntOrNull(16)?.let {
    when (length) {
        8 -> RgbColor(
            (it shr 24 and 0xffu).toInt() / 255.0,
            (it shr 16 and 0xffu).toInt() / 255.0,
            (it shr 8 and 0xffu).toInt() / 255.0,
            (it and 0x000000ffu).toInt() / 255.0
        )
        6 -> RgbColor(
                (it shr 16 and 0xffu).toInt() / 255.0,
                (it shr 8 and 0xffu).toInt() / 255.0,
                (it and 0xffu).toInt() / 255.0
            )
        else -> null
    }
}