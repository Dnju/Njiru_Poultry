package njiru.poultry.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MayaiDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="NjiruPoultry.DB";
    public static final String TABLE_NAME="EGG_COUNT";
    public static final String COL_1="ID";
    public static final String COL_2="QUANTITY";

    public MayaiDatabaseHelper( Context context)   {
        super(context, DATABASE_NAME, null, 1);



    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,QUANTITY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

//passing db instance onCreate
onCreate(db);

    }
    public boolean insertData(String Quantity){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_2,Quantity);
        long result = db.insert(TABLE_NAME,null,contentValues );
        if (result==-1)
            return false;
        else
            return true;
    }
}
