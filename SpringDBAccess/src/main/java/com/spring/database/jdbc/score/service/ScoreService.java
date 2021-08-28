package com.spring.database.jdbc.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.database.jdbc.score.model.ScoreVO;
import com.spring.database.jdbc.score.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	private IScoreDAO dao;

	@Override
	public void insertScore(ScoreVO scores) {
		//scores.setTotal(scores.getKor()+scores.getEng()+scores.getMath());
		scores.calcData();
		dao.insertScore(scores);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		//List<ScoreVO> list = dao.selectAllScores();
		//return list;
		return dao.selectAllScores();
	}

	@Override
	public void deleteScore(int stuNum) {
		//dao.deleteScore(stuNum - 1);
		dao.deleteScore(stuNum);
		
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		//return dao.selectOne(stuNum - 1);
		return dao.selectOne(stuNum);
	}

}
