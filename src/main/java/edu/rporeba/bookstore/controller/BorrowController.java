package edu.rporeba.bookstore.controller;

import edu.rporeba.bookstore.dto.BorrowDto;
import edu.rporeba.bookstore.service.BorrowService;
import edu.rporeba.bookstore.util.BookAlreadyBorrowedException;
import edu.rporeba.bookstore.viewmodel.BorrowListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/borrows", method = RequestMethod.GET)
    public String getAllBorrows(@ModelAttribute("command") BorrowListCommand command) {

        List<BorrowDto> borrowList = borrowService.findAll();
        command.setBorrowList(borrowList);

        return "borrows";

    }

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('USER')")
    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    public String borrowBook(@RequestParam("itemId") Long itemId, @RequestParam("borrowerId") Long borrowerId) {

        try {

            borrowService.borrowBook(itemId, borrowerId);
            return "redirect:books";

        } catch (BookAlreadyBorrowedException e) {

            e.getErrMsg();
            return "exception";

        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String giveBookBack(@RequestParam("id") Long id) {

        borrowService.giveBookBack(id);

        return "redirect:/books";

    }
}
