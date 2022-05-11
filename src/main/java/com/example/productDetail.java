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
        String  proId = request.getParameter("proId");
        System.out.println("proId:"+proId);
        ProductDAO productDAO = ProductDAO.getInstance();
        request.setAttribute("pd", productDAO.selectProducts(String.valueOf(proId)));

        RequestDispatcher ds = request.getRequestDispatcher("/productDetail.jsp");
        ds.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
