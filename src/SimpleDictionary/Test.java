package SimpleDictionary;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties props = new Properties();

		try (FileReader reader = new FileReader("dict.props")) {
			props.load(reader);

		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
		System.out.println(props.get("사과"));
		props.put("장미", "rose");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("dict.props");
			props.store(out, "사전");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
			out.close();
			}catch(Exception ignore) {
				
			}
		}
	}

}
