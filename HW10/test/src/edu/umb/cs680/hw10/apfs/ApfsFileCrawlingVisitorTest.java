//
// CS680: HW10
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ApfsFileCrawlingVisitorTest {
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
    }
    
    @Test
    public void fileCrawlingRootVisitor() {
        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        root.accept(v);
        LinkedList<ApfsFile> files =  v.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {e, f, c, d, a, b};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void fileCrawlingApplicationsVisitor() {
        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        applications.accept(v);
        LinkedList<ApfsFile> files =  v.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {a, b};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void fileCrawlingHomeVisitor() {
        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        home.accept(v);
        LinkedList<ApfsFile> files =  v.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {e, f, c, d};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void fileCrawlingCodeVisitor() {
        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        code.accept(v);
        LinkedList<ApfsFile> files =  v.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected= {e, f};
        assertArrayEquals(expected, actual);
    }
}
