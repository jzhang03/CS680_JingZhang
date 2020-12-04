//
// CS680: HW10
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw10.apfs;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {

    private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();
    private String fileName;
    
    public ApfsFileSearchVisitor(String name) {
        this.fileName = name;
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
		if (file.getName().equals(fileName)) {
			foundFiles.add(file);
		}
	}
	
	public LinkedList<ApfsFile> getFoundFiles() {
		return this.foundFiles;
	}
}
