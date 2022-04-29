<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="CommunityQuestionHead__header">
    <div class="CommunityQuestionHead__header--text">

        <strong class="boardTitle">제목</strong>
        <div class="CommunityQuestionHead__title">
            <c:if test="${empty commonNotice.commonNoticeSubject}">
                <input class="CommunityQuestionHead__title--text CommunityQuestionHead__title--noLink"
                       id="contentSubject" name="commonNoticeSubject" data-cy="threads-title" type="text"
                       placeholder="문의하실 주 제목을 적어주세요">
            </c:if>

            <c:if test="${not empty commonNotice.commonNoticeSubject}">
                <input class="CommunityQuestionHead__title--text CommunityQuestionHead__title--noLink"
                       id="contentSubject" name="commonNoticeSubject" data-cy="threads-title" type="text"
                       placeholder="문의하실 주 제목을 적어주세요" value="${commonNotice.commonNoticeSubject}">
            </c:if>

        </div>
        <hr>
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
                            <textarea class="boardContentWrite" id="contentText" name="commonNoticeText"
                                      placeholder="문의하실 내용을 적어주세요">${commonNotice.commonNoticeText}</textarea>

                        </div>
                        <c:if test="${not empty commonNotice.commonNoticeFile}">
                            <img src="${commonNotice.commonNoticeFile}">
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--파일업로드--%>
<h1>File Upload Example</h1>
<%--<form method="post" action="/upload" enctype="multipart/form-data">--%>
<%--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

    <input type="file" name="file"/>
<%--    <input type="submit" value="submit"/>--%>
<%--</form>--%>


