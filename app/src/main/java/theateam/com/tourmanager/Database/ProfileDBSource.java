package theateam.com.tourmanager.Database;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import theateam.com.tourmanager.ModelClass.ProfileModel;

public class ProfileDBSource {
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    ProfileModel profileModel;

    public ProfileDBSource(Context context) {
        databaseHelper=new DatabaseHelper(context);
    }


    public void open(){
        database=databaseHelper.getWritableDatabase();
    }
    public void close(){
        databaseHelper.close();
    }

    public boolean addProfile(ProfileModel profileModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME,profileModel.getName());
        contentValues.put(DatabaseHelper.COL_EMAIL, profileModel.getEmail());
        contentValues.put(DatabaseHelper.COL_PASSWORD, profileModel.getPassword());
        contentValues.put(DatabaseHelper.COL_IMAGEPATH, profileModel.getImagePath());
        contentValues.put(DatabaseHelper.COL_PHONE,profileModel.getPhoneNumber());
        contentValues.put(DatabaseHelper.COL_EMERGENCY, profileModel.getEmergencyNo());


        long inserted=database.insert(DatabaseHelper.TABLE_PROFILE,null,contentValues);

        this.close();
        if(inserted>0){
            return true;
        }else {
            return false;
        }

    }

    public ProfileModel getProfileModel(int id){
        this.open();

        Cursor cursor=database.query(DatabaseHelper.TABLE_PROFILE,new String[]{
                DatabaseHelper.COL_ID,DatabaseHelper.COL_NAME,DatabaseHelper.COL_EMAIL,
                DatabaseHelper.COL_PASSWORD,DatabaseHelper.COL_IMAGEPATH,DatabaseHelper.COL_PHONE,
                DatabaseHelper.COL_EMERGENCY},
                DatabaseHelper.COL_ID+" = "+id,null,null,null,null);

        cursor.moveToFirst();

        int pId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));//error
        String pName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
        String pEmail=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
        String pPassword=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));
        String pImagePath=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_IMAGEPATH));
        String pPhone=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONE));
        String pEmergency=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMERGENCY));

        cursor.close();
        this.close();
        profileModel=new ProfileModel(pId,pName,pEmail,pPassword,pImagePath,pPhone,pEmergency);
        return profileModel;
    }

    public ArrayList<ProfileModel>getAllProfile(){
        ArrayList<ProfileModel>profileModels=new ArrayList<ProfileModel>();
        this.open();

        Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_PROFILE,null);

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                int pId=cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String pName=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String pEmail=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMAIL));
                String pPassword=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PASSWORD));
                String pImagePath=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_IMAGEPATH));
                String pPhone=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PHONE));
                String pEmergency=cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_EMERGENCY));
                profileModel=new ProfileModel(pId,pName,pEmail,pPassword,pImagePath,pPhone,pEmergency);
                cursor.moveToNext();
                profileModels.add(profileModel);
            }
        }
        cursor.close();
        this.close();
        return profileModels;
    }


    public boolean updateProfile(int id,ProfileModel profileModel){
        this.open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_NAME,profileModel.getName());
        contentValues.put(DatabaseHelper.COL_EMAIL, profileModel.getEmail());
        contentValues.put(DatabaseHelper.COL_PASSWORD, profileModel.getPassword());
        contentValues.put(DatabaseHelper.COL_IMAGEPATH, profileModel.getImagePath());
        contentValues.put(DatabaseHelper.COL_PHONE,profileModel.getPhoneNumber());
        contentValues.put(DatabaseHelper.COL_EMERGENCY, profileModel.getEmergencyNo());

        int updated=database.update(DatabaseHelper.TABLE_PROFILE,contentValues,DatabaseHelper.COL_ID+" = "+id,null);
        this.close();

        if(updated>0){
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteProfile(int id){
        this.open();

        int deleted=database.delete(DatabaseHelper.TABLE_PROFILE,DatabaseHelper.COL_ID+" = "+id,null);

        this.close();
        if(deleted>0){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isMemberExist(String email,String password){
    	this.open();
    	Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_PROFILE+" where "+DatabaseHelper.COL_EMAIL+"='"+email+"' and "+DatabaseHelper.COL_PASSWORD+"='"+password+"'",null);  
    	cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
        return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmailExist(String email){
    	this.open();
    	Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_PROFILE+" where "+DatabaseHelper.COL_EMAIL+"='"+email+"'",null);  
    	cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
        return true;
        }
        else{
            return false;
        }
    }
    public int memberProfileId(String email,String password){
    	this.open();
    	Cursor cursor=database.rawQuery("select * from "+DatabaseHelper.TABLE_PROFILE+" where "+DatabaseHelper.COL_EMAIL+"='"+email+"' and "+DatabaseHelper.COL_PASSWORD+"='"+password+"'",null);  
    	cursor.moveToFirst();
        if(cursor.getCount()>0)
        {
        return cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
        }
        else{
            return 0;
        }
    }


}
