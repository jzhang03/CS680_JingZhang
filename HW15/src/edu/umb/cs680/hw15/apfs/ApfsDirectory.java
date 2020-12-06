//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import edu.umb.cs680.hw15.fs.FSElement;

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
        Collections.sort(this.children, (ApfsElement fse1, ApfsElement fse2) -> 
        {return fse1.getName().compareTo(fse2.getName());});
    }
    
    @Override
    public LinkedList<ApfsElement> getChildren() {
        return this.children;
    }
    
    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        Collections.sort(this.children, comparator);
        return this.children;
    }

    public int countChildren() {
        return this.children.size();
    }
    
    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsDirectory> subDirectories = new LinkedList<ApfsDirectory>();
        for(ApfsElement file: children) {
            if(file.isDirectory())
                subDirectories.add((ApfsDirectory) file);
        }
        Collections.sort(subDirectories, comparator);
        return subDirectories;
    }
    
    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> sortSubDir = new LinkedList<ApfsDirectory>();
        for(ApfsElement apfse: children) {
            if(apfse.isDirectory())
            	sortSubDir.add((ApfsDirectory) apfse);
        }
        return sortSubDir;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<ApfsFile>();
        for(ApfsElement file: children) {
            if(file.isFile())
                files.add((ApfsFile) file);
        }
        return files;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsFile> sortFiles = new LinkedList<ApfsFile>();
        for(ApfsElement file: children) {
            if(file.isFile())
            	sortFiles.add((ApfsFile) file);
        }
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
