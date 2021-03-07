package nl.bingo.controllers;

import nl.bingo.domain.entities.BingoMill;
import nl.bingo.domain.entities.BingoUser;
import nl.bingo.services.BingoUserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/bingouser")
public class BingoUserController {
    private final BingoUserService userService;

    public BingoUserController(BingoUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public @ResponseBody
    BingoUser create(@RequestBody BingoUser bingoUser) {
        return userService.save(bingoUser);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<BingoUser> getAllByBingoMill(BingoMill bingoMill) {
        return userService.findAllByBingoMill(bingoMill);
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
