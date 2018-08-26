<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/8
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>小工具</title>
    <style>
        body {
            width: 100%;
            height: 100%;
            position: relative;
        }

        form {
            width: 530px;
        }

        button {
            width: 200px;
            height: 50px;
            font-size: 30px;
            margin-left: 150px;
            margin-top: 15px;
        }

        div.d1 {
            width: 530px;
            float: left;
        }

        div.d2 {
            height: 400px;
            width: 530px;
            float: left;
        }

    </style>
</head>
<body>
<div class="d1">
    <form action="getjson" method="post">
        domain：<br>
        <textarea name="domain" id="domain" cols="70" rows="10"></textarea><br><br>
        cookies：<br>
        <textarea name="cookies" id="cookies" cols="70" rows="10"></textarea><br>
        <button type="submit">提交</button>
        <br>

    </form>
</div>
<div class="d2">
    Json:<br>
    <textarea name="json" id="json" cols="70" rows="10">${json}</textarea><br>
</div>

</body>
</html>
