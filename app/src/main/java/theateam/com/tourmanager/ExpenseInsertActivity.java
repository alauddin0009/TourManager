package theateam.com.tourmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import theateam.com.tourmanager.Database.ExpenseDBSource;
import theateam.com.tourmanager.ModelClass.ExpenseModel;

public class ExpenseInsertActivity extends AppCompatActivity {
    EditText profileIDEt,eventIdEt,titleEt,amountEt;
    String title;
    int event_Id;
    double amount;
    ExpenseDBSource expenseDBSource;
    ExpenseModel expenseModel;
    boolean status;
    int id;
    Button expenseSaveBtn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int profile_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_insert);

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);

        sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String profile_id_String=sharedPreferences.getString("Pofile_Id","0");


        profile_id=Integer.parseInt(profile_id_String);
        //profile_id=getIntent().getIntExtra("profile_id_from_Expe_list",0);
        event_Id=getIntent().getIntExtra("event_id_from_Expe_list",0);
        expenseDBSource=new ExpenseDBSource(this);
        expenseSaveBtn= (Button) findViewById(R.id.saveBtn);
        titleEt= (EditText) findViewById(R.id.expenseTitleEntry);
        amountEt= (EditText) findViewById(R.id.expenseAmountEntry);
        
        id=getIntent().getIntExtra("id",0);
        if(id>0){
            expenseModel=expenseDBSource.getExpenseModel(id);
            titleEt.setText(expenseModel.getEx_title());
            String total2= new Double(expenseModel.getEx_amount()).toString();
            amountEt.setText(total2);

            expenseSaveBtn.setText("update");
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
            startActivity(new Intent(this,LogInActivity.class));
            ExpenseInsertActivity.this.finish();
        }
        else if(id == R.id.myHome)
        {

            startActivity(new Intent(this,ProfileHomeActivity.class));
            ExpenseInsertActivity.this.finish();
        }
        else if (id== android.R.id.home)
        {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveExpense(View view) {
    	if (titleEt.getText().toString().matches("")
				|| amountEt.getText().toString().matches("")) {
			if (titleEt.getText().toString().matches("")) {
				titleEt.setError("Choose a title");
			}
			if (amountEt.getText().toString().matches("")) {
				amountEt.setError("Enter Amount");
			}

		} else {
        title=titleEt.getText().toString();
        amount=Double.parseDouble(amountEt.getText().toString());
        expenseModel=new ExpenseModel(profile_id,event_Id,title,amount);
        if(id>0){
            status=expenseDBSource.updateExpense(id,expenseModel);
        }else {
            status=expenseDBSource.addExpense(expenseModel);
        }
       // Toast.makeText(ExpenseInsertActivity.this,String.valueOf(status), Toast.LENGTH_SHORT).show();
        Intent homeIntent=new Intent(this,ExpenseListActivity.class);
            homeIntent.putExtra("profile_id_fro_Ev_Ho",profile_id);
            homeIntent.putExtra("event_id_fro_Ev_Ho",event_Id);
        startActivity(homeIntent);
            ExpenseInsertActivity.this.finish();

    }
    }
}