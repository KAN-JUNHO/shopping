package com.example;

import com.example.dao.ProductDAO;
import com.example.shopping.Products;

import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductList", value = "/ProductList")
public class ProductList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = ProductDAO.getInstance();
        try {
            request.setAttribute("pl", ProductDAO.selectProductAll());
        } catch (SQLException | NamingException e) {
            System.out.println("ero");
            throw new RuntimeException(e);
        }
//
        RequestDispatcher ds = request.getRequestDispatcher("/productList.jsp");
        ds.forward(request,response);
//        response.sendRedirect("/ProductList");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
