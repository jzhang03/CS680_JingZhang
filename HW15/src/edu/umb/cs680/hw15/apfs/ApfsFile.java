//
// CS680: HW15
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw15.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement{
    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime,
            String ownersName, LocalDateTime modifiedTimestamp){
    	super(parent, name, size, creationTime, ownersName, modifiedTimestamp);
    }

@Override
public boolean isFile() {
	return true;
	}

public void accept(ApfsFSVisitor v) {
	v.visit(this);
	}
}
