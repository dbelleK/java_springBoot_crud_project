<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../../layout/header.jsp">
    <jsp:param name="pageName" value="header"/>
</jsp:include>


<link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage1.css"/>
<link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage2.css"/>
<link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage3.css"/>

<div>
    <nav class="sidebar">
        <aside class="menu">
            <ul class="menu-list">
                <li>
                    <a class="is-active">Mypage</a>
                    <ul>
                        <li><a>회원정보수정</a></li>
                        <li><a>주문내역조회</a></li>
                        <li><a>장바구니</a></li>
                    </ul>
                </li>
        </aside>
    </nav>


    <%--기본정보수정--%>
    <div class="mypage_cont">

        <div class="my_page">

            <div class="join_base_wrap">

                <div class="member_cont">
                    <div id="formJoin" name="formJoin" action="/mypageInfoPro" method="post" novalidate="novalidate">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                        <input type="hidden" name="memNo" value="85305">
                        <input type="hidden" name="memberFl" value="personal">
                        <input type="hidden" name="dupeinfo"
                               value="MC0GCCqGSIb3DQIJAyEAeZ3cRCnYc6JiQ8mlIopSOtuHfz/aSngizyyjI5qcjKg=">
                        <input type="hidden" name="rncheck" value="authCellphone">
                        <input type="hidden" name="mode" value="modify">


                        <section>
                            <!-- 회원가입/정보 기본정보 -->
                            <div class="base_info_box">
                                <h3>기본정보</h3>
                                <span class="important">표시는 반드시 입력하셔야 하는 항목입니다.</span>
                                <div class="base_info_sec">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <colgroup>
                                            <col width="25%">
                                            <col width="75%">
                                        </colgroup>
                                        <tbody>


                                        <tr>
                                            <th><span class="important">이메일</span></th>
                                            <td>
                                                <input type="hidden" name="email">${user.email}
                                            </td>
                                        </tr>

                                        <tr>
                                            <th><span class="important">아이디</span></th>
                                            <td>
                                                <input type="text" name="id" maxlength="30" value="${user.id}"/>
                                            </td>
                                        </tr>

                                        <tr>
                                            <th><span class="important">비밀번호</span></th>
                                            <td class="member_password">

                                                <div id="memberNewPw" class="member_pw_change">
                                                    <dl class=" dn ">
                                                        <dt>현재 비밀번호</dt>
                                                        <dd>
                                                            <div class="member_warning">
                                                                <input type="pass" id="pass" name="pass">
                                                            </div>
                                                        </dd>
                                                    </dl>
                                                    <c:if test="${error}">
                                                        <p style="color: #ff0000"><strong>현재비빌번호</strong>가 올바르지 않습니다.
                                                        </p>
                                                    </c:if>

                                                    <dl>
                                                        <dt>새 비밀번호</dt>
                                                        <dd>
                                                            <div class="member_warning">
                                                                <input type="password" id="newPass" name="newPass">
                                                            </div>
                                                        </dd>
                                                    </dl>

                                                    <dl>
                                                        <dt>새 비밀번호 확인</dt>
                                                        <dd>
                                                            <div class="member_warning">
                                                                <input type="password" id="newPassCheck"
                                                                       name="newPassCheck">
                                                            </div>
                                                        </dd>
                                                    </dl>

                                                </div>
                                                <!-- //member_pw_change -->
                                            </td>
                                        </tr>

                                        <tr>
                                            <th><span class="important">생일(월일)</span></th>
                                            <td>
                                                <div class="member_warning">
                                                    <input type="text" name="birthday" maxlength="30"
                                                           value="${user.birthday}"/>
                                                </div>
                                            </td>
                                        </tr>


                                        <th><span class="important">주소</span></th>
                                        <td class="member_address">
                                            <div class="address_postcode">
                                                <%--                                            <input type="text" name="zonecode" readonly="readonly" value="28502">--%>
                                                <button type="button" id="btnPostcode" class="btn_post_search">우편번호검색
                                                </button>
                                                <input type="hidden" name="zipcode" value="-">
                                            </div>
                                            <div class="address_input">
                                                <div class="member_warning">
                                                    <input type="text" name="address" value="${user.address}"/>
                                                </div>
                                                <div class="member_warning js_address_sub">
                                                    <input type="text" name="addressSub"/>
                                                </div>
                                            </div>
                                        </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- //base_info_sec -->
                            </div>
                        </section>

                        <section>
                            <div class="btn_center_box">
                                <button type="submit" class="btn_member_cancel">취소</button>
                                <button type="submit" class="btn_comfirm js_btn_join" value="정보수정">정보수정</button>
                            </div>
                            <!-- //btn_center_box -->
                        </section>
                    </div>

                    </form>
                </div>
                <!-- //member_cont -->
            </div>
            <!-- //join_base_wrap -->

        </div>
        <!-- //my_page -->

    </div>
    <%--맨 처음 div--%>



<script>
    $(function () {
        let error = "${error}";
        // console.log(error);
        if (error === "true") {
            alert("현재 비밀번호를 정확히 입력해주세요");
        }
    });
</script>

<jsp:include page="../../layout/footer.jsp">
    <jsp:param name="pageName" value="footer"/>
</jsp:include>