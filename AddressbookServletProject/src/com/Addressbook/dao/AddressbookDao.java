package com.Addressbook.dao;

import java.util.List;



public interface AddressbookDao {
	
	public List<AddressbookVo> getList(); //테이블로부터 필드를 받아옴
	public List<AddressbookVo> search(String keyword); // 스캐너를 통해 입력한 값 포함한 필드를 찾아옴
	public AddressbookVo get(Long id); //
	public boolean insert(AddressbookVo vo); //name,hp,tel
	public boolean delete(Long id); //입력한 id값의 행을 지움 ?
}