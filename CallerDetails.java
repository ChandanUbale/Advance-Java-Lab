package program1;
import java.util.Scanner;
import java.util.ArrayList;

public class CallerDetails {
	
	ArrayList<String> MissCall = new ArrayList<>();
	ArrayList<Contacts> caller1 = new ArrayList<>();
	ArrayList<Contacts> caller = new ArrayList<>();
	Scanner sc =new Scanner(System.in);
	
	int tr;
	//method to read the miss call details from user
	public void readMissCall() {
		
		do {
			System.out.print("enter misscall: ");
			String num = sc.next();
			MissCall.add(num);
			System.out.println("press 1 to enter new number 0 for exit ");
			tr = sc.nextInt();
		}while(tr==1);
	}
	
	//method to read the caller details from user
	public void readCallerDetails() {
		do{
			System.out.print("enter name :");
			String name = sc.next();
			System.out.print("enter number :");
			String number = sc.next();
			Contacts c1 = new Contacts(name,number);
			caller.add(c1);
			System.out.print("enter 1 to new contact 0 to exit :");
			tr = sc.nextInt();
		}while(tr==1);	
	}
	
	//method to check if any miss caller details is exist in Caller(ArrayList) 
	public void check() {
		
		for(String num:MissCall) {
			int flag=0;
			for(Contacts n:caller) {
				if(n.number.equals(num)) {
					System.out.println(n);
					flag =1;
				}
		}
		if(flag==0){
			caller1.add(new Contacts("private_number",num));
		}
	}
		if(!(caller1.isEmpty())) {
			caller.addAll(caller1);
		}
		System.out.println("Caller numbers are below");
		System.out.println(caller);
		//display misscall
		System.out.println("Miss call numbers are below");
		System.out.println(MissCall);
	}
	
	//to delete specified caller details
	public void deleteUser(String num) {
		int flag =0;
		for(Contacts i : caller) {
			if(i.number.equals(num)) {
				caller.remove(num);
				System.out.println("user is removed");
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("user not exist");
		}
	}
	public static void main(String[] args) {
		
		Scanner sc1 =new Scanner(System.in);
		//ArrayList<Contacts> caller1 = new ArrayList<>();
		
		CallerDetails cl = new CallerDetails();
		while(true) {
			System.out.println("ente you choice :");
			System.out.println("1.Enter Contact details :");
			System.out.println("2.Enter misscall :");
			System.out.println("3.Misscall to check in caller details");
			System.out.println("4.delete caller details :");
			System.out.println("5.exit");
			int choice = sc1.nextInt();
			switch(choice) {
			case 1:	cl.readCallerDetails();
					break;
					
			case 2: cl.readMissCall();
					break;
					
			case 3: cl.check();
					break;
					
					
			case 4: System.out.print("Enter the number delete user : ");
					String num = sc1.next();
					cl.deleteUser(num);
					break;
					
			case 5: System.exit(0);
			
			default : System.out.println("Enter valid choice :");
			}
		}
		

	}

}
