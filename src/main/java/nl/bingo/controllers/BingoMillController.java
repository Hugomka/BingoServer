package nl.bingo.controllers;

import nl.bingo.domain.entities.BingoMill;
import org.springframework.web.bind.annotation.*;
import nl.bingo.services.BingoMillService;

import java.util.UUID;

@RestController
@RequestMapping("/api/bingoMill")
public class BingoMillController {
    private final BingoMillService bingoMillService;

    public BingoMillController(BingoMillService bingoMillService) {
        this.bingoMillService = bingoMillService;
    }

    @PostMapping("/create")
    public @ResponseBody
    BingoMill create(@RequestBody BingoMill bingoMill) {
        return bingoMillService.save(bingoMill);
    }

    @GetMapping("/")
    public @ResponseBody
    Iterable<BingoMill> getAllByBingoMill(BingoMill bingoMill) {
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
