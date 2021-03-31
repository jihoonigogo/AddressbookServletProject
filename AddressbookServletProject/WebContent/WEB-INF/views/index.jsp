<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>돌아온 주소록 서블릿</h3>
	<h3>돌아온 목록</h3>
	
	<form action="<c:url value='/abs'/>">
	<input type="hidden" name="action" value="search">
	<input type="text" name="keyword" >
	<input type="submit" value="검색">	
	</form>
	
	
	<table border="1">
		<thead>
			<tr style= "background:lightgray">
				<th>이름</th>
				<th>휴대전화</th>
				<th>전화번호</th>
				<th>도구</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${list}" var="vo">
					<tr>
					<td>${vo.name }</td>
					<td>${vo.hp }</td>
					<td>${vo.tel }</td>
					<td >
						<form action="<c:url value='/abs'/>">
							<input type="hidden" name="action" value="delete">
							<input type="hidden" name="id" value="${vo.id}"/>
							<input type="submit" value="삭제"/>
						</form>					
					</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="<c:url value='/abs?action=form'/>">새 주소 추가</a>
	</p>
	

</body>
</html>