<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List , com.lee.springbootworkspaceblogger.sql.entity.*" %>
<jsp:include flush="true" page="index.jsp"></jsp:include>
<div id="main">
    <div class="t" style="margin-bottom:0; border-bottom:0">
        <table width="100%">
            <tr>
                <th class="h">
                    <strong class="fl w">用戶資訊</strong> &nbsp;
                    <span style="color: red; font-weight: bold; ">${ message }</span>
                </th>
            </tr>
        </table>
    </div>
    <form action="/loginBorder" method="post">
        <div class="t t2">
            <table  width="100%" style="table-layout:fixed;border-top:0">
                <tr class="tr3">
                    <td style="width: 120px; ">名稱:</td>
                    <td><input type="text" name="account" style="width: 200px; "/></td>
                </tr>
                <tr class="tr3">
                    <td style="width: 120px; ">密碼:</td>
                    <td><input type="password" name="password" style="width: 200px; "/></td>
                </tr>
                <tr class="tr3">
                    <td colspan="2">
                        <input  type="submit"  name="btn" value="登入"  />
                    </td>
                </tr>
            </table>

        </div>
    </form>

<jsp:include flush="true" page="footer.jsp"></jsp:include>