//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

	private DrawerClosedPlaying() {
		
	};
	
	private static DrawerClosedPlaying dvd = null;
	
	public static DrawerClosedPlaying getInstance() {
		if (dvd == null) { 
			dvd = new DrawerClosedPlaying();
		}
		return dvd;
	}

	@Override
	public void openCloseButtonPushed() {
		
	}

	@Override
	public void playButtonPushed() {
		
	}

	@Override
	public void stopButtonPushed() {
		DVDPlayer.stop();
		DVDPlayer.changeState(DrawerClosedNotPlaying.getInstance());
	}
}
