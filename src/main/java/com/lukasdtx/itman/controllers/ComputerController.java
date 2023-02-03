package com.lukasdtx.itman.controllers;

import com.lukasdtx.itman.dto.EmployeeDto;
import com.lukasdtx.itman.models.Computer;
import com.lukasdtx.itman.models.Printer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerController {
    @GetMapping("/computers")
    public String getComputers(){
        Computer computer = new Computer(1,"lenovo","Mobo500");
        return computer.toString();
    }
    @GetMapping("/computers/{id}")
    public ResponseEntity<Computer> computerDetail(@PathVariable int id){
        return ResponseEntity.ok(new Computer(1,"lenovo","Mobo500"));
    }
    @GetMapping("/printers/{id}")
    public ResponseEntity<Printer> printerDetail(@PathVariable int id){
        return ResponseEntity.ok(new Printer(1,"lenovo","Mobo500"));
    }
}
