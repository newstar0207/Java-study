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
		
		button.addActionListener(new ActionListener() { // 무명클래스

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Robot robot = new Robot();
					final BufferedImage image = robot.createScreenCapture(rect);
					image.flush(); //  현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비운다.
					JPanel panel = new JPanel() {  // 무명클래스
						@Override
						public void paintComponent(Graphics g) {
							super.paintComponent(g);
							g.drawImage(image, 0, 0, d.width, d.height, this);
						}
					};
					panel.setOpaque(false); // JLabel의 경우 기본 배경색이 투명이기 때문에 setOpaque함수를 
					// "true"로 지정해줘야 배경색설정이 가능하다;
					// "false"의 경우 투명하게;
					panel.prepareImage(image, panel); // 주어진 이미지를 그릴 수 있도록 준비함 
					panel.repaint();
					capture.getContentPane().add(panel, BorderLayout.CENTER);  // contentPane : 일반적인 컴포넌트들을 가질 수 있는 패널
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		capture.setVisible(true);
	}

	
}
