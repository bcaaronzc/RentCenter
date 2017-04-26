import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OpenAllFileTest {
    public OpenAllFileTest() {
    }
    /**
     * ��ȡĳ���ļ����µ������ļ�
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
            	System.out.println("!isDirectory");
                System.out.println("�ļ�");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());
                System.out.println("!isDirectory");

            } else if (file.isDirectory()) {
                System.out.println("�ļ���");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                        + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
    
    public static void main(String[] args){
    	OpenAllFileTest openAllFile = new OpenAllFileTest();
    	 try {
             readfile("src/data/something");
             // deletefile("D:/file");
     } catch (FileNotFoundException ex) {
     } catch (IOException ex) {
     }
     System.out.println("ok");
    }
}