package Prac15;

public class CreateTextDocument implements ICreateDocument {
	public IDocument createNew() {
		return new TextDocument();
	}

	public IDocument createOpen() {
		TextDocument doc = new TextDocument();
		doc.openFile();
		return doc;
	}
}
