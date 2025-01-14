package com.library.management;

import com.library.management.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BorrowingRepository borrowingRepository;

    @GetMapping("/")
    public String index(Model model) {
        // Basic statistics for cards
        model.addAttribute("totalUsers", userRepository.count());
        model.addAttribute("totalBooks", bookRepository.count());
        model.addAttribute("totalAuthors", authorRepository.count());
        model.addAttribute("activeBorrowings",
                borrowingRepository.findByStatus(Borrowing.Status.BORROWED).size());

        return "index"; // Θα χρησιμοποιήσει το index.html του SB Admin
    }

    @GetMapping("/tables")
    public String tables(Model model) {
        // Data for DataTables
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("borrowings", borrowingRepository.findAll());

        return "tables"; // Θα χρησιμοποιήσει το tables.html του SB Admin
    }

    @GetMapping("/charts")
    public String charts(Model model) {
        // Data for charts
        model.addAttribute("borrowingsByStatus",
                borrowingRepository.findByStatus(Borrowing.Status.BORROWED));
        model.addAttribute("usersByRole",
                userRepository.findByRole(User.Role.MEMBER));

        return "charts"; // Θα χρησιμοποιήσει το charts.html του SB Admin
    }
}