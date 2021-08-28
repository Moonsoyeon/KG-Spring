package com.spring.database.jdbc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	//service와 의존관계
	@Autowired
	private IBoardService service;
	
	//게시글 작성 화면 열어주는 처리를 하는 요청 메서드
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write: GET");
	}
	
	//게시글 작성을 처리하는 요청 메서드
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/insert: POST");
		service.insertArticle(article);
		return "redirect:/board/list";
	}

	//글 목록 화면 요청
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list: GET");
		//articles라는 이름으로 service를 통해 글목록을 받아옴
		//list.jsp에서는 articles라는 이름으로 데이터를 뽑아올 수 있음
		model.addAttribute("articles", service.getArticles());
	}
	
	//글 삭제 요청
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete?boardNo="+boardNo+" : GET");
		service.deleteArticle(boardNo);
		return "redirect:/board/list";
	}
	
	//글 내용보기 요청
	//ModelAttribute 사용 안해도됨
	@GetMapping("/content")
	public void content(int boardNo, Model model) {
		System.out.println("/board/content?boardNo="+boardNo+" : GET ");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글 수정하기 화면 요청
	//ModelAttribute 사용 안해도됨
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+" : GET ");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글 수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article) {
		System.out.println("/board/modify?boardNo="+ article.getBoardNo()+" : POST");
		//modifyArticle에 article, boardNo 전달
		service.modifyArticle(article);
		return "redirect:/board/content?boardNo="+ article.getBoardNo();
	}	
	
	@GetMapping("/searchList")
	public String searchList(String keyword, Model model) {
		List<BoardVO> list = service.getSearchList(keyword);
		model.addAttribute("articles", list);
		return "board/list";
	}
}
