package com.bingo.services;

import com.bingo.domain.builders.BingoUserBuilder;
import com.bingo.domain.entities.BingoUser;
import com.bingo.domain.enums.BingoUserRole;
import com.bingo.repos.BingoUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BingoUserServiceTest {
    private static final BingoUser[] bingoUsers = {
        new BingoUserBuilder("BingoUserTest1"),
        new BingoUserBuilder("BingoUserTest2")
    };
    
    private BingoUserService bingoUserService;
    private BingoUserRepository bingoUserRepository;

    @BeforeEach
    void setUp() {
        bingoUserRepository = mock(BingoUserRepository.class);
        bingoUserService = new BingoUserServiceImpl(bingoUserRepository);
    }

    @Test
    void save() {
        BingoUser bingoUser1 = bingoUsers[0];
        when(bingoUserRepository.save(bingoUser1)).thenReturn(bingoUser1);
        BingoUser getBingoUser1 = bingoUserService.save(bingoUser1);
        verify(bingoUserRepository, times(1)).save(bingoUser1);
        assertEquals(bingoUser1, getBingoUser1);

        // BingoUser1 becomes a game master
        bingoUser1.switchUserRole();
        assertEquals(BingoUserRole.Master, bingoUser1.getUserRole());
        when(bingoUserRepository.save(bingoUser1)).thenReturn(bingoUser1);
        getBingoUser1 = bingoUserService.save(bingoUser1);
        verify(bingoUserRepository, times(2)).save(bingoUser1);
        assertEquals(bingoUser1, getBingoUser1);
        assertEquals(BingoUserRole.Master, bingoUser1.getUserRole());

        // BingoUser2 tries to become a game master, but he remains the player.
        BingoUser bingoUser2 = bingoUsers[1];
        bingoUser2.switchUserRole();
        assertEquals(BingoUserRole.Master, bingoUser2.getUserRole());
        BingoUser getBingoUser2 = bingoUserService.save(bingoUser2);
        assertEquals(bingoUser2, getBingoUser2);
        assertEquals(BingoUserRole.Player, bingoUser2.getUserRole());
    }

    @Test
    void findAll() {
        when(bingoUserRepository.findAll()).thenReturn(Arrays.asList(bingoUsers));
        List<BingoUser> foundUsers = (List<BingoUser>) bingoUserService.findAll();
        verify(bingoUserRepository, times(1)).findAll();
        assertArrayEquals(bingoUsers, foundUsers.toArray());
    }

    @Test
    void findById() {
        BingoUser bingoUser1 = bingoUsers[0];
        when(bingoUserRepository.findById(bingoUser1.getId())).thenReturn(Optional.of(bingoUser1));
        BingoUser foundBingoUser = bingoUserService.findById(bingoUser1.getId());
        verify(bingoUserRepository, times(1)).findById(bingoUser1.getId());
        assertEquals(bingoUser1, foundBingoUser);
    }

    @Test
    void deleteById() {
        BingoUser bingoUser1 = bingoUsers[0];
        when(bingoUserRepository.findById(bingoUser1.getId())).thenReturn(Optional.of(bingoUser1));
        boolean deleted = bingoUserService.deleteById(bingoUser1.getId());
        verify(bingoUserRepository, times(1)).deleteById(bingoUser1.getId());
        assertTrue(deleted);
    }
}