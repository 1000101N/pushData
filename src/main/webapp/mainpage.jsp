<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/10/2017
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%! String hello_message = "Push Data Client created by N.Babiy"; %>

<html>
<head>
    <title>Push Data Client</title>
</head>
<body>

    <table cellpadding="1" cellspacing="1" border="1" width="450" height="450">
            <tr width="100">
                <td>
                    <%@ include file="navigation.jspf"%>
                </td>
                <td><%= hello_message %></td>
            </tr>
    </table>
</body>
</html>
