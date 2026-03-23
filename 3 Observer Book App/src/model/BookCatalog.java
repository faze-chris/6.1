package model;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {
    private List<Book> books;
    private List<BookCatalogSubscriber> subscribers;

    public BookCatalog() {
        books = new ArrayList<Book>();
        subscribers = new ArrayList<BookCatalogSubscriber>();
    }

    public void subscribe(BookCatalogSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void addBook(Book book) {
        books.add(book);
        notifySubscribers();
    }

    public List<Book> getBooks() {
        return new ArrayList<Book>(books);
    }

    private void notifySubscribers() {
        List<Book> contextData = getBooks();

        for (BookCatalogSubscriber subscriber : subscribers) {
            subscriber.update(contextData);
        }
    }
}