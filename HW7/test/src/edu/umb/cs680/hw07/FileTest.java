//
// CS680: HW7
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class FileTest {
	private LocalDateTime Date = LocalDateTime.now();
    Directory root = new Directory(null, "Root", 0, Date);
    Directory home = new Directory(root, "Home", 0, Date);
    Directory applications = new Directory(root, "Applications", 0, Date);
    Directory code = new Directory(home, "Code", 0, Date);
    File a = new File(applications, "a", 1, Date);
    File b = new File(applications, "b", 1, Date);
    File c = new File(home, "c", 2, Date);
    File d = new File(home, "d", 2, Date);
    File e = new File(code, "e", 5, Date);
    File f = new File(code, "f", 10, Date);

    private String[] fileToStringArray(File f) {
        String[] fileInfo = {String.valueOf(f.isDirectory()), f.getName(), Integer.toString(f.getSize()),
                f.getCreationTime().toString(), f.getParent().getName()};
        return fileInfo;
    }

    @Test
    public void verifyFileEqualityA() {
        String[] expected = {"false", "a", "1", Date.toString(), "Applications"};
        File actual = this.a;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = {"false", "b", "1", Date.toString(), "Applications"};
        File actual = this.b;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void verifyFileEqualityC() {
        String[] expected = {"false", "c", "2", Date.toString(), "Home"};
        File actual = this.c;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

        @Test
    public void verifyFileEqualityD() {
        String[] expected = {"false", "d", "2", Date.toString(), "Home"};
        File actual = this.d;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

        @Test
    public void verifyFileEqualityE() {
        String[] expected = {"false", "e", "5", Date.toString(), "Code"};
        File actual = this.e;
        assertArrayEquals(expected, fileToStringArray(actual));
    }

        @Test
    public void verifyFileEqualityF() {
        String[] expected = {"false", "f", "10", Date.toString(), "Code"};
        File actual = this.f;
        assertArrayEquals(expected, fileToStringArray(actual));
    }
}
