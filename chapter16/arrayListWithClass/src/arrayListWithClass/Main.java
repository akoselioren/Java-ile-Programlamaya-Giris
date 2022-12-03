package arrayListWithClass;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		Customer abdullah = new Customer(1, "Abdullah", "Köselioren");

		customers.add(abdullah);
		customers.add(new Customer(2, "Berkay", "Işıklı"));
		customers.add(new Customer(3, "Mehmet", "Topçu"));

		customers.remove(abdullah);
		for (Customer customer : customers) {
			System.out.println(customer.firstName);
		}
	}

}
