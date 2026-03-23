import controller.BookController;
import model.BookCatalog;
import view.BookFrame;

public class App {
    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();
        BookFrame frame = new BookFrame();

        new BookController(catalog, frame);

        frame.setVisible(true);

    }
}
