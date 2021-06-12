package ch12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxFrame extends JFrame implements ActionListener{
	
	private JLabel label;
	
	public ComboBoxFrame() {
		this.setTitle("combo box");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		
		String[] fruit = { "Fruit1", "Fruit2", "Fruit3"};
		JComboBox fruitlist  = new JComboBox(fruit);
		fruitlist.setSelectedIndex(0); // 0���� �����ص� ;
		fruitlist.addActionListener(this); // ����ڰ� �޺� �ڽ����� �׸��� �����ϸ� �׼� �̺�Ʈ �߻�
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		changePicture(fruit[fruitlist.getSelectedIndex()]);
		this.add(fruitlist, BorderLayout.PAGE_START);
		this.add(label, BorderLayout.PAGE_END);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox cb = (JComboBox) e.getSource();
		String name = (String) cb.getSelectedItem(); // �޺��ڽ��� ���� ����ڰ� ������ �׸��� ������ (ex. Fruit1 , object Ÿ��;
		changePicture(name);
	}
	
	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon("img/" + name + ".png");
		label.setIcon(icon);
		if(icon != null) {
			label.setText(null);
		}else {
			label.setText("no img");
		}
	}
	public static void main(String[] args) {
		new ComboBoxFrame();
	}
	
}
