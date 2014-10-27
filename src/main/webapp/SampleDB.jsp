<%@page contentType="text/html" pageEncoding="UTF-8"%>

     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

     <sql:setDataSource dataSource="jdbc/SampleDB" />

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <title>Speak To Me, Please</title>
        </head>
        <body>

        <h1>Speak To Me, Please</h1>

        Welcome to the Acme Corp. feedback site. 
         
        <h2>Here's what your fellow workers have said:</h2> 
        <table border='1'>
          <tr><th>Worker</th><th>Comment</th></tr>

       <sql:query var="qryPosts" >
                  SELECT lastname, firstname FROM app.student
          </sql:query>

       <c:forEach var="row" items="${qryPosts.rows}">
	        <tr>
               <td><c:out value="${row.lastname}" /></td>
                  <td><c:out value="${row.firstname}" /></td>
	        </tr>
          </c:forEach>
        </table>

        </body>
        </html>
