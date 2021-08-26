package com.spring.database.jdbc.score.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.database.jdbc.score.model.ScoreVO;

@Repository("sDao1")
//@Scope("protype") //생략하면 싱글톤 타입
public class ScoreDAO implements IScoreDAO {

	//# 전통적 방식의 JDBC
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";
	private String uid = "root";
	private String upw = "3713";
	
	/*
	@Override
	public void insertScore(ScoreVO scores) {
		System.out.println("Repository param: " + scores); 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO scores" + "(stu_name, kor, eng, math, total, average)" + "VALUES (?,?,?,?,?,?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, scores.getStuName());
			pstmt.setInt(2, scores.getKor());
			pstmt.setInt(3, scores.getEng());
			pstmt.setInt(4, scores.getMath());
			pstmt.setInt(5, scores.getTotal());
			pstmt.setDouble(6, scores.getAverage());
			
			pstmt.executeUpdate();
			System.out.println("점수 등록 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	*/
	
	//# Spring-JDBC 방식의 처리 : JdbcTemplate 사용!
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertScore(ScoreVO scores) {
		String sql = "INSERT INTO scores" + "(stu_name, kor, eng, math, total, average)" + "VALUES (?,?,?,?,?,?)";
		template.update(sql, scores.getStuName(), scores.getKor(), scores.getEng(), scores.getMath(), scores.getTotal(), scores.getAverage());
	}
	

	@Override
	public List<ScoreVO> selectAllScores() {
		return null;
	}

	@Override
	public void deleteScore(int stuNum) {

	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return null;
	}

}
