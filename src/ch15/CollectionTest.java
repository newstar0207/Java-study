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
	 * List : ������ �ְ� �ߺ��� ���Ǵ� �ڷᱸ�� set : ������ ���� iterator �����
	 */
	public static void main(String[] args) {
//		test2();
//		test3();
//		setTest1();
		lotto();
	}

	public static void setTest1() {
		Set<String> set = new HashSet<>();

		String[] strArr = { "ġŲ", "����", "ġŲ", "����" };
		
		for ( String s: strArr) {
			if (set.add(s) == false) {
				System.out.println(s + "�ߺ�");
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
//		Set<Integer> lottoNums = new HashSet<>(); // �ߺ� ����
//		MyComparator comp = new MyComparator();
		Set<Integer> lottoNums = new TreeSet<>(); // �ߺ� ���� ���� ���Ѽ�
		
//		Set<Integer> lottoNums = new LinkedHashSet<>(); // �� ������� �ߺ� ����
		
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
		System.out.println("��� �߰�" + list);
		list.set(2, "grape");
		System.out.println("����" + list);
		list.remove(3);
		System.out.println("����" + list);

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

//		iter = list.iterator(); // �ѹٲ� �� ���� �� �� �ٽ� �Ҷ�� �ٽ� �޾ƾ���;

//		iter.next();
		// ���ܹ߻�

	}

	public static void test2() {

		List<Integer> list = new ArrayList<>();
//		List<Integer> list = new LinkedList<>(); // ����
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
		List<Double> list3 = new Vector<>(); // ���� arraylist ����
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
