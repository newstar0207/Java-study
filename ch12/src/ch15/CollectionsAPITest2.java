package ch15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsAPITest2 {
	public static void main(String[] args) {
//		shuffleTest();
		binarySearchTest(); // 이진탐색(정렬된 리스트에서 내가 원하는 값을 찾아주는 방법.
	}
	
	public static void binarySearchTest() {
		// 1. 무작위 정수를 저장한 리스트에 대한 이진탐색 // 잘못된 방법
		// 2. 정렬된 리스트에 대해 이진탐색 
		List<Integer> list3 = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			list3.add((int)(Math.random() * 100 + 1));
		}
		Collections.sort(list3);
		System.out.println(list3);
		int idx = Collections.binarySearch(list3, 1);
		if(idx >= 0) {
			System.out.println(idx); // 있어도 정렬이 안되어있기 때문에 찾을 수 없음!
		}else {
			System.out.println("없음");		
		}
	}
	
	
	public static void shuffleTest() {
		List<Integer> list = new ArrayList<>();
		List<Student2> list2 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add((i + 1) * 2);
			list2.add(new Student2(i , i+6));
		}
		
		
		System.out.println("섞이 전 :" + list2);
		
		Collections.shuffle(list2);
		// 객체도 가능함
		System.out.println("섞은 후 :" + list2);
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
