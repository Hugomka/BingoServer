package com.bingo.services;

import com.bingo.domain.builders.BingoCardBuilder;
import com.bingo.domain.builders.BingoUserBuilder;
import com.bingo.domain.entities.BingoCard;
import com.bingo.repos.BingoCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BingoCardServiceTest {
    private static final BingoCard[] bingoCards = {
            new BingoCardBuilder(new BingoUserBuilder("BingoUserTest1")),
            new BingoCardBuilder(new BingoUserBuilder("BingoUserTest2"))
    };
    
    private BingoCardService bingoCardService;
    private BingoCardRepository bingoCardRepository;

    @BeforeEach
    void setUp() {
        bingoCardRepository = mock(BingoCardRepository.class);
        bingoCardService = new BingoCardServiceImpl(bingoCardRepository);
    }

    @Test
    void saveTest() {
        var bingoCard3 = new BingoCardBuilder(new BingoUserBuilder("BingoUserTest4"));
        when(bingoCardRepository.save(bingoCard3)).thenReturn(bingoCard3);
        BingoCard getBingoCard = bingoCardService.update(bingoCard3);
        verify(bingoCardRepository, times(1)).save(bingoCard3);
        assertEquals(bingoCard3, getBingoCard);
    }

    @Test
    void findAll() {
        when(bingoCardRepository.findAll()).thenReturn(Arrays.asList(bingoCards));
        List<BingoCard> foundCards = (List<BingoCard>) bingoCardService.findAll();
        verify(bingoCardRepository, times(1)).findAll();
        assertArrayEquals(bingoCards, foundCards.toArray());
    }

    @Test
    void findById() {
        BingoCard bingoCard1 = bingoCards[0];
        when(bingoCardRepository.findById(bingoCard1.getId())).thenReturn(Optional.of(bingoCard1));
        BingoCard foundBingoCard = bingoCardService.findById(bingoCard1.getId());
        verify(bingoCardRepository, times(1)).findById(bingoCard1.getId());
        assertEquals(bingoCard1, foundBingoCard);
    }

    @Test
    void deleteById() {
        BingoCard bingoCard1 = bingoCards[0];
        when(bingoCardRepository.findById(bingoCard1.getId())).thenReturn(Optional.of(bingoCard1));
        boolean deleted = bingoCardService.deleteById(bingoCard1.getId());
        verify(bingoCardRepository, times(1)).deleteById(bingoCard1.getId());
        assertTrue(deleted);
    }
}