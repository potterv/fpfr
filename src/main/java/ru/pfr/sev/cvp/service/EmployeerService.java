package ru.pfr.sev.cvp.service;



import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;



import java.util.List;
@Deprecated
 public interface EmployeerService {
    public List<Employeer> getAllEmployeers();
    public void saveEmployeer(Employeer employer);
    public  Employeer getEmployeer(int id);
    public void deleteEmployeer(int id);
}
