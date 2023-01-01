package com.jslhrd.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class TblMenu {

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	public TblMenu(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public abstract void doJavaGet() throws IOException;
}
