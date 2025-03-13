package com.example.tabletmonitor.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/tabletmonitor/utils/Logger;", "", "()V", "LOG_FILE", "", "log", "", "message", "context", "Landroid/content/Context;", "writeToFile", "app_debug"})
public final class Logger {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String LOG_FILE = "app_logs.txt";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.tabletmonitor.utils.Logger INSTANCE = null;
    
    private Logger() {
        super();
    }
    
    public final void log(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void writeToFile(java.lang.String message, android.content.Context context) {
    }
}