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
		
		JLabel label = new JLabel("슬라이더를 움직여보세요", JLabel.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT); // 가운데 정렬
		panel.add(label); 
		
		slider = new JSlider(0, 30, INIT_VALUE); // 0 ~ 30 까지, 초깃값 INIT_VALUE;
		slider.setMajorTickSpacing(10); // 큰 눈금 간격
		slider.setMinorTickSpacing(1); // 작은 눈금 간격
		slider.setPaintTicks(true); // 눈금을 표시함
		slider.setPaintLabels(true); // 값을 레이블로 표시함
		slider.addChangeListener(this);// 슬라이더의 값이 변경되었을 경우 
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
		if(!source.getValueIsAdjusting()) { //   슬라이더의 노브가 드래그 되고 있는 경우에 true를 리턴합니다.
			int value = (int) source.getValue(); // 이벤트 리스너 안에서 슬라이더의 값을 읽어냄
			button.setSize(value * 10, value * 10);
		}
		
	}
	public static void main(String[] args) {
		new SliderFrame();
	}
	
	
}
