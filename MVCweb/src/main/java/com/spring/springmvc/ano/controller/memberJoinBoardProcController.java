package com.spring.springmvc.ano.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class memberJoinBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("memberJoinBoardProcController -->");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		
		
		//2. 디비에 저장
		BoardDo bdo = new BoardDo();
		bdo.setId(id);
		bdo.setName(name);
		bdo.setPassword(password);
		bdo.setNumber(number);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		//3. 뷰어 이용하여 추가된 데이터 확인 !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.do");
		
		return mav;
	}

}
