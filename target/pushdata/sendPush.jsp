<%@ page import="rest.DataBean" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Device" %>
<%@ page import="rest.Timer" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/29/2017
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="timer" class="rest.Timer" scope="page"/>
<jsp:useBean id="data" class="rest.DataBean" scope="page"/>
<html>
<head>
    <title>Send push</title>
</head>
<body>

    <table cellpadding="1" cellspacing="1" border="1" width="450" height="450">
    <tr width="100">
        <td>
            <%@ include file="navigation.jspf"%>
        </td>

        <td>
            <form action="http://localhost:8080/pushdata/api/data/sendPush" method="get">
                <table cellpadding="0" cellspacing="0" border="0">
                    <% String msg = ""; %>


                        <tr>
                            <td>Token:</td>
                            <td><input name="token" type="text" ></td>
                            <%--<% data.setToken(request.getParameter("token")); %>--%>
                        </tr>
                        <tr>
                            <td>IsData:</td>
                            <td><input name="isData" type="text" ></td>
                            <%--<% data.setIsData(request.getParameter("isData")); %>--%>
                        </tr>
                        <tr>
                            <td>Message:</td>
                            <td><input name="message" type="text" ></td>
                            <%--<% data.setMessage(request.getParameter("message")); %>--%>

                        </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="send"></td>
                    </tr>
                </table>
            </form>

        </td>
    </tr>
</table>


</body>
</html>
