package com.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.web.model.BoardVO;
import com.spring.web.model.ScoreVO;
import com.spring.web.service.IBoardService;

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
	//상세조회 할 때 boardVO에 글번호가 없기때문에 content.jsp쪽에서 boardNo를 사용하기위해 
	//ModelAttribute 사용
	//서비스에게 글번호를 보내주면서 해당게시글 정보 덩어리를 article이라는 이름으로 받아와서
	//content.jsp에게 모델에 담아서 보냄
	@GetMapping("/content")
	public void content(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/content?boardNo="+boardNo+" : GET ");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글 수정하기 화면 요청
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		System.out.println("/board/modify?boardNo="+boardNo+" : GET ");
		model.addAttribute("article", service.getContent(boardNo));
	}
	
	//글 수정 처리요청
	@PostMapping("/modify")
	public String modify(BoardVO article, int boardNo) {
		System.out.println("/board/modify?boardNo="+boardNo+" : POST");
		//modifyArticle에 article, boardNo 전달
		service.modifyArticle(article, boardNo);
		return "redirect:/board/content?boardNo="+boardNo;
		
	}	
}
