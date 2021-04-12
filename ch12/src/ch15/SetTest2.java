package ch15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		test1();

	}
	// 인터페이스 객체 생성 안됨!
	private static void test1() {
		File file = new File("wordbook.txt"); 
		Set<String> set = new HashSet<>();
//		if (file.exists() == true) {
//			System.out.println("hi~ " + file.getAbsolutePath());
//		}else {
//			System.out.println("bye~" + file.getAbsolutePath());
//		}

		// 파일 내용 읽기
		// 파일에 읽고 쓰려면 stream 객체를 이용해야 함
		/*
		 * 읽을 경우 Input Stream 
		 * 쓸 경우 Output Stream 
		 * Stream 은 기본적으로 Byte.Stream 
		 * - 문자단위로 읽고 쓸때는 문자 스트림을 이용하는 것이 편리함 
		 * - 문자단위로 입력 스트림은 Reader 객체로 표현됨 
		 * - 문자단위의 출력 스트림은 Writer 객채로 표현됨
		 */
		// FileReader 는 한문자씩 읽을 때 사용
		int cnt = 0;
		BufferedReader bReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			// 한 라인 단위로 일기 위해서 BufferedReader를 이용
			bReader = new BufferedReader(fileReader);
			
			String line = null;

			while ((line = bReader.readLine()) != null) {
				set.add(line);
				System.out.println(line);
				cnt++;
			}
			// FileNotFoundException 이 IOException 을 상속받고 있어 더 구체적으로
			// 하는 FileNotFoundException 을 먼저 써야 함
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {

		} finally {
			try {
			bReader.close();
			}catch (Exception e) {
				
			}
		}

		System.out.println("중복 포함 : " + cnt + "\n중복 없음 : " + set.size());
	}
}
