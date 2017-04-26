import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class ChangeInfoDialog extends JDialog implements ActionListener{
	JTextField inputNo;
	JButton comfirmButton, cancelButton;
	String originalNo;
	HirePerson hirePerson;
	
	String originalVal[] = new String[8];
	
	public ChangeInfoDialog(HirePerson initHirePerson){
		hirePerson = initHirePerson;
		this.setTitle("�޸���������Ϣ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 130);
		
		JLabel changeNo = new JLabel("��������Ҫ�޸ĵ������˱��");
		this.add(changeNo, BorderLayout.NORTH);
		
		JPanel centerPanel = new JPanel();
		inputNo = new JTextField(15);
		centerPanel.add(inputNo, BorderLayout.CENTER);
		this.add(centerPanel);
		
		JPanel operatePanel = new JPanel();
		comfirmButton = new JButton("ȷ��");
		cancelButton = new JButton("ȡ��");
		comfirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		operatePanel.add(comfirmButton);
		operatePanel.add(cancelButton);
		this.add(operatePanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȡ��"){
			this.dispose();
		}
		if (e.getActionCommand() == "ȷ��"){
			originalNo = inputNo.getText();
			//System.out.println(originalNo);
			File newFile = new File("src/data", originalNo + ".txt");
			if (newFile.exists()){
				openFile(originalNo + ".txt");
				System.out.println(originalNo);
				ChangeDialog changeDialgog = new ChangeDialog(originalVal, hirePerson);
				this.dispose();
			}
			else if (!newFile.exists()){
				OpenFileFail openfileFail = new OpenFileFail();
			}
		}
	}
	
	public void openFile(String fileName){
		File changeFile = new File("src/data", fileName);
		BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(changeFile));
            
            for (int line = 0; line < 8; line++){
            	originalVal[line] = reader.readLine();
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
	}
}

class ChangeDialog implements ActionListener{
	JDialog addInfoDialog;
	JPanel addInfoPanel;
	JPanel addOperatePanel;
	JPanel p2, p3, p4, p5, p6, p7, p8;	// No time to change these into a array, so just use them this way
	JTextField userNameValue, IDValue, phoneNumber, mailAddress, cellNumber, QQNumber;
	JRadioButton male, female;
	ButtonGroup sexChoice;
	String originalNo;
	HirePerson hirePerson;
	
	public ChangeDialog(String[] originalVal, HirePerson initHirePerson){
		hirePerson = initHirePerson;
		originalNo = originalVal[0];
		
		addInfoDialog = new JDialog();
		addInfoDialog.setBounds(200, 200, 400, 400);
		addInfoDialog.setTitle("�޸���������Ϣ");
		addInfoDialog.setVisible(true);
		
		addInfoPanel = new JPanel();
		addInfoPanel.setBorder(BorderFactory.createTitledBorder("��� " + originalVal[0]));
		addInfoPanel.setLayout(new GridLayout(8, 1));
		
		JLabel userName = new JLabel("����             ", JLabel.RIGHT);
		userNameValue = new JTextField(15);
		userNameValue.setText(originalVal[1]);
		p2 = new JPanel();
		p2.add(userName);
		p2.add(userNameValue);
		
		//------------------- Here is a bug ------------------------------
		//------------------- originalVal[2] == "true" -------------------
		//------------------- originalVal[2] != "true" -------------------
		JLabel sex = new JLabel("�Ա�             ", JLabel.RIGHT);
		male = new JRadioButton("��", true);
		female = new JRadioButton("Ů");
		sexChoice = new ButtonGroup();
		sexChoice.add(male);
		sexChoice.add(female);
		System.out.println(originalVal[2] == "false");
		if (originalVal[2] == "false"){
			female.setSelected(true);
		}
		p3 = new JPanel();
		p3.add(sex);
		p3.add(male);
		p3.add(female);
		//----------------------------------------------------------------
		
		JLabel ID = new JLabel("���֤����");
		IDValue = new JTextField(15);
		IDValue.setText(originalVal[3]);
		p4 = new JPanel();
		p4.add(ID);
		p4.add(IDValue);
		
		JLabel phone = new JLabel("��ͥ�绰    ");
		phoneNumber = new JTextField(15);
		phoneNumber.setText(originalVal[4]);
		p5 = new JPanel();
		p5.add(phone);
		p5.add(phoneNumber);
		
		JLabel mail = new JLabel("����            ", JLabel.RIGHT);
		mailAddress = new JTextField(15);
		mailAddress.setText(originalVal[5]);
		p6 = new JPanel();
		p6.add(mail);
		p6.add(mailAddress);
		
		JLabel cell = new JLabel("�ֻ�             ", JLabel.RIGHT);
		cellNumber = new JTextField(15);
		cellNumber.setText(originalVal[6]);
		p7 = new JPanel();
		p7.add(cell);
		p7.add(cellNumber);
		
		JLabel QQ = new JLabel("QQ               ", JLabel.RIGHT);
		QQNumber = new JTextField(15);
		QQNumber.setText(originalVal[7]);
		p8 = new JPanel();
		p8.add(QQ);
		p8.add(QQNumber);
		
		addInfoPanel.add(p3);
		addInfoPanel.add(p2);
		addInfoPanel.add(p4);
		addInfoPanel.add(p5);
		addInfoPanel.add(p6);
		addInfoPanel.add(p7);
		addInfoPanel.add(p8);
		
		addOperatePanel = new JPanel();
		JButton bt1 = new JButton("ȷ��");
		JButton bt3 = new JButton("ȡ��");
		addOperatePanel.add(bt1);
		addOperatePanel.add(bt3);
		
		bt1.addActionListener(this);
		bt3.addActionListener(this);	
		
		addInfoDialog.add(addInfoPanel, BorderLayout.CENTER);
		addInfoDialog.add(addOperatePanel, BorderLayout.SOUTH);
		addInfoDialog.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			changeData(originalNo);
			String[] colNamesRefreshed = {"���", "����"};
			DataTable infoTableRefreshed = new DataTable(colNamesRefreshed, hirePerson);
			infoTableRefreshed.setOpaque(true);
			hirePerson.add(infoTableRefreshed, BorderLayout.CENTER);
			hirePerson.setVisible(true);
			ChangeDataSuccess changeDataSuccess = new ChangeDataSuccess();
			addInfoDialog.dispose();
		}
		if (e.getActionCommand() == "ȡ��"){
			addInfoDialog.dispose();
		}
	}
	
	public void changeData(String originalNo){
		String changedData[] = new String[8];
		changedData[0] = originalNo;
		changedData[1] = userNameValue.getText();
		if (male.isSelected()){
			changedData[2] = "true";
		}
		else if (female.isSelected()){
			changedData[2] = "false";
		}
		changedData[3] = IDValue.getText();
		changedData[4] = phoneNumber.getText();
		changedData[5] = mailAddress.getText();
		changedData[6] = cellNumber.getText();
		changedData[7] = QQNumber.getText();
		
		File deleteFile = new File("src/data", originalNo + ".txt");
		deleteFile.delete();
		File changedFile = new File("src/data", originalNo + ".txt");
		if (changedFile.exists()){
			System.out.println("ɾ��Դ�ļ����������ļ�����");
		}
		else {
			try {  
	            if (changedFile.createNewFile()) {  
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
				FileWriter writer = new FileWriter("src/data/" + originalNo + ".txt", true);
	            writer.write(changedData[i]);
	            writer.write("\r\n");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}
}

class OpenFileFail extends JDialog implements ActionListener{
	
	public OpenFileFail(){
		this.setTitle("δ�ҵ���Ϣ");
		this.setBounds(400, 400, 300, 115);
		this.setVisible(true);
		
		JLabel failLabel = new JLabel("�Բ���δ�ҵ���������");
		JPanel labelPanel = new JPanel();
		labelPanel.add(failLabel);
		this.add(labelPanel, BorderLayout.CENTER);
		
		JButton comfirmButton = new JButton("ȷ��");
		comfirmButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(comfirmButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			this.dispose();
		}
	}
}

class ChangeDataSuccess extends JDialog implements ActionListener{
	
	public ChangeDataSuccess(){
		this.setTitle("�޸ĳɹ�");
		this.setBounds(400, 400, 300, 115);
		this.setVisible(true);
		
		JLabel successLabel = new JLabel("�޸ĳɹ���");
		JPanel labelPanel = new JPanel();
		labelPanel.add(successLabel);
		this.add(labelPanel, BorderLayout.CENTER);
		
		JButton comfirmButton = new JButton("ȷ��");
		comfirmButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(comfirmButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			this.dispose();
		}
	}
}
