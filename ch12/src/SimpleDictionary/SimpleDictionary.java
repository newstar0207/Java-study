package SimpleDictionary;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	private static final String dirverClassName = "com.mysql.cj.jdbc.Driver";
	private static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/dictionary";
	private static final String DB_USER = "";
	private static final String DB_USER_PW= "";
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

//		buildDictionaryFromFile(); 

		// DB���� ���ڵ带 �а� , �� ���ڵ���� �̿��� ����
		buildDictionaryFromDB();
	}

	private void buildDictionaryFromDB() {
		/* * JDBC ����̹��� �ٸ��� �ڹ� �ȿ����� ������ � ����̹��� ����ϴ� ������ ���� (�ٸ� sql ���� �ٸ� �� ����)
		 * 1. Data base ���� 
		 * 		a. JDBC ����̹� �޸𸮿� �ε�(����). Class.forName("org.gjt.mm.mysql.Driver");
		 * 		b. DriverMangager (java.sql ��Ű���� ���ǵ� Ŭ����)
		 * 			Connection con = DriverManager.getConnection();
		 * 			�޼��带 ȣ���� ������ establish
		 *  		�� �� ���� ������ getConnection() �޼ҵ忡 �����������
		 *  		���� ���� : DB Server�� URL (ip�ּ�, port ��ȣ, DB �̸�, db ������� ���̵�� ��ȣ)
		 * 
		 * 2. Connection ��ü�� ���� SQL�� ������ ������ ��û�ϰ� �� ����� �޾� ó����
		 * 		a. con.createStatement() �޼ҵ� ȣ���� ���� ��ȯ�Ǵ� Statement ��ü�� �̿� ( ���� SQL ��)
		 * 			����SQL�� : ���α׷��� ������ ������ SQL���� �����ǰ� ������ ���.
		 * 			ex ) select *  from dict;
		 * 		b. con.prepareStatement() �޼��� ȣ���� ���� ��ȯ�Ǵ� PreparedStatement ��ü�� �̿� ( ���� SQL ��)
		 * 			����SQL�� : ���α׷��� ������ ������ SQL���� ���������ʰ� ����Ǵ� SQL��
		 * 			ex ) select * from dict where han = ?
		 * 		* �ַ� b �� �����!!
		 *      * String sql = "select * from dict";
		 *      * PreparedStatement pstmt = con.prepareStatement(sql)
		 * * ���� �غ� �� Preparedstatement �� �����Ű�� ��� 
		 * 		a. ������ SQL ���� insert, delete, �Ǵ� update���� ���
		 * 			pstmt.executeUpdate(); ȣ�� // ���ڰ� ����
		 * 		b. ������ SQL ���� select ���� ���
		 * 		ResultSet rs =	pstmt.executeQuery(); ȣ�� // Resultset ���·� ��ȯ 
		 * 			rs.next(); // ���������� ������ true ������ false�� ��ȯ 
		 * 			while(rs.next()){ }
		 * 3. DB server���� ������ ����(close) ��
		 * 		con.close();
		*/ 		
		
		// MySql JDBC ����̹��� �޸𸮿� ����
		try {
		Class.forName(dirverClassName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		//DB ������ ����
		//DB ���� ���� URL ������ �ٸ�
//			DriverManager.getConnection(DB_server_url, DB_user,DB_user_ password)
//			DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW);
		try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW);){
					
			//SELECT �� ����
			String sql = "select * from dict";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// ���� �����Ͱ� ����Ű�� Į�� ���� ����
				// �� Į���� Ÿ�Կ� ���� ȣ���� �޼��尡 �ٸ�
				// ex) char, varchar Ÿ�� : getString("Į���̸�" �Ǵ� "Į�� ��ġ");
				// ex) int Ÿ�� : getInt("Į���̸�" �Ǵ� "Į�� ��ġ");
				// ex) DateTime, Date Ÿ�� : getDate("Į���̸�" �Ǵ� "Į�� ��ġ");
				String hword = rs.getString("hword" /* 1 */ ); // �ַ� ���� ���
				String eword = rs.getString(2);
				dict.put(hword, eword);
				dict.put(eword, hword);
			}
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
//		finally {
//			try {
//			con.close();
//			} catch ( Exception ignore) {}
//		}
		
	}
//---------------------------------------------------------------------------------
	
	private void buildDictionaryFromFile() {
		// properties��?
		// key, value �� Ÿ���� ���� String, String ���� ������ Map;
		Properties props = new Properties();
		// ���Ͽ��� �о props ��ü�� <key, value>
		// ���� ������ �� �ִ�.
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)) {
			props.load(fReader); // ������Ƽ ���ϰ�ü�� �ε���
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Set<Object> set = props.keySet();
		for (Object obj : set) {
			dict.put((String) obj, (String) props.get(obj)); // props ��ü�� key �� , value ��
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
			dict.put(value, key);
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
		/*
		 * 1. ����̹� Ŭ������ �� �ѹ��� �޸𸮿� �����ϸ� ��. (�츮�� �����ڿ��� �����)
		 * 2. �����ͺ��̽��� ����
		 * 3. SQL �� ����
		 * 4. �����ͺ��̽� ���� �� ����
		 */
		try (Connection con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PW)){
			String sql = "INSERT INTO dict VALUES(? , ?)";
			PreparedStatement pstmt = con.prepareStatement(sql); // �������� ���ư� �˻縦 �� (�̶� ? �ڸ��� �����)
			
			// ?�ڸ��� ���� ä�� ��, �������� �����غ�� SQL ���� �����϶�� ��û�ؾ���.
			pstmt.setString(1, key);
			pstmt.setString(2, value);
			
			
			pstmt.executeUpdate(); // �����û
			
		}catch(Exception e) {
			e.printStackTrace();
		}
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