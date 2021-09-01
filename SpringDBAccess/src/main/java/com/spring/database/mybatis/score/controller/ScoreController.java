package com.spring.database.mybatis.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.database.mybatis.score.model.ScoreVO;
import com.spring.database.mybatis.score.service.IScoreService;

@Controller("scoreController2")
@RequestMapping("/mybatis/score")
public class ScoreController {

	@Autowired
	@Qualifier("scoreService2")
	private IScoreService service;

	//점수 등록 화면을 열어주는 처리를 하는 요청 메서드
	@GetMapping("/register") 
	public String register() {
		System.out.println("/score/register: GET");
		return "score2/write-form";
	}

	//점수 등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
		System.out.println("/score/register: POST");
		System.out.println("Controller param: " + scores);
		service.insertScore(scores);
		return "score2/write-result";
	}

	//점수 전체 조회를 처리하는 요청 메서드
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/score/list: GET");
		//List<ScoreVO> list = service.selectAllScores();
		//model.addAttribute("sList", list);
		model.addAttribute("sList", service.selectAllScores());
		
		return "score2/list";
	}

	//점수 삭제 요청 처리 메서드
	@GetMapping("/delete")
	public String delete(int stuId, RedirectAttributes ra) {
		System.out.println("삭제할 학번: " + stuId);
		service.deleteScore(stuId);
		ra.addFlashAttribute("message", "delSuccess");
		return "redirect:/mybatis/score/list";
	}
	
	//점수 개별 조회 화면 열람요청 메서드
	@GetMapping("/search")
	public String search() {
		System.out.println("/score/search: GET");
		
		return "score2/search";
	}
	
	//점수 개별 조회 처리 요청 메서드
	@GetMapping("/selectOne") 
	public String selectOne(String stuNum, Model model,
							RedirectAttributes ra) {
		System.out.println("/score/selectOne: GET");
		
		List<ScoreVO> list = service.selectAllScores();
		
		try {
			int n = Integer.parseInt(stuNum);
			
			if(n > list.size()) {
				ra.addFlashAttribute("msg", "학번정보가 없습니다.");
				return "redirect:/mybatis/score/search";
			} else {
				model.addAttribute("stu", service.selectOne(n));
				return "score2/search-result";
			}
		} catch(NumberFormatException e) {
			ra.addFlashAttribute("msg", "숫자로만 입력하세요!");
			return "redirect:/mybatis/score/search";
		}
		
	}

}










