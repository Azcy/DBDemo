import java.util.ArrayList;

/**
 * Created by zcy on 2017/5/5.
 */
public class Client {
    public static void main(String[] args) {
        //创建顾客
        Customer cus_a=new Customer("A2001","张三","18826237777");
        Customer cus_b=new Customer("A2002","李四","18826238888");
        Customer cus_c=new Customer("A2003","王五","18826239999");
        //创建CustomerDAO业务处理对象
        CustomerDAO dao=new CustomerDAO();
        //插入数据
        dao.addCustomer(cus_a);
        dao.addCustomer(cus_b);
        dao.addCustomer(cus_c);
        //把数据库的信息存放到list
        ArrayList<Customer> list=dao.allCustomers();
        //显示数据

        PrintCustomer p=new PrintCustomer(list);
        p.print();

    }
}
