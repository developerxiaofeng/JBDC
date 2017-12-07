
package cn.jbdc.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

public class Test3 {
	private static Logger logger=Logger.getLogger(Test3.class.getClass());
	public static void main(String[] args) {
		PreparedStatement state = null;
		Connection conn=null;
		ResultSet rs=null;
		
		
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
			/**
			 String sql="insert into student values(?,?,?)";
			state=conn.prepareStatement(sql);
			state.setInt(1, 12);
			state.setString(2, "小黑");
			state.setString(3, "0000");
			state.executeUpdate();
			state.setInt(1, 13);
			state.setString(2, "小贝");
			state.setString(3, "0000");
			state.executeUpdate(); 
			 **/
			
			/*
			  String sql="select count(*) from student";
			state=conn.prepareStatement(sql);
			rs=  state.executeQuery();
			rs.next();
			System.out.println(rs.getInt(1));
			 
			  
			 */
			/*
			String sql="select * from student";
			state=conn.prepareStatement(sql);
			rs=  state.executeQuery();
			System.out.println("序号\t姓名\t密码");
			while(rs.next()){
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.println(rs.getString(3));
			}
			*/
			Scanner input =new Scanner(System.in);
			System.out.println("请输入用户名");
			String useName = input.next();
			System.out.println("请输入密码"+useName);
			String pwd = input.next();
			String sql="select * from student where name='"+useName+"' and pwd='"+pwd+"'";
			state=conn.prepareStatement(sql);
			rs=  state.executeQuery();
			if(rs.next()){
				System.out.println("登录成功");
				
			}else{
				System.out.println("登录失败");
			}
			
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
}
