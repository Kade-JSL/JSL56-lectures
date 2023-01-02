package com.jslhrd.utility;

import java.util.HashMap;
import java.util.Map;

public class FormFlags {
	
	public static enum FormName {
		TITLE,
		WRITER,
		CONTENT
	}

	private Map<FormName, Boolean> list = null;
	public Map<FormName, Boolean> getList() { return list; }
	public void setList(Map<FormName, Boolean> list) { this.list = list; }
	
	public FormFlags(FormName... names) {
		this.list =  new HashMap<FormName, Boolean>();
		this.list.put(FormName.TITLE, false);
		this.list.put(FormName.WRITER, false);
		this.list.put(FormName.CONTENT, false);
		for (FormName name : names ) {
			for (FormName value : FormName.values()) {
				if (name == value) {
					this.list.put(value, true);
				}
			}
		}
	}
}
