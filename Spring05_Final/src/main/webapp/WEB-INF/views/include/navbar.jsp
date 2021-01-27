<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--  
	jsp 페이지 안에서의 주석 입니다. 
	여기 작성한 내용은 jsp 페이지가 해석하지 않습니다.
	클라이언트 웹브라우저에 출력되지 않습니다.
--%>
<%--
	특정 jsp 페이지에 포함 시킬 내용을 jsp 페이지에 작성할수 있습니다.
 --%>

 <nav class="navbar navbar-dark bg-primary navbar-expand-sm fixed-top">
	<div class="container">
	  	<a class="navbar-brand" href="${pageContext.request.contextPath }/">
	  		<img style="width:30px;height:30px" src="${pageContext.request.contextPath }/resources/images/kim1.png"/> Acorn
	  	</a>
		<button class="navbar-toggler" data-toggle="collapse" data-target="#topNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="topNav">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item ${param.thisPage eq 'cafe' ? 'active' : ''}">
					<a class="nav-link" href="${pageContext.request.contextPath }/cafe/list.do">글목록</a>
				</li>
				<li class="nav-item ${param.thisPage eq 'file' ? 'active' : ''}">
					<a class="nav-link" href="${pageContext.request.contextPath }/file/list.do">자료실</a>
				</li>
				<li class="nav-item ${param.thisPage eq 'gallery' ? 'active' : ''}">
					<a class="nav-link" href="${pageContext.request.contextPath }/gallery/list.do">겔러리</a>
				</li>
			</ul>
			<c:choose>
				<c:when test="${empty sessionScope.id}">
					<a class="btn btn-success btn-sm" 
					href="${pageContext.request.contextPath }/users/loginform.do">로그인</a>
					<a class="btn btn-danger btn-sm ml-1" 
					href="${pageContext.request.contextPath }/users/signup_form.do">회원가입</a>
				</c:when>
				<c:otherwise>
					<span class="navbar-text">
					<a href="${pageContext.request.contextPath }/users/private/info.do">${id }</a>
					<a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath }/users/logout.do">로그아웃</a>
					</span>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</nav>



