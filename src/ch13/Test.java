package ch13;


public class Test{
    public static void main(String args[]) throws Exception{
    	/*n���� ������ ���� �迭�� �ִ�. �� �迭�� ���������� ���� ������ ��� ������ �ִ�.
    	 *  ���� ����� �� �迭�� �� Ư���� ������� �����ؾ� �Ѵ�.
			������ �ǰ� �� ��, ���� ������ ���ʿ� ���������� ���ʿ� �־�� �Ѵ�.
 			���� ���������� ���������� �������� ������ ����� �Ѵ�.
			
    	 * �¿�� �ڸ��� �ٲٴµ� ���� - �̰� �ڰ� + ��츸 
    	 * �ڸ��� �ٲٹǷ� ������ �ٲ��� ����.
    	 */
        int[] list = {-1,1,-3,3,-2,2,4}; 
        int length = list.length-1; 
        for(int i=0; i<length; i++){ 
            for(int j=0; j<(length-i); j++){
                if(list[j] > 0 && list[j+1] < 0){
                    int k = list[j];
                    list[j] = list[j+1];
                    list[j+1] = k;
                }
            }
        }
        for(int k : list) {
            System.out.print(k+" ");
        }
    }
}