package ch12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestFieldFrame570 extends JFrame{
	private JButton button;
	private JTextField text, resuit;
	
	public TestFieldFrame570() {
		this.setSize(300,130);
		this.setTitle("제곱 계산기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("숫자 입력"));
		text = new JTextField(15); // 텍스트 필드에 입력한 후에 enter 키를 누르면 액션 이벤트가 발생 / String 형
		text.addActionListener(listener);
		panel.add(text);
		
		panel.add(new JLabel("제곱한 값"));
		resuit = new JTextField(15);
		resuit.setEditable(false); // 값을 표시만 해두는 용도
		panel.add(resuit);
		
		button = new JButton("ok");
		button.addActionListener(listener);
		panel.add(button);
		this.add(panel);
		this.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button || e.getSource() == text) {
				String number = text.getText();
				int value = Integer.parseInt(number); // 래퍼 클래스로 String -> Integer
				resuit.setText(" " + value * value); // int 를 string 형으로 하기 위해 
				text.requestFocus(); 
				/*
				 *포커스란 ?
				 *ex) 해당요소에 포커스를 부여하여 
				 *1. 텍스트 창의 경우, 커서를 위치시켜 바로 입력가능하게 함.
				 *2. 버튼의 경우, 엔터 키, 스페이스바 를 눌렀을때 클릭 효과를 내게 함.
				 */
			}
		}
		
	}
	public static void main(String[] args) {
		new TestFieldFrame570();
	}
}
