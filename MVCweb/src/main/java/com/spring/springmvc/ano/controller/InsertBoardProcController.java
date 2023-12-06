package com.spring.springmvc.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class InsertBoardProcController{

	//<prop key="/insertProcBoard.do"> insertBoardProc </prop>
	@RequestMapping(value ="/insertProcBoard.do")
	public String insertBoardProc(BoardDo bdo) {
		System.out.println("InsertBoardProcController(Ano)-->");
		
		//데이터 확인
		System.out.println("title:" + bdo.getTitle());
		System.out.println("writer:" + bdo.getWriter());
		System.out.println("content:" + bdo.getContent());

		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		return "redirect:getBoardList.do";
	}
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardProcController -->");
//		
//		//1. 추가될 데이터 가져오기 (request)
//		String writer = request.getParameter("writer");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		//2. 디비에 저장
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle(title);
//		bdo.setWriter(writer);
//		bdo.setContent(content);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.insertBoard(bdo);
//		
//		//3. 뷰어 이용하여 추가된 데이터 확인 !!
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}
