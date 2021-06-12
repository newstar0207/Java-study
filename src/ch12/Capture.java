package ch12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture{
	
	public static void main(String[] args) {
		JFrame capture = new JFrame();
		JButton button = new JButton("click");
		
		capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d;
		Rectangle rect = new Rectangle(500 , 500);
		capture.setSize(d = new Dimension(500, 500));
		capture.setLocationRelativeTo(null);
		capture.add(button, BorderLayout.NORTH);
		
		button.addActionListener(new ActionListener() { // ����Ŭ����

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Robot robot = new Robot();
					final BufferedImage image = robot.createScreenCapture(rect);
					image.flush(); //  ���� ���ۿ� ����Ǿ� �ִ� ������ Ŭ���̾�Ʈ�� �����ϰ� ���۸� ����.
					JPanel panel = new JPanel() {  // ����Ŭ����
						@Override
						public void paintComponent(Graphics g) {
							super.paintComponent(g);
							g.drawImage(image, 0, 0, d.width, d.height, this);
						}
					};
					panel.setOpaque(false); // JLabel�� ��� �⺻ ������ �����̱� ������ setOpaque�Լ��� 
					// "true"�� ��������� ���������� �����ϴ�;
					// "false"�� ��� �����ϰ�;
					panel.prepareImage(image, panel); // �־��� �̹����� �׸� �� �ֵ��� �غ��� 
					panel.repaint();
					capture.getContentPane().add(panel, BorderLayout.CENTER);  // contentPane : �Ϲ����� ������Ʈ���� ���� �� �ִ� �г�
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		capture.setVisible(true);
	}

	
}
