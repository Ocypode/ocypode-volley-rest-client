package com.ocypode.volley.infrastructure.remote.handler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.ocypode.volley.infrastructure.remote.volley.request.VolleyErrorHelper;

public class RequestHandler<T> implements Handler<T> {
	
	// TODO: create this context separated from the view. the app crashes if you
	// finish the context and do not cancel the request
	private Context mContext;
	
	public RequestHandler(Context context) {
		mContext = context;
	}
	
	@Override
	public void onSuccess(T response) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFail(Exception error) {
		try {
			if (error.getMessage() != null && error.getMessage().equals("java.io.IOException: No authentication challenges found")) {
				accessNotAuthorized();
				return;
			} 
			
			if (error instanceof AuthFailureError) {
				accessNotAuthorized();
				return;
			}
				
			String message = VolleyErrorHelper.getMessage(error, mContext);
			AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
			builder.setMessage(message);
			builder.create();
			
		} catch(Exception e) {
			Log.e("onFail", "RequestHandler.onFail", e);
		}
	}
	
	private void accessNotAuthorized() throws Exception {
		Activity activity = ((Activity) mContext);
		
		Toast.makeText(activity, "You've been logged out by the server. Please login again.", Toast.LENGTH_LONG).show();
		activity.onBackPressed();
	}

}
