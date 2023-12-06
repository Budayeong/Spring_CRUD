package com.spring.springmvc.ano.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class GetBoardListController {
//	<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value = "/getBoardList.do")
	public ModelAndView getBoardList(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("GetBoardListController(Ano)-->");
		
		ArrayList<BoardDo> bList = bdao.getBoardList();
		mav.addObject("bList", bList);
		mav.setViewName("getBoardListView");
		
		return mav;
		
	}
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("GetBoardListController --> ");
//		
//		//1. 디비로부터 전체 데이터 가져오기 
//		BoardDo bdo=new BoardDo();
//		BoardDao bdao=new BoardDao();
//		ArrayList<BoardDo> bList=bdao.getBoardList();
//		
//		for(BoardDo board: bList) {
//			System.out.println("--> "+board.toString());
//		}
//		
//		//2. 뷰어를 호출하면서, 데이터 넘기기
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("bList",bList);
//		mav.setViewName("getBoardListView"); //뷰어 쪽으로 데이터 넘기며 처리가 가능하다. 
//		
//		return mav;
//	}
	
	
}
