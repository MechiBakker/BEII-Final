package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {

    private FeignBillRepository feignBillRepository;

    public List<Bill> getBillByUser(String id){
        ResponseEntity<List<Bill>> response = feignBillRepository.getBillByUser(id);
        return response.getBody();
    }
}
