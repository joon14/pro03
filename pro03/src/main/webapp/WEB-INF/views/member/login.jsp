<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인</title>
	<jsp:include page="../include/head.jsp"></jsp:include>
</head>
<body>
<!-- 헤더 부분 인클루드 -->
<div class="full-wrap">
	<header id="hd" class="header">
		<div class="container">
			<jsp:include page="../include/header.jsp"></jsp:include>
		</div>
	</header>
</div>
<div class="container">
	<main class="contents">
		<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px; line-height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path2 }">Home</a></li>
			    <li><a href="${path2 }">로그인</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">로그인</h2>
    		<hr>
    		<div class="page-wrap">
	    		<div class="clr-fix">
		            <form action="${path2 }/member/loginPro.do" method="post" name="loginForm">
		                <div class="table_form_wrap">
		                    <table class="table_form">
		                        <tbody>
		                        <tr>
		                            <th><label for="id">아이디</label></th>
		                            <td><input type="text" name="id" id="id" size="100" class="input" placeholder="아이디 입력" required>
		                                <!--  pattern="^[a-z0-9]+$"  -->
		                            </td>
		                        </tr>
		                        <tr>
		                            <th><label for="pw">비밀번호</label></th>
		                            <td><input type="password" name="pw" id="pw"  class="input" placeholder="비밀번호 입력" required>
		                                <!--  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  -->
		                            </td>
		                        </tr>
		                        <tr>
		                            <td colspan="2">
		                            	<div class="buttons">
			                                <input type="submit" class="button is-danger" value="로그인">
			                                <input type="reset" class="button is-info" value="취소">
			                            </div>    
		                            </td>
		                        </tr>
		                        </tbody>
		                    </table>
		                </div>
		            </form>
		            <script>
		                function loginFaiure() {
		                    alert("로그인 실패");
		                }
		            </script>
		        </div>
			</div>
    	</section>
	</main>
</div>
<!-- 푸터 부분 인클루드 -->
<div class="full-wrap">
	<footer id="ft">
		<jsp:include page="../include/footer.jsp"></jsp:include>
	</footer>
</div>
</body>
</html>