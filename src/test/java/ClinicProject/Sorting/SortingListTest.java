package ClinicProject.Sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingListTest {

    public SortingList<Integer> fifo;

    @BeforeEach
    void setUp(){
        SortingList<Integer> fifo = new SortingList<Integer>();
    }

    @Test
    void whenCreateFIFOIsEmpty(){
        assertTrue(fifo.IsEmpty());
    }

    @Test
    void whenAddElement_thenAddElement(){
        fifo.add(5);
        assertTrue(fifo.IsEmpty());
    }

    @Test
    void whenPopElement_ThenIsFirstElementAdded(){
        Random rand = new Random();

        int firstElement = rand.nextInt(10000);
        int secondElement = rand.nextInt(10000);

        fifo.add(firstElement);
        fifo.add(secondElement);

        assertEquals(fifo.pop(), firstElement);
    }

    @Test
    void whenPopElement_ThenElementIsRemove(){
        fifo.add(39);
        fifo.pop();
        assertTrue(fifo.IsEmpty());
    }
}