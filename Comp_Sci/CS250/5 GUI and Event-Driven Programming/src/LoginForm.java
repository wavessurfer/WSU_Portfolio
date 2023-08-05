import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtPassword);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBackground(new Color(255, 127, 80));
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				//check if either username or password is empty
				//if(username.equals("") || password.equals(""))
				if(username.isEmpty() || password.isEmpty())
					//show error message here
					JOptionPane.showMessageDialog(null, "The username and password should not be empty!", "ERROR", JOptionPane.ERROR_MESSAGE);
				//check if username and password match
				else if(!username.equals(password))
					JOptionPane.showMessageDialog(null, "The username and password should match!", "ERROR", JOptionPane.ERROR_MESSAGE);
				else {
					//TODO: Display Main Form
					System.out.println("Should open Main Form now!");
					MainForm form = new MainForm();
					form.show();
				}
			}
		});
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnLogin);
	}

}
