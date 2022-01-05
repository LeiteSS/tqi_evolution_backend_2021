package br.com.tqi.loanapi.controller;

import br.com.tqi.loanapi.controller.docs.LoansControllerDocs;
import br.com.tqi.loanapi.dto.LoanDTO;
import br.com.tqi.loanapi.repository.model.Loans;
import br.com.tqi.loanapi.service.LoansService;
import br.com.tqi.loanapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/loans")

public class LoansController implements LoansControllerDocs {

    @Autowired
    private LoansService loansService;

    @Override
    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@Valid @RequestBody LoanDTO loanDTO, HttpServletRequest request) throws Exception
    {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(loansService.createLoan(loanDTO, token));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Loans>> listLoans(HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(loansService.listLoans(token));
    }

    @Override
    @GetMapping("/{id}")
    public Loans detailLoan(@PathVariable Long id, HttpServletRequest request) {
        String token = TokenUtils.wrapperToken(request);

        return loansService.detailLoan(id, token);
    }
}
