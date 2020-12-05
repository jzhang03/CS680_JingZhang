//
// CS680: HW10
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw12.apfs;

public class ApfsCountingVisitor implements ApfsFSVisitor {
	int dirNum = 0;
	int fileNum = 0;
	int linkNum = 0;
	
	public int getDirNum() {
		return this.dirNum;
	}
	
	public int getFileNum() {
		return this.fileNum;
	}
	public int getLinkNum() {
		return this.linkNum;
	}
	
	@Override
	public void visit(ApfsDirectory directory) {
		dirNum++;
	}

	@Override
	public void visit(ApfsFile file) {
		fileNum++;
	}
	
	@Override
	public void visit(ApfsLink link) {
		linkNum++;
	}
}
