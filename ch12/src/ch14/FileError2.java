package ch14;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError2 {
    public static void main(String[] args) {
        writeList();
    }
    private static void writeList() {
        PrintWriter out = null;
        // AutoClosable �������̽��� �����ؾ� �Ѵ�
        // �� ��ü�� try with resources ���� ���� �� �ִ�.
        try (FileWriter fw = new FileWriter("out3.txt")) {
            out = new PrintWriter(fw);
            out.println("Hello? I love you.");
            System.out.println("�۾�����...");
            // out.close();
        }catch(IOException e) {
            System.out.println("catch:"+e.getMessage());
        } 
    }  
}