package com.sqs.training;


import org.junit.Test;

import java.sql.*;

public class DBTest {

    Connection conn;
    String url;
    Statement stmt;


    public DBTest  ()throws Exception{


    url =  "jdbc:sqlite:C:/Users/6401/Downloads/chinook/chinook.db";

    //C:/Users/6401/Downloads/chinook

    conn = DriverManager.getConnection(url);
    stmt =  conn.createStatement();

}



    @Test

    public void test1() throws Exception{



        ResultSet rs = stmt.executeQuery("Select name from genres");

        while (rs.next() ){
            System.out.println("rec: "+ rs.getString("name"));
        }

    }

    @Test
    public void test2() throws  Exception{



        ResultSet rs = stmt.executeQuery(" Select \n" +
                "\tcount(t.name),\n" +
                "\tm.name\n" +
                "from\n" +
                "\ttracks as t join media_types as m on\n" +
                "\tt.mediatypeid = m.mediatypeid\n" +
                "group by m.name\n" +
                "order by 1 desc");

        while (rs.next())
            System.out.println( rs.getString(2) + " = " + rs.getString(1));


    }


}


