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

	public static void test1() { // static �� ��ü�������ϰ� ȣ�Ⱑ��
		/*
		 * - ������ ����� 
		 * ������ : set1.addAll(set2); 
		 * ������ : set1.retainAll(set2) 
		 * ������ : set1.removeAll(set2) 
		 * 		  set2.removeAll(set1)
		 */
		// Generic Ŭ���� ��ü�� ������ �� Ÿ�� �ĸ����ʹ�
		// ������Ƽ��(int) Ÿ���� �� �� ����. ��üŸ�Ը� �� �� �ִ�.
		// �������̽��� ��ü���� �ȵ�

		Set<Integer> set1 = new HashSet<>();
		// HashSet, LinkedHashSet, TreeSet
		// LinkedHashSet -> �Է¼������ ����
		// TreeSet -> ���� ���� ���ĵ� ������ ����
		// Integer[] arr = { 2, 3, 4, 5, 6, 8, 9, 10 };

		// �迭�� Collection ��ü�� ����� �ִ� �޼ҵ�
		List<Integer> list1 = Arrays.asList(10, 9, 8,5234,4,3,2,1);
		set1.addAll(list1);
		
		Set<Integer> set2 = new HashSet<>();
		
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 9);
		set2.addAll(list2);
		
		System.out.println("set1 : " + set1.toString());
		System.out.println("set2 : " +set2.toString());
		
		//������
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		System.out.println("������ : " + unionSet);
		// �ߺ��� ��������ʾ� �ڽſ��� ���� ���� ����
		
		//������
		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
		System.out.println("������ : " + intersectionSet);
		
		//������
		Set<Integer> diffSet = new HashSet<>(set1);
		diffSet.removeAll(set2);
		System.out.println("������ (set1 - set2) : " + diffSet);
		
		// ������ ���� �ϳ��� ���
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
		//�� ���ڷ� ���޵� ���� ũ�� ���
		//������ 0
		//�� ���ڷ� ���޵� ���� ũ�� ����
		return n2 - n1	; // ��������
	}
	
	
}
