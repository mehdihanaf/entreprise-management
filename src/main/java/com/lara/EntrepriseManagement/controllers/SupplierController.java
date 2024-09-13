package com.lara.EntrepriseManagement.controllers;

import com.lara.EntrepriseManagement.dto.SupplierDTO;
import com.lara.EntrepriseManagement.service.interfaces.ISupplierService;
import com.lara.EntrepriseManagement.utility.TextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final ISupplierService supplierServiceI;

    private final TextUtil textUtil;

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierDTO>> allSuppliers() {

        List<SupplierDTO> suppliers = supplierServiceI.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(suppliers);
    }


    @PostMapping("/suppliers")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplierDTO) {

        SupplierDTO supplierDTO1 = supplierServiceI.add(supplierDTO);
        String supplier = textUtil.getMessage("supplier");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(supplierDTO1);
    }


    @PutMapping("/suppliers/{id}")
    public ResponseEntity<SupplierDTO> editSupplier(@RequestBody SupplierDTO supplierDTO,@PathVariable("id") Long id) {

        SupplierDTO supplierDTO1 = supplierServiceI.edit(supplierDTO,id);
        String namePrefix = textUtil.getMessage("supplier");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(supplierDTO1);
    }













}
