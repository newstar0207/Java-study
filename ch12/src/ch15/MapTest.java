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
		// 전화번호를 map 에 저장
		// <이름 , 전화번호>
		String[] names = {"홍길동", "일지매","성춘향","이몽룡"};
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
		// Map 객체 , generic 인터페이스
		// Map 은 <key 와 value> 의 쌍으로 저장하며 key값을 통해 값을 인출함
		// Hash Map , TreeMap, LinkedHashMap
		// Map 에 <학번, 학생객체 > 의 형태로 저장함
		//

		Map<String, Student> map = new HashMap<>();

		map.put("2000101", new Student(2000101, "kimsaebeoul"));
		map.put("2000102", new Student(2000102, "kimsaeou"));
		map.put("2000103", new Student(2000103, "kimsaeb"));
		map.put("2000104", new Student(2000104, "kimoul"));
		map.put("2000105", new Student(2000105, "aebeoul"));
		// 같은 값으로 put 할 시 덮어씀
		Student value = map.get("2000101"); // 객체를 줌
//		System.out.println(value.getName());
		

		// Map자료구조에 들어가 있는 모든 원소들을 다 읽을 수있는 방법
		// 1. map 에게 가진 원소의 모든 키 집합을 요청
		// 2. map 에게 <key, value> 의 쌍으로 저장된 엔트리집합을 요청해 집합을 하나씩 읽음

		Set<String> keyset = map.keySet(); // set으로 줌 // key를 받아오는 것임! 
		// Set의 원소를 하나씩 접근하는 방법? // 받아온 key 로 value 값을 가져옴
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
		// map 의 엔트리란 <key, value> 의 쌍으로 구성된 객체
		//2
//		System.out.println(map.entrySet());
		//set 도 generic 이며 set이 entry 타입으로 반환하는데 entry 는 generic <l,t>이다
		Set<Entry<String, Student>> entryset = map.entrySet();
		// Set의 원소타입이 Entry이며 Entry 는 String Student 로 구성
//		System.out.println(entryset.size());
		
		Iterator<Entry<String, Student>> iter2 = entryset.iterator();
		while(iter2.hasNext()) {
			Entry<String, Student> entryObj = iter2.next();
//			System.out.print(iter2.next() + " ");
			String key = entryObj.getKey();
			Student val = entryObj.getValue();
			System.out.println(key + "  " + val);
			// return 시 Entry<String, Student> 값을 반환
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
