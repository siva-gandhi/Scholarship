package sch;
public class Users  implements java.io.Serializable {
     private String username;
     private String name;
     private int roll;
     private String gender;
     private String branch;
     private int sem;
     private String comm;
     private int inc;
     private String password;
    public Users() {
    }
    public Users(String username, String name, int roll, String gender, String branch, int sem, String comm, int inc, String password) {
       this.username = username;
       this.name = name;
       this.roll = roll;
       this.gender = gender;
       this.branch = branch;
       this.sem = sem;
       this.comm = comm;
       this.inc = inc;
       this.password = password;
    }   
    public String getUsername() {
        return this.username;
    }   
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRoll() {
        return this.roll;
    }    
    public void setRoll(int roll) {
        this.roll = roll;
    }
    public String getGender() {
        return this.gender;
    }    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBranch() {
        return this.branch;
    }    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public int getSem() {
        return this.sem;
    }    
    public void setSem(int sem) {
        this.sem = sem;
    }
    public String getComm() {
        return this.comm;
    }   
    public void setComm(String comm) {
        this.comm = comm;
    }
    public int getInc() {
        return this.inc;
    }    
    public void setInc(int inc) {
        this.inc = inc;
    }
    public String getPassword() {
        return this.password;
    }    
    public void setPassword(String password) {
        this.password = password;
    }
}