package program2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class BookDetails {
	Scanner sc = new Scanner(System.in);
	ArrayList<Books> Book = new ArrayList<>();
	ArrayList<Books> book1 = new ArrayList<>();
	
	Comparator<Books> com = new Comparator<Books>() {
	    public int compare(Books B1, Books B2) {
	        if (B1.price < B2.price) {
	            return -1;
	        } else if (B1.price > B2.price) {
	            return 1;
	        } else {
	            return 0;
	        }
	    }
	};

	public void sort() {
	    Collections.sort(Book, com);
	    for (Books b : Book) {
	        System.out.println(b);
	    }
	}

	//reading book details from the user
	public void readBook() {
		int tr;
		 do {
			 System.out.print("enter book id : ");
			 int id = sc.nextInt();
			 System.out.print("enter book name : ");
			 String title = sc.next();
			 System.out.print("enter book author : ");
			 String author = sc.next();
			 System.out.print("enter book publisher : ");
			 String publisher = sc.next();
			 System.out.print("enter book price : ");
			 int price = sc.nextInt();
			 Books b1 = new Books(id,price,title,author,publisher);
			 Book.add(b1);
			 System.out.println("press 1 to enter another book details 0 to exit : ");
			 tr = sc.nextInt();
		 }while(tr==1);
	}
	
	//finding books for the specified author
	public void authorBook(String auth) {
		int flag=0;
		for(Books b: Book) {
			if(b.author.equals(auth)) {
				System.out.println(b);
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("Author does not exist");
		}
	}
	
	//finding the books for price is greater than the user specified
	public void priceGreater(int price) {
		int flag =0;
		for(Books b :Book) {
			if(b.price > price) {
				book1.add(b);
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("No Books");
		}else {
			System.out.println("The books whoose price is greater than "+price);
			System.out.println(book1);	
		}
	}

	//searching books based on their name
	public void searchBook(String title) {
		int flag=0;
		for(Books b: Book) {
			if(b.getTitle().contains(title)){
				System.out.println(b);
				flag=1;
			}
		}
		if(flag==0) {
			System.out.println("no books are available");
		}
	}
	
	//searching and updating publisher details based on the publisher name and book title 
	public void updatePublisher(String publisher,String title) {
		int flag=0,tr;
		for(Books b :Book) {
			if(b.publisher.equals(publisher) && b.title.equals(title)) {
				System.out.println(b);
				flag=1;
			}
		}
		if(!(flag==0)){
			System.out.println("do you want to update publisher details if yes press 1 otherwise 0");
			tr =sc.nextInt();
			if(tr==1) {
				System.out.println("enter new publisher");
				String pub = sc.next();
				for(Books b :Book) {
					if(b.publisher.equals(publisher)) {
						b.setPublisher(pub);
					}
				}
			}
		}
		else {
			System.out.println("no publisher for geaven book");
	}
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		BookDetails bd = new BookDetails();
		while(true) {
			
			System.out.println("Enter your choice");
			System.out.println("1.Read Book details");
			System.out.println("2.Display the book details for specified author name");
			System.out.println("3.Create a new list and display the books for the specified above the price ");
			System.out.println("4.display the based book title");
			System.out.println("5.update publisher ");
			System.out.println("6.sort the books based on their price ");	
			System.out.println("7.exit");
			int choice = sc1.nextInt();
			switch(choice) {
			
			case 1: bd.readBook();
					break;
					
			case 2: System.out.println("Enter the author name to display books");
					String author = sc1.next();
					bd.authorBook(author);
					break;
					
			case 3: System.out.println("Enter the price :");
					int price = sc1.nextInt();
					bd.priceGreater(price);
					break;
					
			case 4: System.out.println("enter book full name or part of a name");
					String title = sc1.next();
					bd.searchBook(title); 
					break;
					
			case 5: System.out.println("Enter publisher name :");
					String publisher = sc1.next();
					System.out.println("Enter book name :");
					title = sc1.next();
					bd.updatePublisher(publisher, title);
					break;
			
			case 6: bd.sort();
					break;
					
			case 7: System.exit(0);
			default : System.out.println("Enter a valid choice");
			
			}
		}
		
	}

}
