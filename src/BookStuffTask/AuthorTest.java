package BookStuffTask;

public class AuthorTest {
	public static void testMain(){
		Author t = new Author("placeholderName", "job.done", '1');
		System.out.println(t.getName() + " " + t.getEmail());
		System.out.println(t);
	}
}
