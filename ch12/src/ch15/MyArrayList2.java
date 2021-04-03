package ch15;

import java.util.ArrayList;

public class MyArrayList2<T>{

	private Object[] arr;  
	private int capacity = 10;
	private int size = 0;

	public MyArrayList2() {
		arr = new Object[capacity]; // new 있을경우 T 를 명시 못함 -> object 로 하고 typecasting 해야함
	}

	public void add(T value) {
		if(size == capacity) {
			increaseCapacity();
		}
		arr[size++] = value;
	}

	public int size() {
		return size;
	}
	
	public T get(int index) {
		return (T)arr[index];
	}
	
	public void add(int idx, T value) {
		
		if(capacity == size) {
			increaseCapacity();
		}
		// 맨 뒤에 있는 인덱스를 민다
		for(int i = size-1; i >= idx; i--) {
			arr[i +1] = arr[i];
		}
		
		arr[idx] = value;
		size++;
	}
	// 기존의 저장된건 자바의 garbagecollecter 가 없엠;
	private void increaseCapacity() {
		if( size >= capacity) {
			capacity = capacity + capacity/2;
			Object[] tmp = new Object[capacity];
			for( int i = 0 ; i < size; i++) {
				tmp[i] = arr[i];
			}
			arr = tmp;
		}	
	}
	
	public void remove() {
		if (size > 0) size--;
	}
	
	public void remove(int idx) {
		for(int i = idx; i < size; i++)
			arr[i] = arr[i + 1];
	}
	
	@Override
	public String toString() {
		if (size == 0) return  "[]";
		String result = "[";
		
		for(int i = 0; i < size -1 ; i++) {
			result += arr[i] + ",";
			if( (i+1) % 10 == 0)
				result += "\n";
		}
		result += arr[size -1];
		result += "]";
		return result;
	}

	public static void main(String[] args) {

//		MyArrayList2 list = new MyArrayList2();
//		list.add(3); // 인덱스 번호에 값을 대입
//		list.remove(3); // 인덱스 번호를 삭제
//		list.remove(T.valueOf(100)); // 그 값을 삭제(들어있는 값)

//		for(int i = 0; i < 10; i++) {
//			list.add(i);
//		}
//		
//		list.add(2, 100);
//		
//		System.out.println(list);
		
		MyArrayList2 array = new MyArrayList2();
		for(int i = 0; i < 100; i++) {
			array.add(i + "hi");
		}
		
		System.out.println(array);
		
		array.remove(3);
		
		System.out.println(array);
	}
}
