package com.spring.springmvc.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class DeleteBoardController{
	
	//<prop key="/deleteBoard.do"> deleteBoard </prop>
	@RequestMapping(value ="/deleteBoard.do" )
	public ModelAndView deleteBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("DeleteBoardController(Ano)-->");
		
		bdao.deleteBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		return mav;
	}
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("DeleteBoardController");
//		
//		//1. seq 가져오기
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		//2. seq 이용하여 디비에서 데이터 삭제하기
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.deleteBoard(bdo);
//		
//		//3. getBoardList.do 요청하여 삭제 확인
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		
//		return mav;
//	}

}
