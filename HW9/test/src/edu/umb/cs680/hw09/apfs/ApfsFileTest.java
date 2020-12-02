//
// CS680: HW9
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw09.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class ApfsFileTest {
    static private LocalDateTime Date1 = LocalDateTime.now();
    static private LocalDateTime Date2 = LocalDateTime.now();
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, Date1, "owner", Date2);
    static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, Date1, "owner", Date2);
    static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, Date1, "owner", Date2);
    static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, Date1, "owner", Date2);
    static ApfsFile a = new ApfsFile(null, "a", 1, Date1, "owner", Date2);
    static ApfsFile b = new ApfsFile(null, "b", 1, Date1, "owner", Date2);
    static ApfsFile c = new ApfsFile(null, "c", 2, Date1, "owner", Date2);
    static ApfsFile d = new ApfsFile(null, "d", 2, Date1, "owner", Date2);
    static ApfsFile e = new ApfsFile(null, "e", 5, Date1, "owner", Date2);
    static ApfsFile f = new ApfsFile(null, "f", 10, Date1, "owner", Date2);
    static ApfsLink x = new ApfsLink(null, "x", 1, Date1, null, "owner", Date2);
    static ApfsLink y = new ApfsLink(null, "y", 1, Date1, null, "owner", Date2);
   
    @BeforeAll
    static void init() {
        root.appendChild(home);
        root.appendChild(applications);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
        home.appendChild(x);
        code.appendChild(y);
        x.setTarget(applications);
        y.setTarget(b);
    }
    
    private String[] fileToStringArray(ApfsFile f) {
        String[] fileInfo = {String.valueOf(f.isDirectory()), f.getName(), 
        		Integer.toString(f.getSize()), f.getCreateTime().toString(), 
        		f.getOwnersName(), f.getParent().getName(), String.valueOf(f.isFile()), 
        		f.getModifiedTimestamp().toString()};
        return fileInfo;
    }
    
    @Test
    public void verifyFileEqualityA() {
        String[] expected = {"false", "a", "1", Date1.toString(), "owner", "Applications", "true", 
        		Date2.toString()};
        ApfsFile actual = a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    
    @Test
    public void verifyFileEqualityB() {
        String[] expected = {"false", "b", "1", Date1.toString(), "owner", "Applications", "true", 
        		Date2.toString()};
        ApfsFile actual = b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    
    @Test
    public void verifyFileEqualityC() {
        String[] expected = {"false", "c", "2", Date1.toString(), "owner", "Home", "true", 
        		Date2.toString()};
        ApfsFile actual = c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    
    @Test
    public void verifyFileEqualityD() {
        String[] expected = {"false", "d", "2", Date1.toString(), "owner", "Home", "true", 
        		Date2.toString()};
        ApfsFile actual = d;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    
    @Test
    public void verifyFileEqualityE() {
        String[] expected = {"false", "e", "5", Date1.toString(), "owner", "Code", "true", 
        		Date2.toString()};
        ApfsFile actual = e;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
    
    @Test
    public void verifyFileEqualityF() {
        String[] expected = {"false", "f", "10", Date1.toString(), "owner", "Code", "true", 
        		Date2.toString()};
        ApfsFile actual = f;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
}
