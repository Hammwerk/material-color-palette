package de.hammwerk.material.color.util

import de.hammwerk.material.color.colorspaces.HslColor
import de.hammwerk.material.color.colorspaces.RgbColor
import kotlin.math.absoluteValue

fun HslColor.toRgbColor(): RgbColor {
    val chroma = (1 - (2.0 * lightness - 1.0).absoluteValue) * saturation
    val huePrime = hue / 60.0
    val x = chroma * (1 - (huePrime % 2 - 1).absoluteValue)
    val m = lightness - chroma / 2.0

    return when {
        huePrime < 1.0 -> RgbColor(chroma + m, x + m, m, alpha)
        huePrime < 2.0 -> RgbColor(x + m, chroma + m, m, alpha)
        huePrime < 3.0 -> RgbColor(m, chroma + m, x + m, alpha)
        huePrime < 4.0 -> RgbColor(m, x + m, chroma + m, alpha)
        huePrime < 5.0 -> RgbColor(x + m, m, chroma + m, alpha)
        else -> RgbColor(chroma + m, m, x + m, alpha)
    }
}