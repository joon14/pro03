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
	<title>도서</title>
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
			    <li><a href="${path2 }/book/list.do">도서</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">도서</h2>
    		
    		<div class="tab_box">
	    		<div class="tabs">
				  <ul>
                        <li><a href="${path2 }/book/listAll.do" class="navbar-item" title="전체">
                            전체
                        </a></li>
                        <li><a href="${path2 }/book/list.do?genre=social" class="navbar-item" title="인문">
                            인문
                        </a></li>
                        <li><a href="${path2 }/book/list.do?genre=science" class="navbar-item" title="자연">
                            자연
                        </a></li>
                        <li><a href="${path2 }/book/list.do?genre=art" class="navbar-item" title="예체능">
                            예체능
                        </a></li>
                        <li><a href="${path2 }/book/list.do?genre=lang" class="navbar-item" title="외국어">
                            외국어
                        </a></li>
                        <li><a href="${path2 }/book/list.do?genre=other" class="navbar-item" title="기타">
                            기타
                        </a></li>   
				  </ul>
				</div>
    		</div>
    		
    		<div class="page-wrap">
	    		<div class="clr-fix">
	    			<br>
					<ul class="columns list" id="list1">
						<c:if test="${not empty list }">
							<c:forEach var="dto" items="${list }">
							<li class="column">
								<a href="${path2 }/book/detail.do?no=${dto.no }" class="item_wrap">
									<div class="item_box">
										<img src="${path2 }/resources/upload/${dto.img3 }" class="item_pic"/>
										<h4 class="list_genre">${dto.genre }</h4>
										<h3 class="list_name">${dto.name }</h3>
										<p class="list_author">${dto.author }</p>
										<p class="list_pub">${dto.pub }</p>
										<p class="list_content">${dto.content }</p>
										<p class="list_pubdate">${dto.pub_date }</p>
										<p class="list_price"><strong>${dto.price }</strong></p>
									</div>
								</a>
							</li>
							</c:forEach>
						</c:if>
						<c:if test="${empty list }">
							<li>
								<p><strong>도서가 존재하지 않습니다.</strong></p>
							</li>
						</c:if>
					</ul>
					<script>
					$(document).ready(function(){
						/* $("#list1").DataTable({
							order:[[0,"desc"]]
						}); */
					});
					</script>
					<hr>
					<c:if test="${cus.id.equals('admin') }">
					<div class="buttons">
					  <a href="${path2 }/book/insert.do" class="button is-danger">도서 등록</a>
					</div>
					</c:if>
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