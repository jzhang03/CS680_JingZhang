//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class DVDPlayerTest {
 
    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DVDPlayer.openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerOpen.getInstance());
        DVDPlayer.playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DVDPlayer.stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void changeStateTest() {
        State actual = DVDPlayer.changeState(DrawerOpen.getInstance());
        State expected = DrawerOpen.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void InstanceEquivalentTest() {
        DVDPlayer dvd1= DVDPlayer.getInstance();
        DVDPlayer dvd2 = DVDPlayer.getInstance();
        assertSame(dvd1, dvd2);
    }
}