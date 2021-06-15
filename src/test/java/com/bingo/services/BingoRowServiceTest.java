package com.bingo.services;

import com.bingo.domain.builders.BingoRowBuilder;
import com.bingo.domain.entities.BingoRow;
import com.bingo.repos.BingoRowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BingoRowServiceTest {
    private BingoRowService bingoRowService;
    private BingoRowRepository bingoRowRepository;

    @BeforeEach
    void setUp() {
        bingoRowRepository = mock(BingoRowRepository.class);
        bingoRowService = new BingoRowServiceImpl(bingoRowRepository);
    }

    @Test
    void save() {
        int totalRows = 1000;
        List<BingoRow> bingoRows = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            BingoRow bingoRow = new BingoRowBuilder();
            when(bingoRowRepository.save(bingoRow)).thenReturn(bingoRow);
            bingoRows.add(bingoRowService.save(bingoRow));
            verify(bingoRowRepository, times(1)).save(bingoRow);
        }
        assertEquals(totalRows, bingoRows.size());
    }

    @Test
    void clearBingoRows() {
    }
}