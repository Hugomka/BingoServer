package com.bingo.services;

import com.bingo.domain.builders.BingoMillBuilder;
import com.bingo.domain.entities.BingoMill;
import com.bingo.logic.BingoLogic;
import com.bingo.repos.BingoMillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BingoMillServiceTest {
    private static final BingoMill[] bingoMills = {
            new BingoMillBuilder(),
            new BingoMillBuilder()
    };

    private BingoMillService bingoMillService;
    private BingoMillRepository bingoMillRepository;

    @BeforeEach
    void setUp() {
        bingoMillRepository = mock(BingoMillRepository.class);
        bingoMillService = new BingoMillServiceImpl(bingoMillRepository);
    }

    @Test
    void open() {
        BingoLogic bingoLogic = BingoLogic.init();
        bingoLogic.openBingoMill(bingoMills[0]);
        BingoMill bingoMill1 = bingoLogic.getBingoMill();
        when(bingoMillRepository.save(bingoMill1)).thenReturn(bingoLogic.getBingoMill());
        BingoMill getBingoMill1 = bingoMillService.open(bingoMills[0]);
        verify(bingoMillRepository, times(1)).save(bingoMill1);
        assertEquals(bingoMill1, getBingoMill1);
    }

    @Test
    void findAll() {
        when(bingoMillRepository.findAll()).thenReturn(Arrays.asList(bingoMills));
        List<BingoMill> foundUsers = (List<BingoMill>) bingoMillService.findAll();
        verify(bingoMillRepository, times(1)).findAll();
        assertArrayEquals(bingoMills, foundUsers.toArray());
    }

    @Test
    void findById() {
        BingoMill bingoMill1 = bingoMills[0];
        when(bingoMillRepository.findById(bingoMill1.getId())).thenReturn(Optional.of(bingoMill1));
        BingoMill foundBingoMill = bingoMillService.findById(bingoMill1.getId());
        verify(bingoMillRepository, times(1)).findById(bingoMill1.getId());
        assertEquals(bingoMill1, foundBingoMill);
    }

    @Test
    void deleteById() {
        BingoMill bingoMill1 = bingoMills[0];
        when(bingoMillRepository.findById(bingoMill1.getId())).thenReturn(Optional.of(bingoMill1));
        boolean deleted = bingoMillService.deleteById(bingoMill1.getId());
        verify(bingoMillRepository, times(1)).deleteById(bingoMill1.getId());
        assertTrue(deleted);
    }
}