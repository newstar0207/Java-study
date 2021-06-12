package ch12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaFrame extends JFrame implements ActionListener{

	
	protected JTextField textField;
	protected JTextArea textArea;
	protected JScrollPane scrollpane;
	
	public TextAreaFrame() {
		this.setTitle("text area test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField(30);
		textField.addActionListener(this);
		
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		
		scrollpane = new JScrollPane(textArea);
		
		this.add(textField, BorderLayout.NORTH);
//		this.add(textArea, BorderLayout.CENTER);
//		스크롤 페인에 컴포넌트를 집어넣으면 됨 (아래와 같이)
		this.add(scrollpane, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		textArea.append(text + "\n");
		textField.selectAll();
		/*
		 * 스크롤 맨밑으로 내리는 기능은 타블로그에서 아래와 같이 설명하고있으나
			JDK 1.8기준으로는 getDocument() 부분이 오류가 나서 사용할 수 없다.
			그냥 append를 사용하면 자동으로 스크롤이 맨 밑으로 맞춰진다.
		 */
//		textArea.setCaretPosition(textArea.getDocument().getLength()); //항상 아래로 스크롤 됨
		
	}
	
	
	public static void main(String[] args) {
		new TextAreaFrame();
	}
	
	
}
