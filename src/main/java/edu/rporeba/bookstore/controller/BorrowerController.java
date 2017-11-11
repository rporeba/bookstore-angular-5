package edu.rporeba.bookstore.controller;

import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.dto.BorrowerDto;
import edu.rporeba.bookstore.model.Borrower;
import edu.rporeba.bookstore.model.JsonResponse;
import edu.rporeba.bookstore.service.BorrowerService;
import edu.rporeba.bookstore.viewmodel.BorrowerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rporeba on 15.07.2016.
 */

@Controller
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('DBA')")
    @RequestMapping(value = "/newborrower", method = RequestMethod.GET)
    public String addBorrower(@ModelAttribute("command") BorrowerCommand command) {

        BorrowerDto borrowerDto = new BorrowerDto();
        command.setBorrowerDto(borrowerDto);
        return "borrowerForm";
    }

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('DBA')")
    @RequestMapping(value = "/newborrower", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JsonResponse saveBorrower(@RequestBody BorrowerDto borrowerDto, BindingResult result) {

        JsonResponse res = new JsonResponse();

        ValidationUtils.rejectIfEmpty(result, "firstName", "First name can not be empty.");
        ValidationUtils.rejectIfEmpty(result, "lastName", "Last name can not be empty.");

        if (!result.hasErrors()) {
            res.setStatus("SUCCESS");
            borrowerService.saveBorrower(borrowerDto);

        } else {
            res.setStatus("FAIL");
            res.setResult(result.getAllErrors());
        }

        return res;

    }

    @RequestMapping(value = {"/borrowers"}, method = RequestMethod.GET)
    public String getAllBorrowersForm(@ModelAttribute("command") BorrowerCommand command) {

        List<BorrowerDto> borrowerList = borrowerService.findAll();
        command.setBorrowerList(borrowerList);

        return "borrowers";

    }

    @RequestMapping(value = "/borrowers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<BorrowerDto> getAllBorrowers() {

        return borrowerService.findAll();

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Borrower deleteBorrower(@PathVariable Long id) {

        return borrowerService.removeBorrower(id);
    }


}
