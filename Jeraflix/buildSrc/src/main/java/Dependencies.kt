package com.sheyla.mymovies

object Versions{
    const val constraint_layout_version = "1.1.3"
    const val lifecycle_version = "2.2.0"
    const val coroutines_version = "1.3.8"
    const val kotlin_version = "1.5.20"
    const val appcompat = "1.3.1"
    const val recycelerview_version = "1.2.1"
    const val material_design_version = "1.2.0"
    const val cardview_version = "1.0.0"
    const val viewpager2_version = "1.0.0"
    const val play_core_version = "1.8.0"
    const val firebase = "23.0.3"
}

//object Libs {
//    private const val agpVersion = "4.2.2"
//    const val androidGradlePlugin = "com.android.tools.build:gradle:$agpVersion"
//    const val junit = "junit:junit:4.13.2"

    object kotlinDependencies {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"
    }

    object androidxsupportDependencies {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val cardview = "androidx.cardview:cardview:${Versions.cardview_version}"
        const val contraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.recycelerview_version}"
        const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2_version}"
    }

    object materialDesignDependencies {
        const val materialDesign =
            "com.google.android.material:material:${Versions.material_design_version}"
    }

    object playcoreDependencies {
        const val play_core = "com.google.android.play:core:${Versions.play_core_version}"
    }

    object firebase {
        const val firestone = "com.google.firebase:firebase-firestore:'${Versions.firebase}"
    }
//}