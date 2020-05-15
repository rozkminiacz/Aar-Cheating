# What?
Example of how to use aar2jar plugin. This plugin extracts java classes from *.aar file so you can pretend that resources bundled in aar don't exists.

```gradle
classpath "gradle.plugin.com.stepango.aar2jar:aar2jar:0.6"
```

```gradle
apply plugin: "com.stepango.aar2jar"

dependencies {
  implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

  implementationAar "androidx.lifecycle:lifecycle-viewmodel:2.1.0"
}
```

# Why?
Basically I wanted to run fast unit tests on classes with android imports (especially classes extending ViewModel) and don't import all android stuff.

# Running example
1. Clone repository
2. Run `./gradlew test`
3. Profit


### Class under test:
```kotlin
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

```

### Test:
```kotlin
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

```
