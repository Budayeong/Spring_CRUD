package com.spring.springmvc.ano.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;


//@Controller
public class GetBoardController{
	
	//<prop key="/getBoard.do"> getBoard </prop>
	@RequestMapping(value = "/getBoard.do")
	public ModelAndView getBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("GetBoardController(Ano)-->");
		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("getBoardView");
		
		
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("GetBoardController-->");
//		
//		//1. seq 변수 이름으로 전달되는 데이터를 받기
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		//2. 디비로부터 데이터 가져오기 (Boarddo, BoardDao)
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getOneBoard(bdo);
//		
//		//3. 뷰어 호출하면서, board 데이터 전달
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("getBoardView");
//		
//		return mav;
//	}

}
