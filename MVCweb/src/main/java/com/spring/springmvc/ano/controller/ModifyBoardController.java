package com.spring.springmvc.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class ModifyBoardController{
	
//	<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value = "/modifyBoard.do")
	public ModelAndView modifyBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyBoardController(Ano)-->");

		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("modifyBoardView");
		
		
		
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("ModifyBoardController -->");
//		
//		//1. seq 값 가져오기
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		//2. 디비로부터 seq에 해당되는 데이터 가져오기
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getOneBoard(bdo);
//		
//		//3. mav를 이용하여 뷰어에 데이터 전달
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("modifyBoardView");
//		
//		return mav;
//	}

}
