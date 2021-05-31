package NetworkPrograming;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception{ // 운영체제가 받고 에러나면 무시함
		// 1. URL 객체 생성
		URL site = new URL("https://www.naver.com");
		
		// 2. URL 객체로부터 사이트 연결을 시도함. openConnection();
		URLConnection con = site.openConnection();
		
		// 3. InputStream 객체를 통해 네트워크 너머의 프로세스가 보내주는 데이터를 읽음.
		InputStream stream = con.getInputStream();
		
		InputStreamReader isreader = new InputStreamReader(stream);
			
		BufferedReader reader = new BufferedReader(isreader);
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
			
	}
}
