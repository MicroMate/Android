/*
 * Zmiana konfiguracji aplikacji
 * 
 * Przykład dla
 * 
 * Zmiany orientacji ekranu
 * 
 */

package com.micromate.zmianakonfiguracji;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button button;
	private TextView textView;
	private String text;
	  
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    	
	    button=(Button)findViewById(R.id.button1);
	    textView=(TextView)findViewById(R.id.textView2);
	    
	    text = "text onCreate";
	    

	    /**
	     *  Metoda getLastNonConfigurationInstance() sprawdzamy czy opeacja nie została przerwana 
	     *  (np w wyniku rotacji) 
	     */
	    
	    // przykład 1   - jedna zmienna    
//	    if (getLastNonConfigurationInstance()!=null){		   
//			   text = (String) getLastNonConfigurationInstance();
//			   Log.v("getLastNonConfigurationInstance", "text restored " + text);
//	    }
	    
	    
	    // przykład	2  -
	    //Now see if we just got interrupted by e.g., rotation
	    MainActivity old = (MainActivity) getLastNonConfigurationInstance();
	    if (old != null) {
	    	text = old.text;
	    }
	    
	    
	    textView.setText(text);
	    
	    button.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View view) {
	       
	    		text = "Button clicked";
	    		textView.setText("Button clicked");
	    	}
	    });
	    

	}
	    
	
	 /** Returns arbitrary single token object to keep alive across
     * the destruction and re-creation of the entire Enterprise.
     */
	  // przykład 1 - zwraca jedna zmienna: text
//    @Override
//    public Object onRetainNonConfigurationInstance() {
//    	return text;   	
//    }

	// przykład 2 - zwraca referencje do aktywnosci
	// co pozwala uzyskac dostęp do wszystkich ich pól
    @Override
    public Object onRetainNonConfigurationInstance() {
    	return this;   	
    }

}
