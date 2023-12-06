package com.spring.springmvc.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class ModifyBoardProcController{
	//<prop key="/modifyProcBoard.do"> modifyBoardProc </prop>
	@RequestMapping(value = "/modifyProcBoard.do")
	public ModelAndView modifyBoardProc(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyBoardProcController(Ano)-->");
		
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		
		
		return mav;
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("ModifyBoardProcController -->");
//		
//		//1. 수정된 데이터를 가져와 보기
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		System.out.println("seq :"+seq+
//							"title :"+title+
//							"content :"+content);
//		
//		
//		//2. 수정된 데이터 디비에 저장
//		BoardDo bdo  = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setTitle(title);
//		bdo.setContent(content);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		//3. 뷰어 호출
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		return mav;
//	}

}
