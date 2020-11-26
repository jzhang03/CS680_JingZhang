//
// CS680: HW8
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileSystemTest {
    private LocalDateTime Date;

    private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
        Directory[] init = new Directory[rootList.size()];
        int i = 0;
        for(Directory root: rootList) {
        	init[i++] = root;
        }
        return init;
    }
    
    @Order(1)
    @Test
    public void sameFileSystemTest() {
        FileSystem sysA = FileSystem.getFileSystem();
        FileSystem sysB = FileSystem.getFileSystem();
        assertSame(sysA, sysB);
    }
    
    @Order(2)
    @Test   
    public void getRootDirsTest() {
        FileSystem actual = FileSystem.getFileSystem();
        Directory[] expected = {};
        assertArrayEquals(expected, this.LinkedListToArray(actual.getRootDirs()));
    }
    
    @Order(3)
    @Test
    public void addRootDirTest() {
        Directory root = new Directory(null, "Root", 0, this.Date);
        FileSystem sys = FileSystem.getFileSystem();
        sys.appendRootDir(root);
        LinkedList<Directory> actual = sys.getRootDirs();
        Directory[] expected = {root};
        assertArrayEquals(expected, this.LinkedListToArray(actual));
    }
}