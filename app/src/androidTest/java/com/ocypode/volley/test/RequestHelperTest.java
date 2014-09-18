package com.ocypode.volley.test;

import junit.framework.TestCase;

import com.ocypode.volley.infrastructure.remote.volley.request.RequestHelper;

public class RequestHelperTest extends TestCase {
	
	public RequestHelperTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public final void testPreconditions() {
		assertNotNull(RequestHelper.getHeaders());
	}

}
