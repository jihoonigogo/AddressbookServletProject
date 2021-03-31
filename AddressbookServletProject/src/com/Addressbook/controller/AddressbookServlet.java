package com.Addressbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Addressbook.dao.AddressbookDao;
import com.Addressbook.dao.AddressbookImpl;
import com.Addressbook.dao.AddressbookVo;


//@WebServlet("/abs")
@WebServlet(name="AddressbookServlet", urlPatterns="/abs")
public class AddressbookServlet extends HttpServlet {
	AddressbookDao dao = new AddressbookImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddressbookDao dao = new AddressbookImpl();
		String action = req.getParameter("action");
		if("form".equals(action)) {			
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(req,resp); 
			//성공
			
		}else if("delete".equals(action)) {
			Long id = Long.valueOf(req.getParameter("id"));					
			dao.delete(id);
			resp.sendRedirect(req.getContextPath()+ "/abs");
			//목록화면으로 돌아가는거 실패..
//			RequestDispatcher rd = 
//					getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
//			rd.forward(req, resp);
			
		}else if("search".equals(action)){
			String keyword = req.getParameter("keyword");
			List<AddressbookVo> list = dao.search(keyword);
			req.setAttribute("list", list);
			//resp.sendRedirect(req.getContextPath()+ "/abs");
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
			
			
		}else {			
			List<AddressbookVo> list = dao.getList();				
			req.setAttribute("list", list); //전달받은 서블릿은 요청으로부터 이 속성을 꺼내 쓸 수 있다.
			RequestDispatcher rd = 
					getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}
		 
	
		
		
		
		
		
		
		
	}


	
	
	
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddressbookDao dao = new AddressbookImpl();
		String action = req.getParameter("action");
		
		if("insert".equals(action)) { //액션이 인서트면 삽임해야함;;
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");			
			String tel = req.getParameter("tel");
			
			AddressbookVo vo = new AddressbookVo();
			vo.setName(name);
			vo.setHp(hp);
			vo.setTel(tel);
			
		
			dao.insert(vo);
			
			
			//리스트 페이지로 리다이렉트
			resp.sendRedirect(req.getContextPath()+"/abs");
		}else {
			doGet(req,resp);
		}
		
		
	}}