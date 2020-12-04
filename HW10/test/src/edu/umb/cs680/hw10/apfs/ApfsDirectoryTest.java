//
// CS680: HW10
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class ApfsDirectoryTest {
    static private LocalDateTime Date1 = LocalDateTime.now();
    static private LocalDateTime Date2 = LocalDateTime.now();
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, Date1, "owner", Date2);
    static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, Date1, "owner", Date2);
    static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, Date1, "owner", Date2);
    static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, Date1, "owner", Date2);
    static ApfsFile a = new ApfsFile(null, "a", 1, Date1, "owner", Date2);
    static ApfsFile b = new ApfsFile(null, "b", 2, Date1, "owner", Date2);
    static ApfsFile c = new ApfsFile(null, "c", 3, Date1, "owner", Date2);
    static ApfsFile d = new ApfsFile(null, "d", 4, Date1, "owner", Date2);
    static ApfsFile e = new ApfsFile(null, "e", 5, Date1, "owner", Date2);
    static ApfsFile f = new ApfsFile(null, "f", 6, Date1, "owner", Date2);
    static ApfsLink x = new ApfsLink(null, "x", 0, Date1, null, "owner", Date2);
    static ApfsLink y = new ApfsLink(null, "y", 0, Date1, null, "owner", Date2);

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
    
    private String[] dirToStringArray(ApfsDirectory d) {
        String[] dirInfo = {String.valueOf(d.isDirectory()), d.getName(), 
        		d.getCreateTime().toString(), d.getOwnersName(), 
        		Integer.toString(d.countChildren()), Integer.toString(d.getTotalSize()),
        		String.valueOf(d.isFile()), d.getModifiedTimestamp().toString()};
        return dirInfo;
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"true", "root", Date1.toString(), "owner", "2", "21", "false", 
        		Date2.toString()};
        ApfsDirectory actual = root;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityApplications() {
        String[] expected = {"true", "Applications", Date1.toString(), "owner", "2", "3", "false", 
        		Date2.toString()};
        ApfsDirectory actual = applications;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
    
    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"true", "Home", Date1.toString(), "owner", "4", "18", "false",
        		Date2.toString()};
        ApfsDirectory actual = home;
        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = {"true", "Code", Date1.toString(), "owner", "3", "11", "false", 
        		Date2.toString()};
        ApfsDirectory actual = code;
        assertArrayEquals(expected, dirToStringArray(actual));
    }
}
