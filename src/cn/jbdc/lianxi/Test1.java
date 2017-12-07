/**
 * 使用纯Java方式连接和关闭数据库
 */
package cn.jbdc.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Test1 {
	private static Logger logger=Logger.getLogger(Test1.class.getClass());
	public static void main(String[] args) {
		Connection conn=null;
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
			System.out.println("建立连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{//3、关闭连接
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
