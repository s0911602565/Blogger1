<!-- replyView.jsp  -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include flush="true" page="index.jsp"></jsp:include>
<div id="main">

    <div class="t3">
        <table cellspacing="0" cellpadding="0" width="100%" align="center">
            <tr>
                <td style="padding-top: 25px;text-align: left;">

                    <b>  &raquo; 向版主留言 </b>
                </td>
            </tr>
        </table>
        <br />
    </div>



    <div class="t" style="margin-bottom:0px; border-bottom:80">
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th class="h">
                    <strong class="fl w"><b>項目:</b>${category.getName()}</strong>
                </th>
            </tr>
        </table>
    </div>

    <form action="addReply" method="post">
        <input type="hidden" value="${boards.getId()}" name="boardsId"/>
        <div class="t t2">
            <table style="table-layout:fixed;border-top:0">
                <tr class="tr1">
                    <th style="width:20%" class="r_two" style="text-align: right">
                        原帖主題
                    </th>
                    <th height="100%" class="r_one" valign="top" id="td_4900235" style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">
                        ${boards.getBoardsname()}
                    </th>
                </tr>
                 <tr class="tr1 r_one">
                    <th style="width:20%" class="r_two" style="text-align: right">
                        ${user}:回覆
                    </th>
                    <th style="vertical-align:bottom;padding-left:15px;border:0">
                        <textarea name="word"  style="width: 350px; height: 100px; "></textarea>
                        <br />
                        <br />
                        <input type="submit" value="送出" title="AddReply.java"/>
                    </th>
                </tr>
            </table>
        </div>
    </form>

</div>

<jsp:include flush="true" page="footer.jsp" />
