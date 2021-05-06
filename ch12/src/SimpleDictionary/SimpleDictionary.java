package SimpleDictionary;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener{

	/*
	 * 단어 입력 받을 수 있는 JTextField
	 * 검색버튼
	 * 추가버튼
	 * 단어장 구현을 위한 자료구조로 Map객체 사용
	 */
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	
	/*
	 * Map 객체를 단어장 구현으로 사용
	 * <key, value> 쌍으로 저장. key 는 한글 ,value 는 대응되는 영어단어.
	 */
	
	private Map<String, String> dict = new HashMap<>();
	
	public SimpleDictionary() {
		// Panel의 기본 레이아웃 : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		searchBtn.addActionListener(this);
		this.add(addBtn);
		addBtn.addActionListener(this);
		this.setSize(new Dimension(600, 50));
		
		// searchBtn, addBtn 의 클릭이벤트가 발생했을때 처리할 리스너를 지정
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if(key.trim().length() == 0) return;
		if(e.getSource() == addBtn) {
			/*
			 * 입력된 단어를 추출
			 * String value = JOptionPane.showInputDialog();
			 * 메서드를 호출해서 추가할 영어단어를 입력받는다.
			 * dict.put(입력된 단어, inputDialog에 입력된 단어);
			 */
			String value = JOptionPane.showInputDialog(this,key + "에 대응되는 영어단어를 입력");
			if(value.trim().length() == 0) {
				return;
			}
			dict.put(key, value);
			JOptionPane.showMessageDialog(this, "단어 추가 완료.", key, JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == searchBtn) {
			/*
			 * 입력된 단어를 추출
			 * 그 단어를 key 값으로 가지는 대응되는 맵 엔트리가 있는지 검사 -> dict.get(단어)
			 * 그 단어에 대응되는 값이 있으면 JOptionPane 클래스의 ShowMessageDialog() 메서드를
			 * 호출하여 그 대응되는 값을 보여줌.
			 * 없다면 (null) JOptionPane.showMessageDialog() 메소드를 호출후
			 * '단어를 찾을 수 없습니다' 라고 출력해줌
			 * inputField 를 빈문자열로 설정함.
			 */
			System.out.println("[" + key + "]");
			String value =dict.get(key);
			if( value != null) {
				// 단어가 있음
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
				
			}else {
				// 단어가 없음
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다",key, JOptionPane.ERROR_MESSAGE
						);
			}
		}
		inputField.setText("");
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);
		frame.setTitle("사전");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
