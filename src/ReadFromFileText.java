import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileText {

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
                //System.out.println("line " + line + ": " + tempString);
                System.out.println(tempString);
                line++;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadFromFileText reader = new ReadFromFileText();
		System.out.println(System.getProperty("user.dir"));
		reader.readFileByLines("src/WhatTheFuck.txt");
		File testFile = new File("src/data", "test.txt");
		try {  
            if (testFile.createNewFile()) {  
                System.out.println("�ɹ���");  
            } else {  
                System.out.println("ʧ�ܣ�");  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("���������ļ�ʧ�ܣ�" + e.getMessage());
        }  
	}

}
