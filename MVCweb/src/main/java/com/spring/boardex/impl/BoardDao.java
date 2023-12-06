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
	
	//1.데이터 저장 
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() --> ");
		
		//1.DB에 연결 
		conn=JdbcUtil.getConnection();
		String sql="insert into board values (null,?,?,?)";
		try {
			
			//2.sql문 완성 
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getWriter());
			pstmt.setString(3, bdo.getContent());
			
			//3.sql처리 
			pstmt.executeUpdate();
			
			//4.연결 해제 
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("insertBoard() 처리 완료 ");
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//2.전체 데이터 가져오기 
	public ArrayList<BoardDo> getBoardList(){
		System.out.println("getBoardList() ==> ");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		
		//1. 디비 연결
		conn=JdbcUtil.getConnection();
		String sql="select * from board";
		
		
		try {
			//2. sql문 완성 
			pstmt=conn.prepareStatement(sql);
			
			//3.sql실행 및 결과 받기
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo=new BoardDo();
				bdo.setSeq(rs.getInt(1));
				bdo.setTitle(rs.getString(2));
				bdo.setWriter(rs.getString(3));
				bdo.setContent(rs.getString(4));
				//배열 리스트에 읽어온 데이터 저장하기 
				bList.add(bdo);
			}
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getBoardList() 처리 완료!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bList;
	}
	
	//3.seq=?인 하나의 데이터 가져오기 
	public BoardDo getOneBoard(BoardDo bdo) {
		System.out.println("getOneBoard() --> ");
		//리턴 타입 
		BoardDo board=new BoardDo();
		
		//1.디비 연결
		conn=JdbcUtil.getConnection();
		
		//2.sql문 완성(??처리 주된 내용)
		String sql="select * from board where seq=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3.sql문 실행 
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneBoard 처리 완료!!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}
	
	//4.seq=?인 데이터를 수정하기 
	public void updateBoard(BoardDo bdo) {
		
		//
		System.out.println("updateBoard()--> ");
		
		//1.DB 연결 
		conn=JdbcUtil.getConnection();
		String sql="update board set title=?, content=? where seq=?";
		
		//2.sql문 완성 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getContent());
			pstmt.setInt(3, bdo.getSeq());
			
			//3.sql문 실행 
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateBoard 처리 완료 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//5.seq=?인 데이터를 삭제하기 
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. 디비 연결 
		conn=JdbcUtil.getConnection();
		
		//2. sql 문 완성 
		String sql="delete from board where seq=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql문 실행 
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard 처리 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
