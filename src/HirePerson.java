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
	
	String[] colNames = {"���", "����", "�Ա�"};
	
	JDialog addInfoDialog = new JDialog();
	//JFrame addInfoDialog = new JFrame();
	DataTable infoTable;
	
	public HirePerson(){
		this.setTitle("��������Ϣ����");
		this.setVisible(true);
		this.setBounds(200, 200, 800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel operatePanel = new JPanel();
		operatePanel.setBorder(BorderFactory.createTitledBorder("��������Ϣ����"));
		JButton addButton, changeButton, deleteButton, quitButton;
		JButton refreshButton;
		addButton = new JButton("���");
		changeButton = new JButton("�޸�");
		deleteButton = new JButton("ɾ��");
		quitButton = new JButton("�˳�");
		refreshButton = new JButton("ˢ��");
		operatePanel.add(addButton);
		operatePanel.add(changeButton);
		operatePanel.add(deleteButton);
		operatePanel.add(refreshButton);
		operatePanel.add(quitButton);
		this.add(operatePanel, BorderLayout.NORTH);
		/*
		JPanel infoPanel = new JPanel();
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("�������б�"));
		System.out.println(loadInfo());
		
		String[][] noData = {{"no", "data"}, {"no", "data"}};
		if (loadInfo() == noData){
			JLabel tempLabel = new JLabel("������Ϣ");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("����Ϣ");
			
			infoTable = new DataTable(colNames, this);
			infoTable.setOpaque(true);	// ��֪�����Ǹ�ʲô�õģ�����ûʲô��Ӧ
			this.add(infoTable, BorderLayout.CENTER);
			this.setVisible(true);
		}
		//this.add(infoPanel, BorderLayout.CENTER);*/
		JTableRefresh();
		
		addButton.addActionListener(this);	// Ϊ addButton ���ʱ����������ɵ�ǰ���� (this) ���м���
		quitButton.addActionListener(this);
		changeButton.addActionListener(this);
		refreshButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	public void JTableRefresh(){
		JPanel infoPanel = new JPanel();
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("�������б�"));
		System.out.println(loadInfo());
		
		String[][] noData = {{"no", "data"}, {"no", "data"}};
		if (loadInfo() == noData){
			JLabel tempLabel = new JLabel("������Ϣ");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("����Ϣ");
			
			infoTable = new DataTable(colNames, this);
			infoTable.setOpaque(true);	// ��֪�����Ǹ�ʲô�õģ�����ûʲô��Ӧ
			this.add(infoTable, BorderLayout.CENTER);
			this.setVisible(true);
		}
		//this.add(infoPanel, BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("���")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			HirePersonAddDialog newHirePerson = new HirePersonAddDialog(this);
		}
		if (e.getActionCommand().equals("�޸�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog(this);
		}
		if (e.getActionCommand().equals("ɾ��")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			DeleteDialog deleteDialog = new DeleteDialog(this);
		}
		if (e.getActionCommand().equals("�˳�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			System.exit(0);
		}
		if (e.getActionCommand() == "ˢ��"){
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
		            //System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
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
	private boolean DEBUG = true;	// ��֪���Ǹ�ʲô��
	
	String originalVal[] = new String[8];
	
	HirePerson hirePerson;
	
	public DataTable(String[] colNames, HirePerson initHirePerson){
		super(new BorderLayout());
		hirePerson = initHirePerson;
		Object[][] data = hirePerson.loadInfo();
		// ��֪����������������ô���ģ�����һ���Ǳ�ͷ��һ������ʾ������
		
		this.setBorder(BorderFactory.createTitledBorder("�������б�"));
		
		final JTable dataTable = new JTable(data, colNames);
		
		// ��֪�����Ǹ�ʲô��
		if (DEBUG){
			dataTable.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e) {
                    directChangeData(dataTable);
                }
			});
		}
		
		// Create the scroll pane and add the table to it.
        //��Ҳ�ǹٷ�����ʹ�õķ�ʽ�������ͷ������ʾ����Ҫ������ȡ��TableHeader�Լ��ֶ��������ʾ
		JScrollPane scrollPane = new JScrollPane(dataTable);
		
		// ������ʾ�������ҵĴ��룬���ǲ����
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
}
