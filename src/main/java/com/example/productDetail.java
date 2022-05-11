package com.example;

import com.example.dao.ProductDAO;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "productDetail", value = "/productDetail")
public class productDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int proId = Integer.parseInt(request.getParameter("proId"));

        ProductDAO productDAO = ProductDAO.getInstance();
        try {
//            System.out.println(ProductDAO.selectProducts(proId));
            request.setAttribute("pd", ProductDAO.selectProducts(proId));
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher ds = request.getRequestDispatcher("/productDetail.jsp");
        ds.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
