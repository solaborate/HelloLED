HELLO LED
============
[ ![Download](https://api.bintray.com/packages/solaborate/maven/com.solaborate.helloled/images/download.svg) ](https://bintray.com/solaborate/maven/com.solaborate.helloled/_latestVersion)

This is a library to allow developers to control the LED ring on Solaborate HELLO 2.

Sample usage, let's make all the LEDs red ( see the [sample app][sample_link] for more example):

```kotlin
val ledAnimation = LedAnimation()

val colors = "FF0000".repeat(24)
val rgbColorArray: ByteArray = hexStringToByteArray(colors) // convert color string to byte array. See sample app.

ledAnimation.writeLedColors(rgbColorArray) // show the colors on HELLO LED ring
```

Note that the array must contain exactly 72 bytes ( 24 LEDs * 3 byte per LED ; 1 red / 1 green / 1 blue for each LED )


Download
--------

```groovy
dependencies {
    implementation 'com.solaborate:helloled:1.0.0'
}
```

License
-------

    Copyright 2019 Solaborate

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [sample_link]: https://github.com/solaborate/HelloLED/tree/master/sample
