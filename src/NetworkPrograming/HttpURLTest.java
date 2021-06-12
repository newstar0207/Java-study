package NetworkPrograming;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpURLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.google.com/search?q=java"); // �ڿ��� ��û�� �ּҸ� ��Ÿ���� Ŭ����
		HttpURLConnection con = (HttpURLConnection) url.openConnection(); // URL Ŭ������ ����� �޼ҵ�� url ��ü�� ���� ������ ���

		con.setRequestMethod("GET"); // http ��ü�� GET ��û�� ��
		con.setRequestProperty("User-Agent", "Mozilla/5.0"); // ��û ����� ����

		int responseCode = con.getResponseCode();
		System.out.println("Response code: " + responseCode); // Response code: 200
		
		InputStream stream = con.getInputStream(); // ���α׷��� �����͸� �Է¹������

		// read
		InputStreamReader isreader = new InputStreamReader(stream, "UTF-8"); // ����Ʈ ������ ���� �ڷḦ ���ڷ� ��ȯ�� �ִ� ���� ��Ʈ��

		BufferedReader reader = new BufferedReader(isreader); //���ڷ� ���� �� �迭�� �����Ͽ� �Ѳ����� ���� �� �ִ� ����� ������ �ִ� ���� ��Ʈ��
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}
}
