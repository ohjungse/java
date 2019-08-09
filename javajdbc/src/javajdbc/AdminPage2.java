package javajdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPage2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtPid;
	private JTextField txtPname;
	private JTextField txtPnum;
	private JTextField txtPtell;
	private JTextField txtPaddr;
	private JTextField txtTname;
	private JTable table;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	String sql = null;

	public AdminPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 811);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("환자번호");
		label.setBounds(43, 15, 82, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("환자명");
		label_1.setBounds(43, 92, 82, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("주민번호");
		label_2.setBounds(43, 184, 82, 21);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("전화번호");
		label_3.setBounds(43, 278, 82, 21);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("주소");
		label_4.setBounds(43, 379, 82, 21);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("내원과");
		label_5.setBounds(43, 476, 82, 21);
		contentPane.add(label_5);
		
		txtPid = new JTextField();
		txtPid.setBounds(201, 15, 166, 27);
		contentPane.add(txtPid);
		txtPid.setColumns(10);
		
		txtPname = new JTextField();
		txtPname.setColumns(10);
		txtPname.setBounds(201, 89, 166, 27);
		contentPane.add(txtPname);
		
		txtPnum = new JTextField();
		txtPnum.setColumns(10);
		txtPnum.setBounds(201, 181, 166, 27);
		contentPane.add(txtPnum);
		
		txtPtell = new JTextField();
		txtPtell.setColumns(10);
		txtPtell.setBounds(201, 275, 166, 27);
		contentPane.add(txtPtell);
		
		txtPaddr = new JTextField();
		txtPaddr.setColumns(10);
		txtPaddr.setBounds(201, 379, 166, 27);
		contentPane.add(txtPaddr);
		
		txtTname = new JTextField();
		txtTname.setColumns(10);
		txtTname.setBounds(201, 473, 166, 27);
		contentPane.add(txtTname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(426, 49, 279, 448);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dbconnect();
				//행번호를 가지고 온다.
				int row = table.getSelectedRow();
				String pid = (table.getModel().getValueAt(row, 0)).toString();
				
				// uid를 이용하여 db를 검색하고 검색된 결과를 텍스트 필드에 전달
				String sql = "SELECT * From patient WHERE p_id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pid);
					
					result = pstmt.executeQuery();
					
					while(result.next()) {
						String vpid = result.getString("p_id");
						String vpname = result.getString("p_name");
						String vpnum = result.getString("p_num");
						String vptell = result.getString("p_tell");
						String vpaddr = result.getString("p_addr");
						String vtname = result.getString("t_name");
						txtPid.setText(vpid);
						txtPname.setText(vpname);
						txtPnum.setText(vpnum);
				        txtPtell.setText(vptell);
				        txtPaddr.setText(vpaddr);
				        txtTname.setText(vtname);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String pid = txtPid.getText();
				String sql = "SELECT * From patient WHERE p_id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pid);
					
					result = pstmt.executeQuery();
					
					while(result.next()) {
						String vpid = result.getString("p_id");
						String vpname = result.getString("p_name");
						String vpnum = result.getString("p_num");
						String vptell = result.getString("p_tell");
						String vpaddr = result.getString("p_addr");
						String vtname = result.getString("t_name");
						txtPid.setText(vpid);
						txtPname.setText(vpname);
						txtPnum.setText(vpnum);
				        txtPtell.setText(vptell);
				        txtPaddr.setText(vpaddr);
				        txtTname.setText(vtname);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}dataLoad();
			}
		});
		btnSearch.setBounds(43, 579, 129, 29);
		contentPane.add(btnSearch);
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String vpid = txtPid.getText();
				String vpname = txtPname.getText();
				String vpnum = txtPnum.getText();
				String vptell = txtPtell.getText();
				String vpaddr = txtPaddr.getText();
				String vtname = txtTname.getText();	        
				
				
					String sql = "INSERT INTO patient VALUES (?, ?, ?, ?, ?, ?)";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, vpid);
						pstmt.setString(2, vpname);
						pstmt.setString(3, vpnum);
						pstmt.setString(4, vptell);
						pstmt.setString(5, vpaddr);
						pstmt.setString(6, vtname);
					
						int rst = pstmt.executeUpdate();
					
					if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 생성하였습니다.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dataLoad();
			}
		});
		btnAdd.setBounds(223, 579, 129, 29);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String vpid = txtPid.getText();
				String vpname = txtPname.getText();
				String vpnum = txtPnum.getText();
				String vptell = txtPtell.getText();
				String vpaddr = txtPaddr.getText();
				String vtname = txtTname.getText();	 
				String sql = "UPDATE patient SET p_name = ?, p_num = ?, p_tell = ?, p_addr = ?, t_name = ? WHERE p_id = ?";
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vpid);
					pstmt.setString(2, vpname);
					pstmt.setString(3, vpnum);
					pstmt.setString(4, vptell);
					pstmt.setString(5, vpaddr);
					pstmt.setString(6, vtname);
					
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
		btnUpdate.setBounds(399, 579, 129, 29);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String vpid = txtPid.getText();
				String vpname = txtPname.getText();
				
				String sql = "DELETE FROM patient WHERE p_id = ? AND p_name = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, vpid);
					pstmt.setString(2, vpname);
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
		btnDelete.setBounds(575, 579, 129, 29);
		contentPane.add(btnDelete);
		
		JButton btnDataLoad = new JButton("데이타 새로고침");
		btnDataLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataLoad();
			}
		});
		btnDataLoad.setBounds(43, 642, 166, 29);
		contentPane.add(btnDataLoad);
		
		JButton btnExit = new JButton("종료");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(575, 642, 129, 29);
		contentPane.add(btnExit);
		
		JButton button = new JButton("차트보기");
		button.setBounds(223, 642, 129, 29);
		contentPane.add(button);
		
		dataLoad();
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
	void dataLoad() {
		//JTable에 테이블 데이터를 로드한다.
		dbconnect();
		sql = "SELECT * FROM patient";
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
