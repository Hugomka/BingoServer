package com.bingo.services;

import com.bingo.domain.builders.BingoUserBuilder;
import com.bingo.domain.entities.BingoMill;
import com.bingo.domain.entities.BingoUser;
import com.bingo.repos.BingoUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BingoUserServiceTest {
    private static final BingoUser[] bingoUsers = {
        new BingoUserBuilder("BingoUserTest1"),
        new BingoUserBuilder("BingoUserTest2")
    };
    
    private BingoUserService bingoUserService;
    private BingoUserRepository bingoUserRepository;

    @Before
    public void setUp() {
        bingoUserRepository = mock(BingoUserRepository.class);
        bingoUserService = new BingoUserServiceImpl(bingoUserRepository);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void save() {
        BingoUser bingoUser3 = new BingoUserBuilder("BingoUserTest3");
        when(bingoUserRepository.save(bingoUser3)).thenReturn(bingoUser3);
        BingoUser getBingoUser = bingoUserService.save(bingoUser3);
        verify(bingoUserRepository, times(1)).save(bingoUser3);
        assertEquals(bingoUser3, getBingoUser);
    }

    @Test
    public void findAllByBingoMill() {
        BingoMill bingoMill = new BingoMill();
        when(bingoUserRepository.findAllByBingoMillId(bingoMill.getId())).thenReturn(Arrays.asList(bingoUsers));
        List<BingoUser> foundUsers = (List<BingoUser>) bingoUserService.findAllByBingoMill(bingoMill);
        verify(bingoUserRepository, times(1)).findAllByBingoMillId(bingoMill.getId());
        assertArrayEquals(bingoUsers, foundUsers.toArray());
    }

    @Test
    public void findById() {
        BingoUser bingoUser1 = bingoUsers[0];
        when(bingoUserRepository.findById(bingoUser1.getId())).thenReturn(Optional.of(bingoUser1));
        BingoUser foundBingoUser = bingoUserService.findById(bingoUser1.getId());
        verify(bingoUserRepository, times(1)).findById(bingoUser1.getId());
        assertEquals(bingoUser1, foundBingoUser);
    }

    @Test
    public void deleteById() {
        BingoUser bingoUser1 = bingoUsers[0];
        when(bingoUserRepository.findById(bingoUser1.getId())).thenReturn(Optional.of(bingoUser1));
        boolean deleted = bingoUserService.deleteById(bingoUser1.getId());
        verify(bingoUserRepository, times(1)).deleteById(bingoUser1.getId());
        assertTrue(deleted);
    }
}