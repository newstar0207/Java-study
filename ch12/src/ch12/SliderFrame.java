package ch12;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame implements ChangeListener{
	static final int INIT_VALUE = 15;
	private JButton button;
	private JSlider slider;
	
	public SliderFrame() {
		JPanel panel;
		
		this.setTitle("slider test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		JLabel label = new JLabel("�����̴��� ������������", JLabel.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT); // ��� ����
		panel.add(label); 
		
		slider = new JSlider(0, 30, INIT_VALUE); // 0 ~ 30 ����, �ʱ갪 INIT_VALUE;
		slider.setMajorTickSpacing(10); // ū ���� ����
		slider.setMinorTickSpacing(1); // ���� ���� ����
		slider.setPaintTicks(true); // ������ ǥ����
		slider.setPaintLabels(true); // ���� ���̺�� ǥ����
		slider.addChangeListener(this);// �����̴��� ���� ����Ǿ��� ��� 
		panel.add(slider);
		
		button = new JButton("  ");
		ImageIcon icon = new ImageIcon("img/Fruit1.png");
		button.setIcon(icon);
		button.setSize(INIT_VALUE * 10 , INIT_VALUE * 10);
		panel.add(button);
		
		this.add(panel);
		
		this.setSize(300, 300);
		this.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) { //   �����̴��� ��갡 �巡�� �ǰ� �ִ� ��쿡 true�� �����մϴ�.
			int value = (int) source.getValue(); // �̺�Ʈ ������ �ȿ��� �����̴��� ���� �о
			button.setSize(value * 10, value * 10);
		}
		
	}
	public static void main(String[] args) {
		new SliderFrame();
	}
	
	
}
