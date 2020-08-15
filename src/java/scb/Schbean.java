package scb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import sch.ScholarshipDetails;
@Stateless
public class Schbean implements SchbeanLocal {
    static List<ScholarshipDetails> slist=new ArrayList<>();
    static List<Integer>rlist=new ArrayList<>();
    @Override
    public void addscholar(ScholarshipDetails sch) {
        if(!rlist.contains(sch.getId()))
        {
             rlist.add(sch.getId());
             slist.add(sch);
        } 
    }
    @Override
    public List<ScholarshipDetails> getscholar() {
        return slist;
    }

    @Override
    public void restart() {
        slist.clear();
        rlist.clear();
    }
}