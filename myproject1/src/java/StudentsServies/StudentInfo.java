

package StudentsServies;
import java.sql.ResultSet;
import java.util.ArrayList;
public final  class StudentInfo {
    private int sid;
    private String fullname;
    private String department;
    private String email;
    private String password;
    
    public  StudentInfo ()
    {}

    public StudentInfo(int sid, String fullname, String department, String email, String password) {
        this.sid = sid;
        this.fullname = fullname;
        this.department = department;
        this.email = email;
        this.password = password;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setfullname(String fullname) {
        this.fullname = fullname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSid() {
        return sid;
    }

    public String getfullname() {
        return fullname;
    }

    public String getDepartment() {
        return department;
    }

    public String getemail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

  
   
    private static boolean isNotNull (String text)
    {
        if(text.equals(""))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private static boolean isInt (String Sid)
    {
        String t=Sid;
        boolean valid=false;
        for (int i=0;i<t.length();i++)
        {
            char c= t.charAt(i);
            if(c>='0'&&c<='9')
            {
                valid=true;
            }
            else
            {
                valid=false;break;
            }
        }
        return valid;
    }
    
    private static boolean IdIsUsed (int id)
    {
           DBConnect db = new DBConnect();
           int i=0;
            try
                    {
                ResultSet rs =db.excuteSelect("SELECT * FROM std1 where sid="+id);
                while(rs.next())
                {
                    i++;
                }


                    db.close();
                    }catch(Exception ex)
                    {
                        System.out.print(ex);
                    }
            if(i>0)
            {
                return false;
            }
            else
            {
                return true;
            }
    }
    public static ArrayList isValid(String sid,String name,String department)
     {
         ArrayList allvalid=new ArrayList();
         boolean idisnotnull=isNotNull(sid);
         if(!idisnotnull)
         {
             String erroridisnotnull="please enter student id";
             allvalid.add(erroridisnotnull);
         }
         else
         {
             boolean idisint=isInt(sid);
             if(!idisint)
             {
                String erridisint="You did not enter  number for id";
             allvalid.add(erridisint); 
             
             }
             else
             {
                 boolean idisused=IdIsUsed(Integer.parseInt(sid));
                 if( !idisused )
                 {
                     String erridisused="this id is used ";
             allvalid.add(erridisused); 
                 }
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="please enter student name";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="please choose department for a student";
             allvalid.add(errdepartmentisnotnull);
         }
         
         return allvalid;
     }
   
     public static ArrayList isValidForUpdata(String sid,String name,String department)
     {
         ArrayList allvalid=new ArrayList();
         boolean idisnotnull=isNotNull(sid);
         if(!idisnotnull)
         {
             String erridisnotnull="please enter Student id";
             allvalid.add(erridisnotnull);
         }
         else
         {
             boolean idisint=isInt(sid);
             if(!idisint)
             {
                String erridisint="You did not enter Student id";
             allvalid.add(erridisint); 
             
             }
             else
             {
              
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="please enter Student name";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="please choose  department";
             allvalid.add(errdepartmentisnotnull);
         }
         
         return allvalid;
     }
   
     
    

   public void addSTD() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("insert into std1 values (" + this.sid + " , '" + this.fullname+ "','" + this.department + "','" + this.email + "','" +  "')");
               
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }
    public void addPas() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("insert into user values (" + this.sid + " , '" + this.password+  "')");
               
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }

    public void updateStd() {
        try {
            DBConnect db = new DBConnect();
             
            
             
            db.excuteDml("update std1  set  fullname= '" + this.fullname + "',department='"+this.department+"',level='"+this.email+"' where sid=" + this.sid);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void updatePass() {
        try {
            DBConnect db = new DBConnect();
             
            
             
            db.excuteDml("update user  set  password= '" + this.password + "'Where sid='"+this.sid);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void deleletSt()
            
    {
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("delete  from std1   where sid=" + this.sid);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }  
    }
    
   public void fillstud()
   {
   
   DBConnect db = new DBConnect();
   
   
   try
         {
       ResultSet rs =db.excuteSelect("SELECT * FROM std1 where sid="+this.sid);
       rs.next();
         this.fullname =rs.getString(2);
         this.department =rs.getString(3);
         this.email =rs.getString(4);
         
           
          db.close();
         }catch(Exception ex)
         {
             System.out.print(ex);
         }
        
       
    }
   public void fillPas()
   {
   
   DBConnect db = new DBConnect();
   
   
   try
         {
       ResultSet rs =db.excuteSelect("SELECT * FROM user where sid="+this.sid);
       rs.next();
         this.password =rs.getString(2);
        
         
           
          db.close();
         }catch(Exception ex)
         {
             System.out.print(ex);
         }
        
       
    }
 
    
    public static ArrayList getAll()
    {
         DBConnect db = new DBConnect();
         ArrayList allStd=new ArrayList();
         try
         {
       ResultSet rs =db.excuteSelect("SELECT * FROM `std1` ORDER BY `std1`.`department` ASC , `sid` ASC ");
               
       int i=0;
        while(rs.next())
        {                
            
         StudentInfo st=new StudentInfo();
         st.sid=rs.getInt(1);    
         st.fullname =rs.getString(2);
         st.department =rs.getString(3);
         st.email=rs.getString(4);
         st.password=rs.getString(5);
         
           i++;
           allStd.add(st);
        }
         db.close();
         }catch(Exception ex)
         {
             System.out.print(ex);
         }
        
       return  allStd;
    }
  
 
    
        public static ArrayList SeachStudent(String search)
    {
         DBConnect db = new DBConnect();
         ArrayList allStd=new ArrayList();
         try
         {
             String query="SELECT *"+
                            "FROM `std1`"+
                            "WHERE `fullname` LIKE '%"+search+"%'"+
                            "OR `department` LIKE '%"+search+"%'"+
                     "OR `sid` LIKE '%"+search+"%'"+
                            "OR `level` LIKE '%"+search+"%'";
       ResultSet rs =db.excuteSelect(query);
               
       int i=0;
        while(rs.next())
        {                
            
         StudentInfo st=new StudentInfo();
         st.sid=rs.getInt(1);    
         st.fullname =rs.getString(2);
         st.department =rs.getString(3);
         st.email =rs.getString(4);
         
           i++;
           allStd.add(st);
        }
         db.close();
         }catch(Exception ex)
         {
             System.out.print(ex);
         }
        
       return  allStd;
    }
 
    

}
