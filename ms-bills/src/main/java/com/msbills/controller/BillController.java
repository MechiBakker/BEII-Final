package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Bill>> getAll() {

        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Bill>> getBillsByUser(@PathVariable String id){
        return ResponseEntity.ok().body(service.getBillByUser(id));
    }

    @PostMapping("/saveBill")
    @PreAuthorize("hasAuthority('/GROUP_PROVIDERS')")
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill, Authentication authentication){
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getSubject();
        return ResponseEntity.ok(service.saveBill(bill, userId));
    }
}
