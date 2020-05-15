package tech.michalik.cheating

import androidx.databinding.Bindable
import tech.michalik.mvx.BaseViewModel
import tech.michalik.mvx.observable
import tech.michalik.mvx.onChange

class SomeViewModel : BaseViewModel() {
    @get:Bindable
    var bindableProperty: String by observable("", 117)

    var textReversed: String = ""

    init {
        onChange(117) {
            textReversed = bindableProperty.reversed()
        }
    }
}
