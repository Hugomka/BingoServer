package com.bingo.controllers;

import com.bingo.domain.entities.BingoCard;
import com.bingo.domain.objects.BingoCardDTO;
import com.bingo.services.BingoCardService;
import com.bingo.services.BingoRowService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/bingoCard")
public class BingoCardController {
    private final BingoCardService bingoCardService;
    private final BingoRowService bingoRowService;

    public BingoCardController(BingoCardService bingoCardService, BingoRowService bingoRowService) {
        this.bingoCardService = bingoCardService;
        this.bingoRowService = bingoRowService;
    }

    @PostMapping("/create")
    public @ResponseBody
    BingoCard create(@RequestBody BingoCardDTO bingoCardDTO) {
        BingoCard bingoCard = BingoCard.create(bingoCardDTO);
        bingoRowService.generateRows(bingoCard);
        return bingoCardService.create(bingoCard);
    }

    @PatchMapping("/update")
    public @ResponseBody BingoCard update(@RequestBody BingoCard bingoCard) {
        return bingoCardService.update(bingoCard);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<BingoCard> getALl() {
        return bingoCardService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody BingoCard get(@PathVariable("id") UUID bingoCardId) {
        return bingoCardService.findById(bingoCardId);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody boolean deleteById(@PathVariable("id") UUID bingoCardId) {
        return bingoCardService.deleteById(bingoCardId);
    }
}
