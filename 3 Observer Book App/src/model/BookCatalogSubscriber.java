package model;

import java.util.List;

public interface BookCatalogSubscriber {
    void update(List<Book> books);
}