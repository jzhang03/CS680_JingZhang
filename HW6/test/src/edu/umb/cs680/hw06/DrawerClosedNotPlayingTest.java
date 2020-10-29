//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedNotPlayingTest {

    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerOpen.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
        DrawerClosedNotPlaying.getInstance().stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void InstanceEquivalentTest() {
        DrawerClosedNotPlaying dvd1= DrawerClosedNotPlaying.getInstance();
        DrawerClosedNotPlaying dvd2 = DrawerClosedNotPlaying.getInstance();
        assertSame(dvd1, dvd2);
    }
}