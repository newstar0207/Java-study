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
	 * 단어 입력 받을 수 있는 JTextField 검색버튼 추가버튼 단어장 구현을 위한 자료구조로 Map객체 사용
	 */
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	private static final String dirverClassName = "org.gjt.mm.mysql.Driver";
	/*
	 * Map 객체를 단어장 구현으로 사용 <key, value> 쌍으로 저장. key 는 한글 ,value 는 대응되는 영어단어.
	 */
	private Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	public SimpleDictionary() {
		// Panel의 기본 레이아웃 : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		searchBtn.addActionListener(this);
		this.add(addBtn);
		addBtn.addActionListener(this);
		this.setSize(new Dimension(600, 50));
		// searchBtn, addBtn 의 클릭이벤트가 발생했을때 처리할 리스너를 지정
		// 파일에 key=value 형태로 저장된 엔트리들을 읽어서, dict 를 구성함
		
		buildDictionaryFromFile();
		
		// DB에서 레코드를 읽고 , 그 레코드들을 이용해 구성
		buildDictionaryFromDB();
	}
	private void buildDictionaryFromDB() {
		/*
		 * 1. Data base 연결 
		 * 		1. JDBC 드라이버 로딩. Class.forName("org.gjt.mm.mysql.Driver");
		 * 2. SELECT 문 수행
		 * 3. SELECT 문의 수행으로 반환된 레코드들을 이용해
		 * dict Map 객체를 구성
		 * 4. Database연결 해제.
		*/ 
	}

	private void buildDictionaryFromFile() {
		// properties란?
		// key, value 의 타입이 각각 String, String 으로 고정된 Map;
		Properties props = new Properties();
		// 파일에서 읽어서 props 객체의 <key, value>
		// 쌍을 구성할 수 있다.
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
			 * 입력된 단어를 추출 String value = JOptionPane.showInputDialog(); 메서드를 호출해서 추가할 영어단어를
			 * 
			 * 입력받는다. dict.put(입력된 단어, inputDialog에 입력된 단어);
			 * 
			 */
			String value = JOptionPane.showInputDialog(this, key + "에 대응되는 영어단어를 입력");
			if (value.trim().length() == 0) {
				return;
			}
			dict.put(key, value);
			// 파일에 key = value 의 쌍으로 기록해둠.
			// DB에 key = value 의 쌍을 하나의 레코드로 저장
			
			addWordToFile(key, value);
			addToDB(key, value);
			JOptionPane.showMessageDialog(this, "단어 추가 완료.", key, JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == searchBtn) {
			/*
			 * 입력된 단어를 추출 그 단어를 key 값으로 가지는 대응되는 맵 엔트리가 있는지 검사 -> dict.get(단어) 그 단어에 대응되는 값이
			 * 있으면 JOptionPane 클래스의 ShowMessageDialog() 메서드를 호출하여 그 대응되는 값을 보여줌. 없다면 (null)
			 * JOptionPane.showMessageDialog() 메소드를 호출후 '단어를 찾을 수 없습니다' 라고 출력해줌 inputField 를
			 * 빈문자열로 설정함.
			 * 
			 */
			System.out.println("[" + key + "]");
			String value = dict.get(key);
			if (value != null) {
				// 단어가 있음
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			} else {
				// 단어가 없음
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다", key, JOptionPane.ERROR_MESSAGE);
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
		frame.setTitle("사전");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}