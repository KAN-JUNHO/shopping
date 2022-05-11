<%@ page import="com.example.dao.ProductDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2022-05-11
  Time: 오전 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">상품 목록</h1>
        </div>
    </div>
    <div class="container">
        <div class="row" align="center">
            <c:forEach var="item" items="${pl}">
                <div class="col-md-4">
                    <h3>${item.proName}</h3>
                    <h3>${item.description}</h3>
                    <h3>${item.unitPrice}원</h3>
                </div>

                <a href="productDetail?proId=${item.proId}"
                   class="btn btn-secondary" role="button">상세정보 &raquo;</a>
                </p>
            </c:forEach>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
    <p>

</body>
</html>
