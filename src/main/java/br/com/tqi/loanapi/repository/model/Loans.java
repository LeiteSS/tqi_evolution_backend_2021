package br.com.tqi.loanapi.repository.model;

import java.time.LocalDate;

public interface Loans {
    Long getid_loan();
    Long getuser_id();
    LocalDate getdate_payment();
    Integer getpayment_quantity();
    Double getvalue();
    String getusername();
    String getemail();
    String getname_surname_lastname();
    String getcpf();
    String getrg();
    Double getincome();
}
