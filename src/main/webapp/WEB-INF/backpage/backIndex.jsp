<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/frontAsset/images/icon.png">
    <%@ include file="Common/intoHead.jsp" %>
    <title>主页</title>
</head>
<body>
<body>
<%@ include file="Common/header.jsp" %>

<div id="bjui-container" class="clearfix">
    <%@ include file="Common/leftMenu.jsp" %>

    <div id="bjui-navtab" class="tabsPage">
        <div class="tabsPageHeader">
            <div class="tabsPageHeaderContent">
                <ul class="navtab-tab nav nav-tabs">
                    <li data-url=""><a href="javascript:;"><span><i class="fa fa-home"></i> #maintab#</span></a></li>
                </ul>
            </div>
            <div class="tabsLeft"><i class="fa fa-angle-double-left"></i></div>
            <div class="tabsRight"><i class="fa fa-angle-double-right"></i></div>
            <div class="tabsMore"><i class="fa fa-angle-double-down"></i></div>
        </div>
        <ul class="tabsMoreList">
            <li><a href="javascript:;">#maintab#</a></li>
        </ul>

        <div class="navtab-panel tabsPageContent">
            <div class="navtabPage unitBox" >
                <div class="bjui-pageHeader" style="background:#FFF;">
                    <div style="padding: 0 15px;">
                        <div class="row">
                            <h3>welcome!</h3>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<%@ include file="Common/footer.jsp" %>
</body>
</html>