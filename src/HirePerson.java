import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HirePerson extends JFrame implements ActionListener{
	/**
	 * @param args
	 */

	JDialog addInfoDialog = new JDialog();
	//JFrame addInfoDialog = new JFrame();
	
	public HirePerson(){
		this.setTitle("求租人信息设置");
		this.setVisible(true);
		this.setBounds(200, 200, 800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel operatePanel = new JPanel();
		operatePanel.setBorder(BorderFactory.createTitledBorder("求租人信息操作"));
		JButton addButton, changeButton, deleteButton, quitButton;
		addButton = new JButton("添加");
		changeButton = new JButton("修改");
		deleteButton = new JButton("删除");
		quitButton = new JButton("退出");
		operatePanel.add(addButton);
		operatePanel.add(changeButton);
		operatePanel.add(deleteButton);
		operatePanel.add(quitButton);
		this.add(operatePanel, BorderLayout.NORTH);
		
		JPanel infoPanel = new JPanel();
		JLabel tempLabel = new JLabel("建设中，敬请期待！");
		infoPanel.setBorder(BorderFactory.createTitledBorder("求租人信息列表"));
		infoPanel.add(tempLabel);
		this.add(infoPanel, BorderLayout.CENTER);
		
		addButton.addActionListener(this);	// 为 addButton 添加时间监听器，由当前窗口 (this) 进行监听
		quitButton.addActionListener(this);
		changeButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("添加")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			HirePersonAddDialog newHirePerson = new HirePersonAddDialog();
		}
		if (e.getActionCommand().equals("退出")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			System.exit(0);
		}
		if (e.getActionCommand().equals("修改")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
		}
		if (e.getActionCommand().equals("删除")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			JDialog deleteDialog = new JDialog();
			deleteDialog.setVisible(true);
			deleteDialog.setTitle("删除求租人信息");
			deleteDialog.setLayout(new GridLayout(2, 2));
			deleteDialog.setBounds(200, 200, 400, 70);
			
			JLabel delete = new JLabel("  输入您要删除的求租人编号");
			JTextField deleteNum = new JTextField(15);
			deleteDialog.add(delete);
			deleteDialog.add(deleteNum);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HirePerson hirePerson = new HirePerson();
		//hirePerson.HirePersonAddDialog();
	}

}
