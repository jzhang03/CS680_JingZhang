//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class APFSComparator implements Comparator<ApfsElement> {
	@Override
	public int compare(ApfsElement apfs1, ApfsElement apfs2) {
		if(apfs1 instanceof ApfsDirectory && apfs2 instanceof ApfsDirectory)
			return 3;
		else if(apfs1 instanceof ApfsDirectory && apfs2 instanceof ApfsFile)
			return 2;
		else if(apfs2 instanceof ApfsDirectory && apfs1 instanceof ApfsFile)
			return 1;
		else 
			return 0;
	}
}
