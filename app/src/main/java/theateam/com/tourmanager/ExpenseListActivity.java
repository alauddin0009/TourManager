package theateam.com.tourmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import theateam.com.tourmanager.AdapterClass.AdapterExpense;
import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.ModelClass.ExpenseModel;



public class ExpenseListActivity extends AppCompatActivity {

	ExpenseDBSource expenseDatabaseSource;
	TextView totalExpenseTV;
    ListView expenseListView;
    ArrayList<ExpenseModel>expenseModels;
    int profile_id, event_id;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_list);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");

        profile_id=Integer.parseInt(profile_id_String);
        // profile_id=getIntent().getIntExtra("profile_id_fro_Ev_Ho",0);
        event_id=getIntent().getIntExtra("event_id_fro_Ev_Ho",0);
        expenseDatabaseSource=new ExpenseDBSource(this);
        expenseListView= (ListView) findViewById(R.id.expenseList);
        totalExpenseTV=(TextView) findViewById(R.id.totalExpenseTextView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabExpense);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entryIntent=new Intent(ExpenseListActivity.this,ExpenseInsertActivity.class);
                entryIntent.putExtra("profile_id_from_Expe_list",profile_id);
                entryIntent.putExtra("event_id_from_Expe_list",event_id);
                startActivity(entryIntent);
                ExpenseListActivity.this.finish();
            }
        });
        //set total expense
        double totalExpense=expenseDatabaseSource.getTotalExpense(profile_id,event_id);//profile id and event id
        totalExpenseTV.setText(String.valueOf("Total Expense :"+totalExpense));
        //set total expense end
        //expenseModels=expenseDatabaseSource.getAllExpense();
        expenseModels=expenseDatabaseSource.getAllExpenseFilter(profile_id, event_id);
       
        //Toast.makeText(MainActivity.this, expenseModels.toString(), Toast.LENGTH_LONG).show();
        //Log.e("Array ", expenseModels.toString());
//        ArrayAdapter<ExpenseModel>expenseModelArrayAdapter=new ArrayAdapter<ExpenseModel>(this,android.R.layout.simple_list_item_1,expenseModels);
//        expenseListView.setAdapter(expenseModelArrayAdapter);
        AdapterExpense customExpenseList=new AdapterExpense(this,expenseModels);
        expenseListView.setAdapter(customExpenseList);
        expenseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Intent singleIntent=new Intent(getApplicationContext(),SingleDetailsActivity.class);
                //singleIntent.putExtra("id",expenseModels.get(i).getEx_id());
              //  Toast.makeText(ExpenseListActivity.this, "Passing : "+expenseModels.get(i).getEx_id(), Toast.LENGTH_LONG).show();
                //startActivity(singleIntent);
            }
        });
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
            startActivity(new Intent(this,LogInActivity.class));
            ExpenseListActivity.this.finish();
        }
        else if(id == R.id.myHome)
        {
            startActivity(new Intent(this,ProfileHomeActivity.class));
            ExpenseListActivity.this.finish();
        }
        else if(id == android.R.id.home)
        {
            onBackPressed();
        }


        return super.onOptionsItemSelected(item);
    }

    public void expenseInsert(View view) {
        Intent entryIntent=new Intent(this,ExpenseInsertActivity.class);
        entryIntent.putExtra("profile_id_from_Expe_list",profile_id);
        entryIntent.putExtra("event_id_from_Expe_list",event_id);
        startActivity(entryIntent);
    }
}
