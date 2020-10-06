package cn.itcast.entity;

public class LinkMan {
    private Integer linkid;
    private String  linkName;
    private String lkmGender;
    private String lkmPhone;
    private String lkmMobile;

    //客户联系人 客户是一 联系人是多  客户是百度 联系人 是员工

    //所属客户
    //虽然是对象 ，但他也是属性，是对象类型


    public LinkMan() {

    }

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer  customer) {
        this.customer = customer;
    }

    public Integer getLinkid() {
        return linkid;
    }

    public void setLinkid(Integer linkid) {
        this.linkid = linkid;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }
}
