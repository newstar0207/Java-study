package tutoring;

public class NumberOfPAndY {

	public static void main(String[] args) {
		boolean solution(String s) {
	        boolean answer = true;

	        int pNum = 0;
			int yNum = 0;
			
			for(int i = 0 ;i < s.length(); i++) {
				if(s.charAt(i) == 'p' || s.charAt(i) == 'P') 
					pNum++;
				if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
					yNum++;
				}
			}
			
			if (pNum == yNum) {
				return answer;
			}else {
	            return false;
	        }
	    }
	}
}
