import java.util.Scanner;

public class AccountingApp {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("*****����:���� ����*****");
			System.out.println("�Ѵ� �� ������ �Է��ϼ���: ");
			int revenue = Integer.parseInt(sc.nextLine());
			double vatRate = 0.1;
			double vat = revenue *vatRate;
			double costRate = 0.3;
			double cost = revenue*costRate;
			double pureRevenue = revenue - vat - cost;
			double a = pureRevenue * 0.5;
			double b = pureRevenue * 0.3;
			double c = pureRevenue * 0.2;
			System.out.println("������ ������ : "+a+"�� �Դϴ�.");
			System.out.println("b ����� ������ : "+b+"�� �Դϴ�.");
			System.out.println("c ����� ������ : "+c+"�� �Դϴ�.");
	}

}
