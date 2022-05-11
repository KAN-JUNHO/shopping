package com.example;

import com.example.dao.ProductDAO;
import com.example.shopping.Products;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Order", value = "/Order")
public class Order extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proId = request.getParameter("proId");
        System.out.println("proId order:"+proId);
        ProductDAO productDAO = ProductDAO.getInstance();

        request.setAttribute("pl", productDAO.selectProducts(proId));
        System.out.println(productDAO.selectProducts(proId));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int size=10*1024*1024;
        String uploadPath=request.getRealPath("upload");;
        MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
        String fileInfo = multi.getParameter("fileInfo");

        String  proId = (multi.getParameter("proId"));
        String proName = multi.getParameter("proName");
        int unitPrice = Integer.parseInt((multi.getParameter("unitPrice")));
        String description = multi.getParameter("description");
        String manufacturer = multi.getParameter("manufacturer");
        String category = multi.getParameter("category");
        int noOfStock = Integer.parseInt((multi.getParameter("noOfStock")));

        ProductDAO productDAO = ProductDAO.getInstance();

        try {
            Products products = new Products(proId,proName,unitPrice,description,manufacturer,category,noOfStock);

            System.out.println("bbbbb");
            productDAO.insertProducts(products);

        } catch (Exception e) {
            System.out.println("모름 에러임");
        }
        RequestDispatcher ds = request.getRequestDispatcher("/orderFrm.jsp");
        ds.forward(request,response);
//        response.sendRedirect("/ProductList");
    }

}
