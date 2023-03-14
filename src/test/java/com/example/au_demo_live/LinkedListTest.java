package com.example.au_demo_live;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LinkedListTest {

    @Test
    @DisplayName("Given the index is negative, getElement() should throw Runtime Exception")
    void testGetElement_shouldThrowExceptionOnNegativeIndex(){
        final var list = new LinkedList<Integer>();
        assertThrows(RuntimeException.class,()->list.getElement(-1));
    }

    @Test
    @DisplayName("Given a valid index, getElement() should return the value")
    void testGetElement_shouldReturnElementOnValidIndex(){
        final var list=new LinkedList<Integer>();
        list.addElement(10);
        assertEquals(10,list.getElement(0));
    }

    @Test
    @DisplayName("Given a index greater than the size, geElement() should throw Runtime Exception")
    void testGetElement_shouldReturnExceptionOnIndexGreaterThanSize(){
        final var list=new LinkedList<Integer>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        final var exception=assertThrows(RuntimeException.class,()->list.getElement(3));
        assertEquals("Index greater than the size",exception.getMessage());
    }

    @Test
    @DisplayName("Given an element to add, getAddElement() should increase the length")
    void testAddElement_shouldIncreaseLengthAfterAdding(){
        final var list=new LinkedList<Integer>();
    }
}
