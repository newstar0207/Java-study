package ch14;

public class OutOfResourcesException extends Exception{
    public OutOfResourcesException() {
        System.out.println("OutOfResourcesException ��ü ����");
    }

    public OutOfResourcesException(String msg) {
        super(msg);
        System.out.println("OutOfResourcesException ��ü ����");
    }
}