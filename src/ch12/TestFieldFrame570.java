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
		this.setTitle("���� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonListener listener = new ButtonListener();
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("���� �Է�"));
		text = new JTextField(15); // �ؽ�Ʈ �ʵ忡 �Է��� �Ŀ� enter Ű�� ������ �׼� �̺�Ʈ�� �߻� / String ��
		text.addActionListener(listener);
		panel.add(text);
		
		panel.add(new JLabel("������ ��"));
		resuit = new JTextField(15);
		resuit.setEditable(false); // ���� ǥ�ø� �صδ� �뵵
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
				int value = Integer.parseInt(number); // ���� Ŭ������ String -> Integer
				resuit.setText(" " + value * value); // int �� string ������ �ϱ� ���� 
				text.requestFocus(); 
				/*
				 *��Ŀ���� ?
				 *ex) �ش��ҿ� ��Ŀ���� �ο��Ͽ� 
				 *1. �ؽ�Ʈ â�� ���, Ŀ���� ��ġ���� �ٷ� �Է°����ϰ� ��.
				 *2. ��ư�� ���, ���� Ű, �����̽��� �� �������� Ŭ�� ȿ���� ���� ��.
				 */
			}
		}
		
	}
	public static void main(String[] args) {
		new TestFieldFrame570();
	}
}
