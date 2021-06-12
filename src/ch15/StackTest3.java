package ch15;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest3 {
   public static void main(String[] args) {
      // { �� ���ÿ� �ְ� } �� ���ÿ��� ����
      // ���� �����ִ°� �ִٸ� �߸��� ��
      // empty �� �ȴٸ� �Ϸ�)
      Scanner input = new Scanner(System.in);
      System.out.print("input : ");
      String exp = input.nextLine();

      // �Է� ���� ������ ���ڿ� �������� ���ڿ� ��ū���� �и�
      // exp ���ڿ� ������ ���� ������ �������� ���ڿ� ��ū��� �и�
      StringTokenizer st = new StringTokenizer(exp);

      // { �� ��� ���ÿ� push , } �� ��� ���ÿ��� pop ��

      Stack<String> stack = new Stack<>();

      while (st.hasMoreElements()) { // hasMorTokens
         // ���� ��ȣ �߰� stack.push()
         // �ݴ� ��ȣ �� ��ū ���� stack.pop()
         // ���� ��ȣ�� ���� �� break;
         String token = st.nextToken();
         if (token.equals("(")) {
            stack.push(token);
         } else if (token.equals(")")) {
            if(stack.isEmpty()) {
               System.out.println("�߸���");
               return;
            }
            stack.pop();
         }
      }

      // ��ū ó�� �Ϸ�
      // �Ŀ� �߸��� ���� ���ų�, ���� ��ȣ�� �� ���� ���
      if (!stack.isEmpty()) {
         System.out.println("�߸���");
         return; // void �� ���� ������ �� ���� �׳� ����� ���α׷��� ����
      }

      System.out.println("�Ϻ���");
   }
}