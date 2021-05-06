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
		System.out.println(props.get("���"));
		props.put("���", "rose");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("dict.props");
			props.store(out, "����");
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
