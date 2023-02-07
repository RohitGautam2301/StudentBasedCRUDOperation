package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private static final String url = "jdbc:mysql://localhost:3306/palle";
	private static final String username = "root";
	private static final String password = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private int sno;
	private String sname;
	private String sub;
	private String email;
	
	public Student(int sno, String sname, String sub, String email) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sub = sub;
		this.email = email;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static void creating() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "create table student(sno int primary key auto_increment, "
					+ "sname varchar(50) not null, sub varchar(50), email varchar(50) unique)";
			s = con.createStatement();
			s.executeUpdate(qry);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (s != null) {
					s.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  static void inserting(String sname, String sub, String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "insert into student (sname, sub, email) values (?, ?, ?)";
			ps = con.prepareStatement(qry);
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void update(int sno, String email, String sub) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "update student set email = ?, sub = ? where sno = ?";
			ps = con.prepareStatement(qry);
			ps.setString(1, email);
			ps.setString(2, sub);
			ps.setInt(3, sno);
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete(int sno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "delete from student where sno = ?";
			ps = con.prepareStatement(qry);
			ps.setInt(1, sno);
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "select * from student";
			s = con.createStatement();
			rs = s.executeQuery(qry);
			while (rs.next()) {
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
				System.out.println("*************");
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (s != null) {
					s.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<Student> reading() {
		ArrayList<Student> alStud = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			String qry = "select * from student";
			s = con.createStatement();
			rs = s.executeQuery(qry);
			while (rs.next()) {
				int i = rs.getInt("sno");
				String n = rs.getString("sname");
				String s = rs.getString("sub");
				String e = rs.getString("email");
				Student stud = new Student (i, n, s,e);
				alStud.add(stud);
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (s != null) {
					s.close();
				}
				if (con != null) {
					con.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return alStud;
	}
}


