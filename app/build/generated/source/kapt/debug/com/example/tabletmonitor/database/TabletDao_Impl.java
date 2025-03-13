package com.example.tabletmonitor.database;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TabletDao_Impl implements TabletDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tablet> __insertionAdapterOfTablet;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Tablet> __updateAdapterOfTablet;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public TabletDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTablet = new EntityInsertionAdapter<Tablet>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `tablets` (`id`,`name`,`dosage`,`schedule`,`stock`,`lastRefill`,`priceHistory`,`description`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tablet entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDosage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDosage());
        }
        if (entity.getSchedule() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSchedule());
        }
        statement.bindLong(5, entity.getStock());
        final Long _tmp = __converters.fromDate(entity.getLastRefill());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp);
        }
        final String _tmp_1 = __converters.fromPriceHistory(entity.getPriceHistory());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        if (entity.getDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription());
        }
      }
    };
    this.__updateAdapterOfTablet = new EntityDeletionOrUpdateAdapter<Tablet>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tablets` SET `id` = ?,`name` = ?,`dosage` = ?,`schedule` = ?,`stock` = ?,`lastRefill` = ?,`priceHistory` = ?,`description` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tablet entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getDosage() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDosage());
        }
        if (entity.getSchedule() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getSchedule());
        }
        statement.bindLong(5, entity.getStock());
        final Long _tmp = __converters.fromDate(entity.getLastRefill());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp);
        }
        final String _tmp_1 = __converters.fromPriceHistory(entity.getPriceHistory());
        if (_tmp_1 == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp_1);
        }
        if (entity.getDescription() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getDescription());
        }
        if (entity.getId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM tablets WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final Tablet tablet, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTablet.insert(tablet);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Tablet tablet, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTablet.handle(tablet);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDelete.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Tablet>> getAllTablets() {
    final String _sql = "SELECT * FROM tablets";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tablets"}, new Callable<List<Tablet>>() {
      @Override
      @NonNull
      public List<Tablet> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
          final int _cursorIndexOfSchedule = CursorUtil.getColumnIndexOrThrow(_cursor, "schedule");
          final int _cursorIndexOfStock = CursorUtil.getColumnIndexOrThrow(_cursor, "stock");
          final int _cursorIndexOfLastRefill = CursorUtil.getColumnIndexOrThrow(_cursor, "lastRefill");
          final int _cursorIndexOfPriceHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "priceHistory");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final List<Tablet> _result = new ArrayList<Tablet>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tablet _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpDosage;
            if (_cursor.isNull(_cursorIndexOfDosage)) {
              _tmpDosage = null;
            } else {
              _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
            }
            final String _tmpSchedule;
            if (_cursor.isNull(_cursorIndexOfSchedule)) {
              _tmpSchedule = null;
            } else {
              _tmpSchedule = _cursor.getString(_cursorIndexOfSchedule);
            }
            final int _tmpStock;
            _tmpStock = _cursor.getInt(_cursorIndexOfStock);
            final Date _tmpLastRefill;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfLastRefill)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfLastRefill);
            }
            _tmpLastRefill = __converters.toDate(_tmp);
            final List<Float> _tmpPriceHistory;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriceHistory)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriceHistory);
            }
            _tmpPriceHistory = __converters.toPriceHistory(_tmp_1);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            _item = new Tablet(_tmpId,_tmpName,_tmpDosage,_tmpSchedule,_tmpStock,_tmpLastRefill,_tmpPriceHistory,_tmpDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
