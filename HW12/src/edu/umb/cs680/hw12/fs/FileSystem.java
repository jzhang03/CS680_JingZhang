//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.fs;

import java.util.LinkedList;

public abstract class FileSystem {
    protected static String name;
    protected static int capacity;
    protected static int id;
    private LinkedList<FSElement> rootDir = new LinkedList<FSElement>();

    public FSElement initFileSystem(String name, int capacity) {
		FileSystem.name = name;
        FileSystem.capacity = capacity;
        
        FSElement root = createDefaultRoot();
        if(root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            FileSystem.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    protected abstract FSElement createDefaultRoot();
    
    protected void setRoot(FSElement root) {
    	rootDir.add(root);
    }
    
    public static int getCapacity() {
        return capacity;
    }
    
    public static String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }
}
