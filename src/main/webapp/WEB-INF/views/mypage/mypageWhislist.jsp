<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage1.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage2.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/mypage/mypage3.css"/>

</head>
<body>
<%--위시리스트--%>
<div class="content">
    <div class="mypage_cont">

        <!-- 마이페이지 회원 요약정보 -->
        <div class="mypage_top_info">
            <div class="mypage_top_txt">
                <div class="grade_txt">
                    <p>김도연님의</p><p> 회원등급은 <span>BRONZE등급</span> 입니다.
                </p><div class="btn_layer">
                    <span class="btn_gray_list"><a href="#lyGrade" class="btn_gray_small"><em>등급혜택보기</em></a></span>

                    <!-- N : 회원등급혜택 레이어 시작 -->
                    <div id="lyGrade" class="layer_area" style="display:none;">
                        <div class="ly_wrap grade_layer">
                            <div class="ly_tit">
                                <strong>등급혜택 안내</strong>
                            </div>
                            <div class="ly_cont">
                                <div class="grade_list">
                                    <dl>
                                        <dt>회원 등급</dt>
                                        <dd>BRONZE등급</dd>
                                    </dl>
                                    <dl>
                                        <dt>추가 할인</dt>
                                        <dd><strong>0원이상 구매시 상품 판매금액의 0.0% 추가 할인</strong></dd>
                                    </dl>
                                    <dl>
                                        <dt>중복 할인</dt>
                                        <dd><strong>0원이상 구매시 상품 판매금액의 0.0% 추가 할인</strong></dd>
                                    </dl>
                                    <dl>
                                        <dt>추가  적립</dt>
                                        <dd>0원이상 구매 시 구매금액당 0.0% 추가 적립</dd>
                                    </dl>
                                </div>
                            </div>
                            <!-- //ly_cont -->
                            <a href="#lyGrade" class="ly_close"><img src="/data/skin/front/moment_181113/img/common/layer/btn_layer_close.png" alt="닫기"></a>
                        </div>
                        <!-- //ly_wrap -->
                    </div>
                    <!-- N : 회원등급혜택 레이어 끝 -->

                </div>
                </div>
                <!-- //grade_txt -->
            </div>
            <!-- //mypage_top_txt -->

            <div class="mypage_top_wallet">
                <ul>
                    <li>
                        <span><img src="/data/skin/front/moment_181113/img/icon/mypage/icon_coupon.png" alt=""></span>
                        <span><em>쿠폰</em><a href="../mypage/coupon.php"><strong>2</strong></a>장</span>
                    </li>
                    <li>
                        <span><img src="/data/skin/front/moment_181113/img/icon/mypage/icon_mileage.png" alt=""></span>
                        <span><em>마일리지</em><a href="../mypage/mileage.php"><strong>86</strong></a>원</span>
                    </li>
                    <li>
                        <span><img src="/data/skin/front/moment_181113/img/icon/mypage/icon_balance.png" alt=""></span>
                        <span><em>예치금</em><a href="../mypage/deposit.php"><strong>0</strong></a>원</span>
                    </li>
                </ul>
            </div>
            <!-- //mypage_top_wallet -->

        </div>
        <!-- //mypage_top_info -->

        <!-- 마이페이지 회원 요약정보 -->

        <div class="mypage_wish_list">
            <div class="mypage_zone_tit">
                <h3>찜리스트</h3>
            </div>

            <div class="mypage_table_type">
                <form id="frmWish" name="frmWish" method="post" target="ifrmProcess">
                    <input type="hidden" name="mode" value="">
                    <input type="hidden" name="isCart" value="false">
                    <table>
                        <colgroup>
                            <col style="width:8%">	<!-- 선택 -->
                            <col>					<!-- 상품명/옵션 -->
                            <col style="width:15%">	<!-- 상품금액/수량 -->
                            <col style="width:15%">	<!-- 혜택 -->
                            <col style="width:10%">	<!-- 합계 -->
                        </colgroup>
                        <thead>
                        <tr>
                            <th>
                                <div class="form_element">
                                    <input type="checkbox" id="allCheck" name="allCheck" class="gd_checkbox_all" data-target-name="sno[]" data-target-form="#frmWish">
                                    <label for="allCheck" class="check_s"></label>
                                </div>
                            </th>
                            <th>상품명/옵션</th>
                            <th>상품금액/수량</th>
                            <th>혜택</th>
                            <th>합계</th>
                        </tr>
                        </thead>
                        <tbody>

                        <tr>
                            <td colspan="5"><p class="no_data">찜리스트에 상품이 없습니다.</p></td>
                        </tr>

                        </tbody>
                    </table>

                    <button class="btn_wish_choice_del"><em>선택 상품 삭제</em></button>
                    <button class="btn_wish_choice_cart"><em>선택 상품 장바구니</em></button>
                </form>
            </div>

        </div>
        <!-- //mypage_wish_list -->

    </div>
    <!-- //mypage_cont -->
</div>

</div>

</body>
</html>
