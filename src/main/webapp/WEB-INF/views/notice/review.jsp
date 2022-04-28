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
                <strong>리뷰</strong>
                <p>
                </p><h3>리뷰를 남겨주시면 순차적으로 답변드리겠습니다.</h3>
            </div>

            <div class="Header_buttonWrapper__qedG2">
                <a href="review-write-form-new" class="ButtonInteractive_container__NfRis ButtonInteractive_withIcon__ECQZi" style="padding: 1.2rem 2.7rem 0.8rem 2.2rem;">
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
                <c:forEach var='obj' items="${reviews}">
                    <div class="List_questionWrapper__49Ukv">
                        <div class="List_question__yvi1N">
                            <div class="ListItem_container__aU8Hn ListItem_regular__1_GMg ListItem_large__k18OQ">
                                <div class="ListItem_contents__nde6Z">
                                    <a role="button" class="ListItem_title__QygUT" tabindex="0"
                                       href="review-write-form?reviewsIdx=${obj.reviewsIdx}">
                                                        <span class="ListItem_new__FQ3iR">
                                                            <i class="fa-regular fa-clipboard"></i>
                                                        </span>
                                        <span class="ListItem_new__FQ3iR">${ obj.reviewsSubject}</span>

                                    </a>
                                </div>
                                <div class="ListItem_profile__aJl52">
                                    <button type="button">
                                        <div class="Profile_container___j_Y3">
                                            <p class="Profile_name__3AVi2">${ user.email }</p>
                                            <p class="Profile_time__vpz_O">${ obj.reviewsDate }</p>
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



    <div class="pager-wrap">
        <ul class="pager">
            <%--화면에 보여지는 페이지의 첫번째 인덱스 > 한 화면에 보여줄 페이지의 수--%>
            <%--1,2,3,4,5 -> 첫번째 인덱스 : 1, 한 화면에 보여줄 페이지의 수 : 5 ///
                6,7,8,9,10-> 첫번째 인덱스 : 6, 한 화면에 보여줄 페이지의 수 : 5 ///  위 식 성립하므로 첫번째 인덱스 6이 나타날 때 부터 해당 버튼 나타남 --%>
            <c:if test="${pageInfo.startPageIndex > pageInfo.blockPage}">
                <li>
                    <%--화면에 보여지는 페이지의 첫번째 인덱스 - 한 화면에 보여줄 페이지의 수--%>
                    <a href="javascript:goPage(${pageInfo.startPageIndex - pageInfo.blockPage});"> <%--6-5=1  url : review?page=1 // 11-5=6 url : review?page=6--%>
                        <i class="fa fa-angle-left" aria-hidden="true"></i> <%--버튼--%>
                    </a>
                </li>
            </c:if>


            <c:forEach begin="${pageInfo.startPageIndex}"
                       end="${pageInfo.endPageIndex}"
                       var="index">
                <li
                    <%--버튼유무--%>
                    <c:if test="${pageInfo.currentPage == index}">
                        class="active"
                    </c:if>
                >
                    <%--인덱스 번호 출력,연결--%>
                    <c:choose>
                        <c:when test="${pageInfo.currentPage == index}">
                            <strong>${index}</strong>
                        </c:when>
                        <c:otherwise>
                            <a href="javascript:goPage(${index});">${index}</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </c:forEach>

            <%--현재 보여지는 페이지의 마지막 인덱스 < 페이지 전체 갯수 --%>
                <%--1,2,3,4,5 -> 마지막 인덱스 : 5 / 6,7,8,9,10-> 페이지 전체 갯수 : 10 //// 위 식 성립하므로 마지막인덱스가 5->6으로 갈 때 해당 버튼 나타남 --%>
            <c:if test="${pageInfo.endPageIndex < pageInfo.pageTotal}">
                <li>
                    <a href="javascript:goPage(${pageInfo.endPageIndex + 1});"> <%--5+1=6 url : review?page=6 /// 10+1=11 url : review?page=11 --%>
                        <i class="fa fa-angle-right" aria-hidden="true"></i> <%--버튼--%>
                    </a>
                </li>
            </c:if>
        </ul>
    </div>

    <%--get방식 보내는 정규식--%>
    <script>
        function replaceQueryParam(param, newval, search) {
            let regex = new RegExp("([?;&])" + param + "[^&;]*[;&]?");
            let query = search.replace(regex, "$1").replace(/&$/, '');

            return (query.length > 2 ? query + "&" : "?") + (newval ? param + "=" + newval : '');
        }

        function goPage(page) {
            location.href = location.pathname + replaceQueryParam("page", page, window.location.search);
        }
    </script>

<jsp:include page="../../layout/footer.jsp">
    <jsp:param name="pageName" value="footer"/>
</jsp:include>
