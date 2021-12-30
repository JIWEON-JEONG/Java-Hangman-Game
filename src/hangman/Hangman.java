package hangman;

import java.io.*;

public class Hangman {

	// TODO Auto-generated method stub
	String hiddenString; // ������ ���ڿ�
	StringBuffer outputString; // �÷��̾��� �Է¿� ���� ����� ������ ���ڿ�
	StringBuffer inputString; // �÷��̾ �Է��� ���ڵ��� ����
	int remainder; // ���� ���ڿ�(�������� �����ִ� ������ ��)
	int failed; // ������ Ƚ��

	public Hangman() throws IOException {
		hiddenString = "hello";
	}

	public int playGame() throws IOException {
		outputString = new StringBuffer();
		for (int i = 0; i < hiddenString.length(); i++) {
			// hiddenString�� ���ڼ� ��ŭ '-' ���
			outputString.append("-");
		}
		inputString = new StringBuffer();
		remainder = hiddenString.length(); // ���� ������ ���ڼ�
		failed = 0;

		System.out.println("\n�ܾ�(" + hiddenString.length() + "����" + ")" + outputString);
		drawMan();
		do {
			checkChar(readChar()); // �ѹ��ڸ� �Է¹޾� �������� Ȯ��
			System.out.println("\n�ܾ�(" + hiddenString.length() + "����" + ")" + outputString);
			drawMan(); // �Է¹��ڿ� ���� ������ ���
		} while ((remainder > 0) && (failed < 6)); // ������ �����ų�, �õ�Ƚ�� 6�� �̻��̰ų�

		return failed;
	}

	public void checkChar(char guess) 
		{
			boolean already = false;
			for(int i=0;i<inputString.length();i++) {
				//�̹� �Է��ߴ� �������� ����
				if(inputString.charAt(i)==guess) {
					System.out.println("\n�̹� �Է��� �����Դϴ�. �ٽ� �Է����ּ���");
					already = true;
				}
			}
			if(!already) {
				inputString.append(guess);	//�Է��� ���ڵ� ���ӿ� �߰�
				boolean success = false;
				for(int i=0; i<hiddenString.length();i++) {
					if(hiddenString.charAt(i) == guess) {
						//������ �ش� ���ڰ� �ִ��� ����
						outputString.setCharAt(i,guess); //������ ���ڰ� ������ -�� ���ڷ� ����
						remainder--;	//���� ���ڼ� ����
					 	success=true;	//�Է��� ���ڰ� ������ �־����� ǥ��	
					}
				}
				if(!success) failed++;	//�Է��� ���ڰ� ������ ������ ���� Ƚ���� 1����		
			}
		}
	public void drawMan() {
		System.out.println(failed);
	}

	public char readChar() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;

		System.out.println("1. ���ڸ� �Է��ϼ���");
		user = in.readLine(); // Ű����� ���� ������ �Է�
		return user.charAt(0); // �Է¹��� ���ڿ��� ù��° ���ڸ� ��ȯ
	}

}
