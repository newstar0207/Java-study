package ch15;

import java.util.StringTokenizer;

public class StackTest2 {
	public static void main(String[] args) {
		String str = "apple, banana, carrot, pineapple, grape, mango, strawberry, watermelon, melon, orange, coconut, kiwi, lemon, tomato, cherry, blueberry, peach, cramberry, raspberry";
		String s;
		
		// ���� ���ڸ� �������� ¥���� ��
		// StringTokennizer :
		// �����ڸ� �Է��ϰ� �����ڷ� ���еǴ� ���ڿ��� �̾� �����ְ� ����
		
		//String str, String delim
		StringTokenizer st = new StringTokenizer(str, ", ");
//		String s = st.nextToken();
		
		System.out.println(st.countTokens());
		
		//1. ��ū�� ����ŭ for �� ����
		for(int i = 0; i < st.countTokens(); i++) {
			s = st.nextToken();
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		st = new StringTokenizer(str, ", ");
		
		//2. ���� ������ �� ��ū�� �����ִ��� ����� �ִٸ� nextToken() �� �̿��� ����ϱ� �ַ� �̿�
		while(st.hasMoreTokens()) {
			s = st.nextToken();
			System.out.print("[" + s + "]");
		}
		
	}
}
