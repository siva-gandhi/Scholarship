package sch;
public class ScholarshipDetails  implements java.io.Serializable {
     private int id;
     private String name;
     private String department;
     private String gender;
     private String comm;
     private int income;
     private int amount;
     private String lastdate;
    public ScholarshipDetails() {}
    public ScholarshipDetails(int id, String name, String department, String gender, String comm, int income, int amount, String lastdate) {
       this.id = id;
       this.name = name;
       this.department = department;
       this.gender = gender;
       this.comm = comm;
       this.income = income;
       this.amount = amount;
       this.lastdate = lastdate;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }   
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return this.department;
    }    
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getGender() {
        return this.gender;
    }    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getComm() {
        return this.comm;
    }    
    public void setComm(String comm) {
        this.comm = comm;
    }
    public int getIncome() {
        return this.income;
    }   
    public void setIncome(int income) {
        this.income = income;
    }
    public int getAmount() {
        return this.amount;
    }    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getLastdate() {
        return this.lastdate;
    }    
    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}