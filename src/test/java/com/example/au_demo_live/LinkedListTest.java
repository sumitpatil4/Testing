package com.example.au_demo_live;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        list=new LinkedList<Integer>();
    }

    @ParameterizedTest
    @ValueSource(ints={-1,-3,-5,Integer.MIN_VALUE})
    @DisplayName("Given the index is negative, getElement() should throw Runtime Exception")
    void testGetElement_shouldThrowExceptionOnNegativeIndex(int negativeIndex){
//        final var list = new LinkedList<Integer>();
        assertThrows(RuntimeException.class,()->list.getElement(negativeIndex));
    }

    @Test
    @DisplayName("Given a valid index, getElement() should return the value")
    void testGetElement_shouldReturnElementOnValidIndex(){
//        final var list=new LinkedList<Integer>();
        list.addElement(10);
        assertEquals(10,list.getElement(0));
    }

    @Test
    @DisplayName("Given a index greater than the size, geElement() should throw Runtime Exception")
    void testGetElement_shouldReturnExceptionOnIndexGreaterThanSize(){
//        final var list=new LinkedList<Integer>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        final var exception=assertThrows(RuntimeException.class,()->list.getElement(3));
        assertEquals("Index greater than the size",exception.getMessage());
    }

    @Test
    @DisplayName("Given an element to add, getAddElement() should increase the length")
    void testAddElement_shouldIncreaseLengthAfterAdding(){
        list.addElement(1);
        list.addElement(2);
        assertEquals(list.getLength()+1,list.addElement(4));
    }

    @Test
    @DisplayName("Given element is null, AddElement() should throw an Runtime Exception")
    void testAddElement_shouldReturnExceptionIfElementIsNull(){
        final var exception=assertThrows(RuntimeException.class,()->list.addElement(null));
        assertEquals("Cannot add null",exception.getMessage());
    }
}
