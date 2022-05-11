<%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2022-05-11
  Time: 오후 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <jsp:include page="menu.jsp"/>
    <form action="/ProductList" method="post" enctype="multipart/form-data"><br>
<%--        아이디 : <input type="text" name="proId"><br>--%>
<%--        이름 : <input type="text" name="proName"><br>--%>
<%--        가격 : <input type="number" name="unitPrice"><br>--%>
<%--        설명 : <input type="text" name="description"><br>--%>
<%--        제품 : <input type="text" name="manufacturer"><br>--%>
<%--        카테고리 : <input type="text" name="category"><br>--%>
<%--        재고수 <input type="number" name="noOfStock"><br>--%>

        파일정보 : <input type="text" name="fileInfo"><p>
            <input type="file" name="fileName"><p>
        <input type="submit" value="보내"><br>
    </form>
</body>
</html>
