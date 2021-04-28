package ch15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	public static void main(String[] args1) {
//		test1();
		test2();
	}
	
	public static void test2() {
		// ��ȭ��ȣ�� map �� ����
		// <�̸� , ��ȭ��ȣ>
		String[] names = {"ȫ�浿", "������","������","�̸���"};
		String[] phones = {"--123","1-23","12-3","1233-"};
		Map<String,String> phoneBook = new HashMap<>();
		for(int i = 0 ; i  < names.length; i++) {
			phoneBook.put(names[i], phones[i]);
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("name ");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + "  " + phone);
		
		}
		
	}

	public static void test1() {
		// Map ��ü , generic �������̽�
		// Map �� <key �� value> �� ������ �����ϸ� key���� ���� ���� ������
		// Hash Map , TreeMap, LinkedHashMap
		// Map �� <�й�, �л���ü > �� ���·� ������
		//

		Map<String, Student> map = new HashMap<>();

		map.put("2000101", new Student(2000101, "kimsaebeoul"));
		map.put("2000102", new Student(2000102, "kimsaeou"));
		map.put("2000103", new Student(2000103, "kimsaeb"));
		map.put("2000104", new Student(2000104, "kimoul"));
		map.put("2000105", new Student(2000105, "aebeoul"));
		// ���� ������ put �� �� ���
		Student value = map.get("2000101"); // ��ü�� ��
//		System.out.println(value.getName());
		

		// Map�ڷᱸ���� �� �ִ� ��� ���ҵ��� �� ���� ���ִ� ���
		// 1. map ���� ���� ������ ��� Ű ������ ��û
		// 2. map ���� <key, value> �� ������ ����� ��Ʈ�������� ��û�� ������ �ϳ��� ����

		Set<String> keyset = map.keySet(); // set���� �� // key�� �޾ƿ��� ����! 
		// Set�� ���Ҹ� �ϳ��� �����ϴ� ���? // �޾ƿ� key �� value ���� ������
		//1
//		Iterator<String> iter = keyset.iterator();
//		while (iter.hasNext()) {
//			String key = iter.next();
//			Student val = map.get(key);
//			System.out.println(key + "  " + val);
//		}
//		System.out.println("---------------");
//
//		for (String value2 : keyset) {
//			System.out.println(map.get(value2));
//		}
		// map �� ��Ʈ���� <key, value> �� ������ ������ ��ü
		//2
//		System.out.println(map.entrySet());
		//set �� generic �̸� set�� entry Ÿ������ ��ȯ�ϴµ� entry �� generic <l,t>�̴�
		Set<Entry<String, Student>> entryset = map.entrySet();
		// Set�� ����Ÿ���� Entry�̸� Entry �� String Student �� ����
//		System.out.println(entryset.size());
		
		Iterator<Entry<String, Student>> iter2 = entryset.iterator();
		while(iter2.hasNext()) {
			Entry<String, Student> entryObj = iter2.next();
//			System.out.print(iter2.next() + " ");
			String key = entryObj.getKey();
			Student val = entryObj.getValue();
			System.out.println(key + "  " + val);
			// return �� Entry<String, Student> ���� ��ȯ
		}
		
		
		
		

	}
}

class Student {
	private int hakbun;
	private String name;

	public Student(int hakbun, String name) {
		super();
		this.hakbun = hakbun;
		this.name = name;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [hakbun=" + hakbun + ", name=" + name + "]";
	}

}
