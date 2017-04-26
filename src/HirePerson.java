import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class HirePerson extends JFrame implements ActionListener{
	/**
	 * @param args
	 */
	
	String[] colNames = {"编号", "姓名"};
	
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
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("求租人列表"));
		System.out.println(loadInfo());
		if (loadInfo() == null){
			JLabel tempLabel = new JLabel("暂无信息");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("有信息");
			JTable dataTable = new JTable(loadInfo(), colNames);
			dataTable.setVisible(true);
			dataTable.setFillsViewportHeight(true);
			JScrollPane dataTableScrollPane = new JScrollPane();
			dataTable.add(dataTableScrollPane);
			//infoPanel.add(dataTable);
			//this.setContentPane(dataTable);
			//add(dataTable, BorderLayout.CENTER);
			infoPanel.add(dataTable);
		}
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
		if (e.getActionCommand().equals("修改")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
		}
		if (e.getActionCommand().equals("删除")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			DeleteDialog deleteDialog = new DeleteDialog();
		}
		if (e.getActionCommand().equals("退出")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HirePerson hirePerson = new HirePerson();
		//hirePerson.HirePersonAddDialog();
	}

	public String[][] loadInfo(){
		String[][] data;
		File filePath = new File("src/data");
		if (!filePath.isDirectory()){
			System.out.println("Something is wrong, directory not found.");
			return null;
		}
		else if (filePath.isDirectory()){
			String[] fileList = filePath.list();
			data = new String[fileList.length][3];
			
			for (int fileLength = 0; fileLength < fileList.length; fileLength++){
				File oneFile = new File("src/data", fileList[fileLength]);
				//String[] fileData = new String[8];
				BufferedReader reader = null;
		        try {
		            //System.out.println("以行为单位读取文件内容，一次读一整行：");
		            reader = new BufferedReader(new FileReader(oneFile));
		            //String tempString = null;
		            for (int line = 0; line < 3; line++){
		            	data[fileLength][line] = reader.readLine();
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
			
			return data;
		}
		
		return null;
	}
}
