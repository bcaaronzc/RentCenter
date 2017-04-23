import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteDialog extends JDialog implements ActionListener{
	JLabel deleteNo;
	JTextField deleteNoInput;
	JButton comfirmButton, cancelButton;

	public DeleteDialog(){
		this.setTitle("ɾ����������Ϣ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 150);
		
		JPanel labelPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel operatePanel = new JPanel();
		
		deleteNo = new JLabel("��������Ҫɾ���������˱��");
		deleteNoInput = new JTextField(15);
		
		comfirmButton = new JButton("ȷ��");
		cancelButton = new JButton("ȡ��");
		comfirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		labelPanel.add(deleteNo);
		inputPanel.add(deleteNoInput);
		operatePanel.add(comfirmButton);
		operatePanel.add(cancelButton);
		
		this.add(labelPanel, BorderLayout.NORTH);
		this.add(inputPanel, BorderLayout.CENTER);
		this.add(operatePanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			DeleteSuccess deleteSuccess = new DeleteSuccess();
			this.dispose();
		}
		if (e.getActionCommand() == "ȡ��"){
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteDialog deleteDialog = new DeleteDialog();
	}
}

class DeleteSuccess extends JDialog implements ActionListener{
	JButton comfirmButton;
	JLabel deleteSuccessLabel;
	
	public DeleteSuccess(){
		this.setTitle("ɾ����������Ϣ");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 115);
		
		deleteSuccessLabel = new JLabel("ɾ���ɹ�");
		comfirmButton = new JButton("ȷ��");
		comfirmButton.addActionListener(this);
		
		JPanel labelPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		labelPanel.add(deleteSuccessLabel);
		buttonPanel.add(comfirmButton);
		
		this.add(labelPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "ȷ��"){
			this.dispose();
		}
	}
}
