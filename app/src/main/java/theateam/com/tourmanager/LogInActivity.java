package theateam.com.tourmanager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import theateam.com.tourmanager.Database.ProfileDBSource;

public class LogInActivity extends Activity {
    ProfileDBSource profileDBSource;
    EditText userEmailET,userPassET;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        profileDBSource=new ProfileDBSource(this);
        userEmailET=(EditText) findViewById(R.id.userNameET);
        userPassET=(EditText) findViewById(R.id.passwordTF);
        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
        int profile_id_int=Integer.parseInt(profile_id_String);

        if(profile_id_int>0){
            Intent profilePageIntent=new Intent(getApplicationContext(),ProfileHomeActivity.class);
            profilePageIntent.putExtra("profile_id_from_login",profile_id_int);
            startActivity(profilePageIntent);
            LogInActivity.this.finish();
        }



    }
    public void onButtonClick(View view){
        if(userEmailET.getText().toString().matches("")||userPassET.getText().toString().matches("")){
            if(userEmailET.getText().toString().matches("")){
                userEmailET.setError("Your Email Please");
            }
            if(userPassET.getText().toString().matches("")){
                userPassET.setError("Your Password Please");
            }

        }else{
            if(profileDBSource.isMemberExist(userEmailET.getText().toString(), userPassET.getText().toString())){
                int profile_id=profileDBSource.memberProfileId(userEmailET.getText().toString(), userPassET.getText().toString());
                Log.e("Saving P Id :", String.valueOf(profile_id));
                editor.putString("Pofile_Id",String.valueOf(profile_id));
                editor.commit();
                Intent profilePageIntent=new Intent(getApplicationContext(),ProfileHomeActivity.class);
                profilePageIntent.putExtra("profile_id_from_login",profile_id);
                startActivity(profilePageIntent);
                LogInActivity.this.finish();

            }else{
                Toast.makeText(LogInActivity.this, "Email and Password Not Matching", Toast.LENGTH_LONG).show();
            }
        }

    }
    public void onSignUpButtonClick(View v){
        Intent signUpPageIntent=new Intent(getApplicationContext(),ProfileInsertActivity.class);
        startActivity(signUpPageIntent);
    }
}
