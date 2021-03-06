package com.Addressbook;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		//요청의 캐릭터 인코딩은 utf-8로 변환하자
		req.setCharacterEncoding("UTF-8"); // 변환작업 수행 
		
		//뒤쪽에 연결된 필터에 요청과 응답을 전달
				chain.doFilter(req, resp);

		//응답에 관련된 필터처리
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
