package com.spring.boardex.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	//1. 게시판 데이터 저장
	void insertBoard(BoardDo bdo);
	
	//2. 전체 게시판 데이터 가져오기 
	ArrayList<BoardDo> getBoardList();
	
	//3. 하나의 게시판 데이터 가져옥 ㅣ
	BoardDo getOneBoard(BoardDo bdo);
	
	//4. 하나의 게시판 데이터 수정하기 
	void updateBoard(BoardDo bdo);
	
	//5. 하나의 게시판 삭제하기 
	void deleteBoard(BoardDo bdo);
	
	
}
