package ch12;

import java.io.IOException;

public class ExceptionTest633 {
	
	public static void main(String[] args) {
		try {
			System.out.println(readString());
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static String readString() throws IOException{
		byte[] buf = new byte[100];
		System.out.println("ют╥б : ");
		System.in.read(buf);
		return new String(buf);
	}
}	
