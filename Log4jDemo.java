package log4jdemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;


public class Log4jDemo
{
    static Scanner sc;
    static Connection c;
    static Properties p;
    static int a;
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
         sc=new Scanner(System.in);
         
         String path="D:\\java program\\Log4jDemoException\\src\\log4jdemoexception\\Log4jDemo.properties";   

        
         Add obj1=new Add();
         Sub obj2=new Sub();
         Mul obj3=new Mul();
         Div obj5=new Div();
         sc=new Scanner(System.in);
         
        String str=null;
         p = new Properties();
         InputStream is=new FileInputStream(path);
         p.load(is);
         
         
         
         
         try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
           c=DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
         }catch(ClassNotFoundException | SQLException e){logger.error(e);}
         
            while(true)
            {
                 System.out.println("enter input(for info press-0...for exiting press-10)");
                                 
                 try{
                      sc=new Scanner(System.in);
                      a=sc.nextInt();
                    
                    }catch(InputMismatchException e){
                     System.out.println("not valid input      not valid input");
                   
                       }
                 
                if(a!=10 && a!=1 && a!=2 && a!=3 && a!=4 && a!=0)
                {
                   System.out.println("wrong input ");
                }     
            if(a==10)
            {
                System.out.println("warning exiting");
                try {
                    c.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
            
            if(a==1)
            {
                System.out.println("info add");
                obj1.add();
                
                
            }
            if(a==2)
            {
                 System.out.println("info sub");
                 obj2.sub();
                 
            }
            
            if(a==3)
            {
                System.out.println("info mul");
                obj3.mul();
                
            }
            
            if(a==4)
            {
                System.out.println("info divide");
                obj5.div();
                
            }
            if(a==0)
            {
                System.out.println("1.  ADD");
                System.out.println("2.  SUB");
                System.out.println("3.  MUL");
                System.out.println("4.  DIV");
                System.out.println("10.  EXIT");
                System.out.println("information");
                
            }
           
    }
    }
}
