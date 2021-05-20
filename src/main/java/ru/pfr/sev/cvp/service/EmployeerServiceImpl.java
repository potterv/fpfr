package ru.pfr.sev.cvp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pfr.sev.cvp.dao.EmployeerDAO;
import ru.pfr.sev.cvp.fpfr.db.entity.Employeer;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeerServiceImpl implements EmployeerService {
@Autowired
    private EmployeerDAO employeerDAO;
    @Override
    @Transactional
    public List<Employeer> getAllEmployeers(){return employeerDAO.getAllEmployeer();}


}