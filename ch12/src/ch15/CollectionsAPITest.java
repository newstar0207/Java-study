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
		
		//Collections 의 sort 매서드는 List 타입을 인자로 가짐!
		// static <-> instance
		// 내부적인 instance 를 사용할 필요가 없어서 static 메소드임
//		Collections.reverse(list); // 원래 주어진 배열을 뒤집는것;
//		Collections.sort(list); // list type // 기본 오름차순 정렬
//		Collections.sort(list, Collections.reverseOrder());
		Collections.sort(list, new MyComparator1()  );
		//원소의 타입 클래스를 내가 변경할 수 있으면 Comparable 
		//원소의 타입 클래스를 내가 변경할 수 없으면 Comparator
		// - 또는 원소의 타입 클래스를 변경할 수 있지만, 그 클래스를 변경하지 않고 정렬방법을 변경하고자 할 경우 Comparator 사용함;
		for( String value : list) {
			System.out.println(value);
		}
		
		
		
		Arrays.sort(sample);
		
//		for(String value : sample) {
//			System.out.println(value);
//		}
		
	}	
	
	// 내부적인 인스턴스를 쓸 필요가 없는 경우 static 를 쓰는것이 좋음.
	// getter 와 setter 가 instance 인 이유
	// 
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}

class MyComparator1 implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// o1 이 크면 양수, 같으면 0, 작으면 음수반환
		// 문자열 값의 비교는 Comparable 인터페이스를 구현하고 있는 String 클래스의 compareTo 를 호출하면 됨.
		
		return o2.compareTo(o1	);
	}
	
}
