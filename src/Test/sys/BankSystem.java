package Test.sys;

import java.util.Map;
import java.util.Scanner;

import Test.data.Data;
import Test.exception.BankException;
import Test.pass.PassBook;

public class BankSystem {
	public static void main(String[] args) {

		Map<Integer, PassBook> data = Data.start();

		Scanner s = new Scanner(System.in);
		for (;;) {
			System.out.println("ATMをご利用いただきありがとうございます。");
			System.out.println("本日の要件を数字で入力してください");
			System.out.println("--------------------------------------");
			System.out.println("1,残高確認");
			System.out.println("2,預入");
			System.out.println("3,引き落とし");
			System.out.println("4,お振込み");
			int input = s.nextInt();
			System.out.println("--------------------------------------");
			System.out.println("使用する口座を選択してください");
			for (int i = 1; i <= data.size(); i++) {
				System.out.println(i + ":" + data.get(i).getName());
			}
			int user = s.nextInt();
			System.out.println(data.get(user).getName() + "様ですね、ご利用ありがとうございます。");
			System.out.println();
			try {
				switch (input) {
				case 1:
					data.get(user).checkBalance();
					break;
				case 2:
					System.out.println("幾ら預けますか？");
					System.out.println("数字だけで入力ください");
					int moneyIn = s.nextInt();
					data.get(user).deposit(moneyIn);
					break;
				case 3:
					System.out.println("幾ら引き落としますか？");
					System.out.println("数字だけで入力ください");
					int moneyOut = s.nextInt();
					data.get(user).withdrawal(moneyOut);
					break;
				case 4:
					System.out.println("どなたに振込しますか？");
					for (int i = 1; i <= data.size(); i++) {
						System.out.println(i + ":" + data.get(i).getName());
					}
					int user2 = s.nextInt();
					System.out.println("幾ら引き落としますか？");
					System.out.println("数字だけで入力ください");
					int moneyPoint = s.nextInt();
					data.get(user).transfer(data.get(user), data.get(user2), moneyPoint);
					break;
				default:
					System.out.println("予期せぬ数字が入力されています。");
					System.out.println("もう一度初めから操作を行ってください");
					break;
				}
			} catch (NullPointerException e) {
				System.out.println("エラーが発生しました。もう一度初めから操作を行ってください");				
			} catch (BankException e) {
				e.printStackTrace();
				System.out.println("エラーが発生しました。もう一度初めから操作を行ってください");
			} finally {
				System.out.println();
			}
		}
	}
}
