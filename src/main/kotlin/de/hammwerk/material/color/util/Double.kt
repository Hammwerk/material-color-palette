package de.hammwerk.material.color.util

import kotlin.math.roundToInt

fun Double.toRadians() = this * Math.PI / 180.0

fun Double.toDegrees() = this * 180.0 / Math.PI

fun Double.roundToUInt(): UInt = roundToInt().toUInt()