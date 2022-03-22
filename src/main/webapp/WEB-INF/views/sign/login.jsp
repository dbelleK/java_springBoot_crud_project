<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link type="text/css" rel="stylesheet" href="/resources/css/signUp1.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/signUp2.css"/>


</head>
<body>

<div class="container login" role="main">
    <!-- ANCHOR Common Appbar -->
    <div id="headerCommonLayout"><header data-system="CCommonAppbar" class="common-layout__sc-1q47zu5-0 lbAVMi"><h1>무신사 스토어</h1><div class="common-layout__sc-1q47zu5-1 fhWAHi"><h2 class="common-layout__sc-wllrag-0 fuSBOR">로그인</h2><div class="common-layout__sc-1q47zu5-2 common-layout__sc-1q47zu5-3 jylTdg fehdnF"><button class="common-layout__sc-1w1f44c-0-button jNqhOq gtm-catch-click" data-gtm-cd-23="header" data-gtm-cd-19="button" data-gtm-cd-21="101" data-gtm-category="header" data-gtm-action="client.click" data-gtm-label="back"><span class="common-layout__sc-1w1f44c-1 gQwfAI">이전 페이지로 이동</span><svg width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg" role="img"><path d="M19 5L9 14.9994L19 25" stroke="black"></path></svg></button></div><div class="common-layout__sc-1q47zu5-2 common-layout__sc-1q47zu5-4 jylTdg kcEGpO"></div></div></header></div><!-- content -->
    <section class="content content--no-interval">
        <!-- tab -->
        <nav class="MCommonTabUnderline">
            <a href="javascript:void(0);" id="login-tab" class="MCommonTabUnderline__button MCommonTabUnderline__button--active">가입 회원 </a>
            <a href="javascript:void(0);" id="buy-tab" class="MCommonTabUnderline__button" data-popup-open="loginBottomsheetFix" style="display: none;">비회원 구매하기</a>
            <a href="javascript:void(0);" id="buy-search-tab" class="MCommonTabUnderline__button" style="">비회원 주문 조회</a>
        </nav><!-- //tab -->
        <!-- login-member -->
        <div class="login-member">

            <form name="loginform" class="login-form" action="/auth/login" method="post" onsubmit="return loginCheck(this);">
                <div class="login-member__form">
                    <input type="hidden" id="cipherKey" name="cipherKey" value="01e11538030ea3147fee96bfc8975f1a">
                    <input type="hidden" id="cipherVersion" name="cipherVersion" value="V1">
                    <input type="hidden" id="csrfToken" name="csrfToken" value="01e11538030ea3147fee96bfc8975f1a042cfde3">
                    <input type="hidden" id="eventPage" name="eventPage" value="">
                    <input type="hidden" id="eventCode" name="eventCode" value="">
                    <input type="hidden" id="refererFromLoginPage" name="referer" value="https://www.musinsa.com/app/">
                    <input type="hidden" id="encryptMemberId" name="encryptMemberId">
                    <input type="hidden" id="encryptPassword" name="encryptPassword">
                    <input type="hidden" id="isCheckGoogleRecaptcha" name="isCheckGoogleRecaptcha" value="false">
                    <div class="login-input">
                        <div class="login-input__wrap">
                            <input type="text" name="id" class="login-input__input" title="아이디 입력" placeholder="아이디">
                            <button type="button" class="login-input__button-clear" style="display:none;" onclick="clearInputValue(this);">
                                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-input__button-clear__svg">
                                    <title>입력한 내용 삭제</title>
                                    <circle cx="10" cy="10" r="10" fill="#B3B3B3"></circle>
                                    <path d="M5.52786 5.52742L14.4722 14.4718M14.4722 5.52734L5.52783 14.4717" stroke="white"></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div class="login-input">
                        <div class="login-input__wrap">
                            <input type="password" name="pw" class="login-input__input" title="비밀번호 입력" placeholder="비밀번호">
                            <button type="button" class="login-input__button-clear" style="display:none;" onclick="clearInputValue(this);">
                                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-input__button-clear__svg">
                                    <title>입력한 내용 삭제</title>
                                    <circle cx="10" cy="10" r="10" fill="#B3B3B3"></circle>
                                    <path d="M5.52786 5.52742L14.4722 14.4718M14.4722 5.52734L5.52783 14.4717" stroke="white"></path>
                                </svg>
                            </button>
                            <button type="button" class="login-input__button-eye" aria-label="비밀번호 보이기" onclick="toggleInputType(this);"></button>
                        </div>
                    </div>
                </div>

                <div class="login-button login-button--static">
                    <button type="submit" class="login-button__item login-button__item--black">로그인</button>
                </div>
                <div class="login-member__util">
                    <div class="login-checkbox login-member__util__login-auto">
                        <input type="checkbox" id="autologin" name="autologin" value="1" class="blind login-member__util__login-auto__checkbox">
                        <label for="autologin" id="labelAutoLogin" class="login-checkbox__label login-member__util__login-auto__label" data-tooltip="login-member__util__login-auto__tooltip">자동 로그인</label>
                        <div id="tooltipAutoLogin" class="login-member__util__login-auto__tooltip">개인 정보 보호를 위해 본인
                            기기에서만 이용해주세요.
                        </div>
                    </div>
                    <ul class="login-member__util__list">
                        <li class="login-member__util__item">
                            <a id="id-search" href="#" class="gtm-catch-click" data-gtm-cd-23="login_navi" data-gtm-cd-19="button" data-gtm-cd-20="/login" data-gtm-cd-21="1" data-gtm-category="login_navi" data-gtm-action="client.click" data-gtm-label="아이디찾기">아이디 찾기</a>
                        </li>
                        <li class="login-member__util__item">
                            <a id="pw-search" href="#" class="gtm-catch-click" data-gtm-cd-23="login_navi" data-gtm-cd-19="button" data-gtm-cd-20="/login" data-gtm-cd-21="1" data-gtm-category="login_navi" data-gtm-action="client.click" data-gtm-label="비밀번호찾기">비밀번호 찾기</a>
                        </li>
                    </ul>
                </div>
            </form>
            <div class="login-button login-button--static login-social">

                <a href="javascript:void(0)" class="login-button__item login-button__item--kakao" id="loginWithKakao">
                    <svg width="30" height="30" viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-button__item__logo">
                        <title>kakao 로고</title>
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M15 7C10.029 7 6 10.129 6 13.989C6 16.389 7.559 18.505 9.932 19.764L8.933 23.431C8.845 23.754 9.213 24.013 9.497 23.826L13.874 20.921C14.243 20.958 14.618 20.978 15 20.978C19.971 20.978 24 17.849 24 13.989C24 10.129 19.971 7 15 7Z" fill="black"></path>
                    </svg>
                    카카오 로그인
                </a>


                <a href="javascript:void(0)" onclick="appleLogin(&quot;https:\/\/appleid.apple.com\/auth\/authorize?client_id=com.musinsa.appleid\u0026redirect_uri=https:\/\/my.musinsa.com\/member\/v1\/sns\/login\/apple\/callback\u0026scope=email\u0026state=01e11538030ea3147fee96bfc8975f1a042cfde3\u0026response_type=code id_token\u0026response_mode=form_post&quot;);" class="login-button__item login-button__item--apple">
                    <svg width="29" height="30" viewBox="0 0 29 30" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-button__item__logo">
                        <title>apple 로고</title>
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M17.6734 6.53179C17.0545 7.30483 16.0153 7.88462 15.1863 7.88462C15.0929 7.88462 14.9995 7.87254 14.9411 7.86046C14.9294 7.81214 14.9061 7.6672 14.9061 7.52225C14.9061 6.53179 15.3848 5.56548 15.9102 4.94946C16.5758 4.14018 17.685 3.53624 18.6074 3.5C18.6308 3.60871 18.6425 3.74158 18.6425 3.87444C18.6425 4.85283 18.2338 5.83121 17.6734 6.53179ZM13.6127 22.1399C13.1966 22.3248 12.8023 22.5 12.2673 22.5C11.123 22.5 10.329 21.4129 9.41827 20.0842C8.35574 18.514 7.4917 16.0861 7.4917 13.7912C7.4917 10.095 9.81526 8.13827 12.1038 8.13827C12.7718 8.13827 13.3821 8.39164 13.9248 8.61693C14.3592 8.79728 14.7503 8.95963 15.0929 8.95963C15.3901 8.95963 15.7604 8.80823 16.1921 8.63177C16.795 8.38531 17.5175 8.08996 18.3272 8.08996C18.841 8.08996 20.7208 8.13827 21.9585 9.97425C21.9514 9.97996 21.9363 9.99029 21.9142 10.0053C21.6097 10.2133 19.9852 11.3227 19.9852 13.5979C19.9852 16.4123 22.3555 17.4148 22.4372 17.439C22.4351 17.4444 22.4303 17.4599 22.4226 17.4845C22.3447 17.7339 21.9733 18.9232 21.1762 20.1325C20.3939 21.2921 19.5649 22.4758 18.3272 22.4758C17.7172 22.4758 17.3285 22.2978 16.9272 22.1139C16.4989 21.9177 16.0562 21.7149 15.3148 21.7149C14.5693 21.7149 14.0774 21.9334 13.6127 22.1399Z" fill="black"></path>
                    </svg>
                    Apple 로그인
                </a>

            </div>
        </div><!-- //login-member -->
        <div class="login-nonmember buy" id="nonMemberOrder" data-tab="nonMemberOrder" style="display: none;">
            <div class="login-nonmember__clause" tabindex="0">비회원정보수집 동의
                <br>비회원 개인정보보호정책은 비회원으로 주문하는 고객님의 개인정보 보호를 위하여 무신사가 실시하는 개인정보 수집의 목적과 그 정보의 정책에 관한 규정입니다.
                <br>
                <br>제1조 개인정보 수집 범위
                <br>1.물품 구매 시
                <br>필수항목: 구매자 정보(성명, 전화번호, 휴대전화 번호, 이메일) 수령자 정보(성명, 전화번호, 휴대전화번호, 주소)
                <br>2.환불 요청 시
                <br>필수항목: 환불계좌
                <br>
                <br>제2조 개인정보 수집 목적 및 이용목적
                <br>무신사((주)무신사)는 고객님께서 비회원으로 재화 혹은 용역을 주문하거나 각종 서비스를 이용하는데 있어, 원활한 주문 및 서비스 접수, 물품 배송, 대금 결제 및 편리하고
                유익한 맞춤정보를 제공하기 위한 최소한의 정보를 수집합니다.
                <br>
                <br>1.e-mail, 전화번호 : 고지의 전달. 불만처리나 주문/배송정보 안내 등 원활한 의사소통 경로의 확보.
                <br>2.성명, 주소 : 고지의 전달, 청구서, 정확한 상품 배송지의 확보.
                <br>3.은행계좌번호, 신용카드번호: 유료정보에 대한 이용 및 상품구매에 대한 결제
                <br>4.전화번호, 휴대전화번호 : 상품구매 전/후 만족도조사, 회원가입권유(포인트 또는 적립금 지급 등)및 영업 목적 전화 및 SMS발송
                <br>
                <br>비회원 주문 시 제공하신 모든 정보는 상기 목적에 필요한 용도 이외로는 사용되지 않습니다.
                <br>단, 이용자의 기본적 인권 침해의 우려가 있는 민감한 개인정보(인종 및 민족, 사상 및 종교, 출신지 및 본적지, 정치적 성향 및 범죄기록, 건강상태 등)는 수집하지
                않습니다.
                <div style="font-size: 14px; font-weight: bold;">
                    <br>제3조 개인정보의 보유기간 및 이용기간
                    <br>고객의 개인정보는 다음과 같이 개인정보의 수집목적 또는 제공받은 목적이 달성되면 파기됩니다. 단, 상법 등 관련법령의 규정에 의하여 다음과 같이 거래 관련 권리 의무
                    관계의 확인 등을 이유로 일정기간 보유하여야 할 필요가 있을 경우에는 일정기간 보유합니다.
                    <br>1.계약 또는 청약철회 등에 관한 기록 : 5년
                    <br>2.대금결제 및 재화등의 공급에 관한 기록 : 5년
                    <br>3.소비자의 불만 또는 분쟁처리에 관한 기록 : 3년
                </div>

                <br>제4조
                <br>동의 거부시 불이익 귀하는 개인정보 수집 및 이용 등에 관해 동의하지 않을 권리가 있습니다. 다만, 필수수집 동의를 하지 않을 경우 구매가 제한될 수 있습니다.<br>
                <br>고객의 동의를 받아 보유하고 있는 거래정보 등을 고객께서 열람을 요구하는 경우 무신사는 지체 없이 그 정보를 열람·확인 할 수 있도록 조치합니다.
            </div>
            <div class="login-checkbox login-nonmember__checkbox">
                <input type="checkbox" id="checkMemberAgree" class="blind">
                <label for="checkMemberAgree" class="login-checkbox__label login-nonmember__checkbox__label">비회원
                    구매약관 동의 (필수)</label>
            </div><!-- button -->
            <div class="login-button login-button--static gtm-catch-click">
                <button type="button" class="login-button__item login-button__item--black" id="btnNonMemberOrder" data-gtm-cd-23="non_member" data-gtm-cd-19="button" data-gtm-cd-20="/login" data-gtm-cd-21="2" data-gtm-category="non_member" data-gtm-action="client.click" data-gtm-label="비회원구매하기" disabled="">구매하기
                </button>
            </div><!-- //button -->
        </div><!-- //login-nonmember -->
        <div class="login-nonmember buy-search" id="nonMemberInquiry" data-tab="nonMemberOrder" style="display: none;">
            <div class="login-nonmember__form">
                <form class="formBox" name="orderviewform" action="https://store.musinsa.com/app/mypage/order_view" method="post" target="_self" onsubmit="return orderviewform_submit(this)">
                    <div class="login-input">
                        <label for="order_name" class="login-input__label">주문자명</label>
                        <div class="login-input__wrap">
                            <input type="text" id="order_name" name="order_name" class="login-input__input">
                            <button type="button" class="login-input__button-clear" style="display:none;" onclick="clearInputValue(this);">
                                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-input__button-clear__svg">
                                    <title>입력한 내용 삭제</title>
                                    <circle cx="10" cy="10" r="10" fill="#B3B3B3"></circle>
                                    <path d="M5.52786 5.52742L14.4722 14.4718M14.4722 5.52734L5.52783 14.4717" stroke="white"></path>
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div class="login-input">
                        <label for="order_no" class="login-input__label">주문번호</label>
                        <div class="login-input__wrap">
                            <input type="number" id="order_no" name="order_no" class="login-input__input">
                            <button type="button" class="login-input__button-clear" style="display:none;" onclick="clearInputValue(this);">
                                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg" class="login-input__button-clear__svg">
                                    <title>입력한 내용 삭제</title>
                                    <circle cx="10" cy="10" r="10" fill="#B3B3B3"></circle>
                                    <path d="M5.52786 5.52742L14.4722 14.4718M14.4722 5.52734L5.52783 14.4717" stroke="white"></path>
                                </svg>
                            </button>
                        </div>
                    </div><!-- button -->
                    <div class="login-button login-button--static">
                        <button type="submit" class="login-button__item login-button__item--black gtm-catch-click" id="btnNonMemberOrderSelect" data-gtm-cd-23="non_member" data-gtm-cd-19="button" data-gtm-cd-20="/login" data-gtm-cd-21="2" data-gtm-category="non_member" data-gtm-action="client.click" data-gtm-label="비회원주문조회" disabled="disabled">주문 내역 조회하기
                        </button>
                    </div><!-- //button -->
                </form>
            </div>
        </div>
        <div class="login-bottom-text login-bottom-text--login-member">
            <span class="login-bottom-text__text">가입만 해도 즉시 15% 할인 </span>
            <a href="#" title="회원가입" id="member-join" class="login-bottom-text__link gtm-catch-click" data-gtm-cd-23="login_navi" data-gtm-cd-19="button" data-gtm-cd-20="/login" data-gtm-cd-21="1" data-gtm-category="login_navi" data-gtm-action="client.click" data-gtm-label="회원가입">회원가입</a>
        </div>


        <div class="popup-pc-load-bottomsheet popup-pc-load-bottomsheet--new-member-benefit" data-popup="loginBottomsheetFix">
            <div class="popup-pc-load-bottomsheet__area">
                <strong class="popup-pc-load-bottomsheet__title">신규회원 15% 쿠폰</strong>
                <div class="popup-pc-load-bottomsheet__text">가입만 해도 더 할인 받을 수 있어요!
                    <br>즉시 사용 가능한 15% 할인 쿠폰을 드립니다.
                </div>
            </div>
            <div class="popup-pc-load-bottomsheet__buttons__wrap">
                <a href="javascript:void(0);" onclick="popupJoin();" class="popup-pc-load-bottomsheet__buttons__button popup-pc-load-bottomsheet__buttons__button--accent">가입하기</a>
            </div>
            <button type="button" aria-label="신규회원 혜택 안내 팝업 닫기" data-popup-close="loginBottomsheetFix" class="popup-pc-load-bottomsheet__button-close">
                <svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" viewBox="0 0 22 22" class="">
                    <title></title>
                    <path class="svg-color" fill-rule="evenodd" d="M17.646 3.646l.708.708L11.707 11l6.647 6.646-.708.708L11 11.707l-6.646 6.647-.708-.708L10.293 11 3.646 4.354l.708-.708L11 10.293l6.646-6.647z"></path>
                </svg>
            </button>
        </div>

</div>
</body>
</html>


