//
// CS680: HW10
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw10.apfs;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsElementTest {
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

    @Test
    public void getChildrenTest() {
        ApfsElement apfstest = new ApfsElement(null, "root", 0, Date1, "owner", Date2);
        apfstest.appendChild(root);
        apfstest.appendChild(home);
        apfstest.appendChild(applications);
        apfstest.appendChild(code);
        apfstest.appendChild(a);
        apfstest.appendChild(b);
        apfstest.appendChild(c);
        apfstest.appendChild(d);
        apfstest.appendChild(e);
        apfstest.appendChild(f);
        apfstest.appendChild(x);
        apfstest.appendChild(y);
        LinkedList<ApfsElement> childrenTest = apfstest.getChildren();
        ApfsElement[] actual = childrenTest.toArray(new ApfsElement[childrenTest.size()]);
        ApfsElement[] expected = {root, home, applications, code, a, b, c, d, e, f, x, y};
        assertArrayEquals(expected, actual);
    }
}
