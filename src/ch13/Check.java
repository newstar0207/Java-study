package ch13;
import java.util.ArrayList;
import java.util.Arrays;
//38�� �ּ�
public class Check {
    public static void main(String[] args) {
        String input = "������,���翵,����ǥ,���翵,�ڹ�ȣ,������,���翵,������,�ֽ���,�̼���,�ڿ���,�ڹ�ȣ,������,����ȯ,���缺,������,������";
        String[] names = input.split(",");

        int count_kim = 0;
        int count_lee = 0;
        int count_ljy = 0;
        ArrayList<String> name_list = new ArrayList<String>();

        for(int i = 0; i < names.length; i++) {
            if(names[i].startsWith("��"))
                count_kim++;
            if(names[i].startsWith("��"))
                count_lee++;
            if(names[i].equals("���翵"))
                count_ljy++;
            if(!name_list.contains(names[i]))
                name_list.add(names[i]);
        }
        String[] name_arr = name_list.toArray(new String[name_list.size()]);

        System.out.println("�� ��: " + count_kim);
        System.out.println("�� ��: " + count_lee);

        System.out.println("���翵 ��: " + count_ljy);

        System.out.println("�ߺ��� ������ �̸�: ");
        for(int i = 0; i < name_arr.length; i++)
            System.out.print(name_arr[i] + ((name_arr.length == i + 1)?"\n":", "));

        Arrays.sort(name_arr);
        System.out.println("�ߺ��� ������ �̸��� ������������: ");
        for(int i = 0; i < name_arr.length; i++)
            System.out.print(name_arr[i] + ((name_arr.length == i + 1)?"\n":", ")); // ��ü���̰� i+1�� ���̿� ������ �ٳѱ� �ƴϸ� "," ���! ���־���!

    }
}
