package theateam.com.tourmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import theateam.com.tourmanager.Database.MomentDBSource;
import theateam.com.tourmanager.ModelClass.MomentModel;

public class ViewMomentActivity extends AppCompatActivity {
	TextView momentName,momentDes,momentTime;
	ImageView momentImage;
	MomentDBSource momentDBSource;
    MomentModel momentModel;
	ScrollView setMyImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_moment);

		ActionBar supportActionBar = getSupportActionBar();
		supportActionBar.setDisplayHomeAsUpEnabled(true);
		momentName=(TextView) findViewById(R.id.momentNameView);
		momentDes=(TextView) findViewById(R.id.momentDescriptionView);
		momentTime=(TextView) findViewById(R.id.momentTimeView);
		momentImage=(ImageView) findViewById(R.id.momentImageView);
		momentDBSource=new MomentDBSource(this);
		
		int moment_id=getIntent().getIntExtra("moment_id",0);
		//Log.e("Id : ", Integer.toString(moment_id));
		momentModel=momentDBSource.getMomentModel(moment_id);
		momentName.setText(momentModel.getM_name());
		momentDes.setText(momentModel.getM_description());
		momentTime.setText(momentModel.getM_time());
		String imagePath=momentModel.getM_image();
		momentImage.setImageURI(Uri.parse(imagePath));
		setMyImage= (ScrollView) findViewById(R.id.setMyImage);
		
		
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
			ViewMomentActivity.this.finish();
		}
		else if(id == R.id.myHome)
		{
			startActivity(new Intent(this,ProfileHomeActivity.class));
			ViewMomentActivity.this.finish();
		}
		else if(id == android.R.id.home)
		{
			onBackPressed();
		}


		return super.onOptionsItemSelected(item);
	}
}
