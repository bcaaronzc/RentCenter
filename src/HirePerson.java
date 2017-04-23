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
		JLabel tempLabel = new JLabel("�����У������ڴ���");
		infoPanel.setBorder(BorderFactory.createTitledBorder("��������Ϣ�б�"));
		infoPanel.add(tempLabel);
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
		if (e.getActionCommand().equals("�˳�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			System.exit(0);
		}
		if (e.getActionCommand().equals("�޸�")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			ChangeInfoDialog changeInfoDialog = new ChangeInfoDialog();
		}
		if (e.getActionCommand().equals("ɾ��")){		// ��ȡ�����¼����¼�Դ���ı�������ͬ���򵯳�����
			JDialog deleteDialog = new JDialog();
			deleteDialog.setVisible(true);
			deleteDialog.setTitle("ɾ����������Ϣ");
			deleteDialog.setLayout(new GridLayout(2, 2));
			deleteDialog.setBounds(200, 200, 400, 70);
			
			JLabel delete = new JLabel("  ������Ҫɾ���������˱��");
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
