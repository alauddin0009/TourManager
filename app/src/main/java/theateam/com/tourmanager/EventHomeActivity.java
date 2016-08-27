package theateam.com.tourmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import theateam.com.tourmanager.AdapterClass.AdapterMoment;
import theateam.com.tourmanager.Database.EventDBSource;
import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.Database.MomentDBSource;
import theateam.com.tourmanager.ModelClass.EventModel;
import theateam.com.tourmanager.ModelClass.MomentModel;
import theateam.com.tourmanager.Weather.MyWeather;


public class EventHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView eventHeaderName, eventHeaderPlace;
    TextView eventNameInEventHome, eventPlaceInEventHome,eventStartInEventHome,eventEndInEventHome,eventBudgetInEventHome;
    EventDBSource eventDBSource;
    ExpenseDBSource expenseDatabaseSource;
    int profile_id;
    int event_id;
    ListView momentList;
    MomentDBSource momentDatabaseSource;
    EventModel eventModel;
    ArrayList<MomentModel> momentModels;
    TextView emptyMoments;
    ExpenseDBSource expenseDBSource;
    TextView BudgetColoring;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        eventDBSource=new EventDBSource(this);
        expenseDatabaseSource=new ExpenseDBSource(this);

        event_id=getIntent().getIntExtra("event_id_from_pro_home",0);
        Log.e("Event id : ", event_id+"");
        Log.e("profile_id id : ", profile_id+"");

        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
       // int proIdy=

        profile_id= Integer.parseInt(profile_id_String);

        eventNameInEventHome= (TextView) findViewById(R.id.eventNameInEventHome);
        eventPlaceInEventHome= (TextView) findViewById(R.id.eventPlaceInEventHome);
        eventStartInEventHome= (TextView) findViewById(R.id.eventStartInEventHome);
        eventEndInEventHome= (TextView) findViewById(R.id.eventEndInEventHome);
        eventBudgetInEventHome= (TextView) findViewById(R.id.eventBudgetInEventHome);
        emptyMoments= (TextView) findViewById(R.id.emptyMoments);
        BudgetColoring = (TextView) findViewById(R.id.BudgetColoring);
        // Coloring

        double budgetStored=eventDBSource.getEventModel(event_id).getE_budget();
        expenseDBSource=new ExpenseDBSource(this);
        double totalexpense=expenseDBSource.getTotalExpense(profile_id, event_id);
        if(totalexpense>=budgetStored){
            BudgetColoring.setTextColor(Color.RED);
            eventBudgetInEventHome.setTextColor(Color.RED);
        }else if(totalexpense>=(budgetStored/4)){
            BudgetColoring.setTextColor(Color.BLUE);
            eventBudgetInEventHome.setTextColor(Color.BLUE);
        }else if(totalexpense>=budgetStored/2){
            BudgetColoring.setTextColor(Color.YELLOW);
            eventBudgetInEventHome.setTextColor(Color.YELLOW);
        }


        //

        momentDatabaseSource=new MomentDBSource(this);
        eventDBSource=new EventDBSource(this);
        eventModel=eventDBSource.getEventModel(event_id);
        eventNameInEventHome.setText(eventModel.getE_name());
        eventPlaceInEventHome.setText(eventModel.getE_place());
        eventStartInEventHome.setText(eventModel.getE_start());
        eventEndInEventHome.setText(eventModel.getE_end());
        eventBudgetInEventHome.setText(String.valueOf(eventModel.getE_budget()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent entryIntent=new Intent(EventHomeActivity.this,MomentInsertActivity.class);
                entryIntent.putExtra("profile_id_fro_Ev_Ho",profile_id);
                entryIntent.putExtra("event_id_fro_Ev_Ho",event_id);
                startActivity(entryIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //drawer end

        View hview = navigationView.getHeaderView(0);
        eventHeaderName = (TextView) hview.findViewById(R.id.eventHeaderName);
        eventHeaderPlace = (TextView) hview.findViewById(R.id.eventHeaderPlace);

        eventHeaderName.setText(eventDBSource.getEventModel(event_id).getE_name());
        eventHeaderPlace.setText(eventDBSource.getEventModel(event_id).getE_place());

        momentList= (ListView) findViewById(R.id.momentList);
        momentModels=momentDatabaseSource.getAllMomentFilter(profile_id,event_id);
        /*if(momentModels.size()==0){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EventHomeActivity.this);
            // set title
            alertDialogBuilder.setTitle("You have no moments right now");
            // set dialog message
            alertDialogBuilder
                    .setMessage("Click plus icon to create moment")
                    .setCancelable(false)
                    .setNegativeButton("Ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
        }*/
        AdapterMoment momentModelArrayAdapter=new AdapterMoment(this,momentModels);
        momentList.setAdapter(momentModelArrayAdapter);
        momentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent singleIntent=new Intent(getApplicationContext(),ViewMomentActivity.class);
                singleIntent.putExtra("moment_id",momentModels.get(i).getM_id());
                //Toast.makeText(MomentListActivity.this, "Passing : "+momentModels.get(i).getM_id(), Toast.LENGTH_LONG).show();
                //Log.e("Object : ", momentDatabaseSource.getContactModel(1).toString());
                startActivity(singleIntent);
            }
        });

        momentList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           final int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EventHomeActivity.this);
                // set title
                alertDialogBuilder.setTitle("Do you want to delete the Moment?");
                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to delete!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                if(momentDatabaseSource.deleteMoment(momentModels.get(position).getM_id())){
                                    Toast.makeText(getApplicationContext(), "Moment Deleted", Toast.LENGTH_LONG).show();
                                    startActivity(getIntent());
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

                return true;
            }
        });


        // Editing start from here


        EventModel eventModelForEvent=eventDBSource.getEventModel(event_id);
        String startDate=eventModelForEvent.getE_start();
        String endDate=eventModelForEvent.getE_end();
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String currentDate=String.valueOf(month+1)+"-"+String.valueOf(day)+"-"+String.valueOf(year);
        SimpleDateFormat dateFormatUpdat = new SimpleDateFormat(
                "MM-dd-yyyy");

        Date currentDateIndate = new Date();
        Date startDateInDate;
        Date endDateInDate;
        try{
            currentDateIndate = dateFormatUpdat.parse(currentDate);
            startDateInDate = dateFormatUpdat.parse(startDate);
            endDateInDate=dateFormatUpdat.parse(endDate);

            if(currentDateIndate.before(startDateInDate) || currentDateIndate.after(endDateInDate)){
                //saveBtnInMomentIns.setVisibility(View.GONE);
               // Toast.makeText(EventHomeActivity.this, "You can not add moment", Toast.LENGTH_SHORT).show();
                //saveBtnInMomentIns.setClickable(false);
                fab.setVisibility(View.GONE);
                if(currentDateIndate.before(startDateInDate))
                {
                   // d
                           // emptyMoments.setText("Event not started yet");
                            emptyMoments.setVisibility(View.VISIBLE);

                }
                else
                {
                   // emptyMoments.setText("Event not started yet");
                  //  emptyMoments.setVisibility(View.VISIBLE);

                }


            }

            else
            {
                fab.setVisibility(View.VISIBLE);
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }



        //  Editing end from here

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
        getMenuInflater().inflate(R.menu.profile_home, menu);
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
            EventHomeActivity.this.finish();
        }
        else if(id == R.id.myHome)
        {
            startActivity(new Intent(this,ProfileHomeActivity.class));
            EventHomeActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_event_weather) {

            startActivity(new Intent(this, MyWeather.class));
            // Handle the camera action
        } else if (id == R.id.nav_expense) {
            Intent expenseInsertIntent=new Intent(this,ExpenseListActivity.class);
            expenseInsertIntent.putExtra("profile_id_fro_Ev_Ho",profile_id);
            expenseInsertIntent.putExtra("event_id_fro_Ev_Ho",event_id);
            //Toast.makeText(EventHomeActivity.this,"Profile : "+String.valueOf(profile_id)+" Event : "+String.valueOf(event_id),Toast.LENGTH_LONG).show();
            startActivity(expenseInsertIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void editEventInEventHome(View view) {
        Intent eventEditIntent=new Intent(this,EventInsertActivity.class);
        eventEditIntent.putExtra("id",getIntent().getIntExtra("event_id_from_pro_home",0));
        eventEditIntent.putExtra("profile_id_from_pro_home", profile_id);
        Log.e("Passing In Edit : ",String.valueOf(getIntent().getIntExtra("event_id_from_pro_home",0)) );
        startActivity(eventEditIntent);
    }
}
