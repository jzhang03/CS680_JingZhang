//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

public class DrawerOpen implements State {
    
	private DrawerOpen() {
    	
    };
	
	private static DrawerOpen dvd = null;
	
	public static DrawerOpen getInstance( ) {
		if (dvd == null) {
			dvd = new DrawerOpen();
        }
		return dvd;
	}
	
	@Override
	public void playButtonPushed() {
		DVDPlayer.close();
		DVDPlayer.play();
		DVDPlayer.changeState(DrawerClosedPlaying.getInstance());
	}
	
	@Override
	public void openCloseButtonPushed() {
		DVDPlayer.close();
		DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}

	@Override
	public void stopButtonPushed() {
		
    }
}