package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*DataBaseInfo dbInfo = new DataBaseInfo();
		dbInfo.setUid("spring1");
		dbInfo.setUpw("sss111"); 
		dbInfo.setUrl("jdbc:mysql://localhost:3306/spring");*/
		
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:db-config.xml");
		
		DataBaseInfo db1 = ct.getBean("db1", DataBaseInfo.class);
		System.out.println("URL : " + db1.getUrl());
		System.out.println("UID : " + db1.getUid());
		System.out.println("UPW : " + db1.getUpw());
		
		System.out.println("=================");
		
		DataBaseInfo db2 = ct.getBean("db2", DataBaseInfo.class);
		System.out.println("URL : " + db1.getUrl());
		System.out.println("UID : " + db1.getUid());
		System.out.println("UPW : " + db1.getUpw());

		System.out.println("=================");
		
		/*MemberDAO dao = new MemberDAO();
		dao.setDbInfo(db1); //생략시 작동 불가능
		dao.showDBInfo();*/
		
		MemberDAO dao = ct.getBean("dao", MemberDAO.class);
		dao.showDBInfo();

	}

}
