package theateam.com.tourmanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME="contact_manager";
    static final int DATABASE_VERSION=1;

    static final String TABLE_PROFILE="profile_info";
    static final String COL_ID="id";
    static final String COL_NAME="name";
    static final String COL_EMAIL="email";
    static final String COL_PASSWORD="password";
    static final String COL_IMAGEPATH="imagePath";
    static final String COL_PHONE="phone";
    static final String COL_EMERGENCY="emergency";
    
    ///Column of event table
    static final String TABLE_EVENT="contact_info";
    static final String COL_E_ID="id";
    static final String COL_E_PFOFILE_ID="p_id";
    static final String COL_E_NAME="name";
    static final String COL_E_PLACE="place";
    static final String COL_E_START="start";
    static final String COL_E_END="end";
    static final String COL_E_BUDGET="phone";
    
    //column for moment table
    static final String TABLE_MOMENT="moment_info";
    static final String COL_M_ID="m_id";
    static final String COL_M_PFOFILE_ID="m_p_id";
    static final String COL_M_EVENT_ID="m_e_id";
    static final String COL_M_NAME="m_name";
    static final String COL_M_DES="m_des";
    static final String COL_M_TIME="m_time";
    static final String COL_M_IMAGE="m_image";
    
    //Column for Expense table
    static final String TABLE_EXPENSE="expense_info";
    static final String COL_EX_ID="ex_id";
    static final String COL_EX_PFOFILE_ID="ex_p_id";
    static final String COL_EX_EVENT_ID="ex_e_id";
    static final String COL_EX_TITLE="ex_name";
    static final String COL_EX_AMOUNT="ex_amount";

    static final String CREATE_TABLE_PROFILE="create table "+TABLE_PROFILE+"("+COL_ID+" integer primary key, "+COL_NAME+" text, "+COL_EMAIL+" text, "+COL_PASSWORD+" text, "+COL_IMAGEPATH+" text, "+COL_PHONE+" text, "+COL_EMERGENCY+" text);";
    static final String CREATE_TABLE_EVENT="create table "+TABLE_EVENT+"("+COL_E_ID+" integer primary key, "+COL_E_PFOFILE_ID+" integer, "+COL_E_NAME+" text, "+COL_E_PLACE+" text, "+COL_E_START+" text, "+COL_E_END+" text, "+COL_E_BUDGET+" double);";
    static final String CREATE_TABLE_MOMENT="create table "+TABLE_MOMENT+"("+COL_M_ID+" integer primary key, "+COL_M_PFOFILE_ID+" integer, "+COL_M_EVENT_ID+" integer, "+COL_M_NAME+" text, "+COL_M_DES+" text, "+COL_M_TIME+" text, "+COL_M_IMAGE+" text);";
    static final String CREATE_TABLE_EXPENSE="create table "+TABLE_EXPENSE+"("+COL_EX_ID+" integer primary key, "+COL_EX_PFOFILE_ID+" integer, "+COL_EX_EVENT_ID+" integer, "+COL_EX_TITLE+" text, "+COL_EX_AMOUNT+" double);";
    
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_PROFILE);
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_MOMENT);
        sqLiteDatabase.execSQL(CREATE_TABLE_EXPENSE);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist"+TABLE_PROFILE);
        sqLiteDatabase.execSQL("drop table if exist"+TABLE_EVENT);
        sqLiteDatabase.execSQL("drop table if exist"+TABLE_MOMENT);
        sqLiteDatabase.execSQL("drop table if exist"+TABLE_EXPENSE);
        onCreate(sqLiteDatabase);
    }
}
