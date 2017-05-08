package kh.edu.rupp.fe.ruppmad.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;

/**
 * Created by sophal_nc on 5/6/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String _DB_NAME = "RUPPMAD.db";
    public static final String _TABLE_NAME = "assignment";
    public static final String _COLUMN_ID = "_id";
    public static final String _COLUMN_TITLE = "_title";
    public static final String _COLUMN_DEADLINE = "_deadline";
    public static final String _COLUMN_IMAGE = "_image";

    public DBHelper(Context context) {
        super(context, _DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE assignment (_id INTEGER PRIMARY KEY AUTOINCREMENT, _title TEXT, _deadline TEXT, _image TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = ("DROP TABLE IF EXISTS assignment");
        db.execSQL(sql);
    }

    public boolean insertAssignment(String title, String deadline, String image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(_COLUMN_TITLE, title);
        contentValues.put(_COLUMN_DEADLINE,deadline);
        contentValues.put(_COLUMN_IMAGE,image);
        long newId = db.insert(_TABLE_NAME,null,contentValues);
        return (newId != -1);
    }

    public List<Assignment> getAssignmentData(){
        List<Assignment> dataList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] selectedCoulumns = {_COLUMN_ID,_COLUMN_TITLE,_COLUMN_DEADLINE,_COLUMN_IMAGE};

        Cursor res = sqLiteDatabase.rawQuery("SELECT * FROM assignment",null);
        res.moveToFirst();

        while (res.moveToNext()){
            Assignment assignment = new Assignment();
            assignment.setId(res.getString(0));
            assignment.setTitle(res.getString(1));
            assignment.setDeadline(res.getString(2));
            assignment.setThumbnailUrl(res.getString(3));
            dataList.add(assignment);
        }
        res.close();
        return dataList;
    }

    public void deleteAssignmentData (Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "_id = ?";
        String[] selectionArgs = {id + ""};
        db.delete("assignment",selection,selectionArgs);
    }

    public Boolean updateAssignmentData (int assignmentId, String newTitle, String newDeadline, String newImage_URL){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(_COLUMN_TITLE, newTitle);
        contentValues.put(_COLUMN_DEADLINE,newDeadline);
        contentValues.put(_COLUMN_IMAGE,newImage_URL);

        String selection = "_id = ?";
        String[] selectionArgs = {assignmentId + ""};

        int effectedRowCount = db.update("assignment",contentValues,selection,selectionArgs);
        return (effectedRowCount > 0);

    }
}
