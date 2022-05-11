<%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2022-05-11
  Time: 오후 2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <form action="addProduct.jsp" name="newProduct" class="form-horizontal" method="post">
            <div class="form-group row">
                <label class="col-sm-2">상품 코드</label>
                <div class="col-sm-3">
                    <input type="text" id="proId" name="proId" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-primary" value="등록">
                </div>
            </div>
        </form>
    </div>
</body>
</html>
