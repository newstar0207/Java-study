package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsAPITest2 {
	public static void main(String[] args) {
//		shuffleTest();
		binarySearchTest(); // ����Ž��(���ĵ� ����Ʈ���� ���� ���ϴ� ���� ã���ִ� ���.
	}
	
	public static void binarySearchTest() {
		// 1. ������ ������ ������ ����Ʈ�� ���� ����Ž�� // �߸��� ���
		// 2. ���ĵ� ����Ʈ�� ���� ����Ž�� 
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			list3.add((int)(Math.random() * 100 + 1));
		}
		Collections.sort(list3);
		System.out.println(list3);
		int idx = Collections.binarySearch(list3, 1);
		if(idx >= 0) {
			System.out.println(idx); // �־ ������ �ȵǾ��ֱ� ������ ã�� �� ����!
		}else {
			System.out.println("����");		
		}
	}
	
	
	public static void shuffleTest() {
		List<Integer> list = new ArrayList<>();
		List<Student2> list2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add((i + 1) * 2);
			list2.add(new Student2(i , i+6));
		}
		
		
		System.out.println("���� �� :" + list2);
		
		Collections.shuffle(list2);
		// ��ü�� ������
		System.out.println("���� �� :" + list2);
	}
}

class Student2 {
	int grade;
	int name;
	
	public Student2(int grade , int name) {
		this.grade = grade;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student2 [grade=" + grade + ", name=" + name + "]";
	}
	
	
}
