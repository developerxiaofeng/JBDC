package cn.jbdc.lianxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;
import com.sun.glass.ui.Menu;

public class JavaJdbc {
	public static void main(String[] args) {
		
		Menu();
	}
	
	
	private static void Menu() {
		System.out.println("欢迎来到XX");
		Scanner input =new Scanner(System.in);
		System.out.println("1、用户登录\n2、用户注册\n3、退出登录");
		int result=input.nextInt();
		switch (result) {
		case 1:
			login();
			break;
		case 2:
			register();
			break;
		default:
			break;
		}
		
	}


	/**
	 * 注册
	 */
	public static void register(){
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/easybuy","root","root");
			System.out.println("请输入你的登录名");
			Scanner input =new Scanner(System.in);
			String loginName=input.next();
			System.out.println("请输入你的用户名");
			String useName=input.next();
			System.out.println("请输入你的密码");
			String password=input.next();
			System.out.println("请输入你的性别,0==>男；1==>女");
			int sex=input.nextInt();
			String sql="insert into easybuy_user(loginName,userName,password,sex) "+
					"values('"+loginName+"','"+useName+"','"+password+"','"+sex+"')";
			st =(Statement) con.createStatement();
			int result =st.executeUpdate(sql);
			if(result>0){
				System.out.println("注册成功");
			}else{
				System.out.println("注册失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Menu();
	}

	public static void login(){
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/easybuy","root","root");
			System.out.println("请输入你的登录名");
			Scanner input =new Scanner(System.in);
			String loginName=input.next();

			System.out.println("请输入你的密码");
			String password=input.next();
			String sql="select * from easybuy_user where loginName='"+loginName
					+"' and password='"+password
					+"'";
			System.out.println(sql);
			st =(Statement) con.createStatement();
			rs =st.executeQuery(sql);

			while(rs.next()){
				System.out.println("登录成功");
				System.out.println(rs.getString(2)+rs.getString(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		secondmenu();
	}
	private static void secondmenu() {
		Scanner input =new Scanner(System.in);
		System.out.println("1、修改 2、删除 3、返回上级菜单");
		int result=input.nextInt();
		switch (result) {
		case 1:
			update();
			break;
		case 2:
			delete(); 
			break;
		case 3:

			break;
		default:
			break;
		}

	}
	private static void update() {
		
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/easybuy","root","root");
			System.out.println("请输入你要修改的登录名");
			Scanner input =new Scanner(System.in);
			String loginName=input.next();
			System.out.println("请输入你要修改之后的用户名");
			String useName=input.next();
			System.out.println("请输入你修改之后的密码");
			String password=input.next();
			System.out.println("请输入你修改之后的的性别,0==>男；1==>女");
			int sex=input.nextInt();
			String sql="update easybuy_user set userName='"+useName+"',password='"+password+"',sex='"+sex+"'"+
			" where  loginName='"+loginName+"'";
			st =(Statement) con.createStatement();
			int result =st.executeUpdate(sql);
			if(result>0){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	private static void delete() {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/easybuy","root","root");
			System.out.println("请输入你要修改的登录名");
			Scanner input =new Scanner(System.in);
			String loginName=input.next();
			String sql="delete from easybuy_user where  loginName='"+loginName+"'";
			st =(Statement) con.createStatement();
			int result =st.executeUpdate(sql);
			if(result>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
