package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Country;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository){
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();
        Division division = divisionRepository.getReferenceById(03L);

        divisionRepository.save(division);

        customer1.setFirstName("Susan");
        customer1.setLastName("Nasus");
        customer1.setDivision(division);
        customer1.setAddress("123 Tim Street");
        customer1.setPostal_code("78972");
        customer1.setPhone("555-555-5555");

        customerRepository.save(customer1);

        customer2.setFirstName("Matty");
        customer2.setLastName("TyyaM");
        customer2.setDivision(division);
        customer2.setAddress("124 Tim Street");
        customer2.setPostal_code("68972");
        customer2.setPhone("666-555-5555");

        customerRepository.save(customer2);

        customer3.setFirstName("Tim");
        customer3.setLastName("Mit");
        customer3.setDivision(division);
        customer3.setAddress("125 Tim Street");
        customer3.setPostal_code("13972");
        customer3.setPhone("777-555-5555");

        customerRepository.save(customer3);

        customer4.setFirstName("Tom");
        customer4.setLastName("Mot");
        customer4.setDivision(division);
        customer4.setAddress("126 Tim Street");
        customer4.setPostal_code("7456972");
        customer4.setPhone("888-555-5555");

        customerRepository.save(customer4);

        customer5.setFirstName("Leo");
        customer5.setLastName("Oel");
        customer5.setDivision(division);
        customer5.setAddress("127 Tim Street");
        customer5.setPostal_code("567572");
        customer5.setPhone("999-555-5555");

        customerRepository.save(customer5);




    }

}
