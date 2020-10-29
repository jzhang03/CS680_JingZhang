//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

	private DrawerClosedNotPlaying() {
		
	};
	
	private static DrawerClosedNotPlaying dvd = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if (dvd == null) { 
			dvd = new DrawerClosedNotPlaying();	
		}
		return dvd;
	}
	
	@Override
	public void openCloseButtonPushed() {
		DVDPlayer.open();
		DVDPlayer.changeState(DrawerOpen.getInstance());			
	}

	@Override
	public void playButtonPushed() {
		
	}

	@Override
	public void stopButtonPushed() {
		
	}
}