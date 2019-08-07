package components;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class TextInputEx extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextInputEx frame = new TextInputEx();
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
	public TextInputEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setToolTipText("this is tooltip...");
		txtName.setText("intput your name");
		txtName.setBounds(125, 34, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(30, 37, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contents");
		lblNewLabel_1.setBounds(30, 95, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(30, 309, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(125, 91, 116, 113);
		contentPane.add(textArea);
		
		txtPwd = new JPasswordField();
		txtPwd.setBounds(125, 302, 116, 29);
		contentPane.add(txtPwd);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(99, 399, 97, 23);
		contentPane.add(btnStore);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				textArea.setText("");
				txtPwd.setText("");
			}
		});
		btnReset.setBounds(221, 399, 97, 23);
		contentPane.add(btnReset);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(317, 87, 135, 23);
		contentPane.add(tglbtnNewToggleButton);
		
		JCheckBox chkCpp = new JCheckBox("C++");
		chkCpp.setBounds(317, 129, 48, 23);
		contentPane.add(chkCpp);
		
		JCheckBox chkJava = new JCheckBox("Java");
		chkJava.setBounds(382, 129, 70, 23);
		contentPane.add(chkJava);
		
		ButtonGroup grp = new ButtonGroup();
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setBounds(316, 181, 121, 23);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setBounds(451, 181, 121, 23);
		contentPane.add(rdoFemale);
		
		grp.add(rdoMale);
		grp.add(rdoFemale);
		
		String[] pet = {"Make selection", "cat", "Dog", "Rabbit", "Pig"};
		
		JList list = new JList(pet);
		list.setBounds(310, 210, 200, 100);
		contentPane.add(list);
		
		JComboBox combo = new JComboBox(pet);
		combo.setBounds(510,210, 170, 40);
		contentPane.add(combo);
	}
}
