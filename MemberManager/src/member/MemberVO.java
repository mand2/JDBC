package member;

import java.util.Date;

public class MemberVO {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String photo;
	private Date regDate;
	
	public MemberVO() {
		this.regDate = new Date();
	}

	public MemberVO(String id, String pw, String name, String photo) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.photo = photo;
		this.regDate = new Date();		
	}
//
//	public MemberVO(String id) {
//		this.name = "김석진";
//		this.id = id;
//		this.photo = "noImg.png";
//		this.regDate = new Date();
//	}
//	
	
	@Override
	public String toString() {
		String info ="";
		info += "<span class=\"inputBox\">회원번호</span>" + idx + "\n";
		info += "<span class=\"inputBox\">아 이 디</span>" + id + "\n";
		info += "<span class=\"inputBox\">이    름</span>" + name + "\n";
		info += "<span class=\"inputBox\">사    진</span>" + photo + "\n";
		info += "<span class=\"inputBox\">가 입 일</span> " + regDate + "\n";
		
		return info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	//memberInfo 인스턴스에서 LoginInfo객체 반환하는 메서드
	public LoginInfo toLoginInfo() {
		return new LoginInfo(id, name, photo, regDate);
	}
}
