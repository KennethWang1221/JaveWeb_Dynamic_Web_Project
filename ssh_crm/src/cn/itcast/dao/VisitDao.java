package cn.itcast.dao;

import cn.itcast.entity.Visit;

import java.util.List;

public interface VisitDao {
    void add(Visit visit);

    List<Visit> findAll();
}
