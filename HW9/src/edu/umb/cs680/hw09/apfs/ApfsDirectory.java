//
// CS680: HW9
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw09.apfs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import edu.umb.cs680.hw09.fs.FSElement;

public class ApfsDirectory extends ApfsElement{
    private LinkedList<ApfsElement> children =  new LinkedList<ApfsElement>();

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, 
    		String ownersName, LocalDateTime modifiedTimestamp){
    	super(parent, name, size, creationTime, ownersName, modifiedTimestamp);
    }

    @Override
    public void appendChild(FSElement child) {
        this.children.add((ApfsElement) child);
        child.setParent(this);
    }
    
    @Override
    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }

    public int countChildren() {
        return this.children.size();
    }
    
    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
        for(ApfsElement file: children) {
            if(file.isDirectory())
                subDirectories.add((ApfsDirectory) file);
        }
        return subDirectories;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for(ApfsElement file: children) {
            if(file.isFile())
                files.add((ApfsFile) file);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for(ApfsElement file: children) {
            if(file.isDirectory()) {
                totalSize += ((ApfsDirectory) file).getTotalSize();
            } else {
                totalSize += file.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
