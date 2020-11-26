//
// CS680: HW8
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {

    private LinkedList<Directory> rootDir = new LinkedList<Directory>();

    private FileSystem(){
    	
    }
    
    private static FileSystem fileSystem = null;
    
    public static FileSystem getFileSystem(){
        if(fileSystem==null)
            fileSystem = new FileSystem();
        return fileSystem;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDir;
    }

    public void appendRootDir(Directory root) {
        this.rootDir.add(root);
    }

}