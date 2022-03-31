<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:include page="../../layout/header.jsp">
    <jsp:param name="pageName" value="header"/>
</jsp:include>

<link rel="stylesheet" href="/resources/css/notice/notice1.css">

<style>
    h1.Header_title__2oXkX span {
        font-size: 15px;
        font-weight: 400;
        color: #7c7d80;
    }

    span.ListItem_new__FQ3iR img {
        width: auto;
        height: 15px;
    }

    .community_container__bXvMW {
        margin-top: 100px;
    }

    .CommunityContentShow {
        padding-bottom: 0 !important;
    }

    .GeneralLayout_content__3FS7b {
        min-height: auto;
    }

    /*타이틀 부분*/
    .board_title {
        margin-bottom: 30px;
    }

    .board_title strong {
        font-size: 3rem;
        color: #6222CC
    }

    .board_title p {
        margin-top: 5px;
        font-size: 1.4rem;
    }

    .CommunityQuestionHead__title--text {
        display: block;
        width: 100%;
        padding: 15px;
        box-sizing: border-box;
        border: 0;

        outline-color: #6222CC;
    }

    /*내용 작성*/
    .boardContentWrite {
        display: block;
        width: 100%;
        height: 300px;
        padding: 15px;
        box-sizing: border-box;
        resize: none;
        border-radius: 0.4rem;
        border: 0.1rem solid #c5c7d0;
        outline-color: #6222CC;
    }

    /*내용작성 스크롤바 Css*/
    .boardContentWrite::-webkit-scrollbar {
        width: 10px;
    }

    .boardContentWrite::-webkit-scrollbar-thumb {
        background-color: #7436d7;
        border-radius: 10px;
    }

    .boardContentWrite::-webkit-scrollbar-track {
        background-color: grey;
        border-radius: 10px;
        box-shadow: inset 0px 0px 5px white;
    }


    .CommunityContentShow__q--header {
        padding-top: 5.3rem;
        padding-bottom: 0rem;
    }

    .CommunityEachBody__content.question {
        margin-bottom: 0rem;
    }

    .CommunityQuestionHead__title--text {
        width: 100%;
        border-radius: 0.4rem;
        border: 0.1rem solid #c5c7d0;
        padding: 1.3rem 2rem;
        font-size: 1.3rem;
        font-weight: 500;
        letter-spacing: -.026rem;
        color: #333236;
    }

    input:focus {
        outline: 1.5px solid #6222CC;
    }

    .boardTitle {
        margin-left: 10px;
        font-size: 25px;
        color: #6222CC;
    }

    .boardContent {
        margin-left: 10px;
        font-size: 20px;
        color: #6222CC;
    }

    .ButtonInteractive_container__NfRis {
        width: 150px;
        position: relative;
        display: flex;
        align-items: center;
        justify-content: center;
        border: none;
        border-radius: 1.1rem;
        box-shadow: 0 .8rem 1.6rem 0 rgba(143, 0, 255, .13);
        background-image: linear-gradient(309deg, #710ad2, #8e43e6);
        color: #fff;
        padding: 1.6rem 6.2rem 1.1rem
    }

    .ButtonInteractive_container__NfRis.ButtonInteractive_withIcon__ECQZi {
        padding: 1.6rem 5.2rem 1.1rem 4.7rem
    }

    .bt_wrap2 {
        margin-left: 200px;
    }


    .CommunityContentShow__q--header {
        padding-top: 100px;
        /*padding-bottom: 100px;*/
        padding-left: 300px;
        padding-right: 300px;
    }

    .toastui-editor-contents {
        /*padding-top: 100px;*/
        padding-bottom: 100px;
        padding-left: 300px;
        padding-right: 300px;
    }

    .button_write_back {
        padding-bottom: 100px;
        padding-left: 300px;
        padding-right: 300px;
    }
</style>


<div class="CommunityContentShow__q CommunityContentShow__box">
    <div class="CommunityQuestionHead CommunityContentShow__q--header">
        <form name="writeform" class="write-form" action="/writePro" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="CommunityQuestionHead__header">
                <div class="CommunityQuestionHead__header--text">
                    <strong class="boardTitle">제목</strong>
                    <div class="CommunityQuestionHead__title">

                        <input class="CommunityQuestionHead__title--text CommunityQuestionHead__title--noLink"
                               id="contentSubject" name="contentSubject" data-cy="threads-title" type="text"
                               placeholder="문의하실 주 제목을 적어주세요">
                    </div>
                    <div class="CommunityQuestionHead__createdTime"></div>
                    <%--                <div class="CommunityQuestionHead__watch CR__hidden--S">--%>
                    <%--                    <div class="QuestionWatch_container__lDJlT" data-cy="question-watch">--%>
                    <%--                        <button class="QuestionWatch_button__WWFbH" type="button" data-cy="question-watch-button">--%>
                    <%--                        </button>--%>
                    <%--                    </div>--%>
                    <%--                </div>--%>
                    <hr>
                </div>
                <div class="CommunityQuestionHead__profile CR__hidden--S">
                    <div class="UserAvatarWrapper">
                        <%--                    <div class="UserAvatar stone">--%>
                        <%--                        <div class="UserAvatar__level">--%>
                        <%--                            <img alt="profile" src="https://d1ckd324hatig8.cloudfront.net/empty-user.png" class="UserAvatar__level__img">--%>
                        <%--                        </div>--%>
                        <%--                        <span class="UserAvatar__name">김도연</span>--%>
                        <%--                    </div>--%>
                    </div>
                </div>
            </div>
    </div>
        <div class="CommunityEachBody question">

    <div class="BookmarkBtn BookmarkBtn--unchecked "></div>
    <div class="CommunityEachBody__bodyWrapper question">
        <div class="CommunityEachBody__content question">
            <div class="Viewer_container__odwvV">
                <div>
                    <input type="hidden" name="_csrf" value="5e5f96c2-d91e-4f71-bb5a-a5704a783a07">
                    <div class="toastui-editor-contents" style="overflow-wrap: break-word;">
                        <div data-nodeid="1">
                            <strong class="boardContent">내용</strong>
                            <textarea class="boardContentWrite" id="contentText" name="contentText"
                                      placeholder="문의하실 내용을 적어주세요"></textarea>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="CommunityEachBody__commentContainer">
        <div class="CommunityCommentTemplate">
            <div class="button_write_back">
                <div class="bt_wrap1" style="float: left">
                    <button type="submit" class="ButtonInteractive_container__NfRis ButtonInteractive_withIcon__ECQZi"
                            style="padding: 1.2rem 2.7rem 0.8rem 2.2rem;">
                        <span class="Header_buttonText__zPcGR">작성완료</span>
                    </button>
                </div>

                <div class="bt_wrap2">
                    <a href="faq" class="ButtonInteractive_container__NfRis ButtonInteractive_withIcon__ECQZi"
                       style="padding: 1.2rem 2.7rem 0.8rem 2.2rem;">
                        <span class="Header_buttonText__zPcGR">뒤로가기</span>
                    </a>
                </div>
            </div>


            <%--                <button class="CommunityCommentTemplate__ctrlBtn">--%>

            <%--                </button>--%>

        </div>
    </div>
        </div>
    </form>
</div>
</div>


<jsp:include page="../../layout/footer.jsp">
    <jsp:param name="pageName" value="footer"/>
</jsp:include>