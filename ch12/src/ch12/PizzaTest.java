package ch12;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame584 extends JFrame implements ActionListener {

	private JButton order, cancel;
	private JTextField textField, resuitField;
	private int resuit, typeResuit, sizeResuit, toppingResuit;

	public MyFrame584() {

		JPanel panel = new JPanel();

		WelcomePanel welcomepanel = new WelcomePanel();
		TypePanel typepanel = new TypePanel();
		AddTopping addtopping = new AddTopping();
		
		Size size = new Size();

		panel.setLayout(new GridLayout(1, 3));

		panel.add(typepanel);
		panel.add(addtopping);
		panel.add(size);

		this.add(welcomepanel, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(6);
		textField.setBackground(Color.white);

		resuitField = new JTextField();
		resuitField.setEditable(false);
		resuitField.setColumns(6);
		resuitField.setBackground(Color.white);

		JPanel resuitpanel = new JPanel();

		order = new JButton("주문");
		order.setBackground(new Color(168, 255, 158));
		order.addActionListener(this);

		cancel = new JButton("취소");
		cancel.setBackground(new Color(168, 255, 158));
		cancel.addActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				
				resuitField.setText(String.valueOf(0));
				
				resuit = 0;
				typeResuit = 0;
				sizeResuit = 0;
				
				addtopping.bacon.setSelected(false);
				addtopping.cheese.setSelected(false);
				addtopping.pepper.setSelected(false);
				addtopping.pepperoni.setSelected(false);
				
				toppingResuit = 0;
				textField.setText(String.valueOf(0));
			}
		});

		resuitpanel.setBackground(Color.white);

		resuitpanel.add(order);
		resuitpanel.add(cancel);
		resuitpanel.add(textField);
		resuitpanel.add(resuitField);

		this.add(resuitpanel, BorderLayout.SOUTH);

		this.setSize(500, 250);
		this.setTitle("피자주문");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == order) {
			resuit = sizeResuit + toppingResuit + typeResuit;
			resuitField.setText(String.valueOf(resuit));
		}
	}

	class WelcomePanel extends JPanel {

		private JLabel message;

		public WelcomePanel() {
			message = new JLabel("자바 피자에 오신 것을 환영합니다.");

			this.setBackground(Color.white);

			this.add(message);
		}
	}

	class TypePanel extends JPanel implements ActionListener {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup bg;

		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));

			bg = new ButtonGroup();

			combo = new JRadioButton("콤보", true); // String text, boolean selected
			combo.addActionListener(this);
			potato = new JRadioButton("포테이토");
			potato.addActionListener(this);
			bulgogi = new JRadioButton("불고기");
			bulgogi.addActionListener(this);

			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);

			this.setBorder(BorderFactory.createTitledBorder("종류"));

			this.add(combo);
			this.add(potato);
			this.add(bulgogi);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == combo) {
				typeResuit = 3000;
			} else if (e.getSource() == potato) {
				typeResuit = 4000;
			} else {
				typeResuit = 2000;
			}
			textField.setText(Integer.toString(typeResuit));
		}
	}

	class AddTopping extends JPanel implements ItemListener {
		private JCheckBox pepper, cheese, pepperoni, bacon;

		public AddTopping() {

			this.setLayout(new GridLayout(4, 1));

//			ButtonGroup bg = new ButtonGroup();

			pepper = new JCheckBox("피망");
			pepper.addItemListener(this);
			cheese = new JCheckBox("치즈");
			cheese.addItemListener(this);
			pepperoni = new JCheckBox("페페로니");
			pepperoni.addItemListener(this);
			bacon = new JCheckBox("베이컨");
			bacon.addItemListener(this);

//			bg.add(pepper);
//			bg.add(cheese);
//			bg.add(pepperoni);
//			bg.add(bacon);

//			this.setOpaque(true);

			this.setBorder(BorderFactory.createTitledBorder("추가토핑"));

			this.add(pepper);
			this.add(cheese);
			this.add(pepperoni);
			this.add(bacon);
		}
		
		public void cancelTopping() {
			pepper.setSelected(false);
			cheese.setSelected(false);
			pepperoni.setSelected(false);
			bacon.setSelected(false);
		}

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				toppingResuit += 1000;
			} else {
				toppingResuit -= 1000;
			}
			textField.setText(Integer.toString(toppingResuit));
		}
	}

	class Size extends JPanel implements ActionListener {

		private JRadioButton small, medium, large;
		private ButtonGroup bg;

		public Size() {

			this.setLayout(new GridLayout(3, 1));

			bg = new ButtonGroup();

			small = new JRadioButton("Small");
			small.addActionListener(this);
			medium = new JRadioButton("Medium", true);
			medium.addActionListener(this);
			large = new JRadioButton("large");
			large.addActionListener(this);

			bg.add(small);
			bg.add(medium);
			bg.add(large);

			this.setBorder(BorderFactory.createTitledBorder("크기"));

			this.add(small);
			this.add(medium);
			this.add(large);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == small) {
				sizeResuit = 15000;
			} else if (e.getSource() == medium) {
				sizeResuit = 20000;
			} else {
				sizeResuit = 25000;
			}
			textField.setText(Integer.toString(sizeResuit));
		}
	}
}

public class PizzaTest {

	public static void main(String[] args) {
		MyFrame584 frame = new MyFrame584();

	}

}
