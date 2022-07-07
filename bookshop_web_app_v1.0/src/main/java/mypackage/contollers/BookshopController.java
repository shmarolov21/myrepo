package mypackage.contollers;

import mypackage.dao.BookshopDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class BookshopController {
    private final BookshopDAO bookshopDAO;

    @Autowired
    public BookshopController(BookshopDAO bookshopDAO) {
        this.bookshopDAO = bookshopDAO;
    }

    @GetMapping()
    public String index() {
        return "bookshop/index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authors", bookshopDAO.getAuthorsList());

        return "bookshop/authors";
    }

    @GetMapping("/books")
    public String booksPage(Model model) {
        model.addAttribute("books", bookshopDAO.getBooksList());

        return "bookshop/books";
    }

    @GetMapping("/authors/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", bookshopDAO.show(id));

        return "bookshop/show";
    }

    @GetMapping("/books/{id}")
    public String showInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("authors", bookshopDAO.showAuthor(id));

        return "bookshop/about_book";
    }
}
