//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.apfs;

public interface ApfsFSVisitor {
	public void visit(ApfsLink link);
	public void visit(ApfsDirectory directory);
	public void visit(ApfsFile file);
}
