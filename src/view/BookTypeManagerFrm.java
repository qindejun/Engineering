package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.BookDao;
import dao.BookTypeDao;
import model.BookType;
import util.Dbutil;
import util.StringUtil;

public class BookTypeManagerFrm extends JInternalFrame {
	private JTable BookTypeTable;
	private Dbutil dbUtil = new Dbutil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private JTextField s_bookTypeNameText;
	private JTextField idText;
	private JTextField bookTypeNameText;
	private JTextArea bookTypeDescText;
	private BookDao bookDao = new BookDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerFrm frame = new BookTypeManagerFrm();
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
	public BookTypeManagerFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 670, 626);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel = new JLabel("图书类别名称：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));

		s_bookTypeNameText = new JTextField();
		s_bookTypeNameText.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeManagerFrm.class.getResource("/images/查询 .png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "\u6570\u636E\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(86)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 473,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 472,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(s_bookTypeNameText, GroupLayout.PREFERRED_SIZE, 194,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
												.addComponent(btnNewButton).addContainerGap(105, Short.MAX_VALUE))))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(s_bookTypeNameText, GroupLayout.PREFERRED_SIZE, 29,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(38)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panel, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(57, Short.MAX_VALUE)));

		JLabel lblNewLabel_1 = new JLabel("编号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("图书类别名称：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		bookTypeNameText = new JTextField();
		bookTypeNameText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("描述：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		bookTypeDescText = new JTextArea();

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeManagerFrm.class.getResource("/images/修改、修改资料.png")));

		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setIcon(new ImageIcon(BookTypeManagerFrm.class.getResource("/images/删除.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addGap(33).addComponent(lblNewLabel_2).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(bookTypeNameText, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_3)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(bookTypeDescText, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)))
				.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addGap(125).addComponent(btnNewButton_1)
						.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE).addComponent(btnNewButton_2)
						.addGap(96)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(idText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeNameText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
						.addComponent(bookTypeDescText, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
				.addContainerGap(30, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		bookTypeDescText.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1, false));

		BookTypeTable = new JTable();
		BookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BookTypeTableMousePressed(e);
			}
		});
		BookTypeTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u7F16\u53F7",
				"\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(86);
		BookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		scrollPane.setViewportView(BookTypeTable);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new BookType());

	}

	/*
	 * 图书类别删除事件处理
	 */
	private void bookTypeDeleteActionEvent(ActionEvent evt) {
		String id = idText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的数据！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "是否要删除该条数据？");
	    if(n==0) {
	    	Connection con = null;
	    	try {
				con = dbUtil.getCon();
				boolean flag = bookDao.existBookByBookTypeId(con, id);
				if(flag) {
					JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此类别！");
					return;
				}
				int deleteNum = bookTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					resetValue();
					this.fillTable(new BookType());
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
	    }
	}

	protected void bookTypeUpdateActionEvent(ActionEvent evt) {
		String id = idText.getText();
		String bookTypeName = bookTypeNameText.getText();
		String bookTypeDesc = bookTypeDescText.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的数据！");
			return;
		}
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int count = bookTypeDao.update(con, bookType);
			if(count ==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new BookType());
				
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}

	/*
	 * 表格行点击事件处理
	 */
	private void BookTypeTableMousePressed(MouseEvent evt) {
		int row = BookTypeTable.getSelectedRow();
		idText.setText((String) BookTypeTable.getValueAt(row, 0));
		bookTypeNameText.setText((String)BookTypeTable.getValueAt(row, 1));
		bookTypeDescText.setText((String)BookTypeTable.getValueAt(row, 2));
	}

	/*
	 * 图片类别事件搜索处理
	 */
	private void bookTypeSearchActionPerformed(ActionEvent e) {
		String s_bookTypeName = this.s_bookTypeNameText.getText();
		BookType bookType = new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	private void fillTable(BookType bookType) {
		DefaultTableModel dtm = (DefaultTableModel) BookTypeTable.getModel();
		dtm.setRowCount(0);// 设置成0行
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, bookType);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void resetValue() {
		this.idText.setText("");
		this.bookTypeNameText.setText("");
		this.bookTypeDescText.setText("");
	}
}
