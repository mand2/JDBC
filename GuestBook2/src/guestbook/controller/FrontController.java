package guestbook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.GuestBookService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(
		urlPatterns = { "/" }, 
		initParams = { 
				@WebInitParam(name = "config", value = "/WEB-INF/commandService.properties")
		})
public class FrontController extends HttpServlet {

	//map 설정
	private Map<String, GuestBookService> commands =
			new HashMap<String, GuestBookService>();
	
	
	public void init(ServletConfig config) throws ServletException {
		
		String configfile = config.getInitParameter("config");
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		String configFilePath = config.getServletContext().getRealPath(configfile);
		
		try {
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator();
		
		while (itr.hasNext()) {
//itr.next() 프린트하면 commandService.propertise에 있는 것들의 앞부분을 가져옴
			String command = (String)itr.next(); //사용자요청URI
			String serviceClassName = prop.getProperty(command); //service class 이름
			
			//받아온 것들을 commands map 형식으로 저장->인스턴스필요
			
			//-1 prop에 있는 클래스이름으로 인스턴스 생성필요
			try {
				Class serviceClass = Class.forName(serviceClassName);
				GuestBookService service = (GuestBookService) serviceClass.newInstance();
				
				commands.put(command, service);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
					
			
			
			
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		/* doGet(request, response); */
	}

	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 사용자요청분석
		 * 사용자 요청에 맞는 모델실행 (서비스.메서드)실행 -> view페이지반환
		 * view로 포워딩
 		*/
		
		String commandUri = request.getRequestURI(); // /gb2/guestWriteForm
		if(commandUri.indexOf(request.getContextPath()) == 0) { //0번지부터 시작하는가~
			commandUri = commandUri.substring(request.getContextPath().length()); // /gb2를 자르고 /guestWirteForm을 가져오게함.
			
		}
		
		System.out.println(commandUri);
		
		
		
		//2 사용자 요청에 맞는 모델 실행
		//commands에서 uri받을 때 값이 없으면 널처리되기때문에 디폴트 페이지 혹은 특정객체로 처리
		//default page 혹은 특정 객체로 처리함

		//초기화
		String viewPage="/WEB-INF/view/null.jsp";
		
		GuestBookService service = commands.get(commandUri); //값이 없으면 널null 처리됨.
		
		if(service != null) { //널이 아닐떄에만 실행하도록,,
			viewPage = service.getViewName(request, response);
		}
		
		
		
		//3view포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); 
		dispatcher.forward(request, response); //servletEx 던진다
		
		
		
	}
}
