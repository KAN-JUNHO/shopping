package com.example.dao;

import com.example.shopping.Products;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    private static ProductDAO dao = new ProductDAO();

    public ProductDAO() {}


    public static ProductDAO getInstance(){
        return dao;
    }
    public Connection getConnection() throws NamingException, SQLException {

        InitialContext ic = new InitialContext();
        // 2. lookup()
        DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
        // 3. getConnection()
        Connection conn = ds.getConnection();

        return conn;
    }
    public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
        conn.close();
    }//연결 닫기
    public void close(Connection conn, PreparedStatement pstmt) throws SQLException {
        conn.close();
    }//연결 닫기
    public static ArrayList<Products> selectProductAll() throws SQLException, NamingException {
        Connection conn = dao.getConnection();
        String sql = "SELECT * FROM Products";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ArrayList<Products> list = new ArrayList<>();

        while (rs.next()) {
            Products ProductDTO = new Products();
            ProductDTO.setProId(rs.getString(1));
            ProductDTO.setProName(rs.getString(2));
            ProductDTO.setUnitPrice(rs.getInt(3));
            ProductDTO.setDescription(rs.getString(4));
            ProductDTO.setManufacturer(rs.getString(5));
            ProductDTO.setCategory(rs.getString(6));
            ProductDTO.setNoOfStock(rs.getInt(7));
            list.add(ProductDTO);
        }

        return list;
    } //모든 멤버 조회
    public static Products selectProducts(int proId) throws SQLException, NamingException {

        Connection conn = dao.getConnection();
        String sql = "SELECT * FROM Products WHERE proId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, proId);
        ResultSet rs = pstmt.executeQuery();

        Products products = null;
        while (rs.next()) {
            products = new Products();
            products.setProId(rs.getString(1));
            products.setProName(rs.getString(2));
            products.setUnitPrice(rs.getInt(3));
            products.setDescription(rs.getString(4));
            products.setManufacturer(rs.getString(5));
            products.setCategory(rs.getString(6));
            products.setNoOfStock(rs.getInt(7));
        }
        System.out.println(products);
        return products;
    }

    public static int insertProducts(Products dto) throws SQLException, NamingException {
        Connection conn = dao.getConnection();
        System.out.println("inserting before");
        String sql = "insert into Products values(?, ?, ?, ?, ?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, dto.getProId());
        pstmt.setString(2,dto.getProName());
        pstmt.setInt(3,dto.getUnitPrice());
        pstmt.setString(4,dto.getDescription());
        pstmt.setString(5,dto.getManufacturer());
        pstmt.setString(6,dto.getCategory());
        pstmt.setInt(7,dto.getNoOfStock());
        int rs = pstmt.executeUpdate();
        System.out.println("inserting before2");
        return rs;
    }//회원 정보 삽입
}
