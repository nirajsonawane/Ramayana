package com.ns.ramayana.view;

import com.ns.ramayana.BaseTest;
import com.ns.ramayana.exception.GameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class BaseViewTest extends BaseTest{

    BaseView baseView ;
    @BeforeEach
    public void setup(){
        this.baseView=super.factory.getBaseView();
    }

    @Test
    void shouldReadString() {

        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("Test")
                .getBytes()));
        assertEquals("Test",baseView.readString());
    }

    @Test
    void shouldReadInt() {
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(1)
                .getBytes()));
        assertEquals(1,baseView.readInt());
    }

    @Test
    void shouldReadLong() {
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf(2l)
                .getBytes()));
        assertEquals(2l,baseView.readLong());

    }


    @Test
    public void shouldThrowExceptionForInvalidInputInt(){
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("Wrong")
                .getBytes()));
        Exception exception = assertThrows(GameException.class, () -> baseView.readInt());
        assertEquals("Invalid Input , Not a Number ", exception.getMessage());
    }
    @Test
    public void shouldThrowExceptionForInvalidInputLong(){
        baseView.mockInput(new ByteArrayInputStream(String
                .valueOf("Wrong")
                .getBytes()));
        Exception exception = assertThrows(GameException.class, () -> baseView.readLong());
        assertEquals("Invalid Input , Not a Number ", exception.getMessage());
    }

}