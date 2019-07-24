package chapter07;

public class SmallAlphabet {

	public static void main(String[] args) {
		char[][] alphabet = new char [13][2];
		char ch = 'a';
	
		for(int i = 0; i < alphabet.length; i++)
		{
			
			
			for(int j =0; j <alphabet[i].length; j++, ch++) 
			{
				System.out.println(alphabet[i]);
				alphabet[i] = ch;
//				alphabet[i][j] = ch;
				System.out.printf("%3c",alphabet[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
}
