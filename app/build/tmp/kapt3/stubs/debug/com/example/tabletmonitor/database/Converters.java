package com.example.tabletmonitor.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007J\u0019\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/tabletmonitor/database/Converters;", "", "()V", "fromDate", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/Long;", "fromPriceHistory", "", "priceHistory", "", "", "toDate", "timestamp", "(Ljava/lang/Long;)Ljava/util/Date;", "toPriceHistory", "json", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long fromDate(@org.jetbrains.annotations.Nullable()
    java.util.Date date) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date toDate(@org.jetbrains.annotations.Nullable()
    java.lang.Long timestamp) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromPriceHistory(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Float> priceHistory) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Float> toPriceHistory(@org.jetbrains.annotations.Nullable()
    java.lang.String json) {
        return null;
    }
}