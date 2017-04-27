import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteDialog extends JDialog implements ActionListener{
	JLabel deleteNo;
	JTextField deleteNoInput;
	JButton comfirmButton, cancelButton;
	HirePerson hirePerson;

	public DeleteDialog(HirePerson initHirePerson){
		hirePerson = initHirePerson;
		
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
			String fileName = deleteNoInput.getText();
			File newFile = new File("src/data", fileName + ".txt");
			if (newFile.exists()){
				newFile.delete();
				
				// ˢ�� DataTable
				
				String[] colNamesRefreshed = {"���", "����"};
				DataTable infoTableRefreshed = new DataTable(colNamesRefreshed, hirePerson);
				infoTableRefreshed.setOpaque(true);
				hirePerson.add(infoTableRefreshed, BorderLayout.CENTER);
				//hirePerson.refresh();
				DeleteSuccess deleteSuccess = new DeleteSuccess();
				hirePerson.setVisible(true);
				
				this.dispose();
			}
			else if (!newFile.exists()){
				DeleteFileFail deleteFileFail = new DeleteFileFail();
			}
		}
		if (e.getActionCommand() == "ȡ��"){
			this.dispose();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DeleteDialog deleteDialog = new DeleteDialog();
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

class DeleteFileFail extends JDialog implements ActionListener{
	
	public DeleteFileFail(){
		this.setTitle("ɾ��ʧ�ܣ�");
		this.setBounds(400, 400, 300, 115);
		this.setVisible(true);
		
		JLabel failLabel = new JLabel("ɾ��ʧ�ܣ�δ�ҵ��������ˡ�");
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
