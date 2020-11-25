//
// CS680: HW7
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DirectoryTest {
    static private LocalDateTime Date = LocalDateTime.now();
    static Directory root = new Directory(null, "Root", 0, Date);
    static Directory home = new Directory(null, "Home", 0, Date);
    static Directory applications = new Directory(null, "Applications", 0, Date);
    static Directory code = new Directory(null, "Code", 0, Date);
    static File a = new File(null, "a", 1, Date);
    static File b = new File(null, "b", 2, Date);
    static File c = new File(null, "c", 3, Date);
    static File d = new File(null, "d", 4, Date);
    static File e = new File(null, "e", 5, Date);
    static File f = new File(null, "f", 6, Date);
    
    @BeforeAll
    static void SetUp() {
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
    }


    private String[] dirToStringArray(Directory d) {
        String parentName = null;
        Directory parent = d.getParent();
        if(parent != null) {
            parentName = parent.getName();
        }

        String[] dirInfo = {String.valueOf(d.isDirectory()), d.getName(), 
        		Integer.toString(d.getSize()), d.getCreationTime().toString(), parentName, 
                Integer.toString(d.countChildren()), Integer.toString(d.getTotalSize())};
        return dirInfo;
    }


    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"true", "Root", "0", Date.toString(), null, "2", "21"};
        Directory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "Home", "0", Date.toString(), "Root", "3", "18"};
        Directory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = {"true", "Code", "0", Date.toString(), "Home", "2", "11"};
        Directory actual = code;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
}
