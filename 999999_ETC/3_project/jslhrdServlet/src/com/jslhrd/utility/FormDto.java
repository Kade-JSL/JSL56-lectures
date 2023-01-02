package com.jslhrd.utility;

import java.util.HashMap;

public class FormDto {
	
	public enum FormName {
		TITLE,
		WRITER,
		CONTENT
	}

	HashMap<FormName, Boolean> fnList = new HashMap<FormName, Boolean>() {
		FormName.TITLE : false,
		FormName.WRITER : false,
		FormName.CONTENT : false
	};
	
	public FormDto(FormName... fnList) {

	}
}
