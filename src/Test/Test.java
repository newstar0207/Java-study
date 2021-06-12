package Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test{
	
	public static void main(String[] args) throws Exception{
		String site = "http://localhost:80";
		URL url = new URL(site);
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
		
		String data = "id=newstar&pw=1111";
		OutputStream stream = con.getOutputStream();
		OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
		PrintWriter writer = new PrintWriter(owriter);
		writer.println(data);
		writer.flush();
		
		InputStream rstream = con.getInputStream();
		InputStreamReader streamReader = new InputStreamReader(rstream);
		
		BufferedReader reader = new BufferedReader(streamReader);
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
	}
	
}