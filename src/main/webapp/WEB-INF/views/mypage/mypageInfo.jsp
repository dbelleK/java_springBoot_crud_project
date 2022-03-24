<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage1.css"/>

</head>
<body>
<%--기본정보수정--%>
<div class="mypage_cont">

    <div class="my_page">

        <div class="mypage_zone_tit">
            <h2>회원정보 변경</h2>
        </div>

        <div class="join_base_wrap">

            <div class="member_cont">
                <form id="formJoin" name="formJoin" action="https://www.aimerfeel.kr/mypage/my_page_ps.php"
                      method="post" novalidate="novalidate">
                    <input type="hidden" name="memNo" value="85305">
                    <input type="hidden" name="memberFl" value="personal">
                    <input type="hidden" name="dupeinfo"
                           value="MC0GCCqGSIb3DQIJAyEAeZ3cRCnYc6JiQ8mlIopSOtuHfz/aSngizyyjI5qcjKg=">
                    <input type="hidden" name="rncheck" value="authCellphone">
                    <input type="hidden" name="mode" value="modify">

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
                                    <th><span class="important">이름</span></th>
                                    <td>
                                        <input type="hidden" name="memNm" value="kkddy1206">김도연
                                    </td>
                                </tr>


                                <tr>
                                    <th><span class="important">아이디</span></th>
                                    <td>
                                        <div class="member_warning">
                                            <input type="text" name="memId" data-pattern="gdEngKor" value="kkddy1206" maxlength="30">
                                        </div>
                                    </td>
                                </tr>

                                <tr class="">
                                    <th><span class="important">비밀번호</span></th>
                                    <td class="member_password">

                                        <!-- //layer_area -->

                                        <div id="memberNewPw" class="member_pw_change" >
                                            <dl class=" dn ">
                                                <dt>현재 비밀번호</dt>
                                                <dd>
                                                    <div class="member_warning">
                                                        <input type="password" id="currentPassword" name="oldMemPw">
                                                    </div>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>새 비밀번호</dt>
                                                <dd>
                                                    <div class="member_warning">
                                                        <input type="password" id="newPassword" name="memPw">
                                                    </div>
                                                </dd>
                                            </dl>
                                            <dl>
                                                <dt>새 비밀번호 확인</dt>
                                                <dd>
                                                    <div class="member_warning">
                                                        <input type="password" id="newPasswordCheck" name="memPwRe">
                                                    </div>
                                                </dd>
                                            </dl>
                                        </div>
                                        <!-- //member_pw_change -->
                                    </td>
                                </tr>



                                <tr>
                                    <th><span class="important">이메일</span></th>
                                    <td>
                                        <input type="hidden" name="memEmail" value="kkddy1206@naver.com">kkddy1206@naver.com
                                    </td>
                                </tr>

                                    <th><span class="important">주소</span></th>
                                    <td class="member_address">
                                        <div class="address_postcode">
                                            <input type="text" name="zonecode" readonly="readonly" value="28502">
                                            <button type="button" id="btnPostcode" class="btn_post_search">우편번호검색
                                            </button>
                                            <input type="hidden" name="zipcode" value="-">
                                        </div>
                                        <div class="address_input">
                                            <div class="member_warning">
                                                <input type="text" name="address" readonly="readonly"
                                                       value="충청북도 청주시 청원구 상당로302번길 132-8">
                                            </div>
                                            <div class="member_warning js_address_sub">
                                                <input type="text" name="addressSub" value="러브하우스 101호">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <!-- //base_info_sec -->
                    </div>


                    <div class="btn_center_box">
                        <button type="button" class="btn_member_cancel">취소</button>
                        <button type="button" class="btn_comfirm js_btn_join" value="정보수정">정보수정</button>
                    </div>
                    <!-- //btn_center_box -->
                </form>
            </div>
            <!-- //member_cont -->
        </div>
        <!-- //join_base_wrap -->

    </div>
    <!-- //my_page -->

</div>

</body>
</html>
