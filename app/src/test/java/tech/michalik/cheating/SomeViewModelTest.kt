package tech.michalik.cheating

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class SomeViewModelTest {
    @Test
    fun `it actually works`() {
        val viewModel = SomeViewModel()
        viewModel.bindableProperty = "other"

        assertEquals("rehto", viewModel.textReversed)
    }
}
