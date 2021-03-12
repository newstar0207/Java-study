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
		fruitlist.setSelectedIndex(0); // 0번을 선택해둠 ;
		fruitlist.addActionListener(this); // 사용자가 콤보 박스에서 항목을 선택하면 액션 이벤트 발생
		
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
		String name = (String) cb.getSelectedItem(); // 콤보박스로 부터 사용자가 선택한 항목을 가져옴 (ex. Fruit1 , object 타입;
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
