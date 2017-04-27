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
		
		this.setTitle("删除求租人信息");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 150);
		
		JPanel labelPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel operatePanel = new JPanel();
		
		deleteNo = new JLabel("请输入需要删除的求租人编号");
		deleteNoInput = new JTextField(15);
		
		comfirmButton = new JButton("确认");
		cancelButton = new JButton("取消");
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
		if (e.getActionCommand() == "确认"){
			String fileName = deleteNoInput.getText();
			File newFile = new File("src/data", fileName + ".txt");
			if (newFile.exists()){
				newFile.delete();
				
				// 刷新 DataTable
				
				String[] colNamesRefreshed = {"编号", "姓名"};
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
		if (e.getActionCommand() == "取消"){
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
		this.setTitle("删除求租人信息");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(200, 200, 300, 115);
		
		deleteSuccessLabel = new JLabel("删除成功");
		comfirmButton = new JButton("确定");
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
		if (e.getActionCommand() == "确定"){
			this.dispose();
		}
	}
}

class DeleteFileFail extends JDialog implements ActionListener{
	
	public DeleteFileFail(){
		this.setTitle("删除失败！");
		this.setBounds(400, 400, 300, 115);
		this.setVisible(true);
		
		JLabel failLabel = new JLabel("删除失败，未找到此求租人。");
		JPanel labelPanel = new JPanel();
		labelPanel.add(failLabel);
		this.add(labelPanel, BorderLayout.CENTER);
		
		JButton comfirmButton = new JButton("确定");
		comfirmButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(comfirmButton);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand() == "确定"){
			this.dispose();
		}
	}
}
