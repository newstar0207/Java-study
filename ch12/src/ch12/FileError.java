package ch12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileError {

	private int[] list;
	private static final int SIZE = 10;

	public FileError() {
		list = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			list[i] = i;
			writeList();
		}
	}

	public void writeList() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("outfile.txt"));
			for (int i = 0; i < SIZE; i++)
				out.println("배열 원소 " + i + " = hi~" + list[i]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("ArrayIndexOutOfBoundsException : "); // 배열의 인덱스 오류
		} catch (IOException e) {
			System.err.println("IOException"); // 입출력 오류
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	public static void main(String[] args) {
		new FileError();
	}

}