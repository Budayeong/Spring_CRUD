package com.spring.springmvc.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller ->주석처리하면 아예 이 메서드로 안들어감
public class InsertBoardController{
	
//	<prop key="/insertBoard.do"> insertBoard </prop>
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard() {
		
		return "insertBoardView";
	}
	

// implemants controller 했을 때 사용했던 코드들 (xml 기반일때)
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardController --> ");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("insertBoardView");
//		
//		
//		return mav;
//	}

}
