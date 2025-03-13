# Add project-specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt

# Room database rules
-keep class * extends androidx.room.RoomDatabase {
    public static <methods>;
}

# Retrofit rules
-keep class com.example.tabletmonitor.api.** { *; }
-keep class * extends retrofit2.Call {
    public <methods>;
}

# MPAndroidChart rules
-keep class com.github.mikephil.charting.** { *; }

# Timber logging rules
-keep class timber.log.** { *; }