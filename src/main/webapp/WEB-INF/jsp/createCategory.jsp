<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List , com.lee.springbootworkspaceblogger.sql.entity.*" %>
<jsp:include flush="true" page="index.jsp"></jsp:include>
<div id="main">
    <div class="t" style="margin-bottom:0px; border-bottom:0">
        <table width="100%">
            <tr>
                <th class="h">
                    <strong class="fl w">增加版面</strong> &nbsp;

                </th>
            </tr>
        </table>
    </div>
    <form action="/createBorder" method="post">

        <div class="t t2">
            <table  width="100%"
                   style="table-layout:fixed;border-top:0">
                <tr class="tr3">

                    <td style="width: 120px; ">
                        類別:
                    </td>
                    <td><select name="categoryID">
                        <option value="0">---選擇---</option>

                        <%


                            List name = (List) request.getAttribute("listCategory");

                            for (Category n :(List<Category>) name) {

                                out.print("<option value="+n.getId()+">" + n.getName() + "</option>");
                            }

                        %>
                    </select>

                    </td>
                </tr>
                <tr class="tr3">
                    <td style="width: 120px; ">
                        名稱:
                    </td>
                    <td>
                        <input type="text" name="titleName" style="width: 200px; "/>
                    </td>
                </tr>
                <tr class="tr3">
                    <td style="width: 120px; ">
                        描述:
                    </td>
                    <td>
                        <textarea name="description"
                                  style="width: 200px; height: 50px; "></textarea>
                    </td>
                </tr>
                <tr class="tr3">
                    <td colspan="2">
                        <input  type="submit"  name="btn" value="增加版面" />
                    </td>
                </tr>
            </table>

        </div>
    </form>

<jsp:include flush="true" page="footer.jsp"></jsp:include>