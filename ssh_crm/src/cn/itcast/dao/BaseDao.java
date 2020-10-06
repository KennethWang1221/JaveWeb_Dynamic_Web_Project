package cn.itcast.dao;

import java.util.List;

/*
* 定义类型是 T ，代表任意类型
* （1）任意类型使用大写字母来表示，不一定用 T 来表示，只是我们习惯用 T 表示
* */
public interface BaseDao<T> {
    //添加
    void add(T t);

    //修改
    void update(T t);

    //删除
    void delete(T t);

    //根据 ID 查询
    T findOne(int id);

    //查询所有
    List<T> findAll();
}
