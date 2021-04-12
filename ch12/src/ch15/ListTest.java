package ch15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
//		List<String> list = new ArrayList<>(); // List 는 arrayList 라서 객체생성 불가능함
		List<String> list = new LinkedList<>();
		String[] sArr = { "자동차", "운동장", "유치원", "히히" };
		for (String s : sArr) {
			list.add(s);
		}

		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println();

		for (String s : list) {
			System.out.println(s + " ");
		}

		System.out.println();

		Iterator<String> iter = list.iterator(); // 자기 원소에 접근 할 수 있는 iterator 객체를 만듬
		// unchecked exception 은 버그다!
		// 즉 exception 자체가 발생하지 않게 코딩해야함
		while (iter.hasNext()) { // 다음게 있냐?
			System.out.print(iter.next() + "  ");
		}
		System.out.println();

		// overloading 된 add 메소드로 중간에 삽입 가능

		list.add(1, "five");

		iter = list.iterator();

		while (iter.hasNext()) { // 다음게 있냐?
			System.out.print(iter.next() + "  ");
		}

		list.remove(list.size() - 1);
		
		System.out.println();
		
		System.out.println(list);
		
		list.clear();
		
		System.out.println(list);
	}
}
