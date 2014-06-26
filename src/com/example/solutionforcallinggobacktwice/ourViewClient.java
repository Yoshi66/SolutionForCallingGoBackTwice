package com.example.solutionforcallinggobacktwice;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourViewClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view,String url){
		super.shouldOverrideUrlLoading(view, url);
		view.loadUrl(url);
		return true;
	}
	
	

}
