//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedPlayingTest {
	 
    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().openCloseButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void playButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().playButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void stopButtonPushedTest() {
        DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
        DrawerClosedPlaying.getInstance().stopButtonPushed();
        State actual = DVDPlayer.getState();
        State expected = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expected);
    }
    
    @Test
    public void InstanceEquivalentTest() {
        DrawerClosedPlaying dvd1= DrawerClosedPlaying.getInstance();
        DrawerClosedPlaying dvd2 = DrawerClosedPlaying.getInstance();
        assertSame(dvd1, dvd2);
    }
}
