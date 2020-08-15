package scb;
import java.util.List;
import javax.ejb.Local;
import sch.ScholarshipDetails;
@Local
public interface SchbeanLocal {
    void addscholar(ScholarshipDetails sch);
    List<ScholarshipDetails> getscholar(); 
    void restart();
}