import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	String originalVal[] = new String[8];
	String changedVal[] = new String[8];
	
	public ChangeInfoDialog(){
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
			System.out.println(originalNo);
			File newFile = new File("src/data", originalNo + ".txt");
			if (newFile.exists()){
				openFile(originalNo + ".txt");
				System.out.println(originalNo);
				ChangeDialog changeDialgog = new ChangeDialog(originalVal);
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
            String tempString = null;
            
            for (int line = 0; line < 8; line++){
            	originalVal[line] = reader.readLine();
            }
            
/*            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
                //System.out.println("line " + line + ": " + tempString);
                System.out.println(tempString);
                line++;
            }*/
            
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
		ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
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
	
	public ChangeDialog(String[] originalVal){
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
			addInfoDialog.dispose();
		}
		if (e.getActionCommand() == "ȡ��"){
			addInfoDialog.dispose();
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
