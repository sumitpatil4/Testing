package com.example.au_demo_live.mockito.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoMockAnnotationExample {
    @Mock
    List<String> mockList;

    @BeforeEach
    public void setUp(){
        //If we don't call, we will get NullPointerException
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        when(mockList.get(0)).thenReturn("JournalDev");
        assertEquals("JournalDev",mockList.get(0));
    }
}
