package theateam.com.tourmanager.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import theateam.com.tourmanager.ModelClass.ExpenseModel;

public class ExpenseDBSource {
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    ExpenseModel expenseModel;

    public ExpenseDBSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }


    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }

    public boolean addExpense(ExpenseModel expenseModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_EX_PFOFILE_ID,expenseModel.getEx_profile_id());
        contentValues.put(DatabaseHelper.COL_EX_EVENT_ID,expenseModel.getEx_event_id());
        contentValues.put(DatabaseHelper.COL_EX_TITLE,expenseModel.getEx_title());
        contentValues.put(DatabaseHelper.COL_EX_AMOUNT,expenseModel.getEx_amount());


        long inserted=database.insert(DatabaseHelper.TABLE_EXPENSE,null,contentValues);

        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }

    }

    public ExpenseModel getExpenseModel(int id){
        this.open();

        Cursor cursor=database.query(DatabaseHelper.TABLE_EXPENSE,new String[]{DatabaseHelper.COL_EX_ID,DatabaseHelper.COL_EX_PFOFILE_ID,DatabaseHelper.COL_EX_EVENT_ID,DatabaseHelper.COL_EX_TITLE,DatabaseHelper.COL_EX_AMOUNT},DatabaseHelper.COL_EX_ID+" = "+id,null,null,null,null);
        
        cursor.moveToFirst();

        int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_ID));
        int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_PFOFILE_ID));
        int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_EVENT_ID));
        String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_TITLE));
        String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_AMOUNT));
        

        cursor.close();
        this.close();
        expenseModel=new ExpenseModel(mId,mProfileId,mEventId,mName,Double.parseDouble(mDescription));
        return expenseModel;
    }

    public ArrayList<ExpenseModel>getAllExpense(){
        ArrayList<ExpenseModel>expenseModels=new ArrayList<ExpenseModel>();
        this.open();

        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_EXPENSE,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
            	 int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_ID));
                 int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_PFOFILE_ID));
                 int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_EVENT_ID));
                 String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_TITLE));
                 String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_AMOUNT));
                expenseModel=new ExpenseModel(mId,mProfileId,mEventId,mName,Double.parseDouble(mDescription));
                
                cursor.moveToNext();
                expenseModels.add(expenseModel);
            }
        }
        cursor.close();
        this.close();
        return expenseModels;
    }
    
    public ArrayList<ExpenseModel>getAllExpenseFilter(int profile_id, int event_id){
        ArrayList<ExpenseModel>expenseModels=new ArrayList<ExpenseModel>();
        this.open();

        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_EXPENSE+" where "+DatabaseHelper.COL_EX_PFOFILE_ID+"='"+profile_id+"' and "+DatabaseHelper.COL_EX_EVENT_ID+"='"+event_id+"'",null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
            	 int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_ID));
                 int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_PFOFILE_ID));
                 int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_EX_EVENT_ID));
                 String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_TITLE));
                 String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EX_AMOUNT));
                expenseModel=new ExpenseModel(mId,mProfileId,mEventId,mName,Double.parseDouble(mDescription));
                
                cursor.moveToNext();
                expenseModels.add(expenseModel);
            }
        }
        cursor.close();
        this.close();
        return expenseModels;
    }


    public boolean updateExpense(int id,ExpenseModel expenseModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_EX_PFOFILE_ID,expenseModel.getEx_profile_id());
        contentValues.put(DatabaseHelper.COL_EX_EVENT_ID,expenseModel.getEx_event_id());
        contentValues.put(DatabaseHelper.COL_EX_TITLE,expenseModel.getEx_title());
        contentValues.put(DatabaseHelper.COL_EX_AMOUNT,expenseModel.getEx_amount());

        int updated=database.update(DatabaseHelper.TABLE_EXPENSE,contentValues,DatabaseHelper.COL_EX_ID+" = "+id,null);
        this.close();

        if(updated>0){
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteExpense(int profileId,int eventid){
        this.open();

        int deleted=database.delete(DatabaseHelper.TABLE_EXPENSE,DatabaseHelper.COL_EX_PFOFILE_ID+" = "+profileId+" AND "+
                DatabaseHelper.COL_EX_EVENT_ID+" = "+eventid,null);

        this.close();
        if(deleted>0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double getTotalExpense(int p_id, int e_id){
    	this.open();
    	Cursor cur = database.rawQuery("SELECT SUM("+DatabaseHelper.COL_EX_AMOUNT+") FROM "+DatabaseHelper.TABLE_EXPENSE+" WHERE "+DatabaseHelper.COL_EX_PFOFILE_ID+"="+p_id+" AND "+DatabaseHelper.COL_EX_EVENT_ID+"="+e_id, null);
    	if(cur.moveToFirst())
    	{
    	    return cur.getInt(0);
    	}else
    		return 0.0;
    }


}

