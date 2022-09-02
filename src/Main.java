public class Main {
	public static void main(String[] args) {
		Book daBook = new Book("zog", 2000);
		System.out.println(daBook);

		AuthorTest.testMain();
	}
}

class Book{
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

class AuthorTest{
	public static void testMain(){
		Author t = new Author("placeholderName", "job.done", '1');
		System.out.println(t.getName() + " " + t.getEmail());
		System.out.println(t);
	}
}

class Author{
	private String name;
	private String email;
	private char gender;

	public Author(String name, String email, char gender){
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName(){
		return(this.name);
	}
	public String getEmail(){
		return(this.email);
	}
	public void setEmail(String email){
		this.email = email;
	}
	public char getGender(){
		return(this.gender);
	}

	@Override
	public String toString() {
		return "Author:" + name + ' ' + email + ' ' + gender;
	}
}
