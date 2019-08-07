package components;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class LabelEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
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
	public LabelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 102));
		contentPane.setBackground(new Color(153, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(102, 51, 255), 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJavaDbClass = new JLabel("Java DB Class");
		lblJavaDbClass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblJavaDbClass.setBackground(new Color(0,0,255));
			}
		});
		lblJavaDbClass.setBounds(30, 24, 364, 62);
		contentPane.add(lblJavaDbClass);
		
		JLabel lbltitle = new JLabel("This is title");
		lbltitle.setFont(new Font("굴림", Font.BOLD, 25));
		lbltitle.setForeground(new Color(255, 255, 102));
		lbltitle.setBounds(30, 96, 364, 62);
		contentPane.add(lbltitle);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbltitle.setForeground(new Color(0,0,255));
			}
		});
		btnNewButton.setBounds(30, 176, 97, 23);
		contentPane.add(btnNewButton);
	}
}
