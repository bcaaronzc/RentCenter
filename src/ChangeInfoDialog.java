import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeInfoDialog extends JDialog implements ActionListener{
	JTextField inputNo;
	JButton comfirmButton, cancelButton;
	
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
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
	}
}
