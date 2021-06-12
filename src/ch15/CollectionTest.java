package ch15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.IntStream;

public class CollectionTest {

	/*
	 * List : 순서가 있고 중복이 허용되는 자료구조 set : 순서가 없어 iterator 써야함
	 */
	public static void main(String[] args) {
//		test2();
//		test3();
//		setTest1();
		lotto();
	}

	public static void setTest1() {
		Set<String> set = new HashSet<>();

		String[] strArr = { "치킨", "피자", "치킨", "피자" };
		
		for ( String s: strArr) {
			if (set.add(s) == false) {
				System.out.println(s + "중복");
			}; // true / false return
		}
		
		System.out.println(set);
	}
	
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public static void lotto() {
//		Set<Integer> lottoNums = new HashSet<>(); // 중복 없이
//		MyComparator comp = new MyComparator();
		Set<Integer> lottoNums = new TreeSet<>(); // 중복 없이 순서 지켜서
		
//		Set<Integer> lottoNums = new LinkedHashSet<>(); // 들어간 순서대로 중복 없이
		
		while(lottoNums.size() < 6) {
			int num =(int) (Math.random() * 45 + 1);
			if(lottoNums.add(num)) {
				System.out.println(num);
			};
		}
		
		System.out.println(lottoNums);
		
		Iterator<Integer> iter = lottoNums.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
	}

	public static void test3() {
		ArrayList<String> list = new ArrayList<>();

		list.add("milk");
		list.add("bread");
		list.add("butter");
		System.out.println(list);
		list.add(1, "apple");
		System.out.println("사과 추가" + list);
		list.set(2, "grape");
		System.out.println("변경" + list);
		list.remove(3);
		System.out.println("삭제" + list);

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

//		iter = list.iterator(); // 한바뀌 다 돌고 난 후 다시 할라면 다시 받아야함;

//		iter.next();
		// 예외발생

	}

	public static void test2() {

		List<Integer> list = new ArrayList<>();
//		List<Integer> list = new LinkedList<>(); // 빠름
//		for(int i = 0; i < 100000; i++) {
//			list.add(i);
//		}

		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i));

		long start = System.currentTimeMillis();

//		for(int i = 0 ; i < 1000; i++) {
//			list.add(30, 1000);
//		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

	public static void test1() {
		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		List<Double> list3 = new Vector<>(); // 옛날 arraylist 버젼
		List<Integer> list4 = new Stack<>();

		for (int i = 0; i < 10; i++) {
			list1.add(i);
			list2.add(String.valueOf(i));
			list3.add((i + 1) * 1.0);
			list4.add(10 - i);
		}

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);

		for (String a : list2) {
			System.out.println(a);
		}

		Iterator<Double> iter = list3.iterator();
		while (iter.hasNext()) {
			Double d = iter.next();
			System.out.print(d);
		}
	}

}
