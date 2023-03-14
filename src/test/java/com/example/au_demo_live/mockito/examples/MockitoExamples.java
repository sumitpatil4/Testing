package com.example.au_demo_live.mockito.examples;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class MockitoExamples {
    @Test
    public void testLinkedListGetElement(){
        final var list = Mockito.mock(java.util.LinkedList.class);
        when(list.size()).thenReturn(10);
        assertEquals(10,list.size());
    }

    @Test
    public void testLinkedListGetElement_ThrowException(){
        final var list = Mockito.mock(java.util.LinkedList.class);
        when(list.add(anyString())).thenThrow(new RuntimeException("You cannot insert data in this list"));
        assertThrows(RuntimeException.class,()->list.add("Sumit"));
    }

    @Test
    public void testLinkedListGetElement_ThrowException_TestAnyString(){
        final var list = Mockito.mock(java.util.LinkedList.class);
        when(list.add("Patil")).thenThrow(new RuntimeException("You cannot insert data in this list"));
        assertThrows(RuntimeException.class,()->list.add("Sumit"));
    }
}
