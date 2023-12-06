package com.spring.boardex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	//db������ ���� �⺻ ���� 
	static String id="root";
	static String pass="111111";
	static String url="jdbc:mysql://localhost:3307/mvcweb?characterEncoding=utf-8";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public static Connection getConnection() {
		
		try {
			//1.����̹� �ε�
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("mySql ����̹� �ε� �Ϸ�!!");
			
			//2.DB���� 
			return DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				pstmt=null;
			}
		}
		
		if(rs != null) {		
			try {
				if(!rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		
		if(conn != null) {	
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
	}
	
}