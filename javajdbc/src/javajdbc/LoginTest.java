package javajdbc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTest frame = new LoginTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(32, 79, 57, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserPwd = new JLabel("User PWD");
		lblUserPwd.setBounds(32, 124, 57, 15);
		contentPane.add(lblUserPwd);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(139, 76, 179, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setBounds(139, 121, 179, 21);
		contentPane.add(txtUserPWD);
		txtUserPWD.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB Connection
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet result = null;
				String sql = null;
				String user = "madang";
				String pwd = "madang";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					conn = DriverManager.getConnection(url, user, pwd); 
					
					sql = "SELECT * From members WHERE userid = ? AND userpwd = ?";// sql 구문 구성
					pstmt = conn.prepareStatement(sql);
					String uid = txtUserID.getText();
					String upwd = txtUserPWD.getText();
					
					pstmt.setString(1, uid);
					pstmt.setString(2, upwd);
					
					result = pstmt.executeQuery();  // Prepared Statement 구성후 실행
					
					if(result.next()) {				// 실행 결과 확인
						JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다..");
					}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
 
				
				
				
				
				
				
			}
		});
		btnLogin.setBounds(68, 179, 97, 23);
		contentPane.add(btnLogin);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(221, 179, 97, 23);
		contentPane.add(btnCancel);
		
		JLabel lblLoginTest = new JLabel("Login Test");
		lblLoginTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTest.setFont(new Font("배달의민족 도현", Font.BOLD, 20));
		lblLoginTest.setBounds(81, 20, 259, 33);
		contentPane.add(lblLoginTest);
	}

}
