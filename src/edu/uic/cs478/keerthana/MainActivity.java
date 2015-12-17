package edu.com.keerthana;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
	EditText editText;
	String userString;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //The Submit Button is defined
        findViewById(R.id.button1).setOnClickListener(Listener1);
        //The multi-line text box which is of type edit text is referenced
        editText = (EditText) findViewById(R.id.editText1);
    }
    //Listener for the button is created 
    final OnClickListener Listener1 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int s=0;
			//A new intent is created to launch the dial screen
			Intent dial = new Intent();
			dial.setAction(Intent.ACTION_DIAL);
			//The string entered by the user is stored into variable userString
			userString = editText.getText().toString();
      // Pattern #1 --> rege(zzz)xxx-yyyyregg (without space between the close braces and the next number and surrounded by any text)

        	if(s==0)
        	{
        		Matcher matcher2 = Pattern.compile("[a-zA-Z]*\\(\\d{3}\\)\\s\\d{3}-\\d{4}[a-zA-Z]*").matcher(userString);
            	if(matcher2.find()) {
            		s=1;
            		dial.setData(Uri.parse("tel:+"+matcher2.group()));
            		  startActivity(dial);
            		   
            	}	
        	}

        	// Pattern #2 --> qwqeqwe(zzz) xxx-yyyyrtw (includes a space between the close braces and the next number and surrounded by any text)
        	if(s==0)
        	{
        		Matcher matcher3 = Pattern.compile("[a-zA-Z]*\\(\\d{3}\\)\\d{3}-\\d{4}[a-zA-Z]*").matcher(userString);
            	if(matcher3.find()) {
            		s=1;
            		dial.setData(Uri.parse("tel:+"+matcher3.group()));
            		startActivity(dial);
            		   
            	}	
        	}
		}
    };
    
}
