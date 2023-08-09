package com.GoTicket.GoTicket.controllers;

import com.GoTicket.GoTicket.models.Passanger;
import com.GoTicket.GoTicket.services.PassangerService;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/passangers")
public class PassangerController {
    private PassangerService passangerService;

    public PassangerController(PassangerService passangerService) {
        this.passangerService = passangerService;
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(passangerService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try again later.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(passangerService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Please try again later.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Passanger passanger) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(passangerService.save(passanger));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try again later.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(passangerService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Please try again later.\"}");
        }
    }

}