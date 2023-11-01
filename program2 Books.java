package program2;

public class Books {
	int id,price;
	String title,author,publisher;
	Books(int id,int price,String title,String author,String publisher){
		this.id=id;
		this.price=price;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
	}
	
	public String toString() {
		return "id :"+id+" name : "+title+" author :"+author+" price :"+price+" publisher :"+publisher;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}
}
