<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List , com.lee.springbootworkspaceblogger.sql.entity.*" %>
<jsp:include flush="true" page="index.jsp"></jsp:include>

<div id="main">
    <div class="t3">
        <table width="100%" align="center" cellspacing="0" cellpadding="0">
            <tr>
                <td align="right" style="padding-bottom:.2em">
                    <a href='myboders?action=rep&id=${bo2.getId()}'><img src='images/yellow/reply.png' /></a>
                </td>
            </tr>
        </table>
    </div>


    <div class="t" style="margin-bottom:0px; border-bottom:0">
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th class="h">
                    <strong class="fl w"><b>本頁主題:</b> ${bo2.name}</strong>
                </th>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr class="tr2">
                <td colspan="2" class="tar">
                    <br />
                </td>
            </tr>

        </table>
    </div>

    <%
        Boards bo2 =(Boards)request.getAttribute("bo2");
        for(ForumInfo gu : bo2.getGuests()){%>

    <div class="t t2">
        <table  width="100%" style="table-layout:fixed;border-top:0">
            <tr class="tr1">
                <th style="width:20%" rowspan="2" class="r_two">
                    <b>作者：<%= gu.getUser() %></b>
                    <div class="user-pic">
                        <table style="border:0">
                            <tr>
                                <td width="1">

                                    <a href="" style="cursor:pointer;"><img class="pic" src="images/yellow/images${1}.jpg" width="100" height="100" border="0" /> </a>
                                </td>
                            </tr>
                        </table>
                    </div>

                </th>
                <th height="100%" class="r_one" valign="top" id="td_4900235"
                    style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">

                    <h1 id="subject_4900235" class="fl">
                        &nbsp;
                    </h1>

                    <div id="p_4900235" class="c"></div>

                    <div class="tpc_content" id="read_4900235">
                        <%= bo2.getDescription() %>
                    </div>
                </th>
            </tr>
            <tr class="tr1 r_one">
                <th style="vertical-align:bottom;padding-left:15px;border:0">

                    <div id="w_4900235" class="c"></div>

                    <div class="tipad">

                        <span class="gray">Posted:  |</span>
                        <span><a class="s3">原帖</a> </span>
                    </div>
                </th>
            </tr>
        </table>
    </div>
    <%}%>


    <%  List list =(List)request.getAttribute("listrep");
        for(Reply r : (List<Reply>)list)
    %>

    <c:forEach  items="${listrep}" var="abc">
        <div class="t t2">
            <table cellspacing="0" cellpadding="0" width="100%"
                   style="table-layout:fixed;border-top:0">
                <tr class="tr1">
                    <th style="width:20%" rowspan="2" class="r_two">
                        <b>作者 ${abc.guid.user}</b>
                        <div class="user-pic">
                            <table style="border:0">
                                <tr>
                                    <td width="1">

                                        <a href=""
                                           style="cursor:pointer;"><img class="pic"
                                                                        src="images/yellow/images${2}.jpg"
                                                                        width="100" height="100" border="0" /> </a>
                                    </td>
                                </tr>
                            </table>
                        </div>

                    </th>
                    <th height="100%" class="r_one" valign="top" id="td_4900235"
                        style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">

                        <h1 id="subject_4900235" class="fl">
                            &nbsp;
                        </h1>

                        <div id="p_4900235" class="c"></div>

                        <div class="tpc_content" id="read_4900235">
                                ${abc.title}
                        </div>
                    </th>
                </tr>
                <tr class="tr1 r_one">
                    <th style="vertical-align:bottom;padding-left:15px;border:0">

                        <div id="w_4900235" class="c"></div>

                        <div class="tipad">
							<span style="float:right"> <a
                                    href="javascript:scroll(0,0)" title="頂端">頂端</a> </span>
                            <span class="gray">Posted: |</span>
                            <span><a class="s3">${abc.date} </a> </span>
                        </div>
                    </th>
                </tr>
            </table>
        </div>


    </c:forEach>


</div>


<jsp:include flush="true" page="footer.jsp" />
