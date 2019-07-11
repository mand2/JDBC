package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	/* Constructor : 초기화, -> request객체에서 Cookie[] 받아서, cookieMap 에 저장. */
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0) {
			for( int i = 0 ; i < cookies.length ; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	//쿠키생성 메서드: 이름, 데이터
		public static Cookie createCookie(String name, String value) {
			Cookie c = new Cookie(name, value);
			return c;
		}
		//쿠키생성 메서드: 이름, 데이터, 유효시간
		public static Cookie createCookie(String name, String value,int maxAge) {
			Cookie c = new Cookie(name, value);
			c.setMaxAge(maxAge);
			return c;
		}
		
		//쿠키정보 반환하는 메서드: 이름(from map)
		public Cookie getCookie(String name) {
			Cookie c = cookieMap.get(name);
			return c;
		}
		
		//쿠키 데이터 반환하는 메서드: 이름(from map)
		public String getValue(String name) {
			
			/* decoder하려면 반환값이 null이 되면 안됨. 
			 * 즉, 처리를 위해 아래와 같은 식을 쓴다. nullPointerException나와서 */
			return (cookieMap.get(name) == null ? null : cookieMap.get(name).getValue());
		}
		
		
		/*쿠키 존재여부 확인 메서드: 쿠키맵이 null이 아니면 true 반환 */
		public boolean exists(String name) {
			return cookieMap.get(name) != null;
		}
		
		
}
