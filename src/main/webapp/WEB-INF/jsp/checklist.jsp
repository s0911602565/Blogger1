<!-- checklist.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List , com.lee.springbootworkspaceblogger.sql.entity.*" %>

<jsp:include flush="true" page="index.jsp"></jsp:include>
<div class="t3">
    <table width="100%" >
        <tr>

            <td align="right" style="padding-bottom:.2em">
                <a href="/signUpExecute" title="新增blogger" style="margin-left:.5em"><img src="../../images/yellow/post.png" id="td_post" /> </a>
            </td>
        </tr>
    </table>
</div>

<div class="contentwrap z">
    <%  List<Category> categoryList = (List<Category>) request.getAttribute("blogger");
        for (Category category : categoryList) {%>
    <div class="t">
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th class="h" colspan="6">
                    <a class="closeicon fr" style="cursor:pointer;" onclick="return IndexDeploy('85', 0)"><img id="img_85"  src="../../images/yellow/index/cate_fold.gif" /> </a>
                    <h2>

                        &raquo;<a href=""  class="cfont"><%= category.getName()%></a>
                    </h2>
                </th>
            </tr>
            <tr></tr>
            <tr class="tr2">
                <td width="*" colspan="2" class="tac">
                    論壇
                </td>
                <td class="tal y-style e" style="width:5%">
                    人氣
                </td>
                <td class="tal y-style e" style="width:5%">
                    留言
                </td>
                <td class="tal y-style f" style="width:40%">
                    最後發表
                </td>
                <td class="y-style" style="width:10%">
                    版主
                </td>
            </tr>


            <%for (Boards boards : category.getBoards()) {%>
            <tr class="tr3 f_one">
                <td class="icon tac" width="45">
                    <a href=""><img src="../../images/yellow/2082210335972b.jpg" width="90" height="80"/> </a>
                </td>
                <th>
                    <h3 class="b">
                        <% out.print("<a href='/showArticle?boardsId="+boards.getId()+ "' title='showArticle.java'>"+boards.getBoardsname()+"</a>"); %>
                    </h3>
                    <br />
                    <span class="smalltxt gray"><%= " "%></span>
                    <br />
                </th>
                <td class="tal y-style e">
                    <span class="f10"><%= boards.getPagecount()%></span>
                    <br />
                </td>
                <td class="tal y-style e">
                    <span class="f10"><%= boards.getReplycoun()%></span>
                    <br />
                </td>
                <th>

                </th>

                <td class="y-style"  style="word-break: keep-all;word-wrap:no-wrap;">
                    <%  for (ForumInfo forumInfo : boards.getForumInfo()) {
                            out.print(forumInfo.getUser() );
                        }
                    %>
                    &nbsp;
                </td>
            </tr>

            <%}%>
            <tr>
                <td class="f_one" colspan="6" style="height:8px"></td>
            </tr>

        </table>
    </div>
    <%
        }
    %>
</div>


<jsp:include flush="true" page="footer.jsp" />





