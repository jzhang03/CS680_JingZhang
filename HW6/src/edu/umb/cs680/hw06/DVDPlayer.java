//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

public class DVDPlayer {
	
	private static DVDPlayer dvd = null;
	public static State state;
	
	private DVDPlayer() {
	};
	
	public static DVDPlayer getInstance() {
		if (dvd == null) {
			dvd = new DVDPlayer();
			state = DrawerClosedNotPlaying.getInstance();
		}
		return dvd;
	}
	
	public static State getState() {
		return DVDPlayer.state;
	}
	
	public static State changeState(State state) {
		DVDPlayer.state = state;
		return DVDPlayer.state;
	}
	
	public static void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}
	
	public static void playButtonPushed() {
		state.playButtonPushed();
	}
	
	public static void stopButtonPushed() {
		state.stopButtonPushed();
	}
	
	public static void open() {
		System.out.print("Drawer opened");
	}
	
	public static void close() {
		System.out.print("Drawer closed");
	}
	
	public static void play() {
		System.out.print("Start playing");
	}
	
	public static void stop() {
		System.out.print("Stopped");
	}
}