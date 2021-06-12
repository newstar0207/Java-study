package BookListViewer;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookListViewer extends JFrame implements ActionListener {

	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previouseBtn, nextBtn, insertBtn, finishBtn;
	private ResultSet rs;
	private Connection con;

	public BookListViewer() throws Exception {
		// DB���� å ���ڵ���� ������.
		// 1. JDBC ����̹� ����
		// 2. DB ����
		// 3. PreparedStatement ��ü ����
		// 4. SQL �� ����

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "newstar0207");
		String sql = "select * from books order by book_id desc";
		PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); // ������ ���� �غ� ( �����˻�, ���缺�˻�, excustion plane)

		// select ���� ������ ��� executeQuery() �޼��� ��� / keyset ��ȯ
		// insert, update, delete �� ��� executeUpdate() ���

		rs = pstmt.executeQuery(); // ���� ��û

		// ������Ʈ���� ����
		// ������ ������Ʈ���� JFrame ��ü(this) �� �߰���(add)
		this.setLayout(new GridLayout(0, 2)); // 0�� ���� ���� �������

		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField();
		this.add(idField);

		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField();
		this.add(titleField);

		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField();
		this.add(publisherField);

		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField();
		this.add(yearField);

		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField();
		this.add(priceField);

		// ��ư ������Ʈ ���� �׼Ǹ����ʸ� ����
		nextBtn = new JButton("Next");
		this.add(nextBtn);
		nextBtn.addActionListener(this);

		previouseBtn = new JButton("Previouse");
		this.add(previouseBtn);
		previouseBtn.addActionListener(this);

		insertBtn = new JButton("����");
		this.add(insertBtn);
		insertBtn.addActionListener(this);

		finishBtn = new JButton("����");
		this.add(finishBtn);
		finishBtn.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setSize(350, 200);
		this.setVisible(true);

	}
	private void setCurrentBookInfoToTextField() throws Exception {
		// book_id ,title, publisher,year, price
		int book_id = rs.getInt(1);
		String title = rs.getString(2);
		String publisher = rs.getString(3);
		Date year = rs.getDate(4);
		int price = rs.getInt(5);
		
		idField.setText(String.valueOf(book_id));
		titleField.setText(String.valueOf(title));
		publisherField.setText(String.valueOf(publisher));
		yearField.setText(year.toString());
		priceField.setText(String.valueOf(price));
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == previouseBtn) {
				// ��������� Ŀ��(������) �������� �̵�
				// �� Ŀ���� ����Ű�� ��� ���ڵ��� Į������ �̾� �ͼ� JTextField �� setText ��.
				rs.previous();
				setCurrentBookInfoToTextField();

			} else if (e.getSource() == nextBtn) {
				// ��������� Ŀ��(������) �������� �̵�
				// �� Ŀ���� ����Ű�� ��� ���ڵ��� Į������ �̾� �ͼ� JTextField �� setText ��.
				rs.next();
				setCurrentBookInfoToTextField();

			} else if (e.getSource() == insertBtn) {

			} else if (e.getSource() == finishBtn) {
				con.close();
				System.out.println("���α׷� ����");
				System.exit(0); // ���α׷��� ������
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// BookListViewer Ŭ������ �ν��Ͻ� ����.
		try {
			new BookListViewer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
