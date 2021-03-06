package zhanlang.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import zhanlang.DAO.ManagerDAO;
import zhanlang.DAO.UserDAO;
import zhanlang.DAO.Imple.ManagerDAOImple;
import zhanlang.DAO.Imple.UserDAOImple;
import zhanlang.entity.Manager;
import zhanlang.entity.Person;
import zhanlang.entity.User;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginMenu extends JFrame {
	
	private JPanel contentPane;
	private JComboBox selectPerson;
	private JPasswordField password;
	static Person userlogin;


	public static Socket socket;
	private JTextField name;
	
	/**
	 * Create the frame.
	 */
	public LoginMenu() {
		setTitle("BMS");
		setBackground(SystemColor.inactiveCaption);
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBms = new JLabel("");
		lblBms.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/BMS.jpg")));
		lblBms.setFont(new Font("DFKai-SB", Font.BOLD | Font.ITALIC, 30));
		lblBms.setBounds(154, 30, 144, 54);
		contentPane.add(lblBms);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/用户名.jpg")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label.setBounds(97, 126, 65, 18);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/密码.jpg")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_2.setBounds(108, 154, 54, 18);
		contentPane.add(label_2);
		
		name = new JTextField();
		name.setFont(new Font("楷体", Font.BOLD, 13));
		name.setBounds(179, 124, 144, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		/**
		 * 注册按钮，完成 跳转并关闭当前页面
		 */
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/注册按钮--1.jpg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client.uRegesterFrame = new U_RegesterUser();
				Client.uRegesterFrame.setVisible(true);	
				Client.loginMenuFrame.dispose();
			}
		});
		button.setBounds(138, 194, 75, 23);
		contentPane.add(button);
		
		/**
		 * 登录按钮，申请登录，完成验证并跳转。
		 */
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/登录.jpg")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginSocket loginSocket=new LoginSocket();
				Thread th=new Thread(loginSocket);
				th.start();
			}

		});
		button_1.setBounds(238, 194, 75, 23);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/身份.jpg")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_3.setBounds(108, 97, 54, 15);
		contentPane.add(label_3);
		
		selectPerson = new JComboBox();
		selectPerson.setFont(new Font("楷体", Font.BOLD, 13));
		selectPerson.setModel(new DefaultComboBoxModel(new String[] {"用户", "管理员"}));
		selectPerson.setBounds(179, 94, 144, 21);
		contentPane.add(selectPerson);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(75, 157, 54, 15);
		contentPane.add(label_4);
		
		password = new JPasswordField();
		password.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		password.setBounds(179, 153, 144, 21);
		contentPane.add(password);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(255, 255, 255));
		label_1.setIcon(new ImageIcon(LoginMenu.class.getResource("/picture/text/denglu.png")));
		label_1.setBounds(0, 0, 434, 245);
		contentPane.add(label_1);
	}
	
	
	class LoginSocket implements Runnable{

		@Override
		public void run() {
			try {
				AdvertisementFrame ad=new AdvertisementFrame();
				socket = new Socket(InetAddress.getLocalHost().getHostName(), 8888);
				Client.os = socket.getOutputStream();
				Client.is = socket.getInputStream();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//取到    登录者的身份信息，判断是用户，还是管理员。
			String select = (String) selectPerson.getSelectedItem();
			String command = new String ("login");
			//为不同身份的登录者，提供同的登录页面
			//如果是用户，则登录成功后，弹出用户页面
			if(select.equals("用户")){
				
				//登录信息打包传输。
				User loginPerson = new User(name.getText(),password.getText());
				//String loginData = new String("login"+","+name.getText()+","+password.getText());
				//创建操作类对象，调用登录方法。
				UserDAO user = new UserDAOImple();
				userlogin = user.login(command, loginPerson);
				//判断服务器返回的信息，是否允许登录
				if(userlogin!=null){
						Client.userMenuFrame= new UserMenu();
						Client.userMenuFrame.setVisible(true);	
						Client.userMenuFrame.setLocationRelativeTo(null);
						Client.loginMenuFrame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "用户不存在或密码错误!");
				}
				
			}else if(select.equals("管理员")){
				
				//登录信息打包传输。
				Manager loginPerson = new Manager(name.getText(),password.getText());
				//String loginData = new String("login"+","+name.getText()+","+password.getText());
				//创建操作类对象，调用登录方法。
				ManagerDAO manager = new ManagerDAOImple();
				//判断服务器返回的信息，是否允许登录
				if(manager.login("login",loginPerson)){
					Client.managerMenuFrame = new ManagerMenu();
					Client.managerMenuFrame.setVisible(true);	
					Client.managerMenuFrame.setLocationRelativeTo(null);
					Client.loginMenuFrame.dispose();
					//Client.loginMenuFrame.setVisible(false);
					
					//如果不允许登录，则弹窗提示，登录失败，请确认用户名与密码。	
				}else{
					JOptionPane.showMessageDialog(null, "用户不存在或密码错误!");
				}
			}
		}
		
	}


}

