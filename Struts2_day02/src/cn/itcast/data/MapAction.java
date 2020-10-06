package cn.itcast.data;

import cn.itcast.entity.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class MapAction extends ActionSupport {
    // 1 声明map集合
    private Map<String, User> map;

    public Map<String,User> getMap() {
        return map;
    }

    public void setMap(Map<String,User> map) {
        this.map=map;
    }

    @Override
    public String execute() throws Exception {
        System.out.println(map);
        return NONE;
    }
}
