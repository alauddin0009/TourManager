package theateam.com.tourmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(Splash_Screen.this,LogInActivity.class));
                Splash_Screen.this.finish();
            }
        }.start();
    }
}
