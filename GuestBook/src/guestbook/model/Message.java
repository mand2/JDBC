package guestbook.model;

public class Message {
	
	private int id;
	private String guestName;
	private String password;
	private String message;
	
	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}
	
	/*메세지 삭제시 비밀번호 입력받고 지워야할 때 사용하는 메서드임*/
	public boolean matchPassword(String password) {
		return hasPassword() && this.password.equals(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
