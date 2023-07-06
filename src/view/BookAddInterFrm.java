package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import dao.BookDao;
import dao.BookTypeDao;
import model.Book;
import model.BookType;
import util.Dbutil;
import util.StringUtil;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameText;
	private JTextField authorText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceText;
	private Dbutil dbUtil = new Dbutil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JComboBox bookTypeJcb;
	private JTextArea bookDescText;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书添加");
		setBounds(100, 100, 600, 600);
		
		JLabel lblNewLabel = new JLabel("图书名称：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		bookNameText = new JTextField();
		bookNameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("图书作者：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		authorText = new JTextField();
		authorText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("作者性别：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_3 = new JLabel("图书价格：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		priceText = new JTextField();
		priceText.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("图书描述：");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		bookDescText = new JTextArea();
		
		JLabel lblNewLabel_5 = new JLabel("图书类别：");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		bookTypeJcb = new JComboBox();
		bookTypeJcb.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/添加 (1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e); 
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/重置.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(bookTypeJcb, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
												.addComponent(manJrb)
												.addGap(18)
												.addComponent(femaleJrb))))
									.addGap(76)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(authorText, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(priceText, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton)
											.addGap(166)
											.addComponent(btnNewButton_1))
										.addComponent(bookDescText, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))))
							.addGap(149))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookNameText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(authorText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(lblNewLabel_3)
						.addComponent(priceText, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(bookTypeJcb, 0, 0, Short.MAX_VALUE)
						.addComponent(lblNewLabel_5))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(bookDescText, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(54))
		);
		bookDescText.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	
	/*
	 * 重置事件处理
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/*
	 * 图书添加事件处理
	 */
	private void bookAddActionPerformed(ActionEvent evt) {
		String bookName = this.bookNameText.getText();
		String author = this.authorText.getText();
		String price = this.priceText.getText();
		String bookDesc = this.bookDescText.getText();

		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}

		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		
		String sex = "";
		if(manJrb.isSelected()) {
			sex="男";
		}else if(femaleJrb.isSelected()) {
			sex="女";
		}
		
		BookType bookType = (BookType)bookTypeJcb.getSelectedItem();
		int BookTypeId = bookType.getId();
		Book book = new Book(bookName, author,sex,Float.parseFloat(price),BookTypeId,bookDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.Add(con,book);
			if(addNum ==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				resetValue();
				
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
		}
	}

	private void fillBookType() {
		Connection con = null;
		BookType bookType = new BookType();
		try {
			con=dbUtil.getCon();
			ResultSet rs =bookTypeDao .list(con, new BookType());
			while(rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setBookTypeDesc(rs.getString("bookTypedesc"));
				this.bookTypeJcb.addItem(bookType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
	}
	
	private void resetValue() {
		this.bookNameText.setText("");
		this.authorText.setText("");
		this.priceText.setText("");
		this.manJrb.setSelected(true);;
		this.bookDescText.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
		
	}
	
}
