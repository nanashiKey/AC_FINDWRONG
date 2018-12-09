package irfan.module.androidcomplete.SampleSQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class SampleBookHelper extends SQLiteOpenHelper {

    final static String dbname = "buku_";
    final static int dbversion = 1;

    public SampleBookHelper(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "Create Table book_entries(id integer primary key autoincrement, title text, author text);";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop = "DROP TABLE IF EXISTS book_entries";
        sqLiteDatabase.execSQL(drop);
        onCreate(sqLiteDatabase);
    }
}
