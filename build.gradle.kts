import org.gradle.kotlin.dsl.extra

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra["room_version"] = "2.4.3"
}
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

}