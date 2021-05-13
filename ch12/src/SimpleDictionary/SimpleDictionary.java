package SimpleDictionary;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener {
	/*
	 * �ܾ� �Է� ���� �� �ִ� JTextField �˻���ư �߰���ư �ܾ��� ������ ���� �ڷᱸ���� Map��ü ���
	 */
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	private static final String dirverClassName = "org.gjt.mm.mysql.Driver";
	/*
	 * Map ��ü�� �ܾ��� �������� ��� <key, value> ������ ����. key �� �ѱ� ,value �� �����Ǵ� ����ܾ�.
	 */
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	public SimpleDictionary() {
		// Panel�� �⺻ ���̾ƿ� : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		searchBtn.addActionListener(this);
		this.add(addBtn);
		addBtn.addActionListener(this);
		this.setSize(new Dimension(600, 50));
		// searchBtn, addBtn �� Ŭ���̺�Ʈ�� �߻������� ó���� �����ʸ� ����
		// ���Ͽ� key=value ���·� ����� ��Ʈ������ �о, dict �� ������
		
		buildDictionaryFromFile();
		
		// DB���� ���ڵ带 �а� , �� ���ڵ���� �̿��� ����
		buildDictionaryFromDB();
	}
	private void buildDictionaryFromDB() {
		/*
		 * 1. Data base ���� 
		 * 		1. JDBC ����̹� �ε�. Class.forName("org.gjt.mm.mysql.Driver");
		 * 2. SELECT �� ����
		 * 3. SELECT ���� �������� ��ȯ�� ���ڵ���� �̿���
		 * dict Map ��ü�� ����
		 * 4. Database���� ����.
		*/ 
	}

	private void buildDictionaryFromFile() {
		// properties��?
		// key, value �� Ÿ���� ���� String, String ���� ������ Map;
		Properties props = new Properties();
		// ���Ͽ��� �о props ��ü�� <key, value>
		// ���� ������ �� �ִ�.
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)) {
			props.load(fReader);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Set<Object> set = props.keySet();
		for (Object obj : set) {
			dict.put((String) obj, (String) props.get(obj));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if (key.trim().length() == 0)
			return;
		if (e.getSource() == addBtn) {
			/*
			 * 
			 * �Էµ� �ܾ ���� String value = JOptionPane.showInputDialog(); �޼��带 ȣ���ؼ� �߰��� ����ܾ
			 * 
			 * �Է¹޴´�. dict.put(�Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�);
			 * 
			 */
			String value = JOptionPane.showInputDialog(this, key + "�� �����Ǵ� ����ܾ �Է�");
			if (value.trim().length() == 0) {
				return;
			}
			dict.put(key, value);
			// ���Ͽ� key = value �� ������ ����ص�.
			// DB�� key = value �� ���� �ϳ��� ���ڵ�� ����
			
			addWordToFile(key, value);
			addToDB(key, value);
			JOptionPane.showMessageDialog(this, "�ܾ� �߰� �Ϸ�.", key, JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == searchBtn) {
			/*
			 * �Էµ� �ܾ ���� �� �ܾ key ������ ������ �����Ǵ� �� ��Ʈ���� �ִ��� �˻� -> dict.get(�ܾ�) �� �ܾ �����Ǵ� ����
			 * ������ JOptionPane Ŭ������ ShowMessageDialog() �޼��带 ȣ���Ͽ� �� �����Ǵ� ���� ������. ���ٸ� (null)
			 * JOptionPane.showMessageDialog() �޼ҵ带 ȣ���� '�ܾ ã�� �� �����ϴ�' ��� ������� inputField ��
			 * ���ڿ��� ������.
			 * 
			 */
			System.out.println("[" + key + "]");
			String value = dict.get(key);
			if (value != null) {
				// �ܾ ����
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			} else {
				// �ܾ ����
				JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�", key, JOptionPane.ERROR_MESSAGE);
			}
		}
//		inputField.setText("");
	}
	
	private void addToDB(String key, String value) {
		
	}

	private void addWordToFile(String key, String value) {
		try (FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true);) {
			fWriter.write("\n" + key + "=" + value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
//		File file = new File("DIC_FILE_NAME");
//		System.out.println(file.getAbsolutePath());
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);
		frame.setTitle("����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}