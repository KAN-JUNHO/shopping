<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<jsp:include page="menu.jsp"/>

    <%
        String greeting = "Welcome to Conan's HOME";
        String tagline = "내이름은 코난, 함정이죠";

    %>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3"><%=greeting%></h1>
            <h5 class="col-md-4">dsf</h5>
            <h5 class="col-md-4">sae</h5>
        </div>
    </div>
    <main role="main">
        <div class="container">
            <div class="text">
                <h3><%=tagline%></h3>
            </div>
            <hr>
        </div>
    </main>
<jsp:include page="footer.jsp"/>
</body>
</html>