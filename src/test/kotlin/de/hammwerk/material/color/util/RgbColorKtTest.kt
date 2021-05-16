package de.hammwerk.material.color.util

import org.junit.Assert.assertEquals
import org.spekframework.spek2.Spek

internal object RgbColorKtTest : Spek({
    test("Material Design default red color palette") {
        val calculatedRedPalette = "F44336".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultRedPalette, calculatedRedPalette)
    }

    test("Material Design default pink color palette") {
        val calculatedPinkPalette = "E91E63".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultPinkPalette, calculatedPinkPalette)
    }

    test("Material Design default purple color palette") {
        val calculatedPurplePalette = "9C27B0".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultPurplePalette, calculatedPurplePalette)
    }

    test("Material Design default deepPurple color palette") {
        val calculatedDeepPurplePalette = "673AB7".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultDeepPurplePalette, calculatedDeepPurplePalette)
    }

    test("Material Design default indigo color palette") {
        val calculatedIndigoPalette = "3F51B5".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultIndigoPalette, calculatedIndigoPalette)
    }

    test("Material Design default blue color palette") {
        val calculatedBluePalette = "2196F3".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultBluePalette, calculatedBluePalette)
    }

    test("Material Design default lightBlue color palette") {
        val calculatedLightBluePalette = "03A9F4".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultLightBluePalette, calculatedLightBluePalette)
    }

    test("Material Design default cyan color palette") {
        val calculatedCyanPalette = "00BCD4".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultCyanPalette, calculatedCyanPalette)
    }

    test("Material Design default teal color palette") {
        val calculatedTealPalette = "009688".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultTealPalette, calculatedTealPalette)
    }

    test("Material Design default green color palette") {
        val calculatedGreenPalette = "4CAF50".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultGreenPalette, calculatedGreenPalette)
    }

    test("Material Design default lightGreen color palette") {
        val calculatedLightGreenPalette = "8BC34A".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultLightGreenPalette, calculatedLightGreenPalette)
    }

    test("Material Design default lime color palette") {
        val calculatedLimePalette = "CDDC39".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultLimePalette, calculatedLimePalette)
    }

    test("Material Design default yellow color palette") {
        val calculatedYellowPalette = "FFEB3B".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultYellowPalette, calculatedYellowPalette)
    }

    test("Material Design default amber color palette") {
        val calculatedAmberPalette = "FFC107".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultAmberPalette, calculatedAmberPalette)
    }

    test("Material Design default orange color palette") {
        val calculatedOrangePalette = "FF9800".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultOrangePalette, calculatedOrangePalette)
    }

    test("Material Design default deepOrange color palette") {
        val calculatedDeepOrangePalette = "FF5722".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultDeepOrangePalette, calculatedDeepOrangePalette)
    }

    test("Material Design default brown color palette") {
        val calculatedBrownPalette = "795548".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultBrownPalette, calculatedBrownPalette)
    }

    test("Material Design default gray color palette") {
        val calculatedGrayPalette = "9E9E9E".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultGrayPalette, calculatedGrayPalette)
    }

    test("Material Design default blueGray color palette") {
        val calculatedBlueGrayPalette = "607D8B".toRgbColorOrNull()!!.createPalette().map { it.rgbHex }
        assertEquals(RgbColorKtTest.defaultBlueGrayPalette, calculatedBlueGrayPalette)
    }
}) {
    private val defaultRedPalette = listOf(
        "FFEBEE",
        "FFCDD2",
        "EF9A9A",
        "E57373",
        "EF5350",
        "F44336",
        "E53935",
        "D32F2F",
        "C62828",
        "B71B1C"
    )
    private val defaultPinkPalette = listOf(
        "FCE4EC",
        "F8BBD0",
        "F48FB0",
        "F06291",
        "EC4079",
        "E91E62",
        "D81B5F",
        "C2185A",
        "AD1356",
        "880D4E"
    )
    private val defaultPurplePalette = listOf(
        "F3E5F5",
        "E1BEE7",
        "CE93D8",
        "BA68C8",
        "AB47BC",
        "9B27B0",
        "8D24AA",
        "7A1FA2",
        "691B9A",
        "49148C"
    )
    private val defaultDeepPurplePalette = listOf(
        "EDE7F6",
        "D1C4E9",
        "B39DDB",
        "9675CD",
        "7F57C2",
        "683AB7",
        "5F35B1",
        "522DA8",
        "4627A0",
        "321B92"
    )
    private val defaultIndigoPalette = listOf(
        "E8EAF6",
        "C5CAE9",
        "9FA8DA",
        "7986CB",
        "5C6BC0",
        "3F51B5",
        "3949AB",
        "303F9F",
        "283593",
        "1A237E"
    )
    private val defaultBluePalette = listOf(
        "E3F2FD",
        "BBDEFB",
        "90C9F9",
        "63B4F6",
        "42A4F5",
        "2194F3",
        "1F87E5",
        "1A75D2",
        "1764C0",
        "1045A1"
    )
    private val defaultLightBluePalette = listOf(
        "E1F5FE",
        "B3E5FC",
        "81D3FA",
        "4EC2F7",
        "28B5F6",
        "03A8F4",
        "049AE5",
        "0487D1",
        "0476BD",
        "03569B"
    )
    private val defaultCyanPalette = listOf(
        "E0F7FA",
        "B2EBF2",
        "80DEEA",
        "4DCFE1",
        "26C5DA",
        "00BBD4",
        "00ABC1",
        "0096A7",
        "00828F",
        "005F64"
    )
    private val defaultTealPalette = listOf(
        "E0F2F1",
        "B2DFDB",
        "80CBC3",
        "4DB6AB",
        "26A699",
        "009687",
        "00897A",
        "00796A",
        "00695B",
        "004D3F"
    )
    private val defaultGreenPalette = listOf(
        "E8F5E9",
        "C8E6C9",
        "A5D6A7",
        "81C784",
        "66BB69",
        "4CAF4F",
        "43A046",
        "388E3B",
        "2E7D31",
        "1B5E1F"
    )
    private val defaultLightGreenPalette = listOf(
        "F1F8E9",
        "DCEDC8",
        "C5E1A5",
        "AED581",
        "9CCC65",
        "8BC34A",
        "7CB342",
        "689F38",
        "558B2F",
        "33691E"
    )
    private val defaultLimePalette = listOf(
        "F9FBE7",
        "F0F4C3",
        "E5EE9C",
        "DBE775",
        "D3E157",
        "CCDC39",
        "BFCA33",
        "AEB42B",
        "9D9D24",
        "817717"
    )
    private val defaultYellowPalette = listOf(
        "FFFDE7",
        "FFF9C4",
        "FFF59D",
        "FEF075",
        "FCEB55",
        "FFEB3B",
        "FDD835",
        "FBC02D",
        "F9A825",
        "F57F16"
    )
    private val defaultAmberPalette = listOf(
        "FFF8E1",
        "FFECB3",
        "FFE082",
        "FFD54F",
        "FFCA28",
        "FFC107",
        "FFB300",
        "FFA000",
        "FF8F00",
        "FF6F00"
    )
    private val defaultOrangePalette = listOf(
        "FFF3E0",
        "FFE0B2",
        "FFCD80",
        "FFB84D",
        "FFA826",
        "FF9900",
        "FB8D00",
        "F57D00",
        "EF6D00",
        "E65200"
    )
    private val defaultDeepOrangePalette = listOf(
        "FBE9E7",
        "FFCCBC",
        "FFAB91",
        "FF8965",
        "FF6F43",
        "FF5622",
        "F4501E",
        "E64919",
        "D84215",
        "BF350C"
    )
    private val defaultBrownPalette = listOf(
        "EFEBE9",
        "D7CCC8",
        "BCAAA4",
        "A1887F",
        "8D6E63",
        "795548",
        "6D4C41",
        "5D4037",
        "4E342E",
        "3E2723"
    )
    private val defaultGrayPalette = listOf(
        "FAFAFA",
        "F5F5F5",
        "EEEEEE",
        "E0E0E0",
        "BDBDBD",
        "9E9E9E",
        "757575",
        "616161",
        "424242",
        "212121"
    )
    private val defaultBlueGrayPalette = listOf(
        "ECEFF1",
        "CFD8DC",
        "B0BEC5",
        "90A4AE",
        "78909C",
        "607D8B",
        "546E7A",
        "455A64",
        "37474F",
        "263238"
    )
}