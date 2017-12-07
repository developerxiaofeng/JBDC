/**
 * 使用纯Java方式连接和关闭数据库
 */
package cn.jbdc.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

public class Test2 {
	private static Logger logger=Logger.getLogger(Test2.class.getClass());
	public static void main(String[] args) {
		Statement state = null;
		Connection conn=null;
		String bid="0005";
		String bName= "精通Java";
		String author="小黑";
		String pubComp="五道口出版社";
		String pubDate="2013-8-15";
		int bCount=6;
		float price=45;
		
		
		//1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2、建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","myadmin","0000");
			state=(Statement) conn.createStatement();
			//insert into book value(0001,'精通java','小黑','五道口出版社'，'2013-8-15',6,45)
			StringBuffer sql= new StringBuffer("insert into book value('");
			sql.append(bid+"','");
			sql.append(bName+"','");
			sql.append(author+"','");
			sql.append(pubComp+"','");
			sql.append(pubDate+"',");
			sql.append(bCount+",");
			sql.append(price+");");
			state.execute(sql.toString());
			System.out.println("插入信息成功");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//3、关闭连接
			if(state!=null){
				try {
					state.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				
				try {
					conn.close();
					System.out.println("关闭连接成功");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
