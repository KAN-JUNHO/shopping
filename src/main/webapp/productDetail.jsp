<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2022-05-11
  Time: 오후 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    function addToCart() {
        if (confirm('상품을 장바구니에 추가스?')){
            document.addForm.submit();
        }else {
            document.addForm.reset();

        }
    }
</script>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>

  <div class="col-md-6">
<%--      <c:forEach var="product" items="${pd}">--%>
<%--          <div class="col-md-4">--%>
<%--              <h3>${product.proName}</h3>--%>
<%--              <h3>${product.description}</h3>--%>
<%--              <h3>${product.unitPrice}원</h3>--%>
<%--          </div>--%>
            <h3>${pd.proName}</h3>
            <h3>${pd.description}</h3>
            <h3>${pd.unitPrice}</h3>
          <p>
              <b>상품 코드 : </b> <span class="badge badge-danger">${pd.proId}</span>
          </p>
<%--      </c:forEach>--%>

      <p>
          <a href="/Order?proId=${pd.proId}" class="btn btn-info">상품 주문</a>
          <a href="/productList" class="btn btn-secondary">
              상품 목록 &raquo;
          </a>
      </p>
    <form name="addForm" action="addCart.jsp?proId=${product.proId}" method="post">
        <a href="#" class="btn btn-info" onclick="addToCart()">상품 주문 &raquo;</a>
        <a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
        <a href="productList.jsp" class="btn btn-secondary">상품 목록 &raquo;</a>
    </form>
  </div>
    <jsp:include page="footer.jsp"/>

</body>
</html>
