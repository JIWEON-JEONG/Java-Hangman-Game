package hangman;

import java.io.*;

public class Hangman {

	// TODO Auto-generated method stub
	String hiddenString; // 숨겨진 문자열
	StringBuffer outputString; // 플레이어의 입력에 따른 결과로 보여줄 문자열
	StringBuffer inputString; // 플레이어가 입력한 문자들의 모임
	int remainder; // 맞힐 문자열(못맞히고 남아있는 문자의 수)
	int failed; // 실패한 횟수

	public Hangman() throws IOException {
		hiddenString = "hello";
	}

	public int playGame() throws IOException {
		outputString = new StringBuffer();
		for (int i = 0; i < hiddenString.length(); i++) {
			// hiddenString의 문자수 만큼 '-' 출력
			outputString.append("-");
		}
		inputString = new StringBuffer();
		remainder = hiddenString.length(); // 맞힐 문제의 문자수
		failed = 0;

		System.out.println("\n단어(" + hiddenString.length() + "글자" + ")" + outputString);
		drawMan();
		do {
			checkChar(readChar()); // 한문자를 입력받아 정답인지 확인
			System.out.println("\n단어(" + hiddenString.length() + "글자" + ")" + outputString);
			drawMan(); // 입력문자에 따른 교수대 출력
		} while ((remainder > 0) && (failed < 6)); // 문제를 맞히거나, 시도횟수 6번 이상이거나

		return failed;
	}

	public void checkChar(char guess) 
		{
			boolean already = false;
			for(int i=0;i<inputString.length();i++) {
				//이미 입력했던 문자인지 조사
				if(inputString.charAt(i)==guess) {
					System.out.println("\n이미 입력한 문자입니다. 다시 입력해주세요");
					already = true;
				}
			}
			if(!already) {
				inputString.append(guess);	//입력한 문자들 모임에 추가
				boolean success = false;
				for(int i=0; i<hiddenString.length();i++) {
					if(hiddenString.charAt(i) == guess) {
						//문제에 해당 문자가 있는지 조사
						outputString.setCharAt(i,guess); //문제에 문자가 있으면 -를 문자로 변경
						remainder--;	//맞힐 문자수 감소
					 	success=true;	//입력한 문자가 문제에 있었음을 표시	
					}
				}
				if(!success) failed++;	//입력한 문자가 문제에 없으면 실패 횟수를 1증가		
			}
		}
	public void drawMan() {
		System.out.println(failed);
	}

	public char readChar() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;

		System.out.println("1. 문자를 입력하세요");
		user = in.readLine(); // 키보드로 부터 한줄을 입력
		return user.charAt(0); // 입력받은 문자열중 첫번째 문자를 반환
	}

}
