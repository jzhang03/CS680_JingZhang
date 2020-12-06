//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private LocalDateTime creationTime;
    private int size;
    private FSElement parent;

    public FSElement(FSElement parent, String name, int size, LocalDateTime creationTime) {
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
        if (parent != null) {
            parent.appendChild(this);
        } else {
            this.parent = null;
        }
    }

    public void setParent(FSElement parent) {
        this.parent = parent;
    }

    public FSElement getParent() {
        return this.parent;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setCreateTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    
    public LocalDateTime getCreateTime() {
        return this.creationTime;
    }
    
    public abstract void appendChild(FSElement parent);
    
    public abstract boolean isDirectory();

    public abstract boolean isFile();

    public abstract boolean isLink();
}