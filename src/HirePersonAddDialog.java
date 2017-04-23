import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class HirePersonAddDialog implements ActionListener{

	/**
	 * @param args
	 */
	JDialog addInfoDialog;
	JPanel addInfoPanel;
	JPanel addOperatePanel;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8;	// No time to change these into a array, so just use them this way
	JTextField hirePersonValue, userNameValue, IDValue, phoneNumber, mailAddress, cellNumber, QQNumber;
	JRadioButton male, female;
	ButtonGroup sexChoice;
	
	public HirePersonAddDialog(){
		addInfoDialog = new JDialog();
		addInfoDialog.setBounds(200, 200, 400, 400);
		addInfoDialog.setTitle("添加求租人信息");
		addInfoDialog.setVisible(true);
		
		addInfoPanel = new JPanel();
		addInfoPanel.setBorder(BorderFactory.createTitledBorder("添加求租人信息"));
		addInfoPanel.setLayout(new GridLayout(8, 1));
		
		JLabel hirePersonNo = new JLabel("求租人编号");
		hirePersonValue = new JTextField(15);
		p1 = new JPanel();
		p1.add(hirePersonNo);
		p1.add(hirePersonValue);
		
		JLabel userName = new JLabel("姓名             ", JLabel.RIGHT);
		userNameValue = new JTextField(15);
		p2 = new JPanel();
		p2.add(userName);
		p2.add(userNameValue);
		
		JLabel sex = new JLabel("性别             ", JLabel.RIGHT);
		male = new JRadioButton("男");
		female = new JRadioButton("女");
		sexChoice = new ButtonGroup();
		sexChoice.add(male);
		sexChoice.add(female);
		p3 = new JPanel();
		p3.add(sex);
		p3.add(male);
		p3.add(female);
		
		JLabel ID = new JLabel("身份证号码");
		IDValue = new JTextField(15);
		p4 = new JPanel();
		p4.add(ID);
		p4.add(IDValue);
		
		JLabel phone = new JLabel("家庭电话    ");
		phoneNumber = new JTextField(15);
		p5 = new JPanel();
		p5.add(phone);
		p5.add(phoneNumber);
		
		JLabel mail = new JLabel("邮箱            ", JLabel.RIGHT);
		mailAddress = new JTextField(15);
		p6 = new JPanel();
		p6.add(mail);
		p6.add(mailAddress);
		
		JLabel cell = new JLabel("手机             ", JLabel.RIGHT);
		cellNumber = new JTextField(15);
		p7 = new JPanel();
		p7.add(cell);
		p7.add(cellNumber);
		
		JLabel QQ = new JLabel("QQ               ", JLabel.RIGHT);
		QQNumber = new JTextField(15);
		p8 = new JPanel();
		p8.add(QQ);
		p8.add(QQNumber);
		
		addInfoPanel.add(p1);
		addInfoPanel.add(p2);
		addInfoPanel.add(p3);
		addInfoPanel.add(p4);
		addInfoPanel.add(p5);
		addInfoPanel.add(p6);
		addInfoPanel.add(p7);
		addInfoPanel.add(p8);
		
		addOperatePanel = new JPanel();
		JButton bt1 = new JButton("确定");
		JButton bt2 = new JButton("重置");
		JButton bt3 = new JButton("退出");
		addOperatePanel.add(bt1);
		addOperatePanel.add(bt2);
		addOperatePanel.add(bt3);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		addInfoDialog.add(addInfoPanel, BorderLayout.CENTER);
		addInfoDialog.add(addOperatePanel, BorderLayout.SOUTH);
		addInfoDialog.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("重置")){		// 获取触发事件的事件源的文本
			hirePersonValue.setText("");
			userNameValue.setText("");
			male.setSelected(true);
			IDValue.setText("");
			phoneNumber.setText("");
			mailAddress.setText("");
			cellNumber.setText("");
			QQNumber.setText("");
		}
		if (e.getActionCommand().equals("确定")){		// 获取触发事件的事件源的文本
			AddSuccess addSuccess = new AddSuccess();
		}
		if (e.getActionCommand().equals("退出")){
			addInfoDialog.dispose();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HirePersonAddDialog newDialog = new HirePersonAddDialog();
	}
}

class AddSuccess extends JDialog implements ActionListener{
	public AddSuccess(){
		this.setTitle("添加成功！");
		this.setBounds(400, 400, 300, 100);
		this.setVisible(true);
		
		JLabel successLabel = new JLabel("                                       添加成功");
		this.add(successLabel, BorderLayout.CENTER);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.addActionListener(this);
		this.add(confirmButton, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "确认"){
			this.dispose();
		}
	}
}