package com.example.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class HTTPConnection {
	
	Context context;
	
	public HTTPConnection(Context context){
		this.context = context;
	}

	public boolean isNetworkConnected(){
		ConnectivityManager cm = (ConnectivityManager) 
				context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			return false; // T
		}
		return true;
	}
	public String getHTTPData(String url, ArrayList<BasicNameValuePair> params){
		return getHTTPData(url + "?" + URLEncodedUtils.format(params, "utf-8"));
	}
	public String getHTTPData(String url){
		try{
			HttpGet request = new HttpGet(new URI(url));
			HttpResponse response =  new DefaultHttpClient().execute(request);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
