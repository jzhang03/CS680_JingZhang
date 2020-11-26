//
// CS680: HW8
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.LocalDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinkTest {
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
    static Link x = new Link(null, "x", 0, Date, null);
    static Link y = new Link(null, "y", 0, Date, null);
    
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
        home.appendChild(x);
        code.appendChild(y);
        x.setTarget(applications);
        y.setTarget(b);
    }
    
    @Test
    public void verifyLinkEqualityX() {
        Directory expected = applications;
        FSElement actual = x.getTarget();
        assertSame(expected, actual);
    }

    @Test
    public void verifyLinkEqualityY() {
        File expected = b;
        FSElement actual = y.getTarget();
        assertSame(expected, actual);
    }
}
