<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icon.png" type="image/x-icon"/>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/master.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
    <script>
        //提示信息全局变量
        var msg = "${message}";
    </script>
</head>
<body>

<div class="login">
    <div class="login_in">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/assets/images/logo.png" />
            <span>综合平台管理</span>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/admin/login">
            <div class="list_group">
                <p class="list_group_item">
                    <label class="label"></label>
                    <input  type="text" id="username" name="username"  class="list_group_item_input" placeholder="用户名登录">
                </p>
                <p class="list_group_item">
                    <label class="label"></label>
                    <input type="password" id="password" name="password"  class="list_group_item_input" placeholder="密码">
                </p>
                <p class="list_group_item">
                    <input type="text" id="inputCode" class="list_group_item_input input_w" placeholder="请输入验证码">
                    <input type="button" id="checkCode"  class="btn_yz code" />
                </p>
                <p class="alert alert-danger" >
                    <strong id="warning-info"></strong>
                </p>
                <p class="list_group_item">
                    <button class="btn" type="submit">登录</button>
                </p>
            </div>
        </form>

    </div>
    <p class="copyright">Copyright © 2017 恒宇科技有限公司 版权所有</p>
</div>
<script>
    webRoot="${pageContext.request.contextPath}";
</script>
    <script src="${pageContext.request.contextPath}/assets/js/common/require.min.js" rel="script" defer data-main="${pageContext.request.contextPath}/assets/js/login-main"></script>
</body>
</html>