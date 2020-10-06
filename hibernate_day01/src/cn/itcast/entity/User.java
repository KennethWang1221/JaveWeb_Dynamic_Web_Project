package cn.itcast.entity;

public class User {
    /*hibernate 要求实体类有一个属性唯一的*/
    private int uid;
    private String username;
    private String password;
    private String address;

    private int getUid() {
        return uid;
    }
    private void setUid(int uid){
        this.uid=uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
