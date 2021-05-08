package com.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc_DB_Reading {

    public static Object[][] readDataFromDb() throws SQLException, ClassNotFoundException {
		int colNum = 0,rowNum = 0;
		ResultSet rs;
	    List lst=new ArrayList();
		Map <Integer,List> mp=new HashMap<Integer,List>();
		int key=0;
		String query="select * from EMP";
		String query1="SELECT COUNT(1) as NumberOfRows FROM EMP";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";//local host 192.168.0.106
		String username = "xe";
		String password = "welcome";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl,username,password);
        Statement stmt = con.createStatement();
        rs= stmt.executeQuery(query1);
        rs.next();
        rowNum=rs.getInt("NumberOfRows");
        System.out.println("NumberOfRows: "+rowNum);
        rs= stmt.executeQuery(query);
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int count = rsMetaData.getColumnCount();
        for(int i = 1; i<=count; i++) {
           lst.add(rsMetaData.getColumnName(i));
        }
        mp.put(key,lst);
		while (rs.next()){
			key=key+1;
		 ResultSetMetaData rsmd = rs.getMetaData();
		 colNum=rsmd.getColumnCount();
		 
		 List lst1=new ArrayList();
		 for(int i=1;i<=colNum;i++) {
		        switch (rsmd.getColumnTypeName(i)) {
		        case "NUMBER":
		            lst1.add(rs.getInt(i));
		            break;
		        case "VARCHAR2":
		            lst1.add(rs.getString(i));
		            break;
		        case "DATE":
                    lst1.add(rs.getDate(i));
		            break;
		        }
		 }
		 mp.put(key, lst1);
    }
		con.close();
		Object [][] obj=new Object[rowNum][colNum];
		// to read data in the form of Map data
	/*	Object [][] obj=new Object[rowNum+1][colNum];
		for( Map.Entry<Integer, List> entry : mp.entrySet() ){
		    System.out.println( entry.getKey()  +   " => " + entry.getValue() );
		    for(int i=0;i<entry.getValue().size();i++)
		    obj[entry.getKey()][i]=entry.getValue().get(i);
		}*/
		//Storing the data into Object
		for(int i=1;i<mp.size();i++) {
			for(int j=0;j<mp.get(i).size();j++) {
				obj[i-1][j]=mp.get(i).get(j);
			}
		}
		//to print the read data
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<colNum;j++) {
				//obj[i-1][j]=mp.get(i).get(j);
				System.out.print(obj[i][j]+ " , ");
			}
			System.out.println();
		}
		return obj;
    }

}
