<%@ page import="com.example.shopping.Products" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: BIT
  Date: 2022-05-11
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%

      InitialContext ic = new InitialContext();
      // 2. lookup()
      DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
      // 3. getConnection()
      Connection conn = ds.getConnection();

      PreparedStatement pstmt = conn.prepareStatement("SELECT *FROM PRODUCTS WHERE PROID=?");
      pstmt.setString(1,proId);
      ResultSet rs = pstmt.executeQuery();
      Products selectedItem =null;
      if (rs.next()){
          new Products(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8))
      }
      rs.close();pstmt.close();conn.close();

      Products selectItem = null;
      ArrayList<Products> cartList = (ArrayList<Products>)session.getAttribute("cartList");
      if (cartList==null){//세션에 카트리스트가 없으면 카트리슽트는 선택 모든
          cartList = new ArrayList<Products>();
          session.setAttribute("cartList",cartList);//새로 생성
      }
      int cnt=0;
      Products orderItem = new Products();//주문 상품
      for (int i = 0; i < cartList.size(); i++) {
          orderItem = cartList.get(i);//세션에 추가된 상품을 주문 상품에 추가
          if (orderItem.getProId().equals(proId)){
              cnt++;
              String orderedQuantity = orderItem.getQuantity() + 1; //주문 수량 증가
              orderItem.setQuantity(orderedQuantity);
          }
      }
      if (cnt==0){ //카트에 추가된 적이 없으면
          selectItem.setQuantity(String.valueOf(1)); //최초 주문수량을 1로 설정
          cartList.add(selectItem); //카트리스트에 추가
      }
        //해당 상품의 상세 페이지로
  %>
</body>
</html>
