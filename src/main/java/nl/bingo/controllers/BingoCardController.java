package nl.bingo.controllers;

import nl.bingo.domain.entities.BingoCard;
import nl.bingo.domain.entities.BingoUser;
import nl.bingo.logic.BingoLogic;
import nl.bingo.services.BingoCardService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:4200"})
@RestController
@RequestMapping("/api/bingoCard")
public class BingoCardController {
    private final BingoCardService bingoCardService;
    private final BingoLogic bingoLogic;

    public BingoCardController(BingoCardService bingoCardService, BingoLogic bingoLogic) {
        this.bingoCardService = bingoCardService;
        this.bingoLogic = bingoLogic;
    }

    @GetMapping("/")
    public @ResponseBody BingoCard create(@RequestBody BingoUser bingoUser) {
        BingoCard bingoCard = bingoLogic.createBingoCard(bingoUser);
        return bingoCardService.save(bingoCard);
    }

    @PatchMapping("/")
    public @ResponseBody BingoCard update(@RequestBody BingoCard bingoCard) {
        return bingoCardService.save(bingoCard);
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
