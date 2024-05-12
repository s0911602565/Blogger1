<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List , com.lee.springbootworkspaceblogger.sql.entity.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script><%--VueJs3--%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--JSTL--%>
    <%@taglib prefix="mine" uri="https://onegztag" %><%--TLD--%>
    <link rel="stylesheet" type="text/css" href="../css/bg.css"/>

    <title>JSP Page</title>
</head>
<body>
<div id="wrapA">
    <div id="header">
        <div class="toptool tar" id="vue_title">
            <span><a href='/blog/index'>Home首頁</a> | <a href="" >{{SendMassage}}</a> </span>
        </div>
        <table >
            <tr>
            </tr>
            <tr>
                <td align="center" height="1" colspan="2"></td>
            </tr>
        </table>
        <div id="h_guide" class="guide ">
            <span class="s3">&raquo;</span>
            <%
                if (session.getAttribute("user") == null) {
            %>
            <c:out value="Hello您尚未"/>

            <a href="/blog/login">登入</a> |
            <a href="/blog/signUp">註冊</a>

            <%} else {%>
            歡迎您,
            <a href="顯示資料"/>${user}</a> |
            <a href='/blog/logout'>登出</a>
            <%}%>
        </div>
    </div>

    <div style="margin-top:7px;"></div>
    <div id="main">
<div id="content">





