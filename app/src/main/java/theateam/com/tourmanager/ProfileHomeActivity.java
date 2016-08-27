package theateam.com.tourmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import theateam.com.tourmanager.AdapterClass.AdapterEvent;
import theateam.com.tourmanager.Database.EventDBSource;
import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.Database.MomentDBSource;
import theateam.com.tourmanager.Database.ProfileDBSource;
import theateam.com.tourmanager.ModelClass.EventModel;
import theateam.com.tourmanager.ModelClass.ProfileModel;
import theateam.com.tourmanager.Weather.MyWeather;
import theateam.com.tourmanager.mainClassAndMap.MainActivity;

public class ProfileHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EventDBSource eventDBSource;
    ListView eventListView;
    ArrayList<EventModel> eventModels;
    LinearLayout noevent;
    ProfileModel profileModel;
    ProfileDBSource profileDBSource;
    ImageView profile_pic;
    TextView profile_name, profile_email,budgetheading;
    public static int profile_id_shared;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ExpenseDBSource expenseDBSource;
    MomentDBSource momentDatabaseSource;
    int proId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);
        noevent = (LinearLayout) findViewById(R.id.noevent);

        expenseDBSource=new ExpenseDBSource(this);
        momentDatabaseSource=new MomentDBSource(this);

        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
        proId=Integer.parseInt(profile_id_String);


//        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        String value=(mSharedPreference.getString("NameOfShared", "Default_Value"));

//        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
//        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
//        int profile_id_int=Integer.parseInt(profile_id_String);

        //navigation drawer start
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent insertEventIntent=new Intent(ProfileHomeActivity.this,EventInsertActivity.class);
                insertEventIntent.putExtra("profile_id_from_pro_home",proId);
                startActivity(insertEventIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //navigation drawer end
        eventDBSource=new EventDBSource(this);
        eventListView= (ListView) findViewById(R.id.eventList);


        eventModels=eventDBSource.getAllEventFilter(proId);


        Log.e("Total events ",eventModels.size()+"");
        if(eventModels.size()==0){
            /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileHomeActivity.this);
            // set title
            alertDialogBuilder.setTitle("You have no event now");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Click plus icon to create event")
                    .setCancelable(false)
                    .setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();*/
            noevent.setVisibility(View.VISIBLE);
        }
        Log.e("Profile Id Pro Ho : ", String.valueOf(proId));
//        ArrayAdapter<EventModel>eventModelArrayAdapter=new ArrayAdapter<EventModel>(this,android.R.layout.simple_list_item_1,eventModels);
//        eventListView.setAdapter(eventModelArrayAdapter);
        AdapterEvent customEventList=new AdapterEvent(ProfileHomeActivity.this,eventModels);
        eventListView.setAdapter(customEventList);
        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent singleIntent=new Intent(getApplicationContext(),EventHomeActivity.class);
                singleIntent.putExtra("event_id_from_pro_home",eventModels.get(i).getE_id());
                singleIntent.putExtra("profile_id_from_pro_home",proId);
                //Toast.makeText(ProfileHomeActivity.this, "Passing : "+eventModels.get(i).getE_id(), Toast.LENGTH_LONG).show();
                startActivity(singleIntent);
            }
        });

        eventListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileHomeActivity.this);
                // set title
                alertDialogBuilder.setTitle("Do you want to delete the event?");
                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to delete!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                int eventId =eventModels.get(position).getE_id();
                                if(eventDBSource.deleteEvent(eventId)){
                                    sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
                                    editor=sharedPreferences.edit();
                                    String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
                                    int proIdy=Integer.parseInt(profile_id_String);
                                    expenseDBSource.deleteExpense(proIdy,eventId);
                                    momentDatabaseSource.deleteMoment(proIdy,eventId);
                                    Toast.makeText(getApplicationContext(), "Event Deleted", Toast.LENGTH_LONG).show();
                                    startActivity(getIntent());
                                }
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();

                return true;
            }
        });


        profileDBSource=new ProfileDBSource(this);
        //int profile_id=getIntent().getIntExtra("profile_id_from_login",0);

        //View hview=navigationView.inflateHeaderView(R.layout.nav_header_profile_home);
        View hview = navigationView.getHeaderView(0);
        profile_name = (TextView) hview.findViewById(R.id.textViewProfileName);
        profile_email = (TextView) hview.findViewById(R.id.textViewProfileEmail);
        profile_pic = (ImageView) hview.findViewById(R.id.imageViewProfile);
        Log.e("Before Error Id ", String.valueOf(proId));
        Uri imageUri=null;
        try
        {
            profile_name.setText(profileDBSource.getProfileModel(proId).getName());
            profile_email.setText(profileDBSource.getProfileModel(proId).getEmail());
            imageUri= Uri.parse(profileDBSource.getProfileModel(proId).getImagePath());
            Picasso.with(ProfileHomeActivity.this).load(imageUri)
                    .transform(new CircleTransform())
                    //  .resize(60, 60)
                    //.centerCrop()
                    .fit()
                    .centerInside()
                    // .error(R.drawable.app_logo)
                    .into(profile_pic);
        }
        catch (Exception e)
        {

        }

        //Log.e("imageurl",imageUri.toString());
       // profile_pic.setImageURI(imageUri);

        //profile_pic.setImageResource(R.mipmap.ic_launcher);
        //Toast.makeText(ProfileHomeActivity.this,"Name :"+profileDBSource.getProfileModel(profile_id).getName()+"E-mail :"+profileDBSource.getProfileModel(profile_id).getEmail(),Toast.LENGTH_LONG ).show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_home_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            SharedPreferences sharedPreferences = getSharedPreferences("TourManager", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            startActivity(new Intent(this,LogInActivity.class));
            ProfileHomeActivity.this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_weather) {
            startActivity(new Intent(ProfileHomeActivity.this, MyWeather.class));
        } else if (id == R.id.nav_nearby) {
            startActivity(new Intent(ProfileHomeActivity.this, MainActivity.class));

        } else if (id == R.id.nav_my_account) {
            Intent singleIntent=new Intent(getApplicationContext(),ProfileDetailsActivity.class);
            singleIntent.putExtra("id",proId);
            startActivity(singleIntent);

        } /*else if (id == R.id.nav_edit_account) {
            Intent singleIntent=new Intent(getApplicationContext(),ProfileInsertActivity.class);
            singleIntent.putExtra("id",getIntent().getIntExtra("profile_id_from_login",0));
            startActivity(singleIntent);

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void insertEvent(View v){
        Intent insertEventIntent=new Intent(getApplicationContext(),EventInsertActivity.class);
        insertEventIntent.putExtra("profile_id_from_pro_home",proId);
        startActivity(insertEventIntent);
    }
}
