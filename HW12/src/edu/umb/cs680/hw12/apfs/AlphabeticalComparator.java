//
// CS680: HW12
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {
	@Override
	public int compare(ApfsElement apfs1, ApfsElement apfs2) {
		return apfs1.getName().toString().compareTo(apfs2.getName().toString());
	}
}
