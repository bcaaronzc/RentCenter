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
		addInfoDialog.setTitle("�����������Ϣ");
		addInfoDialog.setVisible(true);
		
		addInfoPanel = new JPanel();
		addInfoPanel.setBorder(BorderFactory.createTitledBorder("�����������Ϣ"));
		addInfoPanel.setLayout(new GridLayout(8, 1));
		
		JLabel hirePersonNo = new JLabel("�����˱��");
		hirePersonValue = new JTextField(15);
		p1 = new JPanel();
		p1.add(hirePersonNo);
		p1.add(hirePersonValue);
		
		JLabel userName = new JLabel("����             ", JLabel.RIGHT);
		userNameValue = new JTextField(15);
		p2 = new JPanel();
		p2.add(userName);
		p2.add(userNameValue);
		
		JLabel sex = new JLabel("�Ա�             ", JLabel.RIGHT);
		male = new JRadioButton("��");
		female = new JRadioButton("Ů");
		sexChoice = new ButtonGroup();
		sexChoice.add(male);
		sexChoice.add(female);
		p3 = new JPanel();
		p3.add(sex);
		p3.add(male);
		p3.add(female);
		
		JLabel ID = new JLabel("���֤����");
		IDValue = new JTextField(15);
		p4 = new JPanel();
		p4.add(ID);
		p4.add(IDValue);
		
		JLabel phone = new JLabel("��ͥ�绰    ");
		phoneNumber = new JTextField(15);
		p5 = new JPanel();
		p5.add(phone);
		p5.add(phoneNumber);
		
		JLabel mail = new JLabel("����            ", JLabel.RIGHT);
		mailAddress = new JTextField(15);
		p6 = new JPanel();
		p6.add(mail);
		p6.add(mailAddress);
		
		JLabel cell = new JLabel("�ֻ�             ", JLabel.RIGHT);
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
		JButton bt1 = new JButton("ȷ��");
		JButton bt2 = new JButton("����");
		JButton bt3 = new JButton("�˳�");
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
		if (e.getActionCommand().equals("����")){		// ��ȡ�����¼����¼�Դ���ı�
			hirePersonValue.setText("");
			userNameValue.setText("");
			male.setSelected(true);
			IDValue.setText("");
			phoneNumber.setText("");
			mailAddress.setText("");
			cellNumber.setText("");
			QQNumber.setText("");
		}
		if (e.getActionCommand().equals("ȷ��")){		// ��ȡ�����¼����¼�Դ���ı�
			AddSuccess addSuccess = new AddSuccess();
		}
		if (e.getActionCommand().equals("�˳�")){
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
		this.setTitle("��ӳɹ���");
		this.setBounds(400, 400, 300, 100);
		this.setVisible(true);
		
		JLabel successLabel = new JLabel("                                       ��ӳɹ�");
		this.add(successLabel, BorderLayout.CENTER);
		
		JButton confirmButton = new JButton("ȷ��");
		confirmButton.addActionListener(this);
		this.add(confirmButton, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			this.dispose();
		}
	}
}