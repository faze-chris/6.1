package view;

import model.Book;
import model.BookCatalogSubscriber;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

public class BookFrame extends JFrame implements BookCatalogSubscriber {
    private JTextField titleField;
    private JTextField authorField;
    private JButton addButton;
    private JList<String> bookList;
    private DefaultListModel<String> listModel;

    public BookFrame() {
        setTitle("Book App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        titleField = new JTextField(15);
        authorField = new JTextField(15);
        addButton = new JButton("Voeg toe");

        listModel = new DefaultListModel<String>();
        bookList = new JList<String>(listModel);

        buildLayout();
    }

    private void buildLayout() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Titel:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Auteur:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(bookList), BorderLayout.CENTER);
    }

    public String getTitleInput() {
        return titleField.getText().trim();
    }

    public String getAuthorInput() {
        return authorField.getText().trim();
    }

    public void clearInputs() {
        titleField.setText("");
        authorField.setText("");
    }

    public void addAddBookListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void update(List<Book> books) {
        showBooks(books);
    }

    private void showBooks(List<Book> books) {
        int i;
        Book book;
        String line;

        listModel.clear();

        for (i = 0; i < books.size(); i++) {
            book = books.get(i);
            line = book.getTitle() + " - " + book.getAuthor();
            listModel.addElement(line);
        }
    }
}