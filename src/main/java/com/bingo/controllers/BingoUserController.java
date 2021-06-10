package com.bingo.controllers;

import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;
import com.bingo.services.BingoUserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/bingoUser")
public class BingoUserController {
    private final BingoUserService userService;

    public BingoUserController(BingoUserService userService/*, BingoLogic bingoLogic*/) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public @ResponseBody
    BingoUser create(@RequestBody BingoUser bingoUser) {
        return userService.save(bingoUser);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<BingoUser> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    BingoUser get(@PathVariable(value = "id") UUID bingoUserId) {
        return userService.findById(bingoUserId);
    }

    @PatchMapping("/update")
    public @ResponseBody
    BingoUser update(@RequestBody BingoUser bingoUser) {
        return userService.save(bingoUser);
    }

    @DeleteMapping("/{id}")
    public @ResponseStatus boolean delete(@PathVariable(value = "id") UUID bingoUserId) {
        return userService.deleteById(bingoUserId);
    }
}
