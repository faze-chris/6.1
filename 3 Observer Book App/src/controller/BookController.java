package controller;

import model.Book;
import model.BookCatalog;
import view.BookFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookController {
    private BookCatalog catalog;
    private BookFrame frame;

    public BookController(BookCatalog catalog, BookFrame frame) {
        this.catalog = catalog;
        this.frame = frame;

        this.frame.addAddBookListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBookFromInput();
            }
        });
    }

    public void addBookFromInput() {
        String title;
        String author;
        Book book;

        title = frame.getTitleInput();
        author = frame.getAuthorInput();

        if (title.equals("") || author.equals("")) {
            frame.showMessage("Vul titel en auteur in.");
            return;
        }

        book = new Book(title, author);
        catalog.addBook(book);

        frame.clearInputs();
    }
}