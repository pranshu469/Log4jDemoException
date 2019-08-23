package log4jdemo;
import java.io.IOException;
import java.sql.*;
import java.util.InputMismatchException;

public class Div 
{
    private static final Logger logger=Logger.getLogger(Log4jDemo.class.getName());
    public void div() throws IOException
    {
         int x1=0,y1=0,exc=0;
        System.out.println("enter 2 operands");
        try{
        x1=Log4jDemo.sc.nextInt();
        y1=Log4jDemo.sc.nextInt();
        }catch(InputMismatchException e){
            exc=100;
            System.out.println("operands must be integer");
        }
        if(exc!=100)
        {
         if(y1!=0){
           double z1=x1*1.0/y1;
                System.out.println("result of division is ");
                System.out.format("%.3f", z1);
                try{
                    String t1="div";
                    Statement s=Log4jDemo.c.createStatement();
                    int x=s.executeUpdate("insert into "+Log4jDemo.p.getProperty("tb")+" values('"+t1+"','"+x1+"','"+y1+"','"+z1+"')");
                    ResultSet rs=s.executeQuery("select * from "+Log4jDemo.p.getProperty("tb"));
                      }catch(SQLException e){
                                System.out.println("error occured "+e);
                                 }
            }
        else{
                System.out.println("denominator can not be zero");
            Log4jDemo l4;
            l4 = new Log4jDemo();
            }
    }
}
}





 
 
