package com.example.solutionforcallinggobacktwice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class MainActivity extends Activity {

	static long FirstClick;
	WebView webview;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new ourViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				Log.d("this is url", url);
				return super.shouldOverrideUrlLoading(view, url);
			}
        	
        	
        });
        webview.loadUrl("www.google.com");
    }
    
    @Override
    public void onBackPressed(){
    	
    	if(FirstClick + 500 > System.currentTimeMillis()){
    		//the difference between firstClick and currentTime is shorter than 500 millisecond,
    			//it is probably because onBackPressed was executed twice automatically.
    		Log.d("prevent goback() being called twice", "prevent goback() being called twice");
    	}else{
    		//the difference between firstClick and currentTime is longer than 500 millisecond,
    			//users click backbutton twice.
    		Log.d("goback() is called", "goback() is called");
    		webview.goBack();
    		FirstClick = System.currentTimeMillis();
    	}
    	super.onBackPressed();
    }
    
}
