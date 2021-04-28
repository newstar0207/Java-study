package ch15;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest3 {
   public static void main(String[] args) {
      // { 을 스택에 넣고 } 를 스택에서 뺀다
      // 만약 남아있는게 있다면 잘못된 식
      // empty 가 된다면 완료)
      Scanner input = new Scanner(System.in);
      System.out.print("input : ");
      String exp = input.nextLine();

      // 입력 받은 수식을 문자열 기준으로 문자열 토큰으로 분리
      // exp 문자열 변수에 값을 공백을 기준으로 문자열 토큰들로 분리
      StringTokenizer st = new StringTokenizer(exp);

      // { 일 경우 스택에 push , } 일 경우 스택에서 pop 함

      Stack<String> stack = new Stack<>();

      while (st.hasMoreElements()) { // hasMorTokens
         // 여는 괄호 추가 stack.push()
         // 닫는 괄호 시 토큰 제거 stack.pop()
         // 여는 괄호가 없을 시 break;
         String token = st.nextToken();
         if (token.equals("(")) {
            stack.push(token);
         } else if (token.equals(")")) {
            if(stack.isEmpty()) {
               System.out.println("잘못됨");
               return;
            }
            stack.pop();
         }
      }

      // 토큰 처리 완료
      // 식에 잘못된 것이 없거나, 여는 괄호가 더 많은 경우
      if (!stack.isEmpty()) {
         System.out.println("잘못됨");
         return; // void 라 값을 리턴할 수 없고 그냥 쓸경우 프로그램이 끝남
      }

      System.out.println("완벽함");
   }
}