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

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtAid;
	private JTextField txtApw;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("관리자 페이지");
		lblAdmin.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setBounds(127, 15, 238, 86);
		contentPane.add(lblAdmin);
		
		JLabel lblAdminId = new JLabel("아이디");
		lblAdminId.setBounds(48, 145, 123, 21);
		contentPane.add(lblAdminId);
		
		JLabel lblAdminPw = new JLabel("비밀번호");
		lblAdminPw.setBounds(48, 231, 123, 21);
		contentPane.add(lblAdminPw);
		
		txtAid = new JTextField();
		txtAid.setBounds(257, 142, 166, 27);
		contentPane.add(txtAid);
		txtAid.setColumns(10);
		
		txtApw = new JTextField();
		txtApw.setColumns(10);
		txtApw.setBounds(257, 228, 166, 27);
		contentPane.add(txtApw);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = null;
				String user = "madang";
				String pwd = "madang";
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
						try {
							dbconnect();
							sql = "SELECT * From patient WHERE a_id = ? AND a_pw = ?";// sql 구문 구성
							pstmt = conn.prepareStatement(sql);
							String Aid = txtAid.getText();
							String Apw = txtApw.getText();
							
							pstmt.setString(1, Aid);
							pstmt.setString(2, Apw);
							
							result = pstmt.executeQuery();  // Prepared Statement 구성후 실행
							
							if(result.next()) {	
								if(Aid.equals("hong")) {
								JOptionPane.showMessageDialog(null, "관리자 계정 로그인 성공!");
								// 실행 결과 확인
//								JOptionPane.showMessageDialog(null, "로그인이 성공하였습니다.");
//								현재 화면을 닫고....
								dispose();
//								새로운 화면을 생성한 후 
								AdminPage2 adminPage2 = new AdminPage2();						
//								새로운 화면을 보이게 한다.
								adminPage2.setVisible(true);
								
							}
								
							}else {
								JOptionPane.showMessageDialog(null, "로그인이 실패하였습니다..");
							}
																
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						 			
					
			}
		});
		btnLogin.setBounds(294, 312, 129, 29);
		contentPane.add(btnLogin);
	}
	void dbconnect() {
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
