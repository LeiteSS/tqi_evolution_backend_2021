package br.com.tqi.loanapi.repository;

import br.com.tqi.loanapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address, Long>  {
}
