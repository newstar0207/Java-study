package tutoring;

public class CreateMine {

	public static void main(String[] args) {
		int num1, num2, num;
		int[][] list = new int[10][10];;

		for(int i = 0; i < 10; i++) { // �ʱ�ȭ
			for(int j = 0; j< 10 ; j++) {
				list[i][j] = 0;
			}
		}

		for(int i = 0; i < 40; i++) { // ���ڻ���
			num1 = (int)(Math.random() * 10);
			num2 = (int)(Math.random() * 10);
			if(list[num1][num2] == 0) {
				list[num1][num2] = 1;
			}else if(list[num1][num2] == 1) {
				i--;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 ; j++) {
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
		// �ڵ����� 10������ ũ�⸦ ����� 40%�� ���ڸ� ����� �ڵ�
//		num = (int) (Math.random() * 10 + 1);
//		list = new int[num][num]; // 
//
//		for (int i = 0; i < num; i++) { // �ʱ�ȭ
//			for (int j = 0; j < num; j++) {
//				list[i][j] = 0;
//			}
//		}
//
//		for (int i = 0; i < ((num * num) * 0.4); i++) { // ���ڻ���
//			num1 = (int) (Math.random() * num);
//			num2 = (int) (Math.random() * num);
//			if (list[num1][num2] == 0) {
//				list[num1][num2] = 1;
//			} else if (list[num1][num2] == 1) {
//				i--;
//			}
//		}
//		
//		for(int i = 0; i < num; i++) {
//			for(int j = 0; j < num ; j++) {
//				System.out.print(list[i][j] + " ");
//			}
//			System.out.println();
//		}

	}
}
