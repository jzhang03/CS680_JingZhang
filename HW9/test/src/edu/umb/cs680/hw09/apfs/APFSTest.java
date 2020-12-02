//
// CS680: HW9
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw09.apfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {
    private String[] apfsElementToArray(ApfsElement apfs) {
        String[] out = {apfs.getName(), apfs.getOwnersName(), 
        		Integer.toString(apfs.getSize())};
        return out;
    }
    
    @Test
    public void sameAPFSTest() {
        APFS apfsA = APFS.getInstance();
        APFS apfsB = APFS.getInstance();
        assertSame(apfsA, apfsB);
    }

    @Test
    public void getRootDirsTest() {
        APFS apfs = APFS.getInstance();
        apfs.initFileSystem("apfstest", 128);
        String[] actual = this.apfsElementToArray(apfs.getRootDir());
        String[] expected = {"apfstest", "owner", "0"};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void createDefaultRootTest() {
        APFS apfs = APFS.getInstance();
        ApfsDirectory root = apfs.getRootDir();
        String[] actual = this.apfsElementToArray(apfs.getRootDir());
        String[] expected = {"apfstest", "owner", "0"};
        assertArrayEquals(expected, actual);
    }
}
