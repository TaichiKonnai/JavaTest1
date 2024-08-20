package Test.pass;

import Test.exception.BankException;

public class PassBook implements Pass {

    // 名前
    private String name;

    // 支店番号
    private int branchNumber;

    // 口座番号
    private int accountNumber;

    // 残高
    private int money;

    public PassBook(String name, int branchNumber, int accountNumber, int money) {
        this.name = name;
        this.branchNumber = branchNumber;
        this.accountNumber = accountNumber;
        this.money = money;
    }

    // 問題2～5の記述はここから

    /* 問題２残高確認
    public int getBalance() {
        return money;
    }
*/
    public void checkBalance() {
        System.out.println(name + "様の残高は" + money + "円です。");
    }

    // 問３ 預け入れ
    public void deposit(int en) {
        money += en;
        System.out.println(en + "円を預け入れました。現在の残高は" + money + "円です。");
    }

    // 問４ 引き落とし
    public void withdraw(int en) throws BankException {
        if (en > money) {
            throw new BankException("残高不足です。");
        }
        money -= en;
        System.out.println(en + "円を引き落としました。現在の残高は" + money + "円です");
    }
    
    //問５ 振込
    
}
// ゲッターセッター(必要に応じて追加する事)
