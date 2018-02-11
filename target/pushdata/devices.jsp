<%@ page import="domain.Device" %>
<%@ page import="rest.Timer" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Data" %>
<%@ page import="java.sql.*" %>
<%@ page import="domain.RestResult" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/11/2017
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<jsp:useBean id="data" class="rest.DataBean"/>
<%! Device device = null; %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Devices</title>
</head>
<body>

    <table cellpadding="1" cellspacing="1" border="1" width="1000" height="1000">
        <tr>
            <td>
            <%@ include file="navigation.jspf"%>
            </td>
            <td>
                <table cellspacing="1" cellpadding="1" border="1" width="500" height="250">
                <%
                try {
                    String driver = "org.postgresql.Driver";
                    String url = "jdbc:postgresql://localhost:5432/pushDat";
                    String username = "dvDev";
                    String password = "qwerty";
                    String myDataField = null;
                    String myQuery = "SELECT * FROM Device";
                    Connection myConnection = null;
                    PreparedStatement myPreparedStatement = null;
                    ResultSet myResultSet = null;
                    Class.forName(driver).newInstance();
                    myConnection = DriverManager.getConnection(url,username,password);
                    myPreparedStatement = myConnection.prepareStatement(myQuery);
                    myResultSet = myPreparedStatement.executeQuery();

                    if(myResultSet.next()){
                        long id = myResultSet.getLong("_id");
                        String name = myResultSet.getString("name");
                        String token = myResultSet.getString("token");
                %>
                       <c:devices_list id="<%=id%>" token="<%=token%>" name="<%=name%>"/>

                    <%
                    }
                }
                catch(ClassNotFoundException e){e.printStackTrace();}
                catch (SQLException ex)
                {
                    out.print("SQLException: "+ex.getMessage());
                    out.print("SQLState: " + ex.getSQLState());
                    out.print("VendorError: " + ex.getErrorCode());
                }%>

                </table>
            </td>
        </tr>
    </table>

</body>
</html>
