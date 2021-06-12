package ch15;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsAPITest{
	private String name;
	
	public static void main(String[] args) {
		String[] sample = { "i", "walk", "the", "line"};
		List<String> list = Arrays.asList(sample); //
		
		//Collections �� sort �ż���� List Ÿ���� ���ڷ� ����!
		// static <-> instance
		// �������� instance �� ����� �ʿ䰡 ��� static �޼ҵ���
//		Collections.reverse(list); // ���� �־��� �迭�� �����°�;
//		Collections.sort(list); // list type // �⺻ �������� ����
//		Collections.sort(list, Collections.reverseOrder());
		Collections.sort(list, new MyComparator1()  );
		//������ Ÿ�� Ŭ������ ���� ������ �� ������ Comparable 
		//������ Ÿ�� Ŭ������ ���� ������ �� ������ Comparator
		// - �Ǵ� ������ Ÿ�� Ŭ������ ������ �� ������, �� Ŭ������ �������� �ʰ� ���Ĺ���� �����ϰ��� �� ��� Comparator �����;
		for( String value : list) {
			System.out.println(value);
		}
		
		
		
		Arrays.sort(sample);
		
//		for(String value : sample) {
//			System.out.println(value);
//		}
		
	}	
	
	// �������� �ν��Ͻ��� �� �ʿ䰡 ���� ��� static �� ���°��� ����.
	// getter �� setter �� instance �� ����
	// 
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}

class MyComparator1 implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// o1 �� ũ�� ���, ������ 0, ������ ������ȯ
		// ���ڿ� ���� �񱳴� Comparable �������̽��� �����ϰ� �ִ� String Ŭ������ compareTo �� ȣ���ϸ� ��.
		
		return o2.compareTo(o1	);
	}
	
}
