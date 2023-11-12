
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import Helper.*;
import Model.Teacher;
public class ManagmentPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cpnMain;
	

	private JPasswordField psfStudent;
	private JPasswordField psfStudentTc;
	private JPasswordField psfTeacherTc;
	private JPasswordField psfTeacherPassword;
	private DbHelper connection =new DbHelper();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagmentPanel frame = new ManagmentPanel();
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
	public ManagmentPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		cpnMain = new JPanel();
		cpnMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(cpnMain);
cpnMain.setLayout(null);
		
		JTabbedPane tpnMain = new JTabbedPane(JTabbedPane.TOP);
		
		tpnMain.setFont(new Font("Arial", Font.BOLD, 13));
		tpnMain.setToolTipText("StudentPage");
		tpnMain.setBounds(10, 220, 560, 330);
		cpnMain.add(tpnMain);
		
		JPanel pnlStudent = new JPanel();
		tpnMain.addTab("StudentPage", null, pnlStudent, null);
		pnlStudent.setLayout(null);
		
		JLabel lblStudentId = new JLabel("StudentID");
		lblStudentId.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblStudentId.setBounds(21, 11, 85, 33);		pnlStudent.add(lblStudentId);
		
		psfStudent = new JPasswordField();
		psfStudent.setBounds(191, 19, 191, 20);
		pnlStudent.add(psfStudent);
		
		JLabel lblStudentTc = new JLabel("StudentPassword");
		lblStudentTc.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblStudentTc.setBounds(21, 55, 139, 29);
		pnlStudent.add(lblStudentTc);
		
		psfStudentTc = new JPasswordField();
		psfStudentTc.setBounds(191, 63, 192, 20);
		pnlStudent.add(psfStudentTc);
		
		JButton btnStudentLogin = new JButton("GİRŞİ");
		btnStudentLogin.setBounds(162, 178, 220, 23);
		pnlStudent.add(btnStudentLogin);
		
		JPanel pnlTeacher = new JPanel();
		pnlTeacher.setToolTipText("Teacher Page");
		pnlTeacher.setLayout(null);
		tpnMain.addTab("Teacher Page", null, pnlTeacher, null);
		tpnMain.setBackgroundAt(1, new Color(68, 187, 89));
		tpnMain.setEnabledAt(1, true);
		
		JLabel lblTeacherId = new JLabel("Teacher T.C. No:");
		lblTeacherId.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblTeacherId.setBounds(21, 11, 160, 33);
		pnlTeacher.add(lblTeacherId);
		
		psfTeacherTc = new JPasswordField();
		psfTeacherTc.setBounds(191, 19, 191, 20);
		pnlTeacher.add(psfTeacherTc);
		
		JLabel lblTeacherPassword = new JLabel("Teacher Password");
		lblTeacherPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblTeacherPassword.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblTeacherPassword.setBounds(21, 55, 147, 29);
		pnlTeacher.add(lblTeacherPassword);
		
		psfTeacherPassword = new JPasswordField();
		psfTeacherPassword.setBounds(191, 63, 192, 20);
		pnlTeacher.add(psfTeacherPassword);
		
		JButton btnTeacherLogin = new JButton("GİRİŞ");
		btnTeacherLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((psfTeacherTc.getText().length()==0)||(psfTeacherPassword.getText().length()==0)) {
				Helper.showMessage("fill");
				
				}
				else {
					Connection conn=null;
					try {
						conn = connection.DBConnection();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					java.sql.Statement st =null;
					ResultSet rs=null;
					try {;
				 st =conn.createStatement();
				rs= st.executeQuery("SELECT * FROM school.teacher");
                while(rs.next()){
                	if(psfTeacherPassword.getText().equals(rs.getString("teacherPassword"))&&psfTeacherTc.getText().equals(rs.getString("tc"))) {
                		Teacher teacher =new Teacher();
                		teacher.setId(rs.getInt("teacherıd"));
                		teacher.setPassWord(rs.getString("teacherPassword"));
                		teacher.setTc(rs.getString("tc"));
                		teacher.setName(rs.getNString("teacherName"));
                		teacher.setLastName(rs.getString("teacherLastName"));
                		teacher.setPhoneNumber(rs.getString("teacherPhoneNumber"));
                		teacher.setLecture(rs.getString("teacherLecture"));
                		if(teacher.getLecture().equals("PRINCIBAL")) {
                			PrincipalPanel principal = new PrincipalPanel(teacher);
                			principal.setVisible(true);
                			dispose();
                		}else {System.out.println("öğretmen");}
                	}
			       	}
				}catch(SQLException e2) {
					e2.printStackTrace();
				}finally {
					try {
						st.close();
						rs.close();
						conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				}
				
			}
		});
		btnTeacherLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnTeacherLogin.setBounds(153, 165, 229, 23);
		pnlTeacher.add(btnTeacherLogin);
		
		JLabel lblNewLabel = new JLabel("ATATURK HIGH SCHOOL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 0, 584, 31);
		cpnMain.add(lblNewLabel);
	}
}
