import java.util.ArrayList;

/**
 * Created by zcy on 2017/5/5.
 */
public class PrintCustomer {
    ArrayList<Customer> lists=new ArrayList<Customer>();
    //Customer cs=new Customer();
    public  PrintCustomer(ArrayList<Customer> lists){
        this.lists = lists;
    }
    public void print()
    {
        for (int i=0;i<lists.size();i++){
            Customer cus=lists.get(i);
            System.out.println(cus.getCusid()+"\t"+cus.getCusname()+"\t"+cus.getCusphone());
        }
    }
}
