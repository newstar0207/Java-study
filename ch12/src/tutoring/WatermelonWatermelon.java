package tutoring;

public class WatermelonWatermelon {

	public static void main(String[] args) {
		
		int a = 6;
		String resuit = "";
		
		for(int i = 0 ; i < a; i++) {
			if(i % 2 == 0) {
				resuit += "¼ö";
			}else {
				resuit += "¹Ú";
			}
		}
		
		System.out.println(resuit);
	}

}
