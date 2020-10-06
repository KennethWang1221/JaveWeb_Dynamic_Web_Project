package cn.itcast.service;

import cn.itcast.dao.VisitDao;
import cn.itcast.entity.Visit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class VisitService {
    private VisitDao visitDao;

    public VisitDao getVisitDao() {
        return visitDao;
    }

    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    public void addVisit(Visit visit) {
        visitDao.add(visit);
    }

    public List<Visit> findAll() {
        return visitDao.findAll();
    }
}
