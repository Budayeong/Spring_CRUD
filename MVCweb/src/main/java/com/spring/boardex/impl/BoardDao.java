package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDao")
public class BoardDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	//�Խ��� ���� �޼���
	//1.�Խ��� ������ ���� 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() --> ");
		
		//1.DB�� ���� 
		conn=JdbcUtil.getConnection();
		String sql="insert into board values (null,?,?,?,?,?,?,?)";
		try {
			
			//2.sql�� �ϼ� 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getWriter());
			pstmt.setString(3, bdo.getContent());
			pstmt.setString(4, bdo.getTime());
			pstmt.setString(5, bdo.getEndtime());
			pstmt.setString(6, bdo.getWebname());
			pstmt.setString(7, bdo.getWebsite());
			
			
			//3.sqló�� 
			pstmt.executeUpdate();
			
			//4.���� ���� 
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("insertBoard() ó�� �Ϸ� ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//2.��ü ������ �������� 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//1. ��� ����
		conn=JdbcUtil.getConnection();
		String sql="select * from board";
		
		
		try {
			//2. sql�� �ϼ� 
			pstmt=conn.prepareStatement(sql);
			
			//3.sql���� �� ��� �ޱ�
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo=new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setTitle(rs.getString(2));
				bdo.setWriter(rs.getString(3));
				bdo.setContent(rs.getString(4));
				bdo.setTime(rs.getString(5));
				bdo.setEndtime(rs.getString(6));
				bdo.setWebname(rs.getString(7));
				bdo.setWebsite(rs.getString(8));
				//�迭 ����Ʈ�� �о�� ������ �����ϱ� 
				bList.add(bdo);
			}
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getBoardList() ó�� �Ϸ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bList;
	}
	
	//3.seq=?�� �ϳ��� ������ �������� 
	public BoardDo getOneBoard(BoardDo bdo) {
		System.out.println("getOneBoard() --> ");
		//���� Ÿ�� 
		BoardDo board=new BoardDo();
		
		//1.��� ����
		conn=JdbcUtil.getConnection();
		
		//2.sql�� �ϼ�(??ó�� �ֵ� ����)
		String sql="select * from board where seq=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3.sql�� ���� 
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setTime(rs.getString(5));
				board.setEndtime(rs.getString(6));
				board.setWebname(rs.getString(7));
				board.setWebsite(rs.getString(8));
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneBoard ó�� �Ϸ�!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	//4.seq=?�� �����͸� �����ϱ� 
	public void updateBoard(BoardDo bdo) {
		
		//
		System.out.println("updateBoard()--> ");
		
		//1.DB ���� 
		conn=JdbcUtil.getConnection();
		String sql="update board set title=?, content=?, time=?, endtime=?, webname=?, website=? where seq=?";
		
		//2.sql�� �ϼ� 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getContent());
			pstmt.setString(3, bdo.getTime());
			pstmt.setString(4, bdo.getEndtime());
			pstmt.setString(5, bdo.getWebname());
			pstmt.setString(6, bdo.getWebsite());
			pstmt.setInt(7, bdo.getSeq());
			
			//3.sql�� ���� 
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateBoard ó�� �Ϸ� !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//5.seq=?�� �����͸� �����ϱ� 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. ��� ���� 
		conn=JdbcUtil.getConnection();
		
		//2. sql �� �ϼ� 
		String sql="delete from board where seq=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql�� ���� 
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard ó�� �Ϸ�");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//6.�˻��� �Խñ� ��������
	public ArrayList<BoardDo> searchBoardList(BoardDo bdo) {
		System.out.println("searchBoardList() --> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();

		//1.��� ����
		conn=JdbcUtil.getConnection();
		
		//2.sql�� �ϼ�(??ó�� �ֵ� ����)
		
		//�˻������� �����Ҷ� 
		if (bdo.getType() != null && !bdo.getType().isEmpty() && bdo.getKeyword() != null && !bdo.getKeyword().isEmpty()) {
			String sql = "SELECT * FROM board WHERE " + bdo.getType() + " LIKE '%" + bdo.getKeyword() + "%'";
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				System.out.println(sql);
				
				
				//3.sql���� �� ��� �ޱ�
				rs=pstmt.executeQuery();
				while(rs.next()) {
					BoardDo bdo2=new BoardDo();
					bdo2.setSeq(rs.getInt(1));
					bdo2.setTitle(rs.getString(2));
					bdo2.setWriter(rs.getString(3));
					bdo2.setContent(rs.getString(4));
					bdo2.setTime(rs.getString(5));
					bdo2.setEndtime(rs.getString(6));
					bdo2.setWebname(rs.getString(7));
					bdo2.setWebsite(rs.getString(8));
					
					//�迭 ����Ʈ�� �о�� ������ �����ϱ� 
					bList.add(bdo2);
				}
				
				JdbcUtil.close(rs, pstmt, conn);
				System.out.println("searchBoardList() ó�� �Ϸ�!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bList;
	
	}

	//7.���ĵ� ������ �������� 
	public ArrayList<BoardDo> sortBoardList(BoardDo bdo){
		System.out.println("sortBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//1. ��� ����
		conn=JdbcUtil.getConnection();
		String sql="SELECT * FROM board";
		System.out.println(bdo.getSort());
		
		try {
			 // 2. sql�� �ϼ�
	        if ("��û����".equals(bdo.getSort())) {
	            sql += " WHERE endtime >= CURDATE() ORDER BY endtime ASC";
	            System.out.println(sql);
	        } else if ("����Ʈ".equals(bdo.getSort())) {
	            sql += " ORDER BY webname ASC";
	            System.out.println(sql);
	        }

	        pstmt = conn.prepareStatement(sql);
			
			//3.sql���� �� ��� �ޱ�
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo2=new BoardDo();
				bdo2.setSeq(rs.getInt(1));
				bdo2.setTitle(rs.getString(2));
				bdo2.setWriter(rs.getString(3));
				bdo2.setContent(rs.getString(4));
				bdo2.setTime(rs.getString(5));
				bdo2.setEndtime(rs.getString(6));
				bdo2.setWebname(rs.getString(7));
				bdo2.setWebsite(rs.getString(8));
				//�迭 ����Ʈ�� �о�� ������ �����ϱ� 
				bList.add(bdo2);
			}
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getBoardList() ó�� �Ϸ�!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bList;
	}

	
	
	//ȸ�� ���� �޼���
	//1.ȸ������ ������ ���� 
	public void memberJoinBoard(BoardDo bdo) {
		System.out.println("insertBoard() --> ");
		
		//1.DB�� ���� 
		conn=JdbcUtil.getConnection();
		String sql="insert into member values (?,?,?)";
		try {
			
			//2.sql�� �ϼ� 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getId());
			pstmt.setString(2, bdo.getName());
			pstmt.setString(3, bdo.getPassword());
			
			//3.sqló�� 
			pstmt.executeUpdate();
			
			//4.���� ���� 
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("memberJoinBoard() ó�� �Ϸ� ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//2.�α��� ������ ��
	public boolean userCheck(String id, String password) {
	   Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;

       try {
           //DB ���� ����
            conn = JdbcUtil.getConnection();

			String sql="SELECT * FROM member WHERE id = ? AND password = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, password);
	        
	        rs = pstmt.executeQuery();
	
	        return rs.next(); // ����� ������ true, ������ false ��ȯ
	        
		   } catch (SQLException e) {
	           e.printStackTrace();
	           return false;
		   } finally {
	           // ���ҽ� ����
	           JdbcUtil.close(rs, pstmt, conn);
	}
}

	




}
