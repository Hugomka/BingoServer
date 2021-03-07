package nl.bingo.services;

import nl.bingo.domain.builders.BingoUserBuilder;
import nl.bingo.domain.entities.BingoMill;
import nl.bingo.domain.entities.BingoUser;
import nl.bingo.repos.BingoUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BingoUserServiceTest {
    private BingoUser bingoUser1, bingoUser2;

    @InjectMocks
    private BingoUserRepository userRepository;

    @Mock
    private BingoUserService userService;

    @BeforeEach
    public void setUp() {
        bingoUser1 = new BingoUserBuilder("BingoUserTest1");
        bingoUser2 = new BingoUserBuilder("BingoUserTest2");
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void save() {
        Mockito.when(userRepository.save(bingoUser1)).thenReturn(bingoUser1);
        BingoUser savedBingoUser = userService.save(bingoUser1);
        assertEquals(bingoUser1, savedBingoUser);
    }

    @Test
    public void findAllByBingoMill() {
        BingoMill bingoMill = new BingoMill();
        Iterable<BingoUser> users = Arrays.asList(bingoUser1, bingoUser2);
        Mockito.when(userRepository.findAllByBingoMillId(bingoMill.getId())).thenReturn(users);
        Iterable<BingoUser> foundUsers = userService.findAllByBingoMill(bingoMill);
        assertIterableEquals(users, foundUsers);
    }

    @Test
    void findById() {
        Mockito.when(userRepository.findById(bingoUser1.getId())).thenReturn(ofNullable(bingoUser1));
        BingoUser foundBingoUser = userService.findById(bingoUser1.getId());
        assertEquals(bingoUser1, foundBingoUser);
    }

    @Test
    void deleteById() {
        Mockito.when(userRepository.findById(bingoUser1.getId())).thenReturn(ofNullable(bingoUser1));
        boolean deleted = userService.deleteById(bingoUser1.getId());
        Mockito.verify(userRepository, times(1)).deleteById(bingoUser1.getId());
        assertTrue(deleted);
    }
}