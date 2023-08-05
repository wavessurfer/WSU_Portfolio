import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtCourseID;
	private JTextField txtCourseName;
	private JTextField txtInstructor;
	private JTextField txtDateTime;
	private JTextField txtRoom;
	private JComboBox cboCampus;
	private static JTable table;
	
	/**
	 * @return the table
	 */
	public static JTable getTable() {
		return table;
	}

	final DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("Main Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 414);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnuFileAdd = new JMenuItem("Add");
		mnuFileAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
		mnNewMenu.add(mnuFileAdd);
		
		JMenuItem mnuFileModify = new JMenuItem("Modify");
		mnuFileModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnModifyClicked();
			}
		});
		mnNewMenu.add(mnuFileModify);
		
		JMenuItem mnuFileDelete = new JMenuItem("Delete");
		mnuFileDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		mnNewMenu.add(mnuFileDelete);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mnuHelpAbout = new JMenuItem("About");
		mnuHelpAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AboutForm form = new AboutForm();
				form.show();
				
			}
		});
		mnNewMenu_1.add(mnuHelpAbout);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Course ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtCourseID = new JTextField();
		txtCourseID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtCourseID = new GridBagConstraints();
		gbc_txtCourseID.insets = new Insets(0, 0, 5, 0);
		gbc_txtCourseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCourseID.gridx = 1;
		gbc_txtCourseID.gridy = 0;
		contentPane.add(txtCourseID, gbc_txtCourseID);
		txtCourseID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtCourseName = new JTextField();
		txtCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtCourseName = new GridBagConstraints();
		gbc_txtCourseName.insets = new Insets(0, 0, 5, 0);
		gbc_txtCourseName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCourseName.gridx = 1;
		gbc_txtCourseName.gridy = 1;
		contentPane.add(txtCourseName, gbc_txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Instructor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtInstructor = new JTextField();
		GridBagConstraints gbc_txtInstructor = new GridBagConstraints();
		gbc_txtInstructor.insets = new Insets(0, 0, 5, 0);
		gbc_txtInstructor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInstructor.gridx = 1;
		gbc_txtInstructor.gridy = 2;
		contentPane.add(txtInstructor, gbc_txtInstructor);
		txtInstructor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date Time:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtDateTime = new JTextField();
		txtDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtDateTime = new GridBagConstraints();
		gbc_txtDateTime.insets = new Insets(0, 0, 5, 0);
		gbc_txtDateTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateTime.gridx = 1;
		gbc_txtDateTime.gridy = 3;
		contentPane.add(txtDateTime, gbc_txtDateTime);
		txtDateTime.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Room:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtRoom = new JTextField();
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtRoom = new GridBagConstraints();
		gbc_txtRoom.insets = new Insets(0, 0, 5, 0);
		gbc_txtRoom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRoom.gridx = 1;
		gbc_txtRoom.gridy = 4;
		contentPane.add(txtRoom, gbc_txtRoom);
		txtRoom.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Campus:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		cboCampus = new JComboBox();
		cboCampus.setModel(new DefaultComboBoxModel(new String[] {"Winona", "Rochester", "Other"}));
		cboCampus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cboCampus = new GridBagConstraints();
		gbc_cboCampus.insets = new Insets(0, 0, 5, 0);
		gbc_cboCampus.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboCampus.gridx = 1;
		gbc_cboCampus.gridy = 5;
		contentPane.add(cboCampus, gbc_cboCampus);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		contentPane.add(panel, gbc_panel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnAdd);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModifyClicked();
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteClicked();
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnDelete);
		
		table = new JTable();
		// Initialize column headings.
		String[] Headings = { "ID", "Name", "Instructor", "DateTime", "Room", "Campus"
		};
		tableModel.setColumnIdentifiers(Headings);
		// Initialize data.
		String[][] data = {
				{ "CS250", "Algorithm II", "TN", "MW 10:00 AM - 11:50 AM", "WA 209",
				"Winona" },
				{ "CS405", "OS", "TN", "TH 10:00 AM - 11:20 AM", "WA 108", "Winona" }
		};
		for(String[] row : data)
			tableModel.addRow(row);
		table.setModel(tableModel);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 7;
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selIdx = table.getSelectedRow();
				if(selIdx >= 0) { //Make sure a row is selected
					//set each text field text with the corresponding cell's value of the selected row
					txtCourseID.setText(tableModel.getValueAt(selIdx,0).toString());
					txtCourseName.setText(tableModel.getValueAt(selIdx, 1).toString());
					txtInstructor.setText(tableModel.getValueAt(selIdx, 2).toString());
					txtDateTime.setText(tableModel.getValueAt(selIdx,3).toString());
					txtRoom.setText(tableModel.getValueAt(selIdx, 4).toString());
					//for the combobox, you need to check the value and set the	corresponding selected index
					String campus = tableModel.getValueAt(selIdx, 5).toString();
					if( campus.toLowerCase().equals("winona") )
						cboCampus.setSelectedIndex(0);
					else if( campus.toLowerCase().equals("rochester") )
						cboCampus.setSelectedIndex(1);
					else
						cboCampus.setSelectedIndex(2);
					} else {
						JOptionPane.showMessageDialog(null,  "You need to select one row in the table to update");
					}
				}
		});
		contentPane.add(scrollPane, gbc_table);
	}
	

	private void btnAddClicked() {


		if (txtCourseID.getText().isEmpty() && txtCourseID.getText().isEmpty() && txtCourseName.getText().isEmpty() && txtInstructor.getText().isEmpty() && txtDateTime.getText().isEmpty() && txtRoom.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You need to enter the value of at least one text field!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else { String[] newRow = new String[table.getModel().getColumnCount()]; //string array with length = #columns

			newRow[0] = txtCourseID.getText(); //get input on Course ID text field
			newRow[1] = txtCourseName.getText();
			newRow[2] = txtInstructor.getText();
			newRow[3] = txtDateTime.getText();
			newRow[4] = txtRoom.getText();
			newRow[5] = (String) cboCampus.getSelectedItem();
			tableModel.addRow(newRow);
		}

	}
	private void btnModifyClicked() {
		int selIdx = table.getSelectedRow();
		if (txtCourseID.getText().isEmpty() && txtCourseID.getText().isEmpty() && txtCourseName.getText().isEmpty() && txtInstructor.getText().isEmpty() && txtDateTime.getText().isEmpty() && txtRoom.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You need to enter the value of at least one text field!", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		} else {
			
		if(selIdx >= 0) { //Make sure a row is selected
		//update each cell values in the TABLE MODEL
			tableModel.setValueAt(txtCourseID.getText(), selIdx, 0);
			tableModel.setValueAt(txtCourseName.getText(), selIdx, 1);
			tableModel.setValueAt(txtInstructor.getText(), selIdx, 2);
			tableModel.setValueAt(txtDateTime.getText(), selIdx, 3);
			tableModel.setValueAt(txtRoom.getText(), selIdx, 4);
			tableModel.setValueAt(cboCampus.getSelectedItem().toString(), selIdx, 5);
		} else {
			JOptionPane.showMessageDialog(null, "You need to select one row in the table to update", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		}
	}

	private void btnDeleteClicked() {
		int[] selectedRows = table.getSelectedRows();
		if(selectedRows.length > 0) { //Make sure the rows are selected
			//use a for loop from selectedRows.length - 1 down to 0 do
			for(int i = selectedRows.length-1; i >= 0; i--)
				//call tableModel.removeRow() with argument selectedRows[i]
				tableModel.removeRow(selectedRows[i]);
		} else {
			JOptionPane.showMessageDialog(null, "Please select at least one row of the table", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
