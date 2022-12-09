package Prac15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextRedactorCarcass extends JFrame {
	private JTextArea textArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem newFile = new JMenuItem("New");
	private JMenuItem openFile = new JMenuItem("Open");
	private JMenuItem saveFile = new JMenuItem("Save");
	private JMenuItem exit = new JMenuItem("Exit");
	private ICreateDocument createDocument = new CreateTextDocument();
	private IDocument document = null;

	public TextRedactorCarcass() {
		super("Text Redactor");
		setSize(600, 400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(textArea, BorderLayout.CENTER);
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(exit);


		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCreateDocument(new CreateTextDocument());//picking the document type
				document = createDocument.createNew();
				if (document instanceof TextDocument) {
					showContent(((TextDocument) document).getText());
				}
			}
		});

		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCreateDocument(new CreateTextDocument());//picking the document type
				document = createDocument.createOpen();
				document.openFile();
				if (document instanceof TextDocument) {
					showContent(((TextDocument) document).getText());
				}
			}
		});

		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				document.saveFile();
				if (document instanceof TextDocument) {
					showContent(((TextDocument) document).getText());
				}
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void setCreateDocument(ICreateDocument createDocument) {
		this.createDocument = createDocument;
	}

	public void showContent(String content) {
		textArea.setText(content);
	}

	public static void main(String[] args) {
		TextRedactorCarcass app = new TextRedactorCarcass();
		app.setVisible(true);
	}
}
