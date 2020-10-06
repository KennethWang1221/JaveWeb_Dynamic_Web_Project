package cn.itcast.dao;

import cn.itcast.entity.LinkMan;

import java.util.List;

public interface LinkManDao {
    void add(LinkMan linkMan);

    List<LinkMan> list();


    LinkMan findOne(int linkid);

    void update(LinkMan linkMan);

    List<LinkMan> findCondition(LinkMan linkMan);
}
