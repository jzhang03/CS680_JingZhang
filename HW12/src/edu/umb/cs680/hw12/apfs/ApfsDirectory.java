//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import edu.umb.cs680.hw12.fs.FSElement;

public class ApfsDirectory extends ApfsElement {
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
    
    public LinkedList<ApfsElement> getChildren() {
        Collections.sort(this.children, new AlphabeticalComparator());
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
        Collections.sort(subDirectories, new AlphabeticalComparator());
        return subDirectories;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for(ApfsElement file: children) {
            if(file.isFile())
                files.add((ApfsFile) file);
        }
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsElement> sortChildren = getChildren();
        Collections.sort(sortChildren, comparator);
        return sortChildren;
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsDirectory> sortSubDir = getSubDirectories();
        Collections.sort(sortSubDir, comparator);
        return sortSubDir;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsFile> sortFiles = getFiles();
        Collections.sort(sortFiles, comparator);
        return sortFiles;
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
    
    public void accept(ApfsFSVisitor v) {
    	v.visit(this);
        for (ApfsElement e: children) {
        	e.accept(v);
		}
    }
}