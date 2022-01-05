package br.com.tqi.loanapi.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private Long id;

    @Column(name = "date_payment")
    private LocalDate datePayment;

    @Column(name = "payment_quantity")
    private Integer paymentQuantity;

    @Column(name = "value")
    private Double value;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
