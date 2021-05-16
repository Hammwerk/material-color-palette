package de.hammwerk.material.color.util

import de.hammwerk.material.color.colorspaces.HslColor
import de.hammwerk.material.color.colorspaces.RgbColor
import de.hammwerk.material.color.colorspaces.XyzColor
import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.roundToInt

fun RgbColor.toHslColor(): HslColor {
    val max = maxOf(red, green, blue)
    val min = minOf(red, green, blue)
    val delta = max - min
    return HslColor(
        hue = ((when {
            delta == 0.0 -> 0.0
            max == red -> 60.0 * ((green - blue) / delta)
            max == green -> 60.0 * ((blue - red) / delta + 2)
            else -> 60.0 * ((red - green) / delta + 4)
        } + 360.0) % 360.0).roundToInt(),
        saturation = when {
            max == 0.0 || min == 1.0 -> 0.0
            else -> delta / (1 - (max + min - 1).absoluteValue)
        },
        lightness = (max + min) / 2.0,
        alpha = alpha
    )
}

fun RgbColor.toXyzColor() = XyzColor(
    x = .4124564 * red.correctGamma() + .3575761 * green.correctGamma() + .1804375 * blue.correctGamma(),
    y = .2126729 * red.correctGamma() + .7151522 * green.correctGamma() + .0721750 * blue.correctGamma(),
    z = .0193339 * red.correctGamma() + .1191920 * green.correctGamma() + .9503041 * blue.correctGamma(),
    alpha = alpha
)

fun RgbColor.createPalette() = toHslColor()
    .toRgbColor()
    .toXyzColor()
    .toLabColor()
    .toLchColor()
    .createPalette()
    .map {
        it.toLabColor()
            .toXyzColor()
            .toRgbColor()
    }

val RgbColor.rgbHex
    get() = "%02X%02X%02X".format(
        (red * 0xff).roundToInt(),
        (green * 0xff).roundToInt(),
        (blue * 0xff).roundToInt()
    )

val RgbColor.rgbaHex
    get() = "%02X%02X%02X%02X".format(
        (red * 0xff).roundToInt(),
        (green * 0xff).roundToInt(),
        (blue * 0xff).roundToInt(),
        (alpha * 0xff).roundToInt()
    )

val RgbColor.argbHex
    get() = "%02X%02X%02X%02X".format(
        (alpha * 0xff).roundToInt(),
        (red * 0xff).roundToInt(),
        (green * 0xff).roundToInt(),
        (blue * 0xff).roundToInt()
    )

val RgbColor.rgb
    get() = (red * 0xff).roundToUInt() shl 16 and 0x00ff0000u or
            ((green * 0xff).roundToUInt() shl 8 and 0x0000ff00u) or
            ((blue * 0xff).roundToUInt() and 0x000000ffu)

val RgbColor.rgba
    get() = (red * 0xff).roundToUInt() shl 24 and 0xff000000u or
            ((green * 0xff).roundToUInt() shl 16 and 0x00ff0000u) or
            ((blue * 0xff).roundToUInt() shl 8 and 0x0000ff00u) or
            ((alpha * 0xff).roundToUInt() and 0x000000ffu)

val RgbColor.argb
    get() = (alpha * 0xff).roundToUInt() shl 24 and 0xff000000u or
            ((red * 0xff).roundToUInt() shl 16 and 0x00ff0000u) or
            ((green * 0xff).roundToUInt() shl 8 and 0x0000ff00u) or
            ((blue * 0xff).roundToUInt() and 0x000000ffu)

private fun Double.correctGamma() = if (this <= .04045) this / 12.92 else ((this + .055) / 1.055).pow(2.4)