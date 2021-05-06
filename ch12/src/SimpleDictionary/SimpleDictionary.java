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
	 * �ܾ� �Է� ���� �� �ִ� JTextField
	 * �˻���ư
	 * �߰���ư
	 * �ܾ��� ������ ���� �ڷᱸ���� Map��ü ���
	 */
	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("�˻�");
	private JButton addBtn = new JButton("�߰�");
	
	/*
	 * Map ��ü�� �ܾ��� �������� ���
	 * <key, value> ������ ����. key �� �ѱ� ,value �� �����Ǵ� ����ܾ�.
	 */
	
	private Map<String, String> dict = new HashMap<>();
	
	public SimpleDictionary() {
		// Panel�� �⺻ ���̾ƿ� : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		searchBtn.addActionListener(this);
		this.add(addBtn);
		addBtn.addActionListener(this);
		this.setSize(new Dimension(600, 50));
		
		// searchBtn, addBtn �� Ŭ���̺�Ʈ�� �߻������� ó���� �����ʸ� ����
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if(key.trim().length() == 0) return;
		if(e.getSource() == addBtn) {
			/*
			 * �Էµ� �ܾ ����
			 * String value = JOptionPane.showInputDialog();
			 * �޼��带 ȣ���ؼ� �߰��� ����ܾ �Է¹޴´�.
			 * dict.put(�Էµ� �ܾ�, inputDialog�� �Էµ� �ܾ�);
			 */
			String value = JOptionPane.showInputDialog(this,key + "�� �����Ǵ� ����ܾ �Է�");
			if(value.trim().length() == 0) {
				return;
			}
			dict.put(key, value);
			JOptionPane.showMessageDialog(this, "�ܾ� �߰� �Ϸ�.", key, JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == searchBtn) {
			/*
			 * �Էµ� �ܾ ����
			 * �� �ܾ key ������ ������ �����Ǵ� �� ��Ʈ���� �ִ��� �˻� -> dict.get(�ܾ�)
			 * �� �ܾ �����Ǵ� ���� ������ JOptionPane Ŭ������ ShowMessageDialog() �޼��带
			 * ȣ���Ͽ� �� �����Ǵ� ���� ������.
			 * ���ٸ� (null) JOptionPane.showMessageDialog() �޼ҵ带 ȣ����
			 * '�ܾ ã�� �� �����ϴ�' ��� �������
			 * inputField �� ���ڿ��� ������.
			 */
			System.out.println("[" + key + "]");
			String value =dict.get(key);
			if( value != null) {
				// �ܾ ����
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
				
			}else {
				// �ܾ ����
				JOptionPane.showMessageDialog(this, "�ܾ ã�� �� �����ϴ�",key, JOptionPane.ERROR_MESSAGE
						);
			}
		}
		inputField.setText("");
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);
		frame.setTitle("����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
