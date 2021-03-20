package ch12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame {

	private JTextArea englishArea, koreanArea;
	private JButton changeButton, cancelButton;
	
	public TextConverter() {
		
		this.setTitle("TextConverter!");
		
		JPanel textPanel = new JPanel(new GridLayout(1,2, 20 , 20));
		
		englishArea = new JTextArea(10, 14);
		englishArea.setBackground(new Color(181, 223, 255));
		koreanArea = new JTextArea(10, 14);
		koreanArea.setBackground(new Color(181, 223, 255));
		
		textPanel.add(koreanArea);
		textPanel.add(englishArea);
		
		JPanel buttonPanel = new JPanel(); // flowlayout
		
		changeButton = new JButton("convert");
		buttonPanel.add(changeButton);
		
		changeButton.setBackground(Color.green);
		changeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				englishArea.setText("");
				String english = toEnglish(koreanArea.getText());
				englishArea.append(english);
			}
			
			private String toEnglish(String korean) {
				String resuit = korean;
				resuit = resuit.replace("¹Ù³ª³ª", "banana");
				return resuit;
			}
		
		});
		
		cancelButton = new JButton("cancel");
		buttonPanel.add(cancelButton);
		cancelButton.setBackground(Color.green);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				koreanArea.setText("");
			}
			
		});
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // int hgap, int vgap
		mainPanel.add(textPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		mainPanel.setOpaque(true);
		
//		this.add(textPanel, BorderLayout.CENTER);
//		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setLocationRelativeTo(null);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20 , 20)); // int align, int hgap, int vgap
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		new TextConverter();
	}
}
