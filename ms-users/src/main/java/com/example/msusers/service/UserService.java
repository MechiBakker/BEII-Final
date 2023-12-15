package com.example.msusers.service;

import com.example.msusers.repository.BillRepository;
import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findUserByUserName(String id) {
        return repository.findUserById(id);
    }

    public List<User> findUserById(String id){
        return repository.findUserById(id);
    }

    public List<Bill> findBillByUser(String id){
        User user = repository.findUserById(id).orElse(null);
        List<Bill> bills = billRepository.getBillByUser(id);

        if (user != null){
            user.setUserBills(bills);
            return bills;

        } else{
            return null;
        }
    }
}
