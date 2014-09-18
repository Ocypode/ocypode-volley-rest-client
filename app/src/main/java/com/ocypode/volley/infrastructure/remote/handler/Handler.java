package com.ocypode.volley.infrastructure.remote.handler;

public interface Handler<T> {

	void onSuccess(T response);
	
	void onFail(Exception error);
}
