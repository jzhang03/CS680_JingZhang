//
// CS680: HW8
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Link extends FSElement{
    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public void setTarget(FSElement target){
        this.target = target;
    }
    
    public int getTargetSize(){
        return target.getSize();
    }
      
    public FSElement getTarget(){
        return this.target;
    }
    
    public boolean targetisFile() {
        return target.isFile();
    }
    
    public boolean targetisDirectory() {
        return target.isDirectory();
    }
    
    public boolean targetisLink() {
        return target.isLink();
    }
    
    public boolean isDirectory() {
        return false;
    }
    
    public boolean isFile() {
        return false;
    }
    
    public boolean isLink() {
        return true;
    }
}
