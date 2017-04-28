import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	HirePerson hirePerson;	// Add for data transfer
	
	public HirePersonAddDialog(HirePerson initHirePerson){
		hirePerson = initHirePerson;	// Add for data transfer
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
		JButton bt3 = new JButton("ȡ��");
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
			// Obtain data
			boolean repeat = false;
			String data[] = new String[8];
			for (int i = 0; i < 8; i++){
				data[i] = "";
			}
			data[0] = hirePersonValue.getText();
			data[1] = userNameValue.getText();
			data[3] = IDValue.getText();
			data[4] = phoneNumber.getText();
			data[5] = mailAddress.getText();
			data[6] = cellNumber.getText();
			data[7] = QQNumber.getText();
			if (male.isSelected()){
				data[2] = "true";
			}
			else if (female.isSelected()){
				data[2] = "false";
			}
			
			for (int i = 0; i < 8; i++){
				if (data[i] == ""){
					repeat = true;
				}
			}
			
			if (repeat){
				AddFail addFail = new AddFail();
			}
			else{
				saveData();
				AddSuccess addSuccess = new AddSuccess();
				/*
				// ˢ�� DataTable
				
				String[] colNamesRefreshed = {"���", "����"};
				DataTable infoTableRefreshed = new DataTable(colNamesRefreshed, hirePerson);
				infoTableRefreshed.setOpaque(true);
				hirePerson.add(infoTableRefreshed, BorderLayout.CENTER);
				hirePerson.setVisible(true);
				//hirePerson.refresh();*/
				addInfoDialog.dispose();
			}
			
		}
		if (e.getActionCommand().equals("ȡ��")){
			addInfoDialog.dispose();
		}
	}
	
	public void saveData(){
		String line[] = new String[8];
		line[0] = hirePersonValue.getText();
		line[1] = userNameValue.getText();
		if (male.isSelected()){
			line[2] = "true";
		}
		else if (female.isSelected()){
			line[2] = "false";
		}
		line[3] = IDValue.getText();
		line[4] = phoneNumber.getText();
		line[5] = mailAddress.getText();
		line[6] = cellNumber.getText();
		line[7] = QQNumber.getText();
		
		File newFile = new File("src/data", line[0] + ".txt");
		if (newFile.exists()){
			// TODO ����һ������δ�ɹ���
			System.out.println("����ʧ�ܣ�");
		}
		else{
			try {  
	            if (newFile.createNewFile()) {  
	                System.out.println("�����ɹ���");  
	            } else { 
	                System.out.println("����ʧ�ܣ�");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("����ʧ�ܣ�" + e.getMessage());
	        }
		}

		for (int i = 0; i < 8; i++){
			try {
	            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
				FileWriter writer = new FileWriter("src/data/" + line[0] + ".txt", true);
	            writer.write(line[i]);
	            writer.write("\r\n");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HirePersonAddDialog newDialog = new HirePersonAddDialog();
	}
}

class AddSuccess extends JDialog implements ActionListener{
	public AddSuccess(){
		this.setTitle("��ӳɹ���");
		this.setBounds(400, 400, 300, 110);
		this.setVisible(true);
		
		JLabel successLabel = new JLabel("��ӳɹ�");
		JPanel labelPanel = new JPanel();
		labelPanel.add(successLabel);
		this.add(labelPanel, BorderLayout.CENTER);
		
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

class AddFail extends JDialog implements ActionListener{
	
	public AddFail(){
		this.setTitle("���ʧ��");
		this.setBounds(400, 400, 300, 115);
		this.setVisible(true);
		
		JLabel failLabel = new JLabel("������������Ҫ����Ϣ��");
		JPanel labelPanel = new JPanel();
		labelPanel.add(failLabel);
		this.add(labelPanel, BorderLayout.CENTER);
		
		JButton comfirmButton = new JButton("ȷ��");
		comfirmButton.addActionListener(this);
		JPanel comfirmPanel = new JPanel();
		comfirmPanel.add(comfirmButton);
		this.add(comfirmPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			this.dispose();
		}
	}
}