package com.lpi.lcartoon;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashS extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int nightModeFlags = getApplicationContext().getResources().getConfiguration().uiMode
		& Configuration.UI_MODE_NIGHT_MASK;
		switch (nightModeFlags) {
			case Configuration.UI_MODE_NIGHT_YES:
			setTheme(R.style.Theme_MyApplicationDark);
			break;
			
			case Configuration.UI_MODE_NIGHT_NO:
			setTheme(R.style.Theme_MyApplication);
			break;
			
			case Configuration.UI_MODE_NIGHT_UNDEFINED:
			setTheme(R.style.Theme_MyApplicationDark);
			break;
		}
		
		setContentView(R.layout.splash);						
		
		Thread splashScreenStarter = new Thread() {
			public void run() {
				try {
					int delay = 0;
					while (delay < 2000) {
						sleep(150);
						delay = delay + 100;
					}
					startActivity(new Intent(SplashS.this, MainActivity.class));
					
					} catch (InterruptedException e) {
					e.printStackTrace();
					} finally {
					finish();
				}
			}
			
		};
		splashScreenStarter.start();
		
	}
	
}