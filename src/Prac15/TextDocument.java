package Prac15;

public class TextDocument implements IDocument {
	private String text;

	public TextDocument() {
		text = "new text file "; //for tests
	}

	public void newFile() {
		text = "new text file "; //for tests
	}

	public void openFile() {
		text = "open text file "; //for tests
	}

	public void saveFile() {
		text = text + "saved "; //for tests
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
