<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../../layout/header.jsp">
    <jsp:param name="pageName" value="header"/>
</jsp:include>

<link rel="stylesheet" href="/resources/css/notice/notice1.css">

<div class="community_content__qACrW">

    <div class="community_header__AdorW">
        <div class="Header_container__HGW4p">
            <div class="board_title">
                <strong>문의하기</strong>
                <p>
                </p><h3>문의사항을 남겨주시면 순차적으로 답변드리겠습니다.</h3>
            </div>

            <div class="Header_buttonWrapper__qedG2">
                <a href="questions-write-form-new" class="ButtonInteractive_container__NfRis ButtonInteractive_withIcon__ECQZi" style="padding: 1.2rem 2.7rem 0.8rem 2.2rem;">
                    <span class="Header_buttonText__zPcGR">질문하기</span>
                </a>
            </div>


        </div>
    </div>

    <div class="community_tools__I9vJo">
        <div class="Tools_container__8l_zD Tools_withFilter___gLvH">
            <div class="Tools_searchRow__TVWM5">
                <div class="Tools_searchWrapper__TDK0l">
                </div>
            </div>
            <div class="Tools_filters__OB5Q0">
            </div>
        </div>
    </div>



    <div class="community_questions__XzDam">
        <div>
            <div class="List_questionBox__5hZiu">
                <c:forEach var='obj' items="${contents}">
                    <div class="List_questionWrapper__49Ukv">
                        <div class="List_question__yvi1N">
                            <div class="ListItem_container__aU8Hn ListItem_regular__1_GMg ListItem_large__k18OQ">
                                <div class="ListItem_contents__nde6Z">
                                    <a role="button" class="ListItem_title__QygUT" tabindex="0"
                                       href="questions-write-form?contentIdx=${obj.contentIdx}">
                                                        <span class="ListItem_new__FQ3iR">
                                                            <i class="fa-regular fa-clipboard"></i>
                                                        </span>
                                        <span class="ListItem_new__FQ3iR">${ obj.contentSubject}</span>

                                    </a>
                                </div>
                                <div class="ListItem_profile__aJl52">
                                    <button type="button">
                                        <div class="Profile_container___j_Y3">
                                            <p class="Profile_name__3AVi2">${ user.email }</p>
                                            <p class="Profile_time__vpz_O">${ obj.contentDate }</p>
                                        </div>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>



    <div class="community_pagination__V9VQ1">
        <div class="Pagination_container__SunX5">

            <c:choose>

                <c:when test="${pageCount.currentPage <=1}">
                    <a href="#" class="page-link">이전</a>
                </c:when>

                <c:otherwise>
                    <a href="questions?pages=${pageCount.currentPage-1}" class="page-link">이전</a>

<%--                    <a class="Pagination_FirstButton__First" href="faq?page=1">--%>
<%--                        <span class="Pagination_buttonText__First">First</span>--%>
<%--                    </a>--%>

<%--                    <a class="Pagination_previousButton__Left" href="faq?page=${page.currentPage-1}">--%>
<%--                        <i class="fa-solid fa-angle-left"></i>--%>
<%--                    </a>--%>
                </c:otherwise>
            </c:choose>

            <div class="Pagination_pageWrapper__P796x">
                <c:forEach var='idx' begin="${ pageCount.min }" end="${ pageCount.max }">
                    <c:if test="${idx==pageCount.currentPage}">
                        <%--최소값에서 최대값까지 돌때 idx가 현재페이지와 같으면 보라색--%>
                        <a href="questions?pages=${idx}" class="Pagination_page__T9uPQ Pagination_selected__AWwCP">${ idx }</a>

                           <%--매개변수 page밖에 안넘겼으니 pageCount연결해주면 안되고 page만연결--%>
<%--                        <a href="questions?pageCount=${ pageCount }&page=${idx}" class="Pagination_page__T9uPQ Pagination_selected__AWwCP">${ idx }</a>--%>
                    </c:if>
                    <c:if test="${idx!=pageCount.currentPage}">
                         <%--최소값에서 최대값까지 돌때 idx가 현재페이지와 다르면 무색--%>-
                        <a href="questions?pages=${idx}" class="Pagination_page__T9uPQ" >${ idx }</a>

<%--                        <a href="questions?pageCount=${ pageCount }&page=${idx}" class="Pagination_page__T9uPQ" >${ idx }</a>--%>
                    </c:if>
                </c:forEach>
            </div>

            <c:choose>
                <%--전체페이지 수 보다 현재페이지번호가 크거나 같으면 페이지 넘어가지 않게--%>
                <c:when test="${pageCount.currentPage >= pageCount.pageCnt}">
                    <a href="#" class="page-link">다음</a>
                </c:when>
                <c:otherwise>
                    <a href="questions?pages=${pageCount.currentPage+1}" class="page-link">다음</a>

<%--                    <a class="Pagination_nextButton__Right" href="questions?pageCount=${pageCount.currentPage+1}">다음--%>
<%--                        <i class="fa-solid fa-angle-right"></i>--%>
<%--                    </a>--%>

<%--                    <a class="Pagination_lastButton__hGkMG" href="questions?pageCount=${pageCount.pageCnt}">--%>
<%--                        <span class="Pagination_buttonText__KfRX8">Last</span>--%>
<%--                    </a>--%>

                </c:otherwise>
            </c:choose>
        </div>

    </div>
</div>




<jsp:include page="../../layout/footer.jsp">
    <jsp:param name="pageName" value="footer"/>
</jsp:include>
