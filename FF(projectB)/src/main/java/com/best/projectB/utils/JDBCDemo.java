package com.best.projectB.utils;

import com.best.projectB.entity.FPV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {
        //jdbc:mysql://localhost:3306/FPV?allowPublicKeyRetrieval=true

        String sql = "select * from fpv_01 where id = 2";


        List<FPV> fpvs = executeJDBC(sql, "jdbc:mysql://localhost:3306/FPVBB?allowPublicKeyRetrieval=true", "root", "root");

        System.out.println(fpvs);
    }


    public static List<FPV> executeJDBC(String sql, String sqlURL, String username, String password) throws SQLException {
        //连接
        Connection conn = null;
        //说明
        Statement stmt = null;

        try {

            conn = DriverManager.getConnection(sqlURL, username, password);


            String executeSQL = sql;
            //预编译
            stmt = conn.prepareStatement(executeSQL);

            //执行sql语句
            ResultSet rs = stmt.executeQuery(sql);

            List<FPV> list = new ArrayList<>();
            while (rs.next()) {

                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String FC = rs.getString("fc");

                FPV fpv = new FPV();
                fpv.setId(id);
                fpv.setName(name);
                fpv.setFc(FC);


                list.add(fpv);
            }


            return list;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            assert stmt != null;
            stmt.close();
            conn.close();
        }


    }

}
