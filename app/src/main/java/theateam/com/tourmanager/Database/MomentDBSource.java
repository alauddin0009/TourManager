package theateam.com.tourmanager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import theateam.com.tourmanager.ModelClass.MomentModel;

public class MomentDBSource {
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    MomentModel momentModel;

    public MomentDBSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }


    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }

    public boolean addMoment(MomentModel contactModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_M_PFOFILE_ID,contactModel.getM_profile_id());
        contentValues.put(DatabaseHelper.COL_M_EVENT_ID,contactModel.getM_event_id());
        contentValues.put(DatabaseHelper.COL_M_NAME,contactModel.getM_name());
        contentValues.put(DatabaseHelper.COL_M_DES,contactModel.getM_description());
        contentValues.put(DatabaseHelper.COL_M_TIME,contactModel.getM_time());
        contentValues.put(DatabaseHelper.COL_M_IMAGE,contactModel.getM_image());


        long inserted=database.insert(DatabaseHelper.TABLE_MOMENT,null,contentValues);

        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }

    }

    public MomentModel getMomentModel(int id){
        this.open();

        Cursor cursor=database.query(DatabaseHelper.TABLE_MOMENT,new String[]{DatabaseHelper.COL_M_ID,DatabaseHelper.COL_M_PFOFILE_ID,DatabaseHelper.COL_M_EVENT_ID,DatabaseHelper.COL_M_NAME,DatabaseHelper.COL_M_DES,DatabaseHelper.COL_M_TIME,DatabaseHelper.COL_M_IMAGE},DatabaseHelper.COL_M_ID+" = "+id,null,null,null,null);
        
        cursor.moveToFirst();

        int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_ID));
        int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_PFOFILE_ID));
        int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_EVENT_ID));
        String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_NAME));
        String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_DES));
        String mTime=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_TIME));
        String mImage=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_IMAGE));
        

        cursor.close();
        this.close();
        momentModel=new MomentModel(mId,mProfileId,mEventId,mName,mDescription,mTime,mImage);
        return momentModel;
    }

    public ArrayList<MomentModel>getAllMoment(){
        ArrayList<MomentModel>contactModels=new ArrayList<MomentModel>();
        this.open();

        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_MOMENT,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
            	int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_ID));
                int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_PFOFILE_ID));
                int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_EVENT_ID));
                String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_NAME));
                String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_DES));
                String mTime=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_TIME));
                String mImage=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_IMAGE));
                momentModel=new MomentModel(mId,mProfileId,mEventId,mName,mDescription,mTime,mImage);
                
                cursor.moveToNext();
                contactModels.add(momentModel);
            }
        }
        cursor.close();
        this.close();
        return contactModels;
    }
    
    public ArrayList<MomentModel>getAllMomentFilter(int profile_id, int event_id){
        ArrayList<MomentModel>contactModels=new ArrayList<MomentModel>();
        this.open();

        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_MOMENT+" where "+DatabaseHelper.COL_M_PFOFILE_ID+"='"+profile_id+"' and "+DatabaseHelper.COL_M_EVENT_ID+"='"+event_id+"'",null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
            	int mId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_ID));
                int mProfileId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_PFOFILE_ID));
                int mEventId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_M_EVENT_ID));
                String mName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_NAME));
                String mDescription=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_DES));
                String mTime=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_TIME));
                String mImage=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_M_IMAGE));
                momentModel=new MomentModel(mId,mProfileId,mEventId,mName,mDescription,mTime,mImage);
                
                cursor.moveToNext();
                contactModels.add(momentModel);
            }
        }
        cursor.close();
        this.close();
        return contactModels;
    }


    public boolean updateMoment(int id,MomentModel contactModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_M_PFOFILE_ID,contactModel.getM_profile_id());
        contentValues.put(DatabaseHelper.COL_M_EVENT_ID,contactModel.getM_event_id());
        contentValues.put(DatabaseHelper.COL_M_NAME,contactModel.getM_name());
        contentValues.put(DatabaseHelper.COL_M_DES,contactModel.getM_description());
        contentValues.put(DatabaseHelper.COL_M_TIME,contactModel.getM_time());
        contentValues.put(DatabaseHelper.COL_M_IMAGE,contactModel.getM_image());

        int updated=database.update(DatabaseHelper.TABLE_MOMENT,contentValues,DatabaseHelper.COL_M_ID+" = "+id,null);
        this.close();

        if(updated>0){
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteMoment(int id){
        this.open();

        int deleted=database.delete(DatabaseHelper.TABLE_MOMENT,DatabaseHelper.COL_M_ID+" = "+id,null);

        this.close();
        if(deleted>0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteMoment(int profileid,int eventid)
    {
        this.open();
        int deleted=database.delete(DatabaseHelper.TABLE_MOMENT,DatabaseHelper.COL_M_EVENT_ID+" = "+profileid+" AND "+
                DatabaseHelper.COL_M_PFOFILE_ID+" = "+eventid,null);

        this.close();
        if(deleted>0){
            return true;
        }
        else {
            return false;
        }

    }


}
