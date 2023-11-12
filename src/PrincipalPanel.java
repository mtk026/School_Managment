import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Helper.DbHelper;
import Helper.Helper;
import Model.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrincipalPanel extends JFrame {
	static Teacher princibal = new Teacher();

	private static final long serialVersionUID = 1L;
	private JPanel cpnPrincibal;
	private JTextField txtTeacherName;
	private JTextField txtTeacherTc;
	private JTextField txtTeacherPassword;
	private JTable tblTeacher;
	private DefaultTableModel principalModel = null;
	private Object[] teacherData = null;
	private DbHelper connection = null;
	private JTextField txtTeacherLastName;
	private JTextField txtTeacherLecture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalPanel frame = new PrincipalPanel(princibal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public PrincipalPanel(Teacher princibal) throws SQLException {

		principalModel = new DefaultTableModel();
		Object[] colTeacherName = new Object[6];
		colTeacherName[0] = "Id";
		colTeacherName[1] = "Name";
		colTeacherName[2] = "Last Name";
		colTeacherName[3] = "T.C.No";
		colTeacherName[4] = "Phone Number";
		colTeacherName[5] = "Password";
		principalModel.setColumnIdentifiers(colTeacherName);
		teacherData = new Object[6];
		for (int i = 0; i < princibal.getTeacherList().size(); i++) {

			teacherData[0] = princibal.getTeacherList().get(i).getId();
			teacherData[1] = princibal.getTeacherList().get(i).getName();
			teacherData[2] = princibal.getTeacherList().get(i).getLastName();
			teacherData[3] = princibal.getTeacherList().get(i).getTc();
			teacherData[4] = princibal.getTeacherList().get(i).getPhoneNumber();
			teacherData[5] = princibal.getTeacherList().get(i).getPassWord();
			principalModel.addRow(teacherData);
		}

		setTitle("PrincibalPage");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 750, 500);
		cpnPrincibal = new JPanel();
		cpnPrincibal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cpnPrincibal);
		cpnPrincibal.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoşgeldiniz, Sayın " + princibal.getName());
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 182, 49);
		cpnPrincibal.add(lblNewLabel);

		JButton btnPrincibalLongOut = new JButton("Çıkış");
		btnPrincibalLongOut.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrincibalLongOut.setBounds(611, 25, 113, 23);
		cpnPrincibal.add(btnPrincibalLongOut);

		JTabbedPane tpnPrincibal = new JTabbedPane(JTabbedPane.TOP);
		tpnPrincibal.setFont(new Font("Arial", Font.BOLD, 14));
		tpnPrincibal.setToolTipText("Principal Page");
		tpnPrincibal.setBounds(0, 83, 708, 367);
		cpnPrincibal.add(tpnPrincibal);

		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setToolTipText("Principal Page");
		tpnPrincibal.addTab("Principal Page", null, pnlPrincipal, null);
		pnlPrincipal.setLayout(null);

		JLabel lblTeacherName = new JLabel("Öğretmen Adı");
		lblTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherName.setFont(new Font("Arial", Font.BOLD, 15));
		lblTeacherName.setBounds(528, 11, 165, 20);
		pnlPrincipal.add(lblTeacherName);

		txtTeacherName = new JTextField();
		txtTeacherName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherName.setFont(new Font("Arial", Font.BOLD, 14));
		txtTeacherName.setBounds(528, 29, 166, 20);
		pnlPrincipal.add(txtTeacherName);
		txtTeacherName.setColumns(10);

		JLabel lblTeacherTc = new JLabel("Öğretmen T.C.:");
		lblTeacherTc.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherTc.setFont(new Font("Arial", Font.BOLD, 15));
		lblTeacherTc.setBounds(528, 166, 165, 20);
		pnlPrincipal.add(lblTeacherTc);

		txtTeacherTc = new JTextField();
		txtTeacherTc.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherTc.setFont(new Font("Arial", Font.BOLD, 14));
		txtTeacherTc.setColumns(10);
		txtTeacherTc.setBounds(528, 188, 166, 20);
		pnlPrincipal.add(txtTeacherTc);

		JLabel lblTEacherPassWord = new JLabel("Öğretmen Şifre");
		lblTEacherPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblTEacherPassWord.setFont(new Font("Arial", Font.BOLD, 15));
		lblTEacherPassWord.setBounds(528, 219, 165, 20);
		pnlPrincipal.add(lblTEacherPassWord);

		txtTeacherPassword = new JTextField();
		txtTeacherPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherPassword.setFont(new Font("Arial", Font.BOLD, 14));
		txtTeacherPassword.setColumns(10);
		txtTeacherPassword.setBounds(527, 237, 166, 20);
		pnlPrincipal.add(txtTeacherPassword);

		
		
		
		JButton btnTeacherAdd = new JButton("Ekle");
		btnTeacherAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
		if(txtTeacherName.getText().length()==0) {
			Helper.showMessage("fill");
		}else {
			
			try {
				boolean control = Teacher.addTeacher(txtTeacherName.getText(),txtTeacherLastName.getText(),"",txtTeacherPassword.getText(),txtTeacherTc.getText(),
						txtTeacherLecture.getText()) ;
				if(control) {
					txtTeacherName.setText(null);
					txtTeacherLastName.setText(null);
					txtTeacherTc.setText(null);
					txtTeacherPassword.setText(null);
					txtTeacherLecture.setText(null);
					updateTeacherModel();
					Helper.showMessage("İŞLEM BAŞARILI");
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} }
				
			}
			
		});
		

		btnTeacherAdd.setFont(new Font("Arial", Font.BOLD, 14));
		btnTeacherAdd.setBounds(528, 268, 165, 23);
		pnlPrincipal.add(btnTeacherAdd);

		JButton btnTeacherDelete = new JButton("Sil");
		btnTeacherDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtTeacherTc.getText().length()==0) {
					Helper.showMessage("lütfen geçerli bir doktor seçiniz");
					
				}else {
					if(Helper.confirm("sure")) {
						try {
						int selectID=Integer.parseInt(txtTeacherTc.getText());
								boolean delete;
								
									delete = Teacher.deleteTeacher(selectID);
									
									if(delete) {
										Helper.showMessage("success");
										txtTeacherTc.setText(null);
										updateTeacherModel();
										
									}
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
					}
					
				}
			}
		});
		btnTeacherDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnTeacherDelete.setBounds(528, 302, 165, 23);
		pnlPrincipal.add(btnTeacherDelete);

		JScrollPane scpPrincipal = new JScrollPane();
		scpPrincipal.setBounds(10, 11, 487, 314);
		pnlPrincipal.add(scpPrincipal);

		tblTeacher = new JTable(principalModel);
		scpPrincipal.setViewportView(tblTeacher);
		
		tblTeacher.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
				txtTeacherTc.setText(tblTeacher.getValueAt(tblTeacher.getSelectedRow(),3).toString());
				}catch(Exception e3) {}
			}
			
			
		} );
	tblTeacher.getModel().addTableModelListener(new TableModelListener () {
		
		
		public void tableChanged(TableModelEvent e) {
			if(e.getType()==TableModelEvent.UPDATE) {
				
				String selectName= (String) tblTeacher.getValueAt(tblTeacher.getSelectedRow(), 1);
				String selectNameLast=(String) tblTeacher.getValueAt(tblTeacher.getSelectedRow(), 2);
				
				
				try {
					boolean control=Teacher.upDAteTeacher( selectName, selectNameLast);
					if(control) {
						Helper.showMessage("success");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
	});

	
	
	
	
	
	
		txtTeacherLastName = new JTextField();
		txtTeacherLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherLastName.setFont(new Font("Arial", Font.BOLD, 14));
		txtTeacherLastName.setColumns(10);
		txtTeacherLastName.setBounds(527, 78, 166, 20);
		pnlPrincipal.add(txtTeacherLastName);

		JLabel lblTeacherLastName = new JLabel("Öğretmen Soyadı");
		lblTeacherLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherLastName.setFont(new Font("Arial", Font.BOLD, 15));
		lblTeacherLastName.setBounds(527, 60, 165, 20);
		pnlPrincipal.add(lblTeacherLastName);

		txtTeacherLecture = new JTextField();
		txtTeacherLecture.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeacherLecture.setFont(new Font("Arial", Font.BOLD, 14));
		txtTeacherLecture.setColumns(10);
		txtTeacherLecture.setBounds(528, 127, 166, 20);
		pnlPrincipal.add(txtTeacherLecture);

		JLabel lblTeacherLecture = new JLabel("Öğretmen Branşı");
		lblTeacherLecture.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherLecture.setFont(new Font("Arial", Font.BOLD, 15));
		lblTeacherLecture.setBounds(528, 109, 165, 20);
		pnlPrincipal.add(lblTeacherLecture);
	}

	private void updateTeacherModel(){
		DefaultTableModel clearModel= (DefaultTableModel) tblTeacher.getModel();
		clearModel.setRowCount(0);
		try {
			for (int i = 0; i < princibal.getTeacherList().size(); i++) {

				teacherData[0] = princibal.getTeacherList().get(i).getId();
				teacherData[1] = princibal.getTeacherList().get(i).getName();
				teacherData[2] = princibal.getTeacherList().get(i).getLastName();
				teacherData[3] = princibal.getTeacherList().get(i).getTc();
				teacherData[4] = princibal.getTeacherList().get(i).getPhoneNumber();
				teacherData[5] = princibal.getTeacherList().get(i).getPassWord();
				principalModel.addRow(teacherData);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
