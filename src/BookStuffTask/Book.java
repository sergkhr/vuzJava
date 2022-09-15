package BookStuffTask;

public class Book {
	private String title;
	private int date;

	public Book(String title, int date){
		this.title = title;
		this.date = date;
	}
	public Book(String title){
		this.title = title;
		this.date = 2022;
	}
	public Book(int date){
		this.title = "untitled";
		this.date = date;
	}
	public Book(){
		this.title = "untitled";
		this.date = 2022;
	}

	public void setTitle(String newTitle){
		this.title = newTitle;
	}
	public void setDate(int date){
		this.date = date;
	}
	public String getTitle(){
		return(this.title);
	}
	public int getDate(){
		return(this.date);
	}

	@Override
	public String toString() {
		return title + " " + "dated: " + date;
	}
}
