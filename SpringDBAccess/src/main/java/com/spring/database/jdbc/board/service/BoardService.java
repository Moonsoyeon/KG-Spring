package com.spring.database.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.jdbc.board.model.BoardVO;
import com.spring.database.jdbc.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
	//BoardDAO와 주입관계, 의존성 관계가 있기 때문에 dao 주입하는 코드 넣기
	//JDBC Template을 이용한 SQL 처리
	//@Autowirede
	//private IBoardDAO dao;
	
	//MyBatis을 이용한 SQL 처리
	//@Autowired
	private IBoardMapper dao;
	
	//목록 조회 
	//리스트 그대로 컨트롤러에 return
	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles(); 
	}

	//dao쪽이랑 계층연결만 시켜줌
	@Override
	public void insertArticle(BoardVO article) {
		dao.insertArticle(article);

	}

	//컨트롤러는 글번호를 줬지만, dao 쪽에서는 index를 줘야하니까 
	//글번호를 하나 빼서 인덱스로 만들기
	//dao.deleteArticle(boardNo - 1);
	@Override
	public void deleteArticle(int boardNo) {
		int index = boardNo;
		dao.deleteArticle(index);

	}

	//컨트롤러는 글번호를 줬지만, dao 쪽에서는 index를 줘야하니까 
	//글번호를 하나 빼서 인덱스로 만들기
	@Override
	public BoardVO getContent(int boardNo) {
		BoardVO contents = dao.getContent(boardNo);
		return contents;
	}

	//컨트롤러는 글번호를 줬지만, dao 쪽에서는 index를 줘야하니까 
	//글번호를 하나 빼서 인덱스로 만들기
	@Override
	public void modifyArticle(BoardVO article) {
		dao.modifyArticle(article);
	}
	
	public List<BoardVO> getSearchList(String keyword){
		keyword = "%" + keyword + "%";
		return dao.getSearchList(keyword);
	}

}
