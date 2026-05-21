package com.ufscar.dirigemais.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ufscar.dirigemais.data.local.entity.FavoriteEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteEntity> __insertionAdapterOfFavoriteEntity;

  private final EntityDeletionOrUpdateAdapter<FavoriteEntity> __deletionAdapterOfFavoriteEntity;

  public FavoriteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteEntity = new EntityInsertionAdapter<FavoriteEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorites` (`instructorId`,`nome`,`foto`,`cidade`,`bairro`,`preco`,`nota`,`totalAvaliacoes`,`telefone`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteEntity entity) {
        if (entity.getInstructorId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getInstructorId());
        }
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getFoto() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFoto());
        }
        if (entity.getCidade() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCidade());
        }
        if (entity.getBairro() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getBairro());
        }
        statement.bindDouble(6, entity.getPreco());
        statement.bindDouble(7, entity.getNota());
        statement.bindLong(8, entity.getTotalAvaliacoes());
        if (entity.getTelefone() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getTelefone());
        }
      }
    };
    this.__deletionAdapterOfFavoriteEntity = new EntityDeletionOrUpdateAdapter<FavoriteEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `favorites` WHERE `instructorId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteEntity entity) {
        if (entity.getInstructorId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getInstructorId());
        }
      }
    };
  }

  @Override
  public Object insertFavorite(final FavoriteEntity favorite,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavoriteEntity.insert(favorite);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteFavorite(final FavoriteEntity favorite,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavoriteEntity.handle(favorite);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FavoriteEntity>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorites";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"favorites"}, new Callable<List<FavoriteEntity>>() {
      @Override
      @NonNull
      public List<FavoriteEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfInstructorId = CursorUtil.getColumnIndexOrThrow(_cursor, "instructorId");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfPreco = CursorUtil.getColumnIndexOrThrow(_cursor, "preco");
          final int _cursorIndexOfNota = CursorUtil.getColumnIndexOrThrow(_cursor, "nota");
          final int _cursorIndexOfTotalAvaliacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAvaliacoes");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final List<FavoriteEntity> _result = new ArrayList<FavoriteEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavoriteEntity _item;
            final String _tmpInstructorId;
            if (_cursor.isNull(_cursorIndexOfInstructorId)) {
              _tmpInstructorId = null;
            } else {
              _tmpInstructorId = _cursor.getString(_cursorIndexOfInstructorId);
            }
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final String _tmpCidade;
            if (_cursor.isNull(_cursorIndexOfCidade)) {
              _tmpCidade = null;
            } else {
              _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            }
            final String _tmpBairro;
            if (_cursor.isNull(_cursorIndexOfBairro)) {
              _tmpBairro = null;
            } else {
              _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            }
            final double _tmpPreco;
            _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
            final double _tmpNota;
            _tmpNota = _cursor.getDouble(_cursorIndexOfNota);
            final int _tmpTotalAvaliacoes;
            _tmpTotalAvaliacoes = _cursor.getInt(_cursorIndexOfTotalAvaliacoes);
            final String _tmpTelefone;
            if (_cursor.isNull(_cursorIndexOfTelefone)) {
              _tmpTelefone = null;
            } else {
              _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
            }
            _item = new FavoriteEntity(_tmpInstructorId,_tmpNome,_tmpFoto,_tmpCidade,_tmpBairro,_tmpPreco,_tmpNota,_tmpTotalAvaliacoes,_tmpTelefone);
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

  @Override
  public Object getFavoriteById(final String id,
      final Continuation<? super FavoriteEntity> $completion) {
    final String _sql = "SELECT * FROM favorites WHERE instructorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<FavoriteEntity>() {
      @Override
      @Nullable
      public FavoriteEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfInstructorId = CursorUtil.getColumnIndexOrThrow(_cursor, "instructorId");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfFoto = CursorUtil.getColumnIndexOrThrow(_cursor, "foto");
          final int _cursorIndexOfCidade = CursorUtil.getColumnIndexOrThrow(_cursor, "cidade");
          final int _cursorIndexOfBairro = CursorUtil.getColumnIndexOrThrow(_cursor, "bairro");
          final int _cursorIndexOfPreco = CursorUtil.getColumnIndexOrThrow(_cursor, "preco");
          final int _cursorIndexOfNota = CursorUtil.getColumnIndexOrThrow(_cursor, "nota");
          final int _cursorIndexOfTotalAvaliacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAvaliacoes");
          final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
          final FavoriteEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpInstructorId;
            if (_cursor.isNull(_cursorIndexOfInstructorId)) {
              _tmpInstructorId = null;
            } else {
              _tmpInstructorId = _cursor.getString(_cursorIndexOfInstructorId);
            }
            final String _tmpNome;
            if (_cursor.isNull(_cursorIndexOfNome)) {
              _tmpNome = null;
            } else {
              _tmpNome = _cursor.getString(_cursorIndexOfNome);
            }
            final String _tmpFoto;
            if (_cursor.isNull(_cursorIndexOfFoto)) {
              _tmpFoto = null;
            } else {
              _tmpFoto = _cursor.getString(_cursorIndexOfFoto);
            }
            final String _tmpCidade;
            if (_cursor.isNull(_cursorIndexOfCidade)) {
              _tmpCidade = null;
            } else {
              _tmpCidade = _cursor.getString(_cursorIndexOfCidade);
            }
            final String _tmpBairro;
            if (_cursor.isNull(_cursorIndexOfBairro)) {
              _tmpBairro = null;
            } else {
              _tmpBairro = _cursor.getString(_cursorIndexOfBairro);
            }
            final double _tmpPreco;
            _tmpPreco = _cursor.getDouble(_cursorIndexOfPreco);
            final double _tmpNota;
            _tmpNota = _cursor.getDouble(_cursorIndexOfNota);
            final int _tmpTotalAvaliacoes;
            _tmpTotalAvaliacoes = _cursor.getInt(_cursorIndexOfTotalAvaliacoes);
            final String _tmpTelefone;
            if (_cursor.isNull(_cursorIndexOfTelefone)) {
              _tmpTelefone = null;
            } else {
              _tmpTelefone = _cursor.getString(_cursorIndexOfTelefone);
            }
            _result = new FavoriteEntity(_tmpInstructorId,_tmpNome,_tmpFoto,_tmpCidade,_tmpBairro,_tmpPreco,_tmpNota,_tmpTotalAvaliacoes,_tmpTelefone);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object isFavorite(final String id, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM favorites WHERE instructorId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
