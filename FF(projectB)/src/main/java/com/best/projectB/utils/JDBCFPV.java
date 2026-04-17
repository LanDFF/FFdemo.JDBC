package com.best.projectB.utils;

import com.best.projectB.entity.FPV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCFPV {

    public static void main(String[] args) throws SQLException {
        JDBCFPV jdbcfpv = new JDBCFPV();

        List<FPV> list = jdbcfpv.execute();

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).id);
//            System.out.println(list.get(i).name);
//            System.out.println(list.get(i).FC);
//        }
    }

    public static List<FPV> getList() throws SQLException {
        JDBCFPV jdbcfpv = new JDBCFPV();
        return jdbcfpv.execute();
    }
    public List<FPV> execute() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        //	1.加载驱动类
        try {
            Class.forName("com.mysql.jdbc.Driver");


            //2.建立连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FPV?allowPublicKeyRetrieval=true", "root", "root");

            //3.编写sql语句
            String sql = "select * from table_fpv;";

            //4.创建执行体
            stmt = conn.prepareStatement(sql);

            //5.执行sql语
            ResultSet rs = stmt.executeQuery(sql);

            List<FPV> list = new ArrayList<>();
            while (rs.next()) {

                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String FC = rs.getString("FC");

                FPV fpv = new FPV();
                fpv.setId(id);
                fpv.setName(name);
//                fpv.setFC(FC);

                list.add(fpv);
            }
            return list;
            //6.处理结果
//       if (row>-1){
//           System.out.println("插入成功！");
//       }
//       else{
//           System.out.println("插入失败！");
//       }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            assert conn != null;
            conn.close();
            assert stmt != null;
            stmt.close();
        }

    }


}
