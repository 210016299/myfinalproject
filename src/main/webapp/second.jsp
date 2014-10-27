<%-- 
    Document   : second
    Created on : 26 Oct 2014, 11:42:33 AM
    Author     : theresa
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%
            Connection conn = null;
            try
            {
               Class.forName(org.apache.derby.jdbc.ClientDriver);
               String url="jdbc:derby://localhost:1527/sample; create = true";
               conn = DriverManager.getConnection(url, "name", "password");
               Statement st = conn.createStatement();
               ResultSet rs = st.executeQuery("select * from loginmsg");
               while(rs.next())
               {
                   out.println("" + rs.getString(1));
                   out.println("" + rs.getString(2));
               }
            }
            catch(Exception e)
            {
                out.println("Some Error");
                out.println(e.getMessage());
            }
            %>
        <form name="form1"  action="second.jsp" method="get">
            Username: <input type="text" name="t1"></br>
            Password: <input type="text" name="t2"></br>
            <input type="submit" value="submit">
        </form>
        
    </body>
</html>
