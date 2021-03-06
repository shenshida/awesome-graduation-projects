package com.zhatian.lsx.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.zhatian.Tinner.entity.Student;
import com.zhatian.kraken.control.AdminAction;
import com.zhatian.wzp.util.Regex;

public class AdminAddNewStu extends JFrame implements ActionListener{

	private JButton add;
	private JButton return1;
	//设置男女单选框
    private JRadioButton boy;
    private JRadioButton girl;
    //设置其他信息的文本域
	private JTextField userNameField;
	private JPasswordField pwdField;
	private JTextField nameField;

	private JTextField ageField;
	private JTextField clazzField;
	private JPanel panel;
	/***
	 * 
	 * 管理员添加新的学生的操作。
	 * 管理员在该操纵中，直接输入学会的相关身份信息。进行添加
	 * 系统将这些用户信息添加到数据存储XML文件中。
	 * 
	 * 唯一失败的原因是：用户名重复。将无法进行添加
	 */
	public AdminAddNewStu(){
		
		//设置窗体的基本属性，大小和初始位置。以及窗口左上角的图标
		this.setLayout(null);
		this.setTitle("炸天学生签到系统_添加新的学生");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置背景
		ImageIcon imageBg = new ImageIcon("resource\\admin_resouces\\loginBg.jpg");
		JLabel bgLable = new JLabel(imageBg);
		//布局为空
		bgLable.setLayout(null);
		//获取窗体对象
		Container c = this.getContentPane();
		bgLable.setBounds(0, 0, imageBg.getIconWidth(), imageBg.getIconHeight());
		c.add(bgLable);
		
		//设置左上角图片文件
		ImageIcon liftIicon = new ImageIcon("resource\\admin_resouces\\ico1.jpg"); 
		//将左上角图标换做自定义图标
		this.setIconImage(liftIicon.getImage());
		//弹窗用
		panel = new JPanel();
		//--------------------------设置一个label--------------------------------
		JLabel Uplabel = new JLabel("添加新的学生");
		Uplabel.setFont(new Font("楷书",Font.BOLD,25));
		Uplabel.setBounds(173,110,160,70);
		bgLable.add(Uplabel);
		
		//---------------------------创建六个标签和文本框----------------------------
		
		JLabel useNameLabel = new JLabel("账号：");
		useNameLabel.setFont(new Font("", Font.BOLD, 15));
		useNameLabel.setBounds(165,180,50,20);
		userNameField = new JTextField(20);
		userNameField.setBounds(230,180,110,20);
		bgLable.add(useNameLabel);
		bgLable.add(userNameField);
		
		JLabel pwdLabel = new JLabel("密码：");
		pwdLabel.setFont(new Font("", Font.BOLD,15));
		pwdLabel.setBounds(165,205,50,20);
		pwdField = new JPasswordField();
		pwdField.setBounds(230,205,110,20);
		bgLable.add(pwdLabel);
		bgLable.add(pwdField);
		
		JLabel nameLabel = new JLabel("姓名：");
		nameLabel.setFont(new Font("", Font.BOLD, 15));
		nameLabel.setBounds(165,230,50,20);
		nameField = new JTextField(20);
		nameField.setBounds(230,230,110,20);
		bgLable.add(nameLabel);
		bgLable.add(nameField);
		
		JLabel sexLabel = new JLabel("性别：");
		sexLabel.setFont(new Font("", Font.BOLD, 15));
		sexLabel.setBounds(165,255,50,20);
		bgLable.add(sexLabel);
		// 设置性别单选框
		boy = new JRadioButton("男");
		girl = new JRadioButton("女");
		ButtonGroup group = new ButtonGroup();
		group.add(boy);
		group.add(girl);
		boy.setBounds(230,255,45,20);
		boy.setBackground(Color.white);
		girl.setBounds(293,255,45,20);
		girl.setBackground(Color.white);
		bgLable.add(boy);
		bgLable.add(girl);
		
		
		JLabel ageLabel = new JLabel("年龄：");
		ageLabel.setFont(new Font("", Font.BOLD, 15));
		ageLabel.setBounds(165,280,50,20);
		ageField = new JTextField(20);
		ageField.setBounds(230,280,110,20);
		bgLable.add(ageLabel);
		bgLable.add(ageField);
		
		JLabel clazzLabel = new JLabel("班级：");
		clazzLabel.setFont(new Font("", Font.BOLD, 15));
		clazzLabel.setBounds(165,305,50,20);
		clazzField = new JTextField(20);
		clazzField.setBounds(230,305,110,20);
		bgLable.add(clazzLabel);
		bgLable.add(clazzField);
		

		//---------------------------创建两个按钮----------------------------------
		add=new JButton("添加");
		add.setFont(new Font("微软雅黑",Font.BOLD,12));
		add.setBounds(185,345,65,30);
		add.addActionListener(this);
		
		return1 =new JButton("返回");
		return1.setFont(new Font("微软雅黑",Font.BOLD,12));
		return1.setBounds(270,345,65,30);
		return1.addActionListener(this);

		//---------------------创建一个盘子----------------------------
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 500);
	
		panel.setOpaque(false);
		panel.setLayout(null);
		panel.add(add);
		panel.add(return1);
	
		bgLable.add(panel);
		
		this.setVisible(true);
	}
	/**
	 * 响应监听器的事件方法
	 * 设置有监听器的两个按钮代表的两个功能都在这里实现。
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == add) {
			//获取用户输入的所有信息
			String stuUserName = userNameField.getText();
			String stuPwd = new String(pwdField.getPassword());
			String stuName = nameField.getText();
			String stuSex = "";
			if(boy.isSelected()){
				stuSex = "男";
			}else if(girl.isSelected()){
				stuSex = "女";
			}
			
			String stuAge = ageField.getText();
			String stuClazz = clazzField.getText();
			//对用户输入的文本框中的信息进行校验。层层校验
			if (Regex.usernameRegex(stuUserName)) {
				if (Regex.passwordRegex(stuPwd)) {
					if (Regex.nameRegex(stuName)) {
						if (!(stuSex.isEmpty())) {
							if (Regex.ageRegex(stuAge)) {
								if (Regex.classRegex(stuClazz)) {
									//到此处为止是通过了所有的校验。然后按照用户输入的信息创建一个对象传给服务器
									Student stu = new Student(0, stuUserName, stuPwd, stuName, stuSex, stuAge,
											stuClazz);
									boolean flag = AdminAction.adminAddStudent(stu);
									if (flag) {
										JOptionPane.showMessageDialog(panel, "添加成功");
										clearField();
									} else {
										//因为这里服务器设置的是只有当用户名冲突的时候会返回false。
										JOptionPane.showMessageDialog(panel, "用户名冲突，请重新选择用户名！");
										userNameField.setText("");
									}
								} else {
									JOptionPane.showMessageDialog(panel, "班级输入格式错误，请重新输入");
									clearField();
								}
							} else {
								JOptionPane.showMessageDialog(panel, "年龄输入格式错误，请重新输入");
								clearField();
							}
						} else {
							JOptionPane.showMessageDialog(panel, "请选择您的性别~~~");
							
						}
					} else {
						JOptionPane.showMessageDialog(panel, "学生姓名输入格式错误，请重新添加");
						clearField();
					}
				} else {
					JOptionPane.showMessageDialog(panel, "密码输入格式错误，请重新添加");
					clearField();
				}
			} else {
				JOptionPane.showMessageDialog(panel, "用户名输入格式错误，请重新添加");
				clearField();
			}

		} else if (e.getSource() == return1) {
			//点击的返回的时候，此窗体消失，父窗体重绘。
			new AdminManageStus();
			this.dispose();
		}
	}
	/**
	 * 重置文本域方法
	 * 当用户输入数据有误需要重新输入的时候，自动重置文本域的信息为空。方便用户再次输入
	 * 将这八条语句提出来。避免了每次都需要写八条语句的繁琐
	 */
	public void clearField(){
	
		userNameField.setText("");
		pwdField.setText("");
		nameField.setText("");
		
		ageField.setText("");
		clazzField.setText("");
	}
	
	public static void main(String[] args) {
		
		new AdminAddNewStu();
	}
	
}
