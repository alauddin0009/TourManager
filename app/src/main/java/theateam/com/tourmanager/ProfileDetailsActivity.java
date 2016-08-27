package theateam.com.tourmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import theateam.com.tourmanager.Database.ProfileDBSource;
import theateam.com.tourmanager.ModelClass.ProfileModel;

public class ProfileDetailsActivity extends AppCompatActivity {
    ImageView proImageIV;
    TextView proNameTV;
    TextView proEmailTV;
    TextView proPassTV;
    TextView proMobileTV;
    TextView proEmergencyTV;
    ProfileDBSource profileDBSource;
    ProfileModel profileModel;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor; int proId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);
        //View view=this.getSupportActionBar().getCustomView();
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");



        proImageIV = (ImageView) findViewById(R.id.imgIVinProDetails);
        proNameTV = (TextView) findViewById(R.id.proNameTVinProDetails);
        proEmailTV = (TextView) findViewById(R.id.emailTVinProDetails);
        proPassTV = (TextView) findViewById(R.id.passTVinProDetails);
        proMobileTV = (TextView) findViewById(R.id.mobileNoTVinProDetails);
        proEmergencyTV = (TextView) findViewById(R.id.emergencyTVinProDetails);



        proId=Integer.parseInt(profile_id_String);

        profileDBSource = new ProfileDBSource(this);
        profileModel = profileDBSource.getProfileModel(proId);
        proNameTV.setText(profileModel.getName());
        proEmailTV.setText(profileModel.getEmail());
        proPassTV.setText(profileModel.getPassword());
        proMobileTV.setText(profileModel.getPhoneNumber());
        proEmergencyTV.setText(profileModel.getEmergencyNo());

        try
        {
            Uri proImageUrl = Uri.parse(profileModel.getImagePath());
            proImageIV.setImageURI(proImageUrl);
        }catch(Exception e)
        {

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_home,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {

            SharedPreferences sharedPreferences = getSharedPreferences("TourManager", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
            startActivity(new Intent(ProfileDetailsActivity.this,LogInActivity.class));
            ProfileDetailsActivity.this.finish();
        }
        else if(id == R.id.myHome)
        {

            startActivity(new Intent(this,ProfileHomeActivity.class));
            ProfileDetailsActivity.this.finish();
        }
        else if (id== android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }



    public void onProDetailClick(View view) {

        if (view.getId() == R.id.editBtninProDetails) {
            Intent singleIntent = new Intent(getApplicationContext(), ProfileInsertActivity.class);
            singleIntent.putExtra("id", getIntent().getIntExtra("id", 0));
            startActivity(singleIntent);
        }
        if (view.getId() == R.id.deleteBtninProDetails) {
            //if (profileDBSource.deleteProfile(getIntent().getIntExtra("id", 0))) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                // set title
                alertDialogBuilder.setTitle("Are you sure want to delete ? ");
                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to delete")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close current activity
                                //ProfileDetailsActivity.this.finish();
                                if (profileDBSource.deleteProfile(getIntent().getIntExtra("id", 0))) {
                                    Intent singleIntent=new Intent(getApplicationContext(),LogInActivity.class);
                                    startActivity(singleIntent);
                                    sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
                                    editor=sharedPreferences.edit();
                                    editor.clear();
                                    editor.commit();
                                    finish();

                                    Toast.makeText(ProfileDetailsActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();




                /*
                Intent singleIntent=new Intent(getApplicationContext(),LogInActivity.class);
                startActivity(singleIntent);
                Toast.makeText(ProfileDetailsActivity.this, "Deleted", Toast.LENGTH_SHORT).show();*/

        }
    }
}
