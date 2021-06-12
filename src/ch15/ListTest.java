package ch15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
//		List<String> list = new ArrayList<>(); // List �� arrayList �� ��ü���� �Ұ�����
		List<String> list = new LinkedList<>();
		String[] sArr = { "�ڵ���", "���", "��ġ��", "����" };
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

		Iterator<String> iter = list.iterator(); // �ڱ� ���ҿ� ���� �� �� �ִ� iterator ��ü�� ����
		// unchecked exception �� ���״�!
		// �� exception ��ü�� �߻����� �ʰ� �ڵ��ؾ���
		while (iter.hasNext()) { // ������ �ֳ�?
			System.out.print(iter.next() + "  ");
		}
		System.out.println();

		// overloading �� add �޼ҵ�� �߰��� ���� ����

		list.add(1, "five");

		iter = list.iterator();

		while (iter.hasNext()) { // ������ �ֳ�?
			System.out.print(iter.next() + "  ");
		}

		list.remove(list.size() - 1);
		
		System.out.println();
		
		System.out.println(list);
		
		list.clear();
		
		System.out.println(list);
	}
}
