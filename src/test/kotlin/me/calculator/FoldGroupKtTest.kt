package me.calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FoldGroupKtTest {
    @Test
    fun `Check regular expression`() {
        val a = groupMD.find(repMtoPM(trim("-2*-3+0.4/-0.2")))
        println(a)
    }
}