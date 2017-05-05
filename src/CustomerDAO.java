import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zcy on 2017/5/5.
 */
public class CustomerDAO {
    /**
     * 顾客的增、删、改、查类
     *
     * */
    //驱动
    String driver="com.mysql.jdbc.Driver";
    //连接数据库语句
    String str="jdbc:mysql://localhost:3306/myzcy";
    /*添加顾客*/
    public void addCustomer(Customer cus){
        try {
            //加载驱动
            Class.forName(driver);
           //建立连接
            Connection con= DriverManager.getConnection(str,"root","root");
            //sql语句
            String sql="insert into customers values(?,?,?)";
            //创建操作命令对象

            PreparedStatement cmd=con.prepareStatement(sql);
            cmd.setString(1,cus.getCusid());
            cmd.setString(2,cus.getCusname());
            cmd.setString(3,cus.getCusphone());

             //执行更新操作
            cmd.executeUpdate();
            //关闭连接
            con.close();
        }catch (Exception e)
        {

        }
    }

    /*删除顾客*/
    public void deleteCustomerByID(String cusid){
        try {
            //加载驱动
            Class.forName(driver);
            //建立连接
            Connection con= DriverManager.getConnection(str,"root","root");
            //sql语句
            String sql="delete from customers where customerId=?";
            PreparedStatement cmd=con.prepareStatement(sql);
            cmd.setString(1,cusid);
            cmd.executeUpdate();
            con.close();;
        }catch (Exception e){

        }
    }

    /*查询所有顾客信息*/
    public ArrayList<Customer> allCustomers(){
        ArrayList<Customer> list=new ArrayList<Customer>();
        try {
            Class.forName(driver);
            //建立连接
            Connection con= DriverManager.getConnection(str,"root","root");
            //创建命令对象
            Statement cmd=con.createStatement();
            ResultSet rs=cmd.executeQuery("SELECT * FROM customers");
            //遍历输出顾客信息
            while (rs.next()){
                Customer c=new Customer();
                c.setCusid(rs.getString(1));
                c.setCusname(rs.getString(2));
                c.setCusphone(rs.getString(3));
                list.add(c);
            }
            con.close();

        }catch (Exception e){
        }
        return list;
    }
}
