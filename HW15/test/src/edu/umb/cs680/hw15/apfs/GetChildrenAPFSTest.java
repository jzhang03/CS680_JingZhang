//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.apfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GetChildrenAPFSTest {
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
	public void verifyHomeChildrenEquality() {
        ApfsDirectory homeDir = home;
        LinkedList<ApfsElement> actual = homeDir.getChildren((ApfsElement apfstest1, 
                ApfsElement apfstest2)->{
                    int apfstest1Domi = 0;
                    int apfstest2Domi = 0;
                    if(apfstest1.isDirectory()) {
                    	apfstest1Domi = 1;
                    } else if(apfstest1.isFile()){
                    	apfstest1Domi = 2;
                    } else if(apfstest1.isLink()){
                    	apfstest1Domi = 3;
                    }
                    if(apfstest2.isDirectory()) {
                    	apfstest2Domi = 1;
                    } else if(apfstest2.isFile()){
                    	apfstest2Domi = 2;
                    } else if(apfstest2.isLink()){
                    	apfstest2Domi = 3;
                    }
                    return ( (Integer) apfstest1Domi).compareTo( (Integer) apfstest2Domi);
                });
        ApfsElement[] expected = {code, c, d, x};
        assertArrayEquals(expected, actual.toArray(new ApfsElement[actual.size()]));
	}
	
	@Test
	public void verifyRootChildrenEquality() {
        ApfsDirectory rootDir = root;
        LinkedList<ApfsElement> actual = rootDir.getChildren((ApfsElement apfstest1, 
                ApfsElement apfstest2)->{
                    int apfstest1Domi = 0;
                    int apfstest2Domi = 0;
                    if(apfstest1.isDirectory()) {
                    	apfstest1Domi = 1;
                    } else if(apfstest1.isFile()){
                    	apfstest1Domi = 2;
                    } else if(apfstest1.isLink()){
                    	apfstest1Domi = 3;
                    }
                    if(apfstest2.isDirectory()) {
                    	apfstest2Domi = 1;
                    } else if(apfstest2.isFile()){
                    	apfstest2Domi = 2;
                    } else if(apfstest2.isLink()){
                    	apfstest2Domi = 3;
                    }
                    return ( (Integer) apfstest1Domi).compareTo( (Integer) apfstest2Domi);
                });
        ApfsElement[] expected = {applications, home};
        assertArrayEquals(expected, actual.toArray(new ApfsElement[actual.size()]));
	}
}
