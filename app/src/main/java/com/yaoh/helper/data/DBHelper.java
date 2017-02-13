package com.yaoh.helper.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yaoh.helper.utils.LogTool;

/**
 * Package com.yaoh.helper.data.
 * Created by yaoh on 2017/02/09.
 * Company Beacool IT Ltd.
 * <p/>
 * Description:
 */
public class DBHelper extends SQLiteOpenHelper {
    private final String TAG = "DBHelper";

    public static final String DATABASE_NAME = "data";
    public static final String TABLE_NAME = "login";

    public static final String CREATE_LOGIN_TABLE = "create table "
            + TABLE_NAME
            + " (_id integer primary key autoincrement,"
            + " name text, age integer,sex integer)";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        LogTool.LogE(TAG,"oldVersion: " + oldVersion + " newVersion: " + newVersion);
//        if(oldVersion < 2) {
//            db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN address text");
//        }
        if(oldVersion < 3) {
            db.beginTransaction();
            try {
                db.execSQL("CREATE TEMPORARY TABLE pe_backup (_id name, age, sex);");
                db.execSQL("INSERT INTO pe_backup SELECT -id name, age, sex FROM login;");
                db.execSQL("DROP TABLE login;");
                db.execSQL("CREATE TABLE login(name text, age integer ,sex text);");
                db.execSQL("INSERT INTO login SELECT name, age, sex FROM pe_backup;");
                db.execSQL("DROP TABLE pe_backup;");
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
            }
        }

    }
}
