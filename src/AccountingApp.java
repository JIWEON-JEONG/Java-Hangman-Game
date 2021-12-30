import java.util.Scanner;

public class AccountingApp {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*****제목:월급 계산기*****");
			System.out.println("한달 총 수익을 입력하세요: ");
			int revenue = Integer.parseInt(sc.nextLine());
			double vatRate = 0.1;
			double vat = revenue *vatRate;
			double costRate = 0.3;
			double cost = revenue*costRate;
			double pureRevenue = revenue - vat - cost;
			double a = pureRevenue * 0.5;
			double b = pureRevenue * 0.3;
			double c = pureRevenue * 0.2;
			System.out.println("사장의 월급은 : "+a+"원 입니다.");
			System.out.println("b 사원의 월급은 : "+b+"원 입니다.");
			System.out.println("c 사원의 월급은 : "+c+"원 입니다.");
	}

}
