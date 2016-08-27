package theateam.com.tourmanager;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import theateam.com.tourmanager.Database.ProfileDBSource;
import theateam.com.tourmanager.ModelClass.ProfileModel;

public class ProfileInsertActivity extends AppCompatActivity {
	EditText nameEt,emailEt,passwordEt,emergencyEt,phoneEt,imagePathEntry;
	String name,email,password,imagepath;
	String phone,emergency;
	ProfileDBSource profileDBSource;
	ProfileModel profileModel;
	boolean status;
	public static final int RESULT_LOAD_IMG_Gallery=250;
	int id;
	Button saveBtn;
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	Uri fileUri;
	Button btnCamera;
	ImageView cameraImageView,applogo;
	RelativeLayout alreadyRegisteredRL;
	boolean flagEmailExist=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar supportActionBar = getSupportActionBar();
		supportActionBar.setDisplayHomeAsUpEnabled(true);
		profileDBSource=new ProfileDBSource(this);
		setContentView(R.layout.activity_profile_insert);
		saveBtn= (Button) findViewById(R.id.saveBtn);
		nameEt= (EditText) findViewById(R.id.nameEntry);
		emailEt=(EditText) findViewById(R.id.emailEntry);
		passwordEt=(EditText) findViewById(R.id.passwordEntry);
		phoneEt= (EditText) findViewById(R.id.phoneEntry);
		emergencyEt=(EditText) findViewById(R.id.emergencyEntry);
		imagePathEntry=(EditText) findViewById(R.id.imagePathEntry);
		applogo= (ImageView) findViewById(R.id.applogo);
		alreadyRegisteredRL= (RelativeLayout) findViewById(R.id.alreadyRegisteredRL);
		//Image Capture
		cameraImageView = (ImageView) findViewById(R.id.cameraImageView);

		cameraImageView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
				startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

			}
		});
		//Image Capture
		id=getIntent().getIntExtra("id",0);
		if(id>0){


			profileModel=profileDBSource.getProfileModel(id);
			nameEt.setText(profileModel.getName());
			emailEt.setText(profileModel.getEmail());
			emailEt.setFocusable(false);
			passwordEt.setText(profileModel.getPassword());
			//cameraImageView.setBackgroundDrawable(null);
			Uri myUri = Uri.parse(profileModel.getImagePath());
			applogo.setImageURI(myUri);
			imagePathEntry.setText(profileModel.getImagePath());
			phoneEt.setText(profileModel.getPhoneNumber());
			emergencyEt.setText(profileModel.getEmergencyNo());
			alreadyRegisteredRL.setVisibility(View.GONE);
			saveBtn.setText("Update");
			setTitle("Update Profile");
		}
	}


	// try menu

/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.profile_home,menu);
		return true;
	}
*/

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
/*
		if (id == R.id.action_logout) {
			SharedPreferences sharedPreferences = getSharedPreferences("TourManager", MODE_PRIVATE);
			SharedPreferences.Editor editor = sharedPreferences.edit();
			editor.clear();
			editor.commit();
			startActivity(new Intent(this,LogInActivity.class));
			ProfileInsertActivity.this.finish();
		}
		else if(id == R.id.myHome)
		{

			startActivity(new Intent(this,ProfileHomeActivity.class));
			ProfileInsertActivity.this.finish();
		}*/

		 if (id== android.R.id.home)
		{
			onBackPressed();
		}

		return super.onOptionsItemSelected(item);
	}


	//

	public void save(View view) {
		if(id==0) {
			if(profileDBSource.isEmailExist(emailEt.getText().toString())){
				flagEmailExist=true;
			}
		}

		if (nameEt.getText().toString().matches("")
				|| emailEt.getText().toString().matches("")
				|| passwordEt.getText().toString().matches("")
				|| phoneEt.getText().toString().matches("")
				|| emergencyEt.getText().toString().matches("")
				|| flagEmailExist
				|| !isValidEmail(emailEt.getText().toString())
				||!isValidPassword(passwordEt.getText().toString())){
			//|| profileDBSource.isEmailExist(emailEt.getText().toString())) {
			if (nameEt.getText().toString().matches("")) {
				nameEt.setError("Your Name Please");
			}

			if(flagEmailExist){
				emailEt.setError("E-mail Already Taken");
				flagEmailExist=false;
			}

			if (emailEt.getText().toString().matches("")) {
				emailEt.setError("Enter E-mail Id");
			}
			if (passwordEt.getText().toString().matches("")) {
				passwordEt.setError("Enter Password Id");
			}
			if (phoneEt.getText().toString().matches("")) {
				phoneEt.setError("Enter Phone Id");
			}
			if (emergencyEt.getText().toString().matches("")) {
				emergencyEt.setError("Enter Emergency Number");
			}
//			if(profileDBSource.isEmailExist(emailEt.getText().toString())){
//				emailEt.setError("Try another e-mail");
//			}
			if (!isValidEmail( emailEt.getText().toString())) {
				emailEt.setError("Invalid Email");
			}
			if(!isValidPassword(passwordEt.getText().toString()))
			{
				passwordEt.setError("Password should be atleast 6 Character and cannot be null");
			}

		} else {
			name=nameEt.getText().toString().trim();
			email=emailEt.getText().toString();
			password=passwordEt.getText().toString();
			imagepath=imagePathEntry.getText().toString();
			phone=phoneEt.getText().toString();
			emergency=emergencyEt.getText().toString();

			profileModel=new ProfileModel(name,email,password,imagepath,phone,emergency);
			if(id>0){
				status=profileDBSource.updateProfile(id,profileModel);
			}else {
				status=profileDBSource.addProfile(profileModel);
			}
			Toast.makeText(ProfileInsertActivity.this,"Account Information \nStored Successfully.", Toast.LENGTH_SHORT).show();
			Intent homeIntent=new Intent(this,LogInActivity.class);
			startActivity(homeIntent);
			ProfileInsertActivity.this.finish();
		}

	}
	//Image Capture code camera start
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
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "TM_" + timeStamp + ".jpg");
		} else {
			return null;
		}
		return mediaFile;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

			if (resultCode == RESULT_OK) {
				//cameraImageView.setBackgroundDrawable(null);
				applogo.setImageURI(fileUri);
				imagePathEntry.setText(fileUri.toString());
				//Log.e("filePath : ", fileUri.toString());
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(ProfileInsertActivity.this, "Camera cancelled", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(ProfileInsertActivity.this, "Can not be captured", Toast.LENGTH_LONG).show();
			}
		}

		else if (requestCode == RESULT_LOAD_IMG_Gallery) {
			if (resultCode == RESULT_OK) {
				Uri selectedImage = data.getData();
				//cameraImageView.setBackgroundDrawable(null);
				applogo.setImageURI(selectedImage);
				imagePathEntry.setText(selectedImage.toString());
				Log.e("MIne", selectedImage.toString());
				Toast.makeText(ProfileInsertActivity.this, "Image Selected", Toast.LENGTH_LONG).show();
			}else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(ProfileInsertActivity.this, "Gallery Cancelled", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(ProfileInsertActivity.this, "Error in selection", Toast.LENGTH_LONG).show();
			}
		}
	}

	//Image capture code camera end
	public void OnLogInClickProfile(View view){
		Intent logInIntent=new Intent(this,LogInActivity.class);
		startActivity(logInIntent);
	}
	private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	// validating password with retype password
	private boolean isValidPassword(String pass) {
		if (pass != null && pass.length() >= 6) {
			return true;
		}
		return false;
	}

	public void selectImageFromGallery(View view) {
		Intent galleryIntent = new Intent(Intent.ACTION_PICK,
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		startActivityForResult(galleryIntent, RESULT_LOAD_IMG_Gallery);

	}
}




/*
package theateam.com.tourmanager;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import theateam.com.tourmanager.Database.ProfileDBSource;
import theateam.com.tourmanager.ModelClass.ProfileModel;

public class ProfileInsertActivity extends Activity {
    EditText nameEt,emailEt,passwordEt,emergencyEt,phoneEt,imagePathEntry;
    String name,email,password,imagepath;
    String phone,emergency;
    ProfileDBSource profileDBSource;
    ProfileModel profileModel;
    boolean status;
    int id;
    Button saveBtn;
    public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	Uri fileUri;
	Button btnCamera;
	ImageView cameraImageView;
	RelativeLayout alreadyRegisteredRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileDBSource=new ProfileDBSource(this);
        setContentView(R.layout.activity_profile_insert);
        saveBtn= (Button) findViewById(R.id.saveBtn);
        nameEt= (EditText) findViewById(R.id.nameEntry);
        emailEt=(EditText) findViewById(R.id.emailEntry);
        passwordEt=(EditText) findViewById(R.id.passwordEntry);
        phoneEt= (EditText) findViewById(R.id.phoneEntry);
        emergencyEt=(EditText) findViewById(R.id.emergencyEntry);
        imagePathEntry=(EditText) findViewById(R.id.imagePathEntry);
		alreadyRegisteredRL= (RelativeLayout) findViewById(R.id.alreadyRegisteredRL);
        //Image Capture
        cameraImageView = (ImageView) findViewById(R.id.cameraImageView);

		cameraImageView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
				startActivityForResult(intent,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

			}
		});
        //Image Capture
        id=getIntent().getIntExtra("id",0);
        if(id>0){
            profileModel=profileDBSource.getProfileModel(id);
            nameEt.setText(profileModel.getName());
            emailEt.setText(profileModel.getEmail());
            passwordEt.setText(profileModel.getPassword());
            cameraImageView.setBackgroundDrawable(null);
            Uri myUri = Uri.parse(profileModel.getImagePath());
            cameraImageView.setImageURI(myUri);
            imagePathEntry.setText(profileModel.getImagePath());
            phoneEt.setText(profileModel.getPhoneNumber());
            emergencyEt.setText(profileModel.getEmergencyNo());
			alreadyRegisteredRL.setVisibility(View.GONE);
            saveBtn.setText("Update");
            setTitle("Update Profile");
        }
    }

    public void save(View view) {
    	if (nameEt.getText().toString().matches("")
				|| emailEt.getText().toString().matches("")
				|| passwordEt.getText().toString().matches("")
				|| phoneEt.getText().toString().matches("")
				|| emergencyEt.getText().toString().matches("")
				|| !isValidEmail(emailEt.getText().toString())
				|| !isValidEmail(emailEt.getText().toString())
				){
				//|| profileDBSource.isEmailExist(emailEt.getText().toString())) {
			if (nameEt.getText().toString().matches("")) {
				nameEt.setError("Your Name Please");
			}
			if (emailEt.getText().toString().matches("")) {
				emailEt.setError("Enter E-mail Id");
			}
			if (passwordEt.getText().toString().matches("")) {
				passwordEt.setError("Enter Password Id");
			}
			if (phoneEt.getText().toString().matches("")) {
				phoneEt.setError("Enter Phone Id");
			}
			if (emergencyEt.getText().toString().matches("")) {
				emergencyEt.setError("Enter Emergency Number");
			}
//			if(profileDBSource.isEmailExist(emailEt.getText().toString())){
//				emailEt.setError("Try another e-mail");
//			}
			if (!isValidEmail( emailEt.getText().toString())) {
					emailEt.setError("Invalid Email");
				}

		} else {
        name=nameEt.getText().toString().trim();
        email=emailEt.getText().toString();
        password=passwordEt.getText().toString();
        imagepath=imagePathEntry.getText().toString();
        phone=phoneEt.getText().toString();
        emergency=emergencyEt.getText().toString();

			profileModel=new ProfileModel(name,email,password,imagepath,phone,emergency);
        if(id>0){
            status=profileDBSource.updateProfile(id,profileModel);
        }else {
            status=profileDBSource.addProfile(profileModel);
        }
        Toast.makeText(ProfileInsertActivity.this,"Account Information \nStored Successfully.", Toast.LENGTH_SHORT).show();
        Intent homeIntent=new Intent(this,LogInActivity.class);
        startActivity(homeIntent);
		}

    }
    //Image Capture code camera start
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
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "TM_" + timeStamp + ".jpg");
		} else {
			return null;
		}
		return mediaFile;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

			if (resultCode == RESULT_OK) {
				cameraImageView.setBackgroundDrawable(null);				
				cameraImageView.setImageURI(fileUri);
				imagePathEntry.setText(fileUri.toString());
				//Log.e("filePath : ", fileUri.toString());
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(ProfileInsertActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(ProfileInsertActivity.this, "Can not be captured", Toast.LENGTH_LONG).show();
			}
		}
	}
    
    //Image capture code camera end
	public void OnLogInClickProfile(View view){
		Intent logInIntent=new Intent(this,LogInActivity.class);
        startActivity(logInIntent);
	}
private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
}*/
