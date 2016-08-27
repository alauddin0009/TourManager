package theateam.com.tourmanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import theateam.com.tourmanager.Database.EventDBSource;
import theateam.com.tourmanager.ModelClass.EventModel;

public class EventInsertActivity extends AppCompatActivity {
	EditText nameEt,startEt,endEt,budgetEt;
	AutoCompleteTextView placeEntry;
    String name,place,start,end;
    ArrayList<String> cityList;
    private EditText tvDisplayDate;
	private Button btnChangeStartDate,btnChangeEndDate;
	private int year;
	private int month;
	private int day;
	static final int DATE_DIALOG_START_ID = 999;
	static final int DATE_DIALOG_END_ID=10;
    double budget;
    EventDBSource eventDatabaseSource;
    EventModel eventModel;
    boolean status;
	String profile_id_String;
    int id;
    Button saveBtn,btnChangeDate;
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;int  proId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventDatabaseSource=new EventDBSource(this);
        setContentView(R.layout.activity_event_insert);

		ActionBar supportActionBar = getSupportActionBar();
		supportActionBar.setDisplayHomeAsUpEnabled(true);
		sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
		editor=sharedPreferences.edit();


        //Datepicker
        addListenerOnButton();
        //Datepicker
        saveBtn= (Button) findViewById(R.id.saveBtn);
        nameEt= (EditText) findViewById(R.id.eventNameEntry);
        placeEntry= (AutoCompleteTextView) findViewById(R.id.eventPlaceEntry);
        startEt= (EditText) findViewById(R.id.eventStartEntry);
        endEt=(EditText) findViewById(R.id.eventEndEntry);
        budgetEt= (EditText) findViewById(R.id.budgetEntry);
        btnChangeDate=(Button) findViewById(R.id.btnChangeDate);
        addCityToAutoComplete();
        
        ArrayAdapter cityAdapter=new ArrayAdapter(EventInsertActivity.this,android.R.layout.simple_spinner_dropdown_item,cityList);
        placeEntry.setThreshold(1);
        placeEntry.setAdapter(cityAdapter);
        //placeEntry.setOnItemClickListener(EventInsertActivity.this);
        id=getIntent().getIntExtra("id",0);
		Log.d("Id in E I A", String.valueOf(id) );
		if(id>0){
        	Calendar c = Calendar.getInstance(); 
        	int day = c.get(Calendar.DAY_OF_MONTH);
        	int month = c.get(Calendar.MONTH);
        	int year = c.get(Calendar.YEAR);
        	String currentDate=String.valueOf(month+1)+"-"+String.valueOf(day)+"-"+String.valueOf(year);
        	SimpleDateFormat dateFormatUpdat = new SimpleDateFormat(
                    "MM-dd-yyyy");
    		Date currentDateIndate = new Date();
    		Date previousDateInDB = new Date();
			try{
    			currentDateIndate = dateFormatUpdat.parse(currentDate);
        		//previousDateInDB = dateFormatUpdat.parse(eventDatabaseSource.getEventModel(id).getE_start());
				previousDateInDB = dateFormatUpdat.parse(eventDatabaseSource.getEventModel(id).getE_start());

				Log.e("Previous : ", previousDateInDB.toString() );
				Log.e("current : ", currentDateIndate.toString() );
        		if(currentDateIndate.after(previousDateInDB)){
        			btnChangeDate.setVisibility(View.GONE);
        		}
    		}catch (ParseException e) {
    			e.printStackTrace();
				Log.e("Catch Exception: ", "not working " );
			}
    		
            eventModel=eventDatabaseSource.getEventModel(id);
            //profileIDEt.setText(eventModel.getE_profile_id());
            nameEt.setText(eventModel.getE_name());
            placeEntry.setText(eventModel.getE_place());
            startEt.setText(eventModel.getE_start());
            endEt.setText(eventModel.getE_end());
            String total2= new Double(eventModel.getE_budget()).toString();
            budgetEt.setText(total2);

            saveBtn.setText("update");
			setTitle("Update Event");
        }
		else
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
			startActivity(new Intent(this,LogInActivity.class));
			EventInsertActivity.this.finish();
		}
		else if(id == R.id.myHome)
		{

			startActivity(new Intent(this,ProfileHomeActivity.class));
			EventInsertActivity.this.finish();
		}
		else if (id== android.R.id.home)
		{
			onBackPressed();
		}

		return super.onOptionsItemSelected(item);
	}

    public void save(View view) {
    	if ( nameEt.getText().toString().matches("")
				|| placeEntry.getText().toString().matches("")
				|| startEt.getText().toString().matches("")
				|| endEt.getText().toString().matches("")
				|| budgetEt.getText().toString().matches("")) {
			if (nameEt.getText().toString().matches("")) {
				nameEt.setError("Choose a title");
			}
			if (placeEntry.getText().toString().matches("")) {
				placeEntry.setError("Enter Visiting Place");
			}
			if (startEt.getText().toString().matches("")) {
				startEt.setError("Select Start Date");
			}
			if (endEt.getText().toString().matches("")) {
				endEt.setError("Select End Date");
			}
			if (budgetEt.getText().toString().matches("")) {
				budgetEt.setError("Enter Your Budget");
			}

		} else {
        name=nameEt.getText().toString().trim();
        //profile_id=Integer.parseInt(profileIDEt.getText().toString());
        start=startEt.getText().toString().trim();
        end=endEt.getText().toString().trim();
        place=placeEntry.getText().toString();
        budget=Double.parseDouble(budgetEt.getText().toString());
			profile_id_String=sharedPreferences.getString("Pofile_Id","0");
			  proId=Integer.parseInt(profile_id_String);
			Log.e("Profile Id Eve Ins : ", proId+"");
        eventModel=new EventModel(proId,name,place,start,end,budget);
        
        //Date Compare
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM-dd-yyyy");
		Date convertedDate = new Date();
		Date convertedDate2 = new Date();
	
		//Date compare
//        if(id>0){
//            status=eventDatabaseSource.updateEvent(id,eventModel);
//            
//        }else {
	            try {
	    			convertedDate = dateFormat.parse(start);
	    			convertedDate2 = dateFormat.parse(end);
	    			if (convertedDate2.after(convertedDate)||convertedDate2.equals(convertedDate)) {
	    				Log.e("Status", "dateEnd is Big");
	    				if(id>0){
	    					status=eventDatabaseSource.updateEvent(id,eventModel);
	    				}
	    				else{
	    				status=eventDatabaseSource.addEvent(eventModel);
	    				}
	    				Intent eventHomePage=new Intent(this,ProfileHomeActivity.class);
						String profile_id_String=sharedPreferences.getString("Pofile_Id","0");
						int id = Integer.parseInt(profile_id_String);
						Log.e("Id Aseni ", id+"");
						eventHomePage.putExtra("profile_id_from_login",id);
	    		        startActivity(eventHomePage);
						EventInsertActivity.this.finish();
	    			} else {
	    				Log.e("Status", "dateStart is Big");
	    				endEt.setError("Must After From Or Equal");
	    			}
	    		} catch (ParseException e) {
	    			e.printStackTrace();
	    		}
			//}
     //Toast.makeText(EventInsertActivity.this,String.valueOf(status), Toast.LENGTH_SHORT).show();
//        Intent eventHomePage=new Intent(this,EventListActivity.class);
//        startActivity(eventHomePage);
		} 

    }
    
    
    ///Code for Datepicker Start
    public void addListenerOnButton() {
		btnChangeStartDate = (Button) findViewById(R.id.btnChangeDate);
		btnChangeStartDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_START_ID);
			}
		});
		btnChangeEndDate=(Button) findViewById(R.id.btnChangeEndDate);
		btnChangeEndDate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_END_ID);
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_START_ID:
		   // set date picker as current date
		   //return new DatePickerDialog(this, datePickerListener, year, month,day);
		   DatePickerDialog dialog = new DatePickerDialog(this, datePickerListener, year, month, day);
		    //dialog.getDatePicker().setMaxDate(new Date().getTime());
		    dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
		    return dialog;
		case DATE_DIALOG_END_ID:
			String startDate=startEt.getText().toString().trim();
			DatePickerDialog dialogEnd = new DatePickerDialog(this, datePickerListenerEnd, year, month, day);
		
			
			dialogEnd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
			return dialogEnd;
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			startEt.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};
	private DatePickerDialog.OnDateSetListener datePickerListenerEnd = new DatePickerDialog.OnDateSetListener() {
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;

			// set selected date into textview
			endEt.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));

		}
	};
    ///Code for Datepicker End
   
	public void addCityToAutoComplete(){
		cityList= new ArrayList<String>();
        cityList.add("Barguna"); cityList.add("Barisal"); cityList.add("Bhola"); cityList.add("Jhalokati"); cityList.add("Patuakhali");
        cityList.add("Pirojpur");cityList.add("Bandarban"); cityList.add("Brahmanbaria"); cityList.add("Chandpur"); cityList.add("Chittagong");
        cityList.add("Comilla");cityList.add("Cox's Bazar");cityList.add("Feni");cityList.add("Khagrachhari");cityList.add("Lakshmipur");
        cityList.add("Noakhal");cityList.add("Rangamati");cityList.add("Dhaka");cityList.add("Faridpur");
        cityList.add("Gazipur");cityList.add("Gopalganj");cityList.add("Jamalpur ");cityList.add("Kishoreganj");cityList.add("Madaripur");
        cityList.add("Manikganj");cityList.add("Munshiganj");cityList.add("Mymensingh");cityList.add("Narayanganj");cityList.add("Narsingdi");
        cityList.add("Netrakona");cityList.add("Rajbari");cityList.add("Shariatpur");cityList.add("Sherpur");cityList.add("Tangail");
        cityList.add("Bagerhat");cityList.add("Chuadanga");cityList.add("Jessore");cityList.add("Jhenaidah");cityList.add("Khulna");
        cityList.add("Kushtia");cityList.add("Magura");cityList.add("Meherpur");cityList.add("Narail");cityList.add("Satkhira");
        cityList.add("Bogra");cityList.add("Joypurhat");cityList.add("Naogaon");cityList.add("Natore");
        cityList.add("Nawabganj");cityList.add("Pabna");cityList.add("Rajshahi");cityList.add("Sirajganj");
        cityList.add("Dinajpur");cityList.add("Gaibandha");cityList.add("Kurigram");cityList.add("Lalmonirhat");
        cityList.add("Nilphamari");cityList.add("Panchagarh");cityList.add("Rangpur");cityList.add("Thakurgaon");
        cityList.add("Habiganj");cityList.add("Moulvibazar");cityList.add("Sunamganj");cityList.add("Sylhet");
	}

	
}
