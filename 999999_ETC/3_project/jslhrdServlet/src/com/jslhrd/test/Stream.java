package com.jslhrd.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Stream {

	public static void main(String[] args) throws Exception {
		OutputStream out = new FileOutputStream("C:/DirSweetDir/JSL56-lectures/221205-_JSP/230106/hello.txt");
		
		byte[] array = new byte[] { 'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!' };
		
		out.write(array);
		out.flush();
		out.close();
		
		InputStream in = new FileInputStream("C:/DirSweetDir/JSL56-lectures/221205-_JSP/230106/hello.txt");
		
		byte[] buffer = new byte[1024];
		
		while (true) {
			int readByte = in.read(buffer);
			if (readByte == -1) {
				System.out.print("\n다 읽어왔습니다.\n");
				break;
			}
			for (int i = 0; i < readByte; i++) {
				System.out.print(Character.toChars(buffer[i]));
			}
		}
	}
}
