import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ChangeInfoDialog extends JDialog implements ActionListener{
	// TODO Add secondary dialog (another class) where the data can change
	JTextField inputNo;
	JButton comfirmButton, cancelButton;
	String originalNo;
	
	public ChangeInfoDialog(){
		this.setTitle("修改求租人信息");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 130);
		
		JLabel changeNo = new JLabel("请输入需要修改的求租人编号");
		this.add(changeNo, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		inputNo = new JTextField(15);
		centerPanel.add(inputNo, BorderLayout.CENTER);
		this.add(centerPanel);
		
		JPanel operatePanel = new JPanel();
		comfirmButton = new JButton("确认");
		cancelButton = new JButton("取消");
		comfirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		operatePanel.add(comfirmButton);
		operatePanel.add(cancelButton);
		this.add(operatePanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "取消"){
			this.dispose();
		}
		if (e.getActionCommand() == "确认"){
			originalNo = inputNo.getText();
			ChangeDialog changeDialgog = new ChangeDialog(originalNo);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
	}
}

class ChangeDialog extends JDialog implements ActionListener{
	JTextField name, IDNumber, phoneNumber, mailAddress, cellNumber, QQNumber;
	JButton comfirmButton, resetButton, cancelButton;
	JRadioButton male, female;
	
	public ChangeDialog(String originalNo){
		this.setTitle("修改求租人信息");
		this.setBounds(200, 200, 400, 400);
		
		JPanel changeInfoPanel = new JPanel();
		JPanel operatePanel = new JPanel();
		changeInfoPanel.setLayout(new GridLayout(8, 2));
		JPanel infoPanel[] = new JPanel[16];
		
		JLabel renter = new JLabel("求租人编号");
		JLabel renterNo = new JLabel(originalNo);
		JLabel nameLabel = new JLabel("姓名");
		JLabel sexLabel = new JLabel("性别");
		JLabel IDLabel = new JLabel("身份证号码");
		JLabel phoneLabel = new JLabel("家庭电话");
		JLabel mailLabel = new JLabel("邮箱");
		JLabel cellLabel = new JLabel("手机");
		JLabel QQLabel = new JLabel("QQ");
		
		name = new JTextField(15);
		IDNumber = new JTextField(15);
		phoneNumber = new JTextField(15);
		mailAddress = new JTextField(15);
		cellNumber = new JTextField(15);
		QQNumber = new JTextField(15);
		ButtonGroup sexChoice = new ButtonGroup();
		male = new JRadioButton("男");
		female = new JRadioButton("女");
		sexChoice.add(male);
		sexChoice.add(female);
		
		infoPanel[0].add(renter);
		infoPanel[1].add(renterNo);
		infoPanel[2].add(nameLabel);
		infoPanel[3].add(name);
		infoPanel[4].add(sexLabel);
		infoPanel[5].add(male);
		infoPanel[5].add(female);
		infoPanel[6].add(IDLabel);
		infoPanel[7].add(IDNumber);
		infoPanel[8].add(phoneLabel);
		infoPanel[9].add(phoneNumber);
		infoPanel[10].add(mailLabel);
		infoPanel[11].add(mailAddress);
		infoPanel[12].add(cellLabel);
		infoPanel[13].add(cellNumber);
		infoPanel[14].add(QQLabel);
		infoPanel[15].add(QQNumber);
		
		for (int i = 0; i < 16; i++){
			System.out.println("i = " + i);
			changeInfoPanel.add(infoPanel[i]);
		}
		
		operatePanel.add(comfirmButton);
		operatePanel.add(resetButton);
		operatePanel.add(cancelButton);
		
		this.add(changeInfoPanel, BorderLayout.CENTER);
		this.add(operatePanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}
