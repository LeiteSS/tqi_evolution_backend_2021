package br.com.tqi.loanapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;

    // longadouro em inglês
    @Column(name = "ADDRESS_PUBLIC_AREA", nullable = false)
    private String publicArea;

    @Column(name = "ADDRESS_DISTRICT")
    private String district;

    @Column(name = "ADDRESS_CITY")
    private String city;

    @Column(name = "ADDRESS_STATE")
    private String state;

    @Column(name = "ADDRESS_HOUSE_NUMBER")
    private Integer houseNumber;

    @Column(name = "ADDRESS_ZIP_CODE")
    private String zipCode;

    private Long userId;
}
