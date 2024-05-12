<!-- signUp.jsp signUpExecute.java-->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include flush="true" page="index.jsp"></jsp:include>

<div id="main">
    <div class="t" style="margin-bottom:0; border-bottom:0">
        <table width="100%">
            <tr><th class="h">
                <strong class="fl ">註冊使用者</strong> &nbsp;
            </th></tr>
        </table>
    </div>

    <form action="/signUpExecute" method="post">
        <div class="t t2">
            <table width="100%" style="table-layout:fixed;border-top:0">

                <tr class="tr3">
                    <td style="width: 120px;">帳號:</td>
                    <td><input type="text" name="account" size="30"/></td>
                </tr>
                <tr class="tr3">
                    <td>密碼:</td>
                    <td><input type="password" name="password" size="30"/></td>
                </tr>
                <tr class="tr3">
                    <td>確認密碼:</td>
                    <td><input type="password" name="password2" size="30"/></td>
                </tr>
                <tr class="tr3">
                    <td>姓名:</td>
                    <td><input type="text" name="user" size="30"/></td>
                </tr>

                <tr class="tr3">
                    <td>電子郵件:</td>
                    <td><input type="email" name="email"/> meow@gmail.com</td>
                </tr>
                <tr class="tr3" id="vue_birthday">
                    <td>生日:</td>
                    <td>
                        <input type="text" v-model="years" size="5"/>-
                        <input type="text" v-model="months" size="3"/>-
                        <input type="text" v-model="days" size="3"/>YYYY-MM-DD
                        <input type="hidden" name="birthday" v-model="combineDate"/>
                    </td>
                </tr>
                <tr class="tr3">
                    <td colspan="2">
                        <input type="submit" value="帳戶註冊"/>
                    </td>
                </tr>
            </table>
        </div>
        ${msg}
    </form>

<jsp:include flush="true" page="footer.jsp"></jsp:include>