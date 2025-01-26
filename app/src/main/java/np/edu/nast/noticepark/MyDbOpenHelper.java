package np.edu.nast.noticepark;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyDbOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "nast.db";
    public static final String DB_LOG = "DB";
    private static final int DB_VERSION = 1;
    private static final String STUDENT_TABLE_NAME = "tbl_students";
    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String STUDENT_TABLE_SQL = "CREATE TABLE " +
            STUDENT_TABLE_NAME + "(" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FIRST_NAME + " TEXT, " +
            LAST_NAME + " TEXT)";

    public MyDbOpenHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        Toast.makeText(ctx, "Created", Toast.LENGTH_LONG).show();
        Log.i(DB_LOG, "Database Created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(DB_LOG, STUDENT_TABLE_SQL);
        db.execSQL(STUDENT_TABLE_SQL);
        Log.i(DB_LOG, "Table Created Successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + STUDENT_TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean insert(String firstName, String lastName) {
        ContentValues values = new ContentValues();
        values.put(FIRST_NAME, firstName);
        values.put(LAST_NAME, lastName);

        SQLiteDatabase db = this.getWritableDatabase();
        boolean ins = db.insert(STUDENT_TABLE_NAME, null, values) > 0;
        Log.i(DB_LOG, "Inserted");
        db.close();
        return ins;
    }

    public List<String> readAll() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + STUDENT_TABLE_NAME;
        List<String> students = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndexOrThrow(ID));
                String firstName = cursor.getString(cursor.getColumnIndexOrThrow(FIRST_NAME));
                String lastName = cursor.getString(cursor.getColumnIndexOrThrow(LAST_NAME));
                String student = id + ": " + firstName + " " + lastName;
                students.add(student);
            } while (cursor.moveToNext());
        }
        db.close();
        return students;
    }

    public boolean updateRecord(long id, String firstName, String lastName) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(ID, id);
        args.put(FIRST_NAME, firstName);
        args.put(LAST_NAME, lastName);
        int i = db.update(STUDENT_TABLE_NAME, args, ID + "=" + id, null);
        return i > 0;
    }

    public boolean deleteRecord(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        // db.execSQL("DELETE FROM " + STUDENT_TABLE_NAME+ " WHERE "+ID+"='"+id+"'");
        return db.delete(STUDENT_TABLE_NAME, ID + "=" + id, null) > 0;
        //
    }
}


