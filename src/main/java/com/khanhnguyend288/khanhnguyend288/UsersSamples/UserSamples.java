package com.khanhnguyend288.khanhnguyend288.UsersSamples;

import com.khanhnguyend288.khanhnguyend288.dao.CustomerRepository;
import com.khanhnguyend288.khanhnguyend288.dao.DivisionRepository;
import com.khanhnguyend288.khanhnguyend288.entities.Customer;
import com.khanhnguyend288.khanhnguyend288.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
public class UserSamples implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public UserSamples(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("UserSamples runner started.");

        //
        Division division1 = divisionRepository.findById(31L).orElse(null);
        Division division2 = divisionRepository.findById(32L).orElse(null);
        Division division3 = divisionRepository.findById(33L).orElse(null);
        Division division4 = divisionRepository.findById(34L).orElse(null);
        Division division5 = divisionRepository.findById(35L).orElse(null);

        if (customerRepository.count() < 5) {
            Date now = new Date();
            Customer c1 = new Customer();
            c1.setFirstName("Khanh");
            c1.setLastName("Nguyen");
            c1.setAddress("123 Test Street");
            c1.setPhone("555-0000");
            c1.setPostalCode("99999");
//            c1.setCreate_date(now);
//            c1.setLast_update(now);
            c1.setDivision(division1);
            c1.setCarts(new HashSet<>()); // Prevent null pointer
            customerRepository.save(c1);


            Customer c2 = new Customer();
            c2.setFirstName("Paolo");
            c2.setLastName("Maldini");
            c2.setAddress("Stadio SanSiro");
            c2.setPhone("555-1111");
            c2.setPostalCode("12345");
//            c2.setCreate_date(now);
//            c2.setLast_update(now);
            c2.setDivision(division2);
            c2.setCarts(new HashSet<>());
            customerRepository.save(c2);

            Customer c3 = new Customer();
            c3.setFirstName("Ronaldo");
            c3.setLastName("de Lima");
            c3.setAddress("Estadio Bernabeu");
            c3.setPhone("555-2222");
            c3.setPostalCode("67890");
//            c3.setCreate_date(now);
//            c3.setLast_update(now);
            c3.setDivision(division3);
            c3.setCarts(new HashSet<>());
            customerRepository.save(c3);

            Customer c4 = new Customer();
            c4.setFirstName("Leo");
            c4.setLastName("Messi");
            c4.setAddress("Estadio Camp Nou");
            c4.setPhone("555-3333");
            c4.setPostalCode("54321");
//            c4.setCreate_date(now);
//            c4.setLast_update(now);
            c4.setDivision(division4);
            c4.setCarts(new HashSet<>());
            customerRepository.save(c4);

            Customer c5 = new Customer();
            c5.setFirstName("Thierry");
            c5.setLastName("Henry");
            c5.setAddress("Emirates Stadium");
            c5.setPhone("555-4444");
            c5.setPostalCode("11223");
//            c5.setCreate_date(now);
//            c5.setLast_update(now);
            c5.setDivision(division5);
            c5.setCarts(new HashSet<>());
            customerRepository.save(c5);

            // Verify inserts
            List<Customer> customers = customerRepository.findAll();
            for (Customer c : customers) {
                System.out.println(c.getFirstName() + " " + c.getLastName());
            }

            System.out.println("Inserted customers successfully.");

        }
    }
}
