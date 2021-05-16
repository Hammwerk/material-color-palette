package de.hammwerk.material.color

import de.hammwerk.material.color.colorspaces.LchColor

data class GoldenPalette(private val colors: List<LchColor>) : List<LchColor> by colors {
    fun minDeltaE(color: LchColor) = minOf { color.deltaE(it) }

    fun getClosestColor(color: LchColor) = minByOrNull { color.deltaE(it) }!!

    fun hasMainColorLowChroma() = this[5].chroma < 30
}