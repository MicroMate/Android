package com.mikemat.ahhttprequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 
	    HttpRequestTask httpRequestTask = new HttpRequestTask();
	    httpRequestTask.execute();
	        
	        
	        
	}
	  
	  
	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private class HttpRequestTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			
			
			   // Creating HTTP client
	        HttpClient httpClient = new DefaultHttpClient();
	        // Creating HTTP Post
	        //HttpPost httpPost = new HttpPost("http://www.example.com/login");
	        HttpPost httpPost = new HttpPost("http://www.google.com");
	 
	        // Building post parameters
	        // key and value pair
	        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(2);
	        nameValuePair.add(new BasicNameValuePair("email", "michal.mikemat@gmail.com"));
	        nameValuePair.add(new BasicNameValuePair("message", "Hi, trying Android HTTP post!"));
	 
	        // Url Encoding the POST parameters
	        try {
	            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
	        } catch (UnsupportedEncodingException e) {
	            // writing error to Log
	            e.printStackTrace();
	        }
	 
	        // Making HTTP Request
	        try {
	            HttpResponse response = httpClient.execute(httpPost);
	 
	            // writing response to log
	            Log.d("Http Response:", response.toString());
	        } catch (ClientProtocolException e) {
	            // writing exception to log
	            e.printStackTrace();
	        } catch (IOException e) {
	            // writing exception to log
	            e.printStackTrace();
	 
	        }
			
			
			
			
			return null;
		}
		
	}
	
}


