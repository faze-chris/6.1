import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookApp extends JFrame {

    private JTextField titleField;
    private JTextField authorField;
    private JButton addButton;
    private JList<String> bookList;
    private DefaultListModel<String> listModel;

    private List<String> books;

    public BookApp() {
        books = new ArrayList<>();

        setTitle("Book App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        titleField = new JTextField(15);
        authorField = new JTextField(15);
        addButton = new JButton("Voeg toe");

        listModel = new DefaultListModel<>();
        bookList = new JList<>(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Titel:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Auteur:"));
        inputPanel.add(authorField);
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(bookList), BorderLayout.CENTER);

        addButton.addActionListener(e -> addBook());

        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();

        if (title.isEmpty() || author.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vul titel en auteur in.");
            return;
        }

        String book = title + " - " + author;
        books.add(book);
        listModel.addElement(book);

        titleField.setText("");
        authorField.setText("");
    }
}