package de.hammwerk.material.color.util

import de.hammwerk.material.color.colorspaces.LabColor
import de.hammwerk.material.color.colorspaces.RgbColor
import de.hammwerk.material.color.colorspaces.XyzColor
import kotlin.math.pow

fun XyzColor.toLabColor() = LabColor(
    lightness = 116.0 * f(y) - 16,
    a = 500.0 * (f(x / .95047) - f(y)),
    b = 200.0 * (f(y) - f(z / 1.08883)),
    alpha = alpha
)

fun XyzColor.toRgbColor(): RgbColor {
    return RgbColor(
        (3.2404542 * x + -1.5371385 * y + -.4985314 * z).reverseGammaCorrection().coerceIn(0.0, 1.0),
        (-.9692660 * x + 1.8760108 * y + .0415560 * z).reverseGammaCorrection().coerceIn(0.0, 1.0),
        (.0556434 * x + -.2040259 * y + 1.0572252 * z).reverseGammaCorrection().coerceIn(0.0, 1.0),
        alpha = alpha
    )
}

private fun f(value: Double): Double {
    val delta = 6.0 / 29.0
    return if (value > delta.pow(3)) value.pow(1.0 / 3.0) else value / (3.0 * delta.pow(2)) + 4.0 / 29.0
}

private fun Double.reverseGammaCorrection() = if (this <= .0031308) 12.92 * this else 1.055 * pow(1.0 / 2.4) - .055