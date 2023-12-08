package com.spring.springmvc.ano.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

@Controller //String으로 반환 타입 통일
public class ProjectController{
	
	//insertBoard
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard() {
		
		return "insertBoardView";
	}
	
	//insertBoardProc
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
	
	//getBoard
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("GetBoardController(Ano)-->");
		
		BoardDo board = bdao.getOneBoard(bdo);
		model.addAttribute("board", board);
//		mav.addObject("board", board);
//		mav.setViewName("getBoardView");
		
		
		return "getBoardView";
	}
	
	//getBoardList
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("GetBoardListController(Ano)-->");
		
		ArrayList<BoardDo> bList = bdao.getBoardList();
//		mav.addObject("bList", bList);
//		mav.setViewName("getBoardListView");
		model.addAttribute("bList",bList);
		
		return "getBoardListView";
		
	}
	
	//modifyBoard
	@RequestMapping(value = "/modifyBoard.do")
	public String modifyBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("ModifyBoardController(Ano)-->");
		
		BoardDo board = bdao.getOneBoard(bdo);
//		mav.addObject("board", board);
//		mav.setViewName("modifyBoardView");
		model.addAttribute("board", board);
		
		
		
		return "modifyBoardView";
	}
	
	//modifyBoardProc
	@RequestMapping(value = "/modifyProcBoard.do")
	public String modifyBoardProc(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("ModifyBoardProcController(Ano)-->");
		
		bdao.updateBoard(bdo);
//		mav.setViewName("redirect:getBoardList.do");


		
		return "redirect:getBoardList.do";
	}
	
	//deleteBoard
	@RequestMapping(value ="/deleteBoard.do" )
	public String deleteBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("DeleteBoardController(Ano)-->");
		
		bdao.deleteBoard(bdo);
//		mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}

	//memberJoin
	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {
		
		return "memberJoinView";
	}
	
	//login
	@RequestMapping(value = "/login.do")
	public String login() {
		
		return "loginView";
	}
	
	//memberJoinProc
	@RequestMapping(value = "/memberJoinBoardProc.do")
	public String memberJoinBoardProc(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("memberJoinBoardProcController -->");
	
		bdao.memberJoinBoard(bdo);

		return "redirect:getBoardList.do";
	}

	//loginProc
	@RequestMapping(value = "/loginProcBoard.do")
	public String loginProc(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("loginProcBoardController -->");
		
        boolean userCheck = bdao.userCheck(bdo.getId(), bdo.getPassword());

        // 3. 결과에 따라 페이지 이동
        if (userCheck) {
            // 사용자가 유효하면 
        	return "redirect:getBoardList.do";
        } else {
            // 사용자가 유효하지 않으면 
        	return "redirect:memberJoin.do";
        }
    }
}
