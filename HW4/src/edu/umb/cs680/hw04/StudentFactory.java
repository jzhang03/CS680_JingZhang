package edu.umb.cs680.hw04;

class StudentFactory {

    private StudentFactory() {
    }

    public static Student createInStateStudent(String name, String usAddr) {
        Student s = new Student(name, usAddr, Integer.MAX_VALUE, Integer.MIN_VALUE, null, StudentStatus.INSTATE);
        s.setTution(1000f);
        return s;
    }

    public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
        Student s = new Student(name, usAddr, yrsInState, Integer.MIN_VALUE, null, StudentStatus.OUTSTATE);
        s.setTution(2000f);
        return s;

    }

    public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
        Student s = new Student(name, usAddr, Integer.MIN_VALUE, i20num, foreignAddr, StudentStatus.INTL);
        s.setTution(3000f);
        return s;
    }
}