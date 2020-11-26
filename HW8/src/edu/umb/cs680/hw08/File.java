//
// CS680: HW8
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name, size, creationTime);
    }

    public boolean isDirectory() {
        return false;
    }
    
    public boolean isFile() {
        return true;
    }
    
    public boolean isLink() {
        return false;
    }
}
