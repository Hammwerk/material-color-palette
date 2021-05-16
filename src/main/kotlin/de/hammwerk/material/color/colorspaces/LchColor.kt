package de.hammwerk.material.color.colorspaces

import de.hammwerk.material.color.util.toLabColor
import de.hammwerk.material.color.util.toLchColor
import de.hammwerk.material.color.util.toRadians
import kotlin.math.*

data class LchColor(val lightness: Double, val chroma: Double, val hue: Double, val alpha: Double = 1.0) {
    fun deltaE(other: LchColor): Double {
        val deltaLightness = lightness - other.lightness
        val meanLightness = (lightness + other.lightness) / 2.0
        val meanChroma = (chroma + other.chroma) / 2.0

        val aFactor = 1 - sqrt(meanChroma.pow(7) / (meanChroma.pow(7) + 25.0.pow(7)))
        val thisPrime = toLabColor()
            .let { LabColor(it.lightness, it.a + it.a / 2.0 * aFactor, it.b, alpha) }
            .toLchColor()
        val otherPrime = other.toLabColor()
            .let { LabColor(it.lightness, it.a + it.a / 2.0 * aFactor, it.b, alpha) }
            .toLchColor()

        val deltaChromaPrime = thisPrime.chroma - otherPrime.chroma
        val meanChromaPrime = (thisPrime.chroma + otherPrime.chroma) / 2.0

        val deltaHuePrime = thisPrime.hueDelta(otherPrime)
        val deltaHPrime = 2.0 * sqrt(thisPrime.chroma * otherPrime.chroma) * sin((deltaHuePrime / 2.0).toRadians())
        val meanHuePrime = thisPrime.meanHue(otherPrime)

        val t = 1.0 -
                .17 * cos((meanHuePrime - 30.0).toRadians()) +
                .24 * cos((2.0 * meanHuePrime).toRadians()) +
                .32 * cos((3.0 * meanHuePrime + 6.0).toRadians()) -
                .2 * cos((4.0 * meanHuePrime - 63.0).toRadians())
        val sL = 1.0 + .015 * (meanLightness - 50.0).pow(2) / sqrt(20.0 + (meanLightness - 50.0).pow(2))
        val sC = 1.0 + .045 * meanChromaPrime
        val sH = 1.0 + .015 * meanChromaPrime * t
        val rT = -2.0 * sqrt(meanChromaPrime.pow(7) / (meanChromaPrime.pow(7) + 25.0.pow(7))) *
                sin((60.0 * exp(-((meanHuePrime - 275.0) / 25.0).pow(2))).toRadians())

        return sqrt(
            (deltaLightness / sL).pow(2) +
                    (deltaChromaPrime / sC).pow(2) +
                    (deltaHPrime / sH).pow(2) +
                    rT * (deltaChromaPrime / sC) * (deltaHPrime / sH)
        )
    }

    private fun hueDelta(other: LchColor) = when {
        (hue - other.hue) in -180.0..180.0 -> hue - other.hue
        hue <= other.hue -> hue - other.hue + 360.0
        else -> hue - other.hue - 360.0
    }

    private fun meanHue(other: LchColor) = when {
        (hue - other.hue) in -180.0..180.0 -> (other.hue + hue) / 2.0
        other.hue + hue < 360.0 -> (other.hue + hue + 360.0) / 2.0
        else -> (other.hue + hue - 360.0) / 2.0
    }
}