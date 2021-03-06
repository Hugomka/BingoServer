package com.bingo.controllers;

import com.bingo.domain.entities.BingoMill;
import org.springframework.web.bind.annotation.*;
import com.bingo.services.BingoMillService;

import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/bingoMill")
public class BingoMillController {
    private final BingoMillService bingoMillService;

    public BingoMillController(BingoMillService bingoMillService) {
        this.bingoMillService = bingoMillService;
    }

    @PostMapping("/create")
    public @ResponseBody
    BingoMill create() {
        return bingoMillService.create();
    }

    @GetMapping("/")
    public @ResponseBody
    Iterable<BingoMill> getAll() {
        return bingoMillService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody BingoMill get(@PathVariable(value = "id") UUID bingoMillId) {
        return bingoMillService.findById(bingoMillId);
    }

    @PatchMapping("/update")
    public @ResponseBody BingoMill update(@RequestBody BingoMill bingoMill) {
        return bingoMillService.save(bingoMill);
    }

    @DeleteMapping("/{id}")
    public @ResponseStatus boolean delete(@PathVariable(value = "id") UUID bingoMillId) {
        return bingoMillService.deleteById(bingoMillId);
    }
}
