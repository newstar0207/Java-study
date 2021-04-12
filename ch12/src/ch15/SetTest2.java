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
	// �������̽� ��ü ���� �ȵ�!
	private static void test1() {
		File file = new File("wordbook.txt"); 
		Set<String> set = new HashSet<>();
//		if (file.exists() == true) {
//			System.out.println("hi~ " + file.getAbsolutePath());
//		}else {
//			System.out.println("bye~" + file.getAbsolutePath());
//		}

		// ���� ���� �б�
		// ���Ͽ� �а� ������ stream ��ü�� �̿��ؾ� ��
		/*
		 * ���� ��� Input Stream 
		 * �� ��� Output Stream 
		 * Stream �� �⺻������ Byte.Stream 
		 * - ���ڴ����� �а� ������ ���� ��Ʈ���� �̿��ϴ� ���� ���� 
		 * - ���ڴ����� �Է� ��Ʈ���� Reader ��ü�� ǥ���� 
		 * - ���ڴ����� ��� ��Ʈ���� Writer ��ä�� ǥ����
		 */
		// FileReader �� �ѹ��ھ� ���� �� ���
		int cnt = 0;
		BufferedReader bReader = null;
		try {
			FileReader fileReader = new FileReader(file);
			// �� ���� ������ �ϱ� ���ؼ� BufferedReader�� �̿�
			bReader = new BufferedReader(fileReader);
			
			String line = null;

			while ((line = bReader.readLine()) != null) {
				set.add(line);
				System.out.println(line);
				cnt++;
			}
			// FileNotFoundException �� IOException �� ��ӹް� �־� �� ��ü������
			// �ϴ� FileNotFoundException �� ���� ��� ��
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {

		} finally {
			try {
			bReader.close();
			}catch (Exception e) {
				
			}
		}

		System.out.println("�ߺ� ���� : " + cnt + "\n�ߺ� ���� : " + set.size());
	}
}
