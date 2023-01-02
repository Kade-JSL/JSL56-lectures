package com.jslhrd.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	public static String encode(String pw) {
		
		String newPw = "";
		
			// SHA-256 암호화 처리를 하려면 먼저 MessageDigest 객체를 생성해야 한다
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				// 암호화하고자 하는 패스워드를 update() 메서드를 이용하여 전달
				// 전달하는 패스워드는 String.getBytes() 메서드로 byte 타입의 배열로 변환하여 전달한다
				md.update(pw.getBytes());
				// 전달된 배열은 digest() 메서드로 암호화, 그리고 byte[]에 저장된다
				byte[] encodedData = md.digest();
				for (int i = 0; i < encodedData.length; i++) {
					newPw += Integer.toHexString(encodedData[i]&0xFF);
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return newPw;
	}
}
