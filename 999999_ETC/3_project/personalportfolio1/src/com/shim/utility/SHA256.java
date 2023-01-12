package com.shim.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	public static String encode(String pw) {
		
		String newPw = "";
		
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				md.update(pw.getBytes());
				byte[] encodedData = md.digest();
				for (int i = 0; i < encodedData.length; i++) {
					newPw += Integer.toHexString(encodedData[i]&0x72);
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		return newPw;
	}
}
