//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.apfs;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor {
	private LinkedList<ApfsFile> files= new LinkedList<ApfsFile>();
	
	public LinkedList<ApfsFile> getFiles() {
		return files;	
	}
	
 	@Override
	public void visit(ApfsLink link) {
		return;	
	}

	@Override
	public void visit(ApfsDirectory dir) {
		return;
	}

	@Override
	public void visit(ApfsFile file) {
        files.add(file);
	}
}
