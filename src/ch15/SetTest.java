package ch15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		test1();
		test2();
	}
	
	public static void test2() {
		List<Integer> list1 = Arrays.asList(10, 9, 8,5234,4,3,2,1);
//		Set<Integer> set1 = new LinkedHashSet<>();
//		Set<Integer> set1 = new TreeSet<>();
		
		MyComparator mc = new MyComparator();
		
		Set<Integer> set1 = new TreeSet<>(mc);
		set1.addAll(list1);
		Iterator<Integer> iter = set1.iterator();
		
		System.out.println();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

	public static void test1() { // static 시 객체생성안하고 호출가능
		/*
		 * - 원본이 변경됨 
		 * 합집합 : set1.addAll(set2); 
		 * 교집함 : set1.retainAll(set2) 
		 * 차집함 : set1.removeAll(set2) 
		 * 		  set2.removeAll(set1)
		 */
		// Generic 클래스 객체를 생성할 때 타입 파리미터는
		// 프리미티브(int) 타입을 줄 수 없다. 객체타입만 줄 수 있다.
		// 인터페이스는 객체생성 안됨

		Set<Integer> set1 = new HashSet<>();
		// HashSet, LinkedHashSet, TreeSet
		// LinkedHashSet -> 입력순서대로 인출
		// TreeSet -> 값에 따라 정렬된 순서로 인출
		// Integer[] arr = { 2, 3, 4, 5, 6, 8, 9, 10 };

		// 배열을 Collection 객체로 만들어 주는 메소드
		List<Integer> list1 = Arrays.asList(10, 9, 8,5234,4,3,2,1);
		set1.addAll(list1);
		
		Set<Integer> set2 = new HashSet<>();
		
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		set2.addAll(list2);
		
		System.out.println("set1 : " + set1.toString());
		System.out.println("set2 : " +set2.toString());
		
		//합집합
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("합집합 : " + unionSet);
		// 중복을 허용하지않아 자신에게 없는 값만 넣음
		
		//교집합
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("교집합 : " + intersectionSet);
		
		//차집합
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println("차집합 (set1 - set2) : " + diffSet);
		
		// 차집합 원소 하나씩 출력
//		for ( Integer i : diffSet) {
//			System.out.print(i + " ");
//		}
		
//		Iterator<Integer> iter = diffSet.iterator();
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) { // boolean
			Integer i = iter.next();
			System.out.print(i + " ");
		}
		
	}
}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer n1, Integer n2) {
		//앞 인자로 전달된 수가 크면 양수
		//같으면 0
		//뒤 인자로 전달된 수가 크면 음수
		return n2 - n1	; // 오름차순
	}
	
	
}
