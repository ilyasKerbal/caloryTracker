buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(Build.hiltAndroidGradlePlugin)
    }
}
plugins {
    id(CorePlugins.androidApplication) version CorePlugins.androidApplicationVersion apply false
    id(CorePlugins.androidLibrary) version CorePlugins.androidLibraryVersion apply false
    id(CorePlugins.kotlinAndroid) version CorePlugins.kotlinAndroidVersion apply false
    id(CorePlugins.kotlinJVM) version CorePlugins.kotlinJVMVersion apply false
    id(CorePlugins.hiltAndroid) version CorePlugins.hiltAndroidVersion apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}