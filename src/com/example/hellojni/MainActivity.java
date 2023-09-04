package com.example.hellojni;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.os.Environment;

import java.io.File;


public class MainActivity extends Activity {


  static public native String stringFromJNI();
  static public native String unimplementedStringFromJNI();


  private void load(String p) {
    try {
      System.load(p);
    } catch(Exception e) {
      Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
      
    }
  }


	EditText path;
	Button load;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_main);

		path = (EditText) findViewById(R.id.editText1);

    File dl = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
		
    path.setText(dl.getAbsolutePath()+"/libhello-jni.so");

		load = (Button) findViewById(R.id.button1);
		

		load.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				String p=path.getText().toString();

        load(p);

        path.setText(stringFromJNI());

	    }
		});

  }

}
