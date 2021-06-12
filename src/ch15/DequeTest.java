package ch15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args1) {
		// Deque �� �������̽���
		// ������ Ŭ������ ArrayDeque

		Deque<Integer> queue = new ArrayDeque<>();
		//1. ť�� ���� �� 10�� ����
		//2. ����Ȯ���� ���� -> fifo ����
		
		for( int i = 1; i <= 10; i++) {
			queue.add(i);
//			queue.offer(i);
		}
		
		
		// ������ �޼ҵ� 
//		queue.peek();
		
//		System.out.println(queue);
		//poll �� ����, FIFO ������ ����
		
//		queue.isEmpty();
		
//		while (/* queue.size() > 0*/ ! queue.isEmpty()) { // queue.isEmpty() ��������� true �� ��ȯ 
//			Integer val = queue.poll(); // ť�� ����� 1�� ����
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
