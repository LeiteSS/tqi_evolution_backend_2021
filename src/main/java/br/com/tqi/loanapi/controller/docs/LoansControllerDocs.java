package br.com.tqi.loanapi.controller.docs;

import br.com.tqi.loanapi.dto.ErrorDTO;
import br.com.tqi.loanapi.dto.LoanDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(value = "/api/v1/loans",  description = "Operações relacionadas aos Emprestimos")
public interface LoansControllerDocs {

    @ApiOperation(value = "Pedir um emprestimo", nickname = "createLoan", notes = "", response = LoanDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "Loans", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Emprestimo Pedido!", response = LoanDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@Valid @RequestBody LoanDTO loanDTO, HttpServletRequest request) throws Exception;
}
