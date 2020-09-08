import java.util.*;



	class transaction{
	
	float deposite(float amt){
		return 0;

	}
	
	float withdraw(float amt) {
		return 0;
	}
	
	float dis_bal() {
		return 0;
	}
	}
	
class Checking_acc extends transaction{ 
	
	float c_bal;
	
	Checking_acc(){
		c_bal=10000;
	}
	
	float deposite(float amt){
		c_bal+=amt;
		System.out.println(amt+" Rs has been deposited to your account");
		
		return c_bal;

	}
	
	float withdraw(float amt) {
	
		if(c_bal<0 || c_bal<amt) {
			System.out.println("Low Balance!!!");
		}
		else {
		c_bal-=amt;
		System.out.println(amt+" Rs has been withdrawn from your account");
		}
		return c_bal;
		
	}
	float dis_bal() {
		return c_bal;
	}
}

class Saving_acc extends transaction{
	float s_bal;
	Saving_acc(){
		s_bal=10000;
	}
	
	float deposite(float amt){
		s_bal+=amt;
		System.out.println(amt+" Rs has been deposited to your account");
		
		return s_bal;

	}
	
	float withdraw(float amt) {
	
		if(s_bal<0 || s_bal<amt) {
			System.out.println("Low Balance!!!");
		}
		else {
		s_bal-=amt;
		System.out.println(amt+" Rs has been withdrawn from your account");
		}
		return s_bal;
		}
	float dis_bal() {
		return s_bal;
	}
}
public class Bank_system {
	
	public static void main(String []args) {
		
		Checking_acc c=new Checking_acc();
		
		Saving_acc s=new Saving_acc();
		
		Map<String,Float> checking=new Hashtable<>();
		
		Map<String,Float> saving=new Hashtable<>();
		
		float amount=0;
		char acc_type;
		int choice;
		boolean exit=false,exit1=false;
		Scanner Sc=new Scanner(System.in);
		
		do {
			System.out.println("Enter c for Checking_account, s for Saving_account and e to exit");

			acc_type=Sc.next().charAt(0);
		switch(acc_type) {
		
		case 'c':
		do {
		
		System.out.println("Enter 1 for Deposite, 2 for withdraw and 3 to exit");

		choice=Sc.nextInt();
		
		switch(choice) {
		
		case 1:
			//deposite
			float balance;
			
			System.out.println("Enter amount to be deposited in multiple of 500");
			amount=Sc.nextFloat();
			while((amount>0) && ((amount%500)!=0)) {
				System.out.println("Please enter amount to be deposited in multiple of 500");
				amount=Sc.nextFloat();

			}
			balance=c.deposite(amount);
		
			checking.put("credited",amount);
			
			
			
			break;
		
		case 2:
			//withdraw
			System.out.println("Withdraw");

			System.out.println("Enter amount to be withdrawn in multiple of 500");
				
			amount=Sc.nextFloat();
			while((amount>0) && ((amount%500)!=0)) {
				System.out.println("Please enter amount to be withdrawn in multiple of 500");
				amount=Sc.nextFloat();
			}
			balance=c.withdraw(amount);
			checking.put("debited",amount);
			
			break;
		case 3:
			exit= true;
		default:
			System.out.println("you entered a wrong choice");
		
		}
		}while(!exit);
		
		break;
		
		case 's':
			do {
				
				System.out.println("Enter 1 for Deposite, 2 for withdraw and 3 to exit");

				choice=Sc.nextInt();
				
				switch(choice) {
				
				case 1:
					//deposite
					float balance;
					
					System.out.println("Enter amount to be deposited in multiple of 500");
					amount=Sc.nextFloat();
					while((amount>0) && ((amount%500)!=0)) {
						System.out.println("Please enter amount to be deposited in multiple of 500");
						amount=Sc.nextFloat();
			

					}
					balance=s.deposite(amount);
					
					saving.put("credited",amount);
					
					
					
					break;
				
				case 2:
					//withdraw
					System.out.println("Withdraw");

					System.out.println("Enter amount to be withdrawn in multiple of 500");
						
					amount=Sc.nextFloat();
					while((amount>0) && ((amount%500)!=0)) {
						System.out.println("Please enter amount to be withdrawn in multiple of 500");
						amount=Sc.nextFloat();
					}
					balance=s.withdraw(amount);
					saving.put("Debited",amount);
								
					
					break;
				case 3:
					exit= true;
				default:
					System.out.println("you entered a wrong choice");
				
				}
				}while(!exit);

			break;
			
		case'e':
			exit1=true;
		}		
		}while(!exit1);
		
		System.out.println("Saving Account");
		System.out.println(saving);
		System.out.println("Saving Account Balamce is : " +s.dis_bal());
		
		System.out.println("Checking Account");
		System.out.println(checking);
		System.out.println("Checking Account Balamce is : " +c.dis_bal());
		
	}

}
