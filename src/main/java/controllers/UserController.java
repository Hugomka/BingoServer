package controllers;

import domain.entities.BingoMill;
import domain.entities.User;
import services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public @ResponseBody User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/")
    public @ResponseBody Iterable<User> getAllByBingoMill(BingoMill bingoMill) {
        return userService.findAllByBingoMill(bingoMill);
    }

    @GetMapping("/{id}")
    public @ResponseBody User get(@PathVariable(value = "id") UUID userId) {
        return userService.findById(userId);
    }

    @PatchMapping("/update")
    public @ResponseBody User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public @ResponseStatus boolean delete(@PathVariable(value = "id") UUID userId) {
        return userService.deleteById(userId);
    }
}
