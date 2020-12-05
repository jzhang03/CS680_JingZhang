//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;
import edu.umb.cs680.hw12.fs.FileSystem;

public class APFS extends FileSystem {
    private static LocalDateTime cTime = LocalDateTime.now();
    private static APFS apfs = null;
    private static ApfsDirectory rootDir; 

    private APFS(){
    	
    }

    public static APFS getInstance() {
		if (apfs == null) {
			apfs = new APFS();
		}
		return apfs;
    }
    
    protected ApfsElement createDefaultRoot() {
        APFS.rootDir = new ApfsDirectory(null, APFS.name, 0, cTime,
                "owner", cTime);
        return APFS.rootDir;
    }

    public static ApfsDirectory getRootDir() {
        return rootDir;
    }
}
