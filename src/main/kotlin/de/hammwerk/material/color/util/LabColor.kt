package de.hammwerk.material.color.util

import de.hammwerk.material.color.colorspaces.LabColor
import de.hammwerk.material.color.colorspaces.LchColor
import de.hammwerk.material.color.colorspaces.XyzColor
import kotlin.math.abs
import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt

fun LabColor.toLchColor() = LchColor(
    lightness = lightness,
    chroma = sqrt(a.pow(2) + b.pow(2)),
    hue = when {
        1E-4 > abs(b) && 1E-4 > abs(a) -> 0.0
        else -> (atan2(b, a).toDegrees() + 360.0) % 360.0
    },
    alpha = alpha
)

fun LabColor.toXyzColor() = XyzColor(
    x = .95047 * fInv((lightness + 16.0) / 116.0 + a / 500.0),
    y = 1 * fInv((lightness + 16.0) / 116.0),
    z = 1.08883 * fInv((lightness + 16.0) / 116.0 - b / 200.0),
    alpha = alpha
)

private fun fInv(value: Double): Double {
    val delta = 6.0 / 29.0
    return if (value > delta) value.pow(3) else 3.0 * delta.pow(2) * (value - 4.0 / 29.0)
}
