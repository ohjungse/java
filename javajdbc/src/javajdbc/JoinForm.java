package javajdbc;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinForm extends JFrame {

	private JPanel contentPane;
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet result;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtAddr;
	private JTextField txtPhone;
	private JButton btnJoin;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					JoinForm frame = new JoinForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public JoinForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoinForm = new JLabel("Join Form");
		lblJoinForm.setFont(new Font("배달의민족 도현", Font.ITALIC, 26));
		lblJoinForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinForm.setBounds(206, 10, 257, 44);
		contentPane.add(lblJoinForm);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(36, 105, 83, 15);
		contentPane.add(lblUserId);
		
		JLabel lblUserPwd = new JLabel("User PWD");
		lblUserPwd.setBounds(36, 152, 83, 15);
		contentPane.add(lblUserPwd);
		
		JLabel lblUserAddr = new JLabel("User Addr");
		lblUserAddr.setBounds(36, 202, 83, 15);
		contentPane.add(lblUserAddr);
		
		JLabel lblUserPhone = new JLabel("User Phone");
		lblUserPhone.setBounds(36, 245, 83, 15);
		contentPane.add(lblUserPhone);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(150, 102, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(150, 149, 116, 21);
		contentPane.add(txtUserPWD);
		
		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(150, 199, 116, 21);
		contentPane.add(txtAddr);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(150, 242, 116, 21);
		contentPane.add(txtPhone);
		
		btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uadr = txtAddr.getText();
		        String aphone = txtPhone.getText();		        	        
		        String sql = "INSERT INTO members VALUES (?, ?, ?, ?)";
		        String sql1 = "SELECT * FROM members WHERE userid = ?";	        	
		       
		        try {
					pstmt = conn.prepareStatement(sql1);
					pstmt.setString(1, uid);					
					result = pstmt.executeQuery();
					if(result.next()) {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
					}else {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, uid);
						pstmt.setString(2, upwd);
						pstmt.setString(3, uadr);
						pstmt.setString(4, aphone);
					
						int rst = pstmt.executeUpdate();						
						if(rst==1)JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.");
					}
						
					
					
					
		        }
		        
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				
		        
		        
			}
			
		});
		btnJoin.setBounds(36, 332, 97, 23);
		contentPane.add(btnJoin);
	}
	
	
	public void dbconnect() {
		//연결 설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang","madang");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
		} 
		
		
	}// end of dbconnect()

}
