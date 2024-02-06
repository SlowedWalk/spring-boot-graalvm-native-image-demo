package tech.hidetora.nativeimagedemo.service;

import tech.hidetora.nativeimagedemo.dto.CustomerDTO;
import tech.hidetora.nativeimagedemo.exception.CustomerNotFoundException;
import tech.hidetora.nativeimagedemo.exception.EmailAlreadyExistException;

import java.util.List;

/**
 * @author hidetora
 * @version 1.0.0
 * @since 2022/04/18
 */
public interface CustomerService {
    CustomerDTO saveNewCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException;
    List<CustomerDTO> getAllCustomers();
    CustomerDTO findCustomerById(Long id) throws CustomerNotFoundException;
    List<CustomerDTO> searchCustomers(String keyword);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO)throws CustomerNotFoundException;
    void deleteCustomer(Long id)throws CustomerNotFoundException;
}
