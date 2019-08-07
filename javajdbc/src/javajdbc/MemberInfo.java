package javajdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberInfo extends JFrame {
	
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtAddr;
	private JTextField txtPhone;
	private JTable table;
	
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberInfo frame = new MemberInfo();
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
	public MemberInfo() {
		setTitle("Member Information Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemberInformationForm = new JLabel("Member Information Form");
		lblMemberInformationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberInformationForm.setFont(new Font("배달의민족 도현", Font.PLAIN, 26));
		lblMemberInformationForm.setBounds(179, 0, 419, 69);
		contentPane.add(lblMemberInformationForm);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(152, 98, 116, 21);
		contentPane.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(10);
		txtUserPWD.setBounds(152, 132, 116, 21);
		contentPane.add(txtUserPWD);
		
		JLabel lblNewLabel = new JLabel("User ID");
		lblNewLabel.setBounds(23, 104, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblUserPassword = new JLabel("User Password");
		lblUserPassword.setBounds(23, 138, 107, 15);
		contentPane.add(lblUserPassword);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String sql = "SELECT * From members WHERE userid = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					
					result = pstmt.executeQuery();
					
					while(result.next()) {
						String vuserid = result.getString("Userid");
						String vuserPWD = result.getString("Userpwd");
						String vuseradr = result.getString("address");
						String vuserpnum = result.getString("phonenumber");
						txtUserID.setText(vuserid);
						txtUserPWD.setText(vuserPWD);
						txtAddr.setText(vuseradr);
				        txtPhone.setText(vuserpnum);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnSearch.setBounds(23, 388, 97, 23);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uadr = txtAddr.getText();
		        String aphone = txtPhone.getText();
		        
					String sql = "INSERT INTO members VALUES (?, ?, ?, ?)";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, uid);
						pstmt.setString(2, upwd);
						pstmt.setString(3, uadr);
						pstmt.setString(4, aphone);
					
						int rst = pstmt.executeUpdate();
					
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 생성하였습니다.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dataLoad();
				
			}
		});
		btnAdd.setBounds(132, 388, 97, 23);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uadr = txtAddr.getText();
				String aphone = txtPhone.getText();
				String sql = "UPDATE members SET userpwd = ?, address = ?, phonenumber = ? WHERE userid = ?";
				
				try {
					pstmt = conn.prepareStatement(sql);					
					pstmt.setString(1, upwd);
					pstmt.setString(2, uadr);
					pstmt.setString(3, aphone);
					pstmt.setString(4, uid);
					
					int rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 업데이트 하였습니다.");
						
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 테이블 데이터를 로드하는 메서드 호출
				dataLoad();
				
				
			}// end of actionPerformed()
		});
		btnUpdate.setBounds(241, 388, 97, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String sql = "DELETE FROM members WHERE userid = ? AND userpwd = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					pstmt.setString(2, upwd);
					int rst = pstmt.executeUpdate();
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 삭제 하였습니다.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 테이블 데이터를 로드하는 메서드 호출
				dataLoad();				
				
			}//end of actionPerformed()
		});
		btnDelete.setBounds(350, 388, 97, 23);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(568, 388, 97, 23);
		contentPane.add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText("");
		        txtUserPWD.setText("");
		        txtAddr.setText("");
		        txtPhone.setText("");
			}
		});
		btnReset.setBounds(459, 388, 97, 23);
		contentPane.add(btnReset);
		

		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(23, 169, 57, 15);
		contentPane.add(lblAdress);
		
		JLabel lblPhoneNumber = new JLabel("phone Number");
		lblPhoneNumber.setBounds(23, 202, 107, 15);
		contentPane.add(lblPhoneNumber);
		
		txtAddr = new JTextField();
		txtAddr.setBounds(152, 163, 116, 21);
		contentPane.add(txtAddr);
		txtAddr.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(152, 199, 116, 21);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 79, 482, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블을 클릭했을 때, 행을 추출하고 
				// 추출된 행의 각 컬럼을 왼쪽에 있는 각각의 텍스트 필드에 전달한다.
				dbconnect();
				//행번호를 가지고 온다.
				int row = table.getSelectedRow();
				String uid = (table.getModel().getValueAt(row, 0)).toString();
				
				// uid를 이용하여 db를 검색하고 검색된 결과를 텍스트 필드에 전달
				String sql = "SELECT * From members WHERE userid = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					
					result = pstmt.executeQuery();
					
					while(result.next()) {
						String vuserid = result.getString("Userid");
						String vuserPWD = result.getString("Userpwd");
						String vuseradr = result.getString("address");
						String vuserpnum = result.getString("phonenumber");
						txtUserID.setText(vuserid);
						txtUserPWD.setText(vuserPWD);
						txtAddr.setText(vuseradr);
				        txtPhone.setText(vuserpnum);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
				// -----
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnDataLoad = new JButton("Data Load");
		btnDataLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataLoad();				
				
			}// end od actionPerformed()
		});
		btnDataLoad.setBounds(677, 388, 97, 23);
		contentPane.add(btnDataLoad);
		
		// 테이블 데이터를 로드하는 메서드 호출
		dataLoad();
		
	}// end of MemberInfo()
	
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
	void dataLoad() {
		//JTable에 테이블 데이터를 로드한다.
		dbconnect();
		sql = "SELECT * FROM members";
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeQuery();
			// 질의 결과를 table에 넘겨준다.
			table.setModel(DbUtils.resultSetToTableModel(result));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}// end of dataLoad()
}	
