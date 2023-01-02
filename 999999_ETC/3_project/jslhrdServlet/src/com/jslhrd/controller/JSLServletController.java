package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class JSLServletController {

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public JSLServletController(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	protected void doGetList() throws IOException {}

	protected void doPostWrite() throws IOException {}
}
