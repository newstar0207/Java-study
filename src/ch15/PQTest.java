package ch15;

import java.util.PriorityQueue;
import java.util.Queue;

public class PQTest {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		Queue<String> q = new PriorityQueue<>();
		
		// 넣기
		q.offer("PineApple");
		q.offer("Banana");
		q.offer("Apple");
		q.offer("Strawberry");
		q.offer("Mango");
		
		//엿보기(인출아님)
		System.out.println(q.peek()); // q.element();
		
		// 인출
		while(q.size() > 0) {
			System.out.println(q.poll()); // q.remove()
		}
 		
	}
}
