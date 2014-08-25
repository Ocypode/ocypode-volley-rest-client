package com.ocypode.volley.infrastructure.remote.volley.request;

import java.util.Map;

import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.ocypode.volley.infrastructure.remote.handler.Handler;
import com.ocypode.volley.infrastructure.remote.volley.request.RequestHelper.ListenerCatchingException;

public class JsonObjectRequest extends com.android.volley.toolbox.JsonObjectRequest {
	
	public JsonObjectRequest(int method, String url, JSONObject jsonRequest,
			final Handler<?> handler, ListenerCatchingException<JSONObject> listener) {
		super(method, url, jsonRequest, RequestHelper.createResponseListener(handler, listener), 
				RequestHelper.createErrorResponseListener(handler));
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return RequestHelper.getHeaders();
	}

}
