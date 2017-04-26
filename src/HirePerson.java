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
	
	String[] colNames = {"���", "����"};
	
	JDialog addInfoDialog = new JDialog();
	//JFrame addInfoDialog = new JFrame();
	
	public HirePerson(){
		this.setTitle("��������Ϣ����");
		this.setVisible(true);
		this.setBounds(200, 200, 800, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel operatePanel = new JPanel();
		operatePanel.setBorder(BorderFactory.createTitledBorder("��������Ϣ����"));
		JButton addButton, changeButton, deleteButton, quitButton;
		addButton = new JButton("���");
		changeButton = new JButton("�޸�");
		deleteButton = new JButton("ɾ��");
		quitButton = new JButton("�˳�");
		operatePanel.add(addButton);
		operatePanel.add(changeButton);
		operatePanel.add(deleteButton);
		operatePanel.add(quitButton);
		this.add(operatePanel, BorderLayout.NORTH);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setVisible(true);
		infoPanel.setBorder(BorderFactory.createTitledBorder("�������б�"));
		System.out.println(loadInfo());
		if (loadInfo() == null){
			JLabel tempLabel = new JLabel("������Ϣ");			
			infoPanel.add(tempLabel);
		}
		else {
			System.out.println("����Ϣ");
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
		
		addButton.addActionListener(this);	// Ϊ addButton ���ʱ����������ɵ�ǰ���� (this) ���м���
		quitButton.addActionListener(this);
		changeButton.addActionListener(this);
		deleteButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("���")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			HirePersonAddDialog newHirePerson = new HirePersonAddDialog();
		}
		if (e.getActionCommand().equals("�޸�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
		}
		if (e.getActionCommand().equals("ɾ��")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			DeleteDialog deleteDialog = new DeleteDialog();
		}
		if (e.getActionCommand().equals("�˳�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
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
