package br.com.tqi.loanapi.controller;

import br.com.tqi.loanapi.controller.docs.LoansControllerDocs;
import br.com.tqi.loanapi.dto.LoanDTO;
import br.com.tqi.loanapi.service.LoansService;
import br.com.tqi.loanapi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(cacheNames = "Loans", allEntries = true)
    public ResponseEntity<LoanDTO> createLoan(@Valid @RequestBody LoanDTO loanDTO, HttpServletRequest request) throws Exception
    {
        String token = TokenUtils.wrapperToken(request);

        return ResponseEntity.ok(loansService.createLoan(loanDTO, token));
    }
}
