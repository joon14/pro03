<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path3" value="${pageContext.request.contextPath }" />
<!-- 푸터 내용 기술 -->
<div class="ft-wrap">
	<nav class="footer container clr-fix">
		<ul class="menu">
			<li><a href="${path3 }/member/intro.do">회사소개</a></li>
			<li><a href="${path3 }/member/term.do">이용약관</a></li>
			<li><a href="${path3 }/member/policy.do">개인정보처리방침</a></li>
			<li><a href="${path3 }/member/come.do">오시는길</a></li>
		</ul>
	</nav>
	<hr style="background-color:#ddd; height:3px; margin:0px auto; padding:0px; ">
	<div class="footer container clr-fix">
		<p class="copyright">
			<span class="ft_col">법인명 : (주)교보문고</span> 
			<span class="ft_col">교보문고 본사 : 경기도 파주시 문발로 249 교보문고 (우)10881</span>
			<span class="ft_col">사업자등록번호: 102-81-11670</span> 
			<span class="ft_col">서울특별시 통신판매업신고번호 : 제 653호</span>
			<br><br>
			<span class="ft_col">대표전화 : 1544-1900(발신자 부담전화)</span> 
			<span class="ft_col">FAX : 0502-987-5711(지역번호 공통)</span> 
			<span class="ft_col">고객센터 1544-1900 (평일 10시 ~ 5시 / 토,일,공휴일 휴무)</span>
			<br><br>
			<span class="ft_col">제작자 : 정도준</span> 
			<span class="ft_col">COPYRIGHT (C) KYOBO BOOK CENTRE. All RIGHTS RESERVED.</span>
		</p>
	</div>
</div>