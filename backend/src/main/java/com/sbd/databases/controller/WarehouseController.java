package com.sbd.databases.controller;

import com.sbd.databases.model.DTO.WarehouseProductDTO;
import com.sbd.databases.service.WarehouseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/secure/warehouse")
public class WarehouseController
{
    private final WarehouseProductService warehouseProductService;

    @Autowired
    public WarehouseController(WarehouseProductService warehouseProductService)
    {
        this.warehouseProductService = warehouseProductService;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<WarehouseProductDTO> getWarehouseProducts()
    {
        return warehouseProductService.getWarehouseProducts();
    }

    @PostMapping("/products/add")
    @ResponseBody
    public WarehouseProductDTO addProductToWarehouse(@RequestBody @Validated WarehouseProductDTO warehouseProductDTO)
    {
        return warehouseProductService.addProductToWarehouse(warehouseProductDTO);
    }
}