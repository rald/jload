package com.example.hellojni;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;

import android.widget.Button;
import android.widget.EditText;

import android.view.View;
import android.os.Environment;


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


	EditText edtPath;
	Button btnLoad;

  @Override
  protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.activity_main);

		edtPath = (EditText) findViewById(R.id.editText1);
		btnLoad = (Button) findViewById(R.id.button1);	


		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
		    String dl = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();

	    edtPath.setText(dl+"/libhello-jni.so");

		}


		btnLoad.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				String p=edtPath.getText().toString();

        load(p);

        edtPath.setText(stringFromJNI());

	    }
		});

  }

}
