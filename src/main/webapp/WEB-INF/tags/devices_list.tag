<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="id" type="java.lang.Long" required="true" %>
<%@ attribute name="token" type="java.lang.String" required="true" %>
<%@ attribute name="name" type="java.lang.String" required="true" %>



    <tr>
        <td><%=id%></td>
        <td><%=token%></td>
        <td><%=name%></td>
        <td><input type="checkbox" name="select"></td>
    </tr>