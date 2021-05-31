package NetworkPrograming;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLPostTest {
	
	public static void main(String[] args) throws Exception{
		String site = "http://localhost:80/test";
		URL url = new URL(site);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true); // OutputStream 은 기본적으로 막혀있음
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/x-www-form-urlencoded"); // 헤더정보
		
		// id = id, pw = 11
		
		OutputStream stream = con.getOutputStream();
		OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
		PrintWriter writer = new PrintWriter(owriter);
		writer.println("id=dd&pw=dd");
		
		
	}
}
