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
import org.apache.log4j.*;
import java.util.Scanner;


public class Log4jDemo
{
    static Scanner sc;
    static Connection c;
   // static String path="C:\\Users\\Pranshu\\Documents\\NetBeansProjects\\14-06-19\\13-06-19\\Log4jDemoException\\src\\Log4jDemo.properties";
    private static final Logger logger=Logger.getLogger(Log4jDemo.class.getName());
    static Properties p;
    static int a;
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
         sc=new Scanner(System.in);
         System.out.println("enter the path of properties file");
         
         String path=sc.nextLine();   

        PropertyConfigurator.configure(path);
        
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
                logger.warn("warning exiting");
                try {
                    c.close();
                } catch (Exception e) {
                    logger.error(e);
                }
                break;
            }
            
            if(a==1)
            {
                logger.info("info add");
                obj1.add();
                
                
            }
            if(a==2)
            {
                 logger.info("info sub");
                 obj2.sub();
                 
            }
            
            if(a==3)
            {
                logger.info("info mul");
                obj3.mul();
                
            }
            
            if(a==4)
            {
                logger.info("info divide");
                obj5.div();
                
            }
            if(a==0)
            {
                System.out.println("1.  ADD");
                System.out.println("2.  SUB");
                System.out.println("3.  MUL");
                System.out.println("4.  DIV");
                System.out.println("10.  EXIT");
                logger.info("information");
                
            }
           
    }
    }
}

/* try{
                      str=sc.nextLine();
                      System.out.println("invalid input "+str);
                  }catch(Exception e){//a=0;
                  System.out.println("check your input"+str);}
                  */
                 
                 /*
               if(a!=10 || a!=1 || a!=2 || a!=3 || a!=4 || a!=0)
               {
                   System.out.println("wrong input");
                   //a=0;
               }*/
//System.in.read();
//byte[] b = new byte[1024];
                     //int aa =  System.in.read(b);
                    
                     //System.out.print(b.toString());