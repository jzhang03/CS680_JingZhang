//
// CS680: HW6
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw06;

public interface State {
    public DVDPlayer dvd =DVDPlayer.getInstance();
    public void openCloseButtonPushed();
    public void playButtonPushed();
    public void stopButtonPushed();
}