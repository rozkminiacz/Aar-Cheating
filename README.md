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
