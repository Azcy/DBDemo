/**
 * Created by zcy on 2017/5/5.
 */
public class Customer {
    /**
     * Customer的基本信息类
     * @param cusid 顾客id
     * @param cusname 顾客姓名
     * @param cusphone 顾客电话
     * */
    private String cusid,cusname,cusphone;
    public Customer(String cusid,String cusname,String cusphone) {
        this.cusid=cusid;
        this.cusname=cusname;
        this.cusphone=cusphone;
    }

    public Customer() {

    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getCusphone() {
        return cusphone;
    }

    public void setCusphone(String cusphone) {
        this.cusphone = cusphone;
    }
}
