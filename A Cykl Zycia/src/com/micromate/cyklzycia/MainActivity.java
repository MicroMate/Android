package com.micromate.cyklzycia;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("MyAndroid","onCreate");
	}

	
	public void onStart(){
		super.onStart();
		Log.d("MyAndroid","onStart");
	}
	
	public void onResume(){
		super.onResume();
		Log.d("MyAndroid","onResume");
	}
	
	public void onPause(){
		super.onPause();
		Log.d("MyAndroid","onPause");
	}
	
	public void onStop(){
		super.onStop();
		Log.d("MyAndroid","onStop");
	}

	public void onRestart(){
		super.onRestart();
		Log.d("MyAndroid", "onRestart");
	}
	
	public void onDestroy(){
		super.onDestroy();
		Log.d("MyAndroid","onDestroy");
	}
	
	
}
