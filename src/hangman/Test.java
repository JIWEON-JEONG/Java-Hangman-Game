package hangman;
import java.io.*;

public class Test {
	public static void main(String[] args) throws IOException
	{
		Hangman hangman = new Hangman();
		int result = hangman.playGame();	//������ ����
		
		System.out.println();
		if(result<=5) {
			System.out.println("Nice bay");
		}
		else {
			System.out.println("�й� �ϼ���");
		} 
	}
}

