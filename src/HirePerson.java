import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableCellRenderer;

public class HirePerson extends JFrame implements ActionListener{
	/**
	 * @param args
	 */
	
	String[] colNames = {"编号", "姓名", "性别"};
	
	JDialog addInfoDialog = new JDialog();
	//JFrame addInfoDialog = new JFrame();
	DataTable infoTable;
	
	public HirePerson(){
		this.setTitle("求租人信息设置");
		this.setVisible(true);
		this.setBounds(200, 200, 800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel operatePanel = new JPanel();
		operatePanel.setBorder(BorderFactory.createTitledBorder("求租人信息操作"));
		JButton addButton, changeButton, deleteButton, quitButton;
		JButton refreshButton;
		addButton = new JButton("添加");
		changeButton = new JButton("修改");
		deleteButton = new JButton("删除");
		quitButton = new JButton("退出");
		refreshButton = new JButton("刷新");
		operatePanel.add(addButton);
		operatePanel.add(changeButton);
		operatePanel.add(deleteButton);
		operatePanel.add(refreshButton);
		operatePanel.add(quitButton);
		this.add(operatePanel, BorderLayout.NORTH);
		/*
		JPanel infoPanel = new JPanel();
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("求租人列表"));
		System.out.println(loadInfo());
		
		String[][] noData = {{"no", "data"}, {"no", "data"}};
		if (loadInfo() == noData){
			JLabel tempLabel = new JLabel("暂无信息");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("有信息");
			
			infoTable = new DataTable(colNames, this);
			infoTable.setOpaque(true);	// 不知道这是干什么用的，好像没什么反应
			this.add(infoTable, BorderLayout.CENTER);
			this.setVisible(true);
		}
		//this.add(infoPanel, BorderLayout.CENTER);*/
		JTableRefresh();
		
		addButton.addActionListener(this);	// 为 addButton 添加时间监听器，由当前窗口 (this) 进行监听
		quitButton.addActionListener(this);
		changeButton.addActionListener(this);
		refreshButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	public void JTableRefresh(){
		JPanel infoPanel = new JPanel();
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("求租人列表"));
		System.out.println(loadInfo());
		
		String[][] noData = {{"no", "data"}, {"no", "data"}};
		if (loadInfo() == noData){
			JLabel tempLabel = new JLabel("暂无信息");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("有信息");
			
			infoTable = new DataTable(colNames, this);
			infoTable.setOpaque(true);	// 不知道这是干什么用的，好像没什么反应
			this.add(infoTable, BorderLayout.CENTER);
			this.setVisible(true);
		}
		//this.add(infoPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("添加")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			HirePersonAddDialog newHirePerson = new HirePersonAddDialog(this);
		}
		if (e.getActionCommand().equals("修改")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog(this);
		}
		if (e.getActionCommand().equals("删除")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			DeleteDialog deleteDialog = new DeleteDialog(this);
		}
		if (e.getActionCommand().equals("退出")){		// 获取触发事件的事件源的文本，若相同，则弹出窗体
			System.exit(0);
		}
		if (e.getActionCommand() == "刷新"){
			JTableRefresh();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HirePerson hirePerson = new HirePerson();
		//hirePerson.HirePersonAddDialog();
	}

	public String[][] loadInfo(){
		String[][] data;
		String[][] noData = {{"no", "data"}, {"no", "data"}};
		File filePath = new File("src/data");
		if (!filePath.isDirectory()){
			System.out.println("Something is wrong, directory not found.");
			return noData;
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

class DataTable extends JPanel {
	private boolean DEBUG = true;	// 不知道是干什么的
	
	String originalVal[] = new String[8];
	
	HirePerson hirePerson;
	
	public DataTable(String[] colNames, HirePerson initHirePerson){
		super(new BorderLayout());
		hirePerson = initHirePerson;
		Object[][] data = hirePerson.loadInfo();
		// 不知道这两个参数是怎么来的，就是一个是表头，一个是显示的数据
		
		this.setBorder(BorderFactory.createTitledBorder("求租人列表"));
		
		final JTable dataTable = new JTable(data, colNames);
		
		// 不知道这是干什么的
		if (DEBUG){
			dataTable.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
                    directChangeData(dataTable);
                }
			});
		}
		
		// Create the scroll pane and add the table to it.
        //这也是官方建议使用的方式，否则表头不会显示，需要单独获取到TableHeader自己手动地添加显示
		JScrollPane scrollPane = new JScrollPane(dataTable);
		
		// 居中显示，网上找的代码，我是不会的
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		dataTable.setDefaultRenderer(Object.class, r);
		
		add(scrollPane);
	}
	
    private void directChangeData(JTable table) {        
        int numClicked = table.getSelectedRow();

        javax.swing.table.TableModel model = table.getModel();
        
        String dataNum = "" + model.getValueAt(numClicked, 0);
        
        File newFile = new File("src/data", dataNum + ".txt");
        if (newFile.exists()){
			openFile(dataNum + ".txt");
			System.out.println(dataNum);
			ChangeDialog changeDialgog = new ChangeDialog(originalVal, hirePerson);
		}
		else if (!newFile.exists()){
			OpenFileFail openfileFail = new OpenFileFail();
		}
    }
    
    public void openFile(String fileName){
		File changeFile = new File("src/data", fileName);
		BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
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
}
