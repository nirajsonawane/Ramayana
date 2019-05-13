package com.ns.ramayana.command;

import com.ns.ramayana.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelpCommandTest extends BaseTest{


    @Test
    public void shouldPrintHelpMessageToConsol(){
        HelpCommand helpCommand= new HelpCommand(super.factory.getBaseView());
        helpCommand.accept(null);
        String s = super.outContent.toString();
        String str = "The Game is based On Ancient India epic Ramayana. For more details please check https://en.wikipedia.org/wiki/Ramayana. You Will BE playing this Game as Lord Ram and The Final Step is to Kill Ravana. The Game Has 6 levels " +
                "In Last Level You will be fighting with Ravana. You Can Check Your progress in ProfileCommand Section";
        assertEquals(str,s.trim());

    }
}