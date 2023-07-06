package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookType;
import util.StringUtil;

public class BookTypeDao {
	public int add(Connection con,BookType bookType) throws Exception{
		String sql = "insert into bookType values(null,?,?)";
		String sql2 = "ALTER TABLE booktype AUTO_INCREMENT = 0;";
		PreparedStatement pstmt = con.prepareStatement(sql); 
		PreparedStatement pstmt2 = con.prepareStatement(sql2); 
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		int count2 = pstmt2.executeUpdate();
		int count = pstmt.executeUpdate();
		return count;
	}

	public ResultSet list(Connection con,BookType bookType)throws Exception{
		StringBuffer sb = new StringBuffer("select * from booktype ");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%" +bookType.getBookTypeName()+"%' ");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/*
	 * 删除图书类别
	 */
	public int delete(Connection con,String id)throws Exception {
		String sql = "delete from booktype where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/*
	 * 修改图书类别
	 */
	public int update(Connection con,BookType bookType)throws Exception{
		String sql = "update booktype set bookTypeName = ?,bookTypeDesc = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
	
	
}

