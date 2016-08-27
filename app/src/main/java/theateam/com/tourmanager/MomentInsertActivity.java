package theateam.com.tourmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import theateam.com.tourmanager.Database.MomentDBSource;
import theateam.com.tourmanager.ModelClass.MomentModel;

public class MomentInsertActivity extends AppCompatActivity {
    EditText nameEt,descriptionEt,timeEt,imageEt;
    String name,description,time,imagePath;
    Uri fileUri;
	Button btnCamera;
	ImageView cameraImageViewMoment;
    int profile_id,event_id;
    MomentDBSource eventDatabaseSource;
    MomentModel eventModel;
    boolean status;
    int id;
    Button eventSaveButton;
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventDatabaseSource=new MomentDBSource(this);
        setContentView(R.layout.activity_moment_insert);
        eventSaveButton= (Button) findViewById(R.id.saveBtn);

		sharedPreferences=getSharedPreferences("TourManager",MODE_PRIVATE);
		editor=sharedPreferences.edit();
		String profile_id_String=sharedPreferences.getString("Pofile_Id","0");

		 profile_id=Integer.parseInt(profile_id_String);
	//	profile_id=getIntent().getIntExtra("profile_id_fro_Ev_Ho",0);
		event_id=getIntent().getIntExtra("event_id_fro_Ev_Ho",0);

		ActionBar supportActionBar = getSupportActionBar();
		supportActionBar.setDisplayHomeAsUpEnabled(true);


        nameEt= (EditText) findViewById(R.id.momentNameEntry);
        descriptionEt= (EditText) findViewById(R.id.momentDescriEntry);
        timeEt= (EditText) findViewById(R.id.momentTimeEntry);
        //imageEt=(EditText) findViewById(R.id.momentImageEntry);
        //Camera code start
        imageEt=(EditText) findViewById(R.id.imagePathView);
        cameraImageViewMoment = (ImageView) findViewById(R.id.momentImageEntry);

		cameraImageViewMoment.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				fileUri = getOutputMediaFileUri(ProfileInsertActivity.MEDIA_TYPE_IMAGE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
				startActivityForResult(intent,ProfileInsertActivity.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

			}
		});
        //camera code end
        id=getIntent().getIntExtra("id",0);
        if(id>0){
            eventModel=eventDatabaseSource.getMomentModel(id);
            nameEt.setText(eventModel.getM_name());
            descriptionEt.setText(eventModel.getM_description());
            timeEt.setText(eventModel.getM_time());
            imageEt.setText(eventModel.getM_image());
            eventSaveButton.setText("update");
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
			MomentInsertActivity.this.finish();
		}
		else if(id == R.id.myHome)
		{
			startActivity(new Intent(this,ProfileHomeActivity.class));
			MomentInsertActivity.this.finish();
		}
		else if(id == android.R.id.home)
		{
			onBackPressed();
		}


		return super.onOptionsItemSelected(item);
	}

    public void save(View view) {
    	if (nameEt.getText().toString().matches("")
				|| descriptionEt.getText().toString().trim().length()>80
				|| imageEt.getText().toString().matches("")) {
			if (nameEt.getText().toString().matches("")) {
				nameEt.setError("Choose a title");
			}
			if (descriptionEt.getText().toString().trim().length()>80) {
				descriptionEt.setError("Maximum length is 80 words");
			}
			if (imageEt.getText().toString().matches("")) {
				Toast.makeText(MomentInsertActivity.this, "Capture a photo", Toast.LENGTH_LONG).show();
			}

		} else {
        name=nameEt.getText().toString().trim();
        String newTeme = new SimpleDateFormat("yyyy-MM-dd"+"\n"+"hh:mm aa").format(new Date());
        time=newTeme.toString();
        imagePath=fileUri.toString();
        Log.e("Pathe Entering :", imagePath);
        description=descriptionEt.getText().toString();
        eventModel=new MomentModel(profile_id,event_id,name,description,time,imagePath);
        if(id>0){
            status=eventDatabaseSource.updateMoment(id,eventModel);
        }else {
            status=eventDatabaseSource.addMoment(eventModel);
        }
			//Toast.makeText(MomentInsertActivity.this,String.valueOf(status), Toast.LENGTH_SHORT).show();
			Intent homeIntent=new Intent(this,EventHomeActivity.class);
			homeIntent.putExtra("event_id_from_pro_home",event_id);
			homeIntent.putExtra("profile_id_from_pro_home",profile_id);
			startActivity(homeIntent);
			MomentInsertActivity.this.finish();
		}

    }
    //Image path code camera
    private static Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}

	private static File getOutputMediaFile(int type) {
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "TourMate");

		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d("TourMate", "failed to create directory");
				return null;
			}
		}

		// Create a media file name
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		File mediaFile;
		if (type == ProfileInsertActivity.MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "TM_M" + timeStamp + ".jpg");
		} else {
			return null;
		}
		return mediaFile;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == ProfileInsertActivity.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

			if (resultCode == RESULT_OK) {
				cameraImageViewMoment.setBackgroundDrawable(null);
				//cameraImageViewMoment.setImageURI(fileUri);

				Picasso.with(this).load(fileUri)
						.transform(new CircleTransform())
						.fit()
						.into(cameraImageViewMoment);
				imageEt.setText(fileUri.toString());
				//Log.e("filePath : ", fileUri.toString());
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(MomentInsertActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(MomentInsertActivity.this, "Can con be captured", Toast.LENGTH_LONG).show();
			}
		}
	}


	//Image path code camera end
}