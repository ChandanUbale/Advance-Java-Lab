package program1;

public class Contacts {
	String name;
	String number;
	
	Contacts(String name,String number){
		this.name=name;
		this.number =number;
	}
	public String toString() {
		return name+" : "+number;
	}
}
