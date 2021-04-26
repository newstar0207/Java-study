package ch15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args1) {
		// Deque 는 인터페이스임
		// 구현한 클래스로 ArrayDeque

		Deque<Integer> queue = new ArrayDeque<>();
		//1. 큐에 임의 수 10개 넣음
		//2. 순서확인후 인출 -> fifo 인지
		
		for( int i = 1; i <= 10; i++) {
			queue.add(i);
//			queue.offer(i);
		}
		
		
		// 엿보는 메소드 
//		queue.peek();
		
//		System.out.println(queue);
		//poll 로 인출, FIFO 순으로 나옴
		
//		queue.isEmpty();
		
//		while (/* queue.size() > 0*/ ! queue.isEmpty()) { // queue.isEmpty() 비어있으면 true 를 반환 
//			Integer val = queue.poll(); // 큐의 사이즈가 1씩 감소
//			Integer val = queue.remove();
//			System.out.println(val);
//		};
		
		Iterator<Integer> iter = queue.iterator();
		while(iter.hasNext() == true) {
			System.out.println(iter.next());
		}
		
		System.out.println(queue);
		
	}
}
