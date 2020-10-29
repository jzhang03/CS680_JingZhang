//
// CS680: HW4
// Copyright 2020 Jing Zhang <Jing.Zhang002@umb.edu>
// Git Repositories: https://github.com/jzhang03/CS680_JingZhang
// Git Name: jzhang03
//

package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw04.*;

class StudentTest {
    @Test
    public void createInStateStudentTest() {
        Student s = StudentFactory.createInStateStudent("Tom", "Malden");
        String name = s.getName();
        String usAddr = s.getusAddr();
        int yrsInState = s.getyrsInState();
        int i20Num = s.getI20num();
        float tution = s.getTution();
        String foreignAddr = s.getForeignAddr();
        StudentStatus status = s.getStatus();
        
        assertEquals(name, "Tom");
        assertEquals(usAddr, "Malden");
        assertEquals(yrsInState, Integer.MAX_VALUE);
        assertEquals(i20Num, Integer.MIN_VALUE);
        assertEquals(foreignAddr, null);
        assertEquals(status, StudentStatus.INSTATE);
        assertEquals(tution, 1000f);
    }

    @Test
    public void createOutStateStudentTest() {
        Student s = StudentFactory.createOutStateStudent("Jerry", "Seattle", 13);
        String name = s.getName();
        String usAddr = s.getusAddr();
        int yrsInState = s.getyrsInState();
        int i20Num = s.getI20num();
        float tution = s.getTution();
        String foreignAddr = s.getForeignAddr();
        StudentStatus status = s.getStatus();
        
        assertEquals(name, "Jerry");
        assertEquals(usAddr, "Seattle");
        assertEquals(yrsInState, 13);
        assertEquals(i20Num, Integer.MIN_VALUE);
        assertEquals(foreignAddr, null);
        assertEquals(status, StudentStatus.OUTSTATE);
        assertEquals(tution, 2000f);
    }

    @Test
    public void createIntlStateStudentTest() {
        Student s = StudentFactory.createIntlStudent("Bob", "Boston", 777777, "Tokyo");
        String name = s.getName();
        String usAddr = s.getusAddr();
        int yrsInState = s.getyrsInState();
        int i20Num = s.getI20num();
        float tution = s.getTution();
        String foreignAddr = s.getForeignAddr();
        StudentStatus status = s.getStatus();
        
        assertEquals(name, "Bob");
        assertEquals(usAddr, "Boston");
        assertEquals(yrsInState, Integer.MIN_VALUE);
        assertEquals(i20Num, 777777);
        assertEquals(foreignAddr, "Tokyo");
        assertEquals(status, StudentStatus.INTL);
        assertEquals(tution, 3000f);
    }
}