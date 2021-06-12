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
//		��ũ�� ���ο� ������Ʈ�� ��������� �� (�Ʒ��� ����)
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
		 * ��ũ�� �ǹ����� ������ ����� Ÿ��α׿��� �Ʒ��� ���� �����ϰ�������
			JDK 1.8�������δ� getDocument() �κ��� ������ ���� ����� �� ����.
			�׳� append�� ����ϸ� �ڵ����� ��ũ���� �� ������ ��������.
		 */
//		textArea.setCaretPosition(textArea.getDocument().getLength()); //�׻� �Ʒ��� ��ũ�� ��
		
	}
	
	
	public static void main(String[] args) {
		new TextAreaFrame();
	}
	
	
}
