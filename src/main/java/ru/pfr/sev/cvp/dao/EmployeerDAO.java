package ru.pfr.sev.cvp.dao;



import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;

import java.util.List;

public interface EmployeerDAO {
    public List<Employeer> getAllEmployeer();
    public void saveEmployeer(Employeer employeer);
    public  Employeer getEmployer(int id);
    public void deleteEmployeer(int id);
}
