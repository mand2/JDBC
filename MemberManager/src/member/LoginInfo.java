package member;

import java.util.Date;

public class LoginInfo {
	private String id;
	private String name;
	private String photo;
	private Date regDate;
	
	public LoginInfo(String id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.regDate = new Date();
	}
	
	public LoginInfo(String id, String name, String photo, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.regDate = regDate;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getPhoto() {
		return photo;
	}


	public Date getRegDate() {
		return regDate;
	}


	@Override
	public String toString() {
		String info ="";
		info += "<div class = \"main\"> <form><h1>회원 정보</h1><hr>";
		info += "<span class=\"inputBox\">아 이 디</span>" + id + "<br>";
		info += "<span class=\"inputBox\">이    름</span>" + name + "<br>";
		info += "<span class=\"inputBox\">사    진</span>" + photo + "<br>";
		info += "<span class=\"inputBox\">가 입 일</span>" + regDate + "<br>";
		info += "</form></div> \n";
		
		
		return info;
	}


	
	
	
}
