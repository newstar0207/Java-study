package ch15;

import java.util.Stack; // util �̶� ���̱���� �ǹ�

public class StackTest {
	public static void main(String[] args) {
		// stack : LIFO(Last In First Out)
		// Generic : Ŭ���� ���ο��� ����� ������ Ÿ���� ������ ���� �ƴ�,
		// �� Ŭ������ ��ü�� ������ �� ������ Ÿ���� ������ �� �ֵ���, �ÿ��� Ÿ����
		// �Ķ���ͷ� �޾Ƽ� ��ü�� �����ϴ� ��.
		// Ÿ�� �Ķ���� (Type Parameter)
		// primitive type �� ���� ������!
		Stack<Integer> stack = new Stack<>();
		//stack �� �ַ� ��ȣ�� ������ �°ų� ���� Ȯ���ϴ� �뵵�� ���� ���̴µ���
		for( int i = 1; i <= 10; i++) {
			stack.push(i);
		}
		
		System.out.println(stack);

		while(! stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.println(val);
		}
	}
}
