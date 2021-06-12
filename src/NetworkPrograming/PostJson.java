package NetworkPrograming;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.google.gson.Gson;

public class PostJson {

	public static void main(String[] args) throws Exception {

		String site = "https://jsonplaceholder.typicode.com/posts";
		URL url = new URL(site);

		URLConnection con = url.openConnection();

		InputStream stream = con.getInputStream();
		// ���ٽ� �б� ���� Bufferedreader �� �̿��ϸ� BufferdReader �� InputStreamReader �� ����� �� �־�
		// InputStreamReader �� ���;

		// Reader ��� ���ڰ� �������� ���ڿ��� ��� ��� / ���� ���� ��� ����Ʈ�� ����
		InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

		// �� ���ξ� ���� �� ����
		BufferedReader bReader = new BufferedReader(reader);
		String line = null;
		String jsonString = "";
		while ((line = bReader.readLine()) != null) {
//			System.out.println(line);
			jsonString += line;
		}

		Gson gson = new Gson();
		String json = jsonString;
		Post[] posts = gson.fromJson(json, Post[].class);

		/*
		 * ���������� Post post = new Post(); post.setUserId(1); post.setId(1);
		 * post.setTitle("title"); post.setBody("test body"); return post;
		 */

		for (Post post : posts) {
			System.out.println(post.getUserId());
			System.out.println(post.getId());
			System.out.println(post.getTitle());
			System.out.println(post.getBody());
			System.out.println("=======================");
		}

		insertIntoDB(posts);

	}

	private static void insertIntoDB(Post[] posts) throws Exception {
		/*
		 * 1. Class.forName(..); 2. Connection con = DriverManger.getConnection(); 3.
		 * String sql = "insert into posts(userId, Id, title, body) values (? , ? ,?
		 * ,?); 4. PreparedStatement pstmt = con.prepareStatement(sql); // 4�������� �ѹ��� �ϸ�
		 * �� 5. pstmt.setInt(1, post.getUserId()); pstmt.setInt(2, post.getId());
		 * pstmt.setString(3, post.getTitle()); pstmt.setString(4, post.getBody()); 6.
		 * pstmt.executeUpdate(); 7. con.close();
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "newstar0207");

//		String sql = "insert into posts(userId, Id, title, body) values (? , ? ,? ,?);";
//		
//		PreparedStatement pstmt = con.prepareStatement(sql);
//
//		for (Post post : posts) {
//			pstmt.setInt(1, post.getUserId());
//			pstmt.setInt(2, post.getId());
//			pstmt.setString(3, post.getTitle());
//			pstmt.setString(4, post.getBody());
//			
//			pstmt.executeUpdate();
//		}
//		
//		con.close();
		
		String sql2 = "delete from posts where userId = 10";
		
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.executeUpdate();
		
		con.close();

	}

}
