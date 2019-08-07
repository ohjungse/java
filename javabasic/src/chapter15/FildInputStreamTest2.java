package chapter15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FildInputStreamTest2 {
	public static void main(String[] args) {
		try {
			FileReader fis = new FileReader("d://data//input.txt");
			int i;
			String s = new String();
			while((i = fis.read()) != -1) {
				s = (s+(char)i);
				System.out.print((char)i);// 읽어온 바이트를 문자로 변환하여 출력한다.
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
