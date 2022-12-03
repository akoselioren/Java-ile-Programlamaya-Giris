package throwDemo;

public class Main {

	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		manager.deposit(100);
		System.out.println("Hesap : " + manager.getBalance());
		try {
			manager.withdraw(110);
		} catch (BalanceInsufficentException exception) {
			System.out.println(exception.getMessage());
		}

	}

}
