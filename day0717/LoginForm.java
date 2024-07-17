package com.ureca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ureca.util.DBUtil;

@SuppressWarnings("serial")
public class LoginForm extends JFrame  implements ActionListener
{
    public JTextField tf_id;
    public JPasswordField tf_pass;
    public JButton bt_login,bt_join;
	JLabel la_id, la_pass, la_img;

	JFrame serviceFrame;
	DBUtil dbUtil;
	
  public LoginForm()
	{		
	    dbUtil = DBUtil.getInstance();
		setTitle("Login Form");
		
		tf_id = new JTextField();			  
		tf_pass = new JPasswordField();
		
		bt_login = new JButton("로그인");
		bt_join = new JButton("신규가입");
	
	    la_id = new JLabel("I  D");
		la_pass = new JLabel("Password");
		
		tf_id.setBounds(80,30,100,25);
		tf_pass.setBounds(80,65,100,25);
		bt_login.setBounds(90,110,80,25);
		bt_join.setBounds(190,30,90,25);
		la_id.setBounds(8,30,80,25);
		la_pass.setBounds(8,65,90,25);
		
		setLayout(null);
		add(tf_id);
		add(tf_pass);
		add(bt_login);
		add(bt_join);
		add(la_id);
		add(la_pass);
		
		setBounds(400,300,300,180);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		serviceFrame = new JFrame("서비스화면");
		la_img = new JLabel(new ImageIcon("image/won.jpg"));
		serviceFrame.add(la_img);
		serviceFrame.setBounds(200,200,600,300);
//		serviceFrame.setVisible(true);
	
		bt_login.addActionListener(this);
	}//생성자   
  
   public void showMsg(String msg) {
      JOptionPane.showMessageDialog(this, msg);
   }
    
   public static void main(String[] args) {
	  new LoginForm();
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌렸어요~~~~~");
		String id = tf_id.getText();
		String pwd = tf_pass.getText();
		loginProcess(id,pwd);
	}
	
	public void loginProcess(String id, String pwd){//(DB)로그인 처리
		
		//String sql="select~";//DB에 id,pwd 검사(존재,일치)
//		String sql="select * from member";
//		String sql="select id,pwd from member";
//		String sql="select id,pwd from member where id='gildong' and pwd='1234'";
//		String sql="select pwd from member where id='gildong'";
				
		try {
			//1.드라이버 로딩
			//2.연결객체
			Connection conn = dbUtil.getConnection();
			
//			String sql="select count(*) cnt from member where id='gildong' and pwd='1234'";
			String sql="select count(*) cnt from member where id='"+id+"' and pwd='"+pwd+"'";
			//select count(*) cnt from member where id='a' or 1=1 #' and pass='1234'
			//3.실행객체
			Statement stmt = conn.createStatement();
			
			//4.결과저장
			ResultSet rs = stmt.executeQuery(sql);//실행시점!! (DB에 sql실행 요청)
			
//			rs.next(); ==> 리턴 boolean  ==> 결과행이 존재하면 true  ==>주로 if() 또는 while()과 함께 사용
			rs.next();//4-1 (행)
//			rs.getInt(1);//4-2 (열)
			int cnt = rs.getInt("cnt");//4-2 (열)
			
			if(cnt > 0) {
				showMsg("로그인성공!!^O^");
			    serviceFrame.setVisible(true);
			}
			else {showMsg("로그인실패!!T.T");}
			
			
			//5.자원반환(마무리)
			dbUtil.close(rs,stmt,conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5.자원반환(마무리)
			
//			rs.close();
//			stmt.close();
//			conn.close();
			
		}
	}//loginProcess
	
	
	
}//LoginForm