package edu.umb.cs680.hw04;

class Student {
    float tution;
    String name;
    int i20num;
    String usAddr;
    int yrsInState;
    String foreignAddr;
    StudentStatus status;

    protected Student(String name, String usAddr, int yrsInState, int i20num, 
    		String foreignAddr, StudentStatus status) {
        this.name = name;
        this.usAddr = usAddr;
        this.yrsInState = yrsInState;
        this.i20num = i20num;
        this.foreignAddr = foreignAddr;
        this.status = status;
    }

    public void setTution(float tution) {
        this.tution = tution;
    }
    
    public float getTution() {
        return tution;
    }

    public String getName() {
        return name;
    }

    public int getI20num() {
        return i20num;
    }

    public String getusAddr() {
        return usAddr;
    }

    public int getyrsInState() {
        return yrsInState;
    }

    public String getForeignAddr() {
        return foreignAddr;
    }

    public StudentStatus getStatus() {
        return status;
    }
}