package javajdbc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static LoginForm frame = new LoginForm();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
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
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToJavadb = new JLabel("Welcome to JAVADB class");
		lblWelcomeToJavadb.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToJavadb.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblWelcomeToJavadb.setBounds(68, 21, 392, 49);
		contentPane.add(lblWelcomeToJavadb);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(250, 113, 77, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(250, 171, 77, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//
				dispose();
				JoinForm joinform = new JoinForm();
				joinform.setVisible(true);
			}
		});
		btnJoin.setBounds(250, 253, 97, 23);
		contentPane.add(btnJoin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(394, 253, 97, 23);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(41, 97, 178, 139);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(359, 110, 132, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 168, 132, 21);
		contentPane.add(textField_1);
		
		
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
					String uid = textField.getText();
					String upwd = textField_1.getText();
					
					pstmt.setString(1, uid);
					pstmt.setString(2, upwd);
					
					result = pstmt.executeQuery();  // Prepared Statement 구성후 실행
					
					if(result.next()) {				// 실행 결과 확인
//						JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.");
//						현재 화면을 닫고....
						frame.dispose();
//						새로운 화면을 생성한 후 
						MemberInfo membInfo = new MemberInfo();						
//						새로운 화면을 보이게 한다.
						membInfo.setVisible(true);
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
		
	}

}
	

