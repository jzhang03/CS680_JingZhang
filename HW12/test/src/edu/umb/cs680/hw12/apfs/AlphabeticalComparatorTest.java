//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AlphabeticalComparatorTest {
    static ApfsDirectory root = new ApfsDirectory(null, "root", 0, 
    		LocalDateTime.of(2015, 01, 07, 6,0), "owner", LocalDateTime.of(2018, 02, 25, 3,0));
    static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, 
    		LocalDateTime.of(2016, 05, 24, 2,0), "owner", LocalDateTime.of(2018, 03, 05, 4,0));
    static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, 
    		LocalDateTime.of(2016, 06, 21, 3,0), "owner", LocalDateTime.of(2018, 04, 12, 3,0));
    static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, 
    		LocalDateTime.of(2016, 07, 18, 3,0), "owner", LocalDateTime.of(2018, 05, 12, 3,0));
    static ApfsFile a = new ApfsFile(null, "a", 1, 
    		LocalDateTime.of(2016, 11, 18, 3,0), "owner", LocalDateTime.of(2018, 06, 12, 3,0));
    static ApfsFile b = new ApfsFile(null, "b", 2, 
    		LocalDateTime.of(2016, 12, 18, 3,0), "owner", LocalDateTime.of(2018, 07, 12, 3,0));
    static ApfsFile c = new ApfsFile(null, "c", 3, 
    		LocalDateTime.of(2017, 01, 18, 3,0), "owner", LocalDateTime.of(2019, 01, 14, 3,0));
    static ApfsFile d = new ApfsFile(null, "d", 4, 
    		LocalDateTime.of(2017, 02, 18, 3,0), "owner", LocalDateTime.of(2019, 02, 14, 3,0));
    static ApfsFile e = new ApfsFile(null, "e", 5, 
    		LocalDateTime.of(2017, 03, 18, 3,0), "owner", LocalDateTime.of(2019, 03, 14, 3,0));
    static ApfsFile f = new ApfsFile(null, "f", 6, 
    		LocalDateTime.of(2017, 04, 18, 3,0), "owner", LocalDateTime.of(2020, 01, 14, 3,0));
    static ApfsLink x = new ApfsLink(null, "x", 0, 
    		LocalDateTime.of(2017, 05, 18, 3,0), null, "owner", LocalDateTime.of(2020, 02, 14, 3,0));
    static ApfsLink y = new ApfsLink(null, "y", 0, 
    		LocalDateTime.of(2017, 06, 18, 3,0), null, "owner", LocalDateTime.of(2020, 03, 14, 3,0));

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
	
	@Test
	public void verifyOrderEquality() {
		String[] expected = {"Code", "c", "d", "x"};
		LinkedList<ApfsElement> children = home.getChildren(new AlphabeticalComparator());
        String[] actual = new String[children.size()];
        for(int i =0; i < children.size(); i++)
            actual[i] = children.get(i).getName();
        assertArrayEquals(expected, actual);
	}
}
