package ch13;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculatorTest extends JFrame implements ActionListener {
	private JTextField textField;
	private JPanel panel;
	private JButton[] numberButtons;
	private JButton add, sub, mul, div, dec, equ, del, clr, neg;
	private Font myFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);

	private double num1;
	private double num2;
	private double resuit;
	private String operator = "";
	private int numOfOperand = 0;

	public CalculatorTest() {
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(420, 550);
		this.setLayout(null);

		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);

		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		numberButtons = new JButton[10];
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].addActionListener(this);
		}

		add = new JButton("+");
		add.setFocusable(false);
		add.setFont(myFont);
		add.addActionListener(this);

		sub = new JButton("-");
		sub.setFocusable(false);
		sub.setFont(myFont);
		sub.addActionListener(this);

		mul = new JButton("*");
		mul.setFocusable(false);
		mul.setFont(myFont);
		mul.addActionListener(this);

		div = new JButton("/");
		div.setFocusable(false);
		div.setFont(myFont);
		div.addActionListener(this);

		dec = new JButton(".");
		dec.setFocusable(false);
		dec.setFont(myFont);
		dec.addActionListener(this);

		equ = new JButton("=");
		equ.setFocusable(false);
		equ.setFont(myFont);
		equ.addActionListener(this);

		del = new JButton("Delete");
		del.setFocusable(false);
		del.setBounds(150, 430, 100, 50);
		del.setFont(myFont);
		del.addActionListener(this);

		clr = new JButton("Clear");
		clr.setFocusable(false);
		clr.setBounds(250, 430, 100, 50);
		clr.setFont(myFont);
		clr.addActionListener(this);

		neg = new JButton("-");
		neg.setFocusable(false);
		neg.setBounds(50, 430, 100, 50);
		neg.setFont(myFont);
		neg.addActionListener(this);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(add);

		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(sub);

		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mul);

		panel.add(dec);
		panel.add(numberButtons[0]);
		panel.add(equ);
		panel.add(div);

		this.add(neg);
		this.add(clr);
		this.add(del);
		this.add(panel);
		this.add(textField);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JFrame calculator = new CalculatorTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < numberButtons.length; i++) {
			if (e.getSource() == numberButtons[i]) {
				System.out.println(i + " 버튼이 클릭되었습니다.");
				String str = textField.getText();
				textField.setText(str.concat(String.valueOf(i)));
				break;
			}
		}
		if (e.getSource() == dec) {
			String str = textField.getText();
			textField.setText(str.concat("."));
			System.out.println("decimal 버튼이 클릭되었습니다.");
		} else if (e.getSource() == add || e.getSource() == sub || e.getSource() == mul || e.getSource() == div) {
			System.out.println(((JButton) (e.getSource())).getText() + " 버튼이 클릭되었습니다.");
			String str = textField.getText();
			num1 = Double.parseDouble(str);
			operator = ((JButton) (e.getSource())).getText();
			textField.setText("");
			numOfOperand = 1;
		} else if (e.getSource() == equ) {
			System.out.println("= 버튼이 클릭되었습니다.");
			String str = textField.getText();
			System.out.println("[" + str + "]");

			if (str != null && str.equals("") == false && operator.equals("") == false) {
				numOfOperand += 1;
				if (numOfOperand == 2) {
					num2 = Double.parseDouble(str);
					switch (operator) {
					case "+":
						resuit = num1 + num2;
						break;
					case "-":
						resuit = num1 - num2;
						break;
					case "*":
						resuit = num1 * num2;
						break;
					case "/":
						resuit = num1 / num2;
						break;
					}
				}
			}

			textField.setText(String.valueOf(resuit));
			num1 = resuit;
			operator = "";
			numOfOperand = 0;
		} else if (e.getSource() == clr) {
			textField.setText("");
			System.out.println("clear 버튼이 클릭되었습니다.");
		} else if (e.getSource() == del) {
			String str = textField.getText();
			if (str.length() > 0) {
				textField.setText(str.substring(0, str.length() - 1));
			}
			System.out.println("delete 버튼이 클릭되었습니다.");
		} else if (e.getSource() == neg) {
			if(textField.getText().equals("") == false) {
				String str = textField.getText();
				double temp = Double.parseDouble(str);
				temp = temp * -1;
				textField.setText(String.valueOf(temp));
			}
		}
	}

}
