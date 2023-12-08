package com.spring.springmvc.ano.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class loginProcBoardController implements Controller{
	
	// BoardDao를 생성자나 세터 메서드를 통해 주입
    public loginProcBoardController(BoardDao boardDao) {
    }
    
    public loginProcBoardController() {}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("loginProcBoardController -->");
		
		 // 1. 로그인 데이터 가져오기 (request)
        String id = request.getParameter("id");
        String password = request.getParameter("password");


        BoardDao boardDao = new BoardDao();
        // 2. DB와 데이터 비교
        boolean userCheck = boardDao.userCheck(id, password);

        // 3. 결과에 따라 페이지 이동
        if (userCheck) {
            // 사용자가 유효하면 
            ModelAndView mav = new ModelAndView("loginConfirm"); 
            return mav;
        } else {
            // 사용자가 유효하지 않으면 
            ModelAndView mav = new ModelAndView("memberJoin"); 
            return mav;
        }
    }



}