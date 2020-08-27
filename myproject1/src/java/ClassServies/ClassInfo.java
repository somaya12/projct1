/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anas
 */

package ClassServies;
import java.sql.ResultSet;
import java.util.ArrayList;
public final  class ClassInfo {
    private int cid;
    private String className;
    private String department;
    private String level;
    private String Teacher;
    private String classNum;
    public  ClassInfo ()
    {}

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassNum() {
        return classNum;
    }

    public ClassInfo(int cid, String className, String department, String level, String Teacher, String classNum) {
        this.cid = cid;
        this.className = className;
        this.department = department;
        this.level = level;
        this.Teacher = Teacher;
        this.classNum = classNum;
    }

    

    public ClassInfo(String className, String department, String level, String Teacher, String classNum) {
        this.className = className;
        this.department = department;
        this.level = level;
        this.Teacher = Teacher;
        this.classNum = classNum;
    }

    public int getCid() {
        return cid;
    }

    public String getClassName() {
        return className;
    }

    public String getDepartment() {
        return department;
    }

    public String getLevel() {
        return level;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setTeacher(String Teacher) {
        this.Teacher = Teacher;
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
    
    private static boolean isInt (String classNum)
    {
        String t=classNum;
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
                ResultSet rs =db.excuteSelect("SELECT * FROM mat where classNum="+id);
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
     public static ArrayList isValid(String classNum,String name,String department)
     {
         ArrayList allvalid=new ArrayList();
         boolean idisnotnull=isNotNull(classNum);
         if(!idisnotnull)
         {
             String erridisnotnull="please enter class num";
             allvalid.add(erridisnotnull);
         }
         else
         {
             boolean idisint=isInt(classNum);
             if(!idisint)
             {
                String erridisint="You did not enter the number for class";
             allvalid.add(erridisint); 
             
             }
             else
             {
                 boolean idisused=IdIsUsed(Integer.parseInt(classNum));
                 if( !idisused )
                 {
                     String erridisused="this id is used";
             allvalid.add(erridisused); 
                 }
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="please enter z name";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="please choose your department";
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
             String erridisnotnull="please enter your sid";
             allvalid.add(erridisnotnull);
         }
         else
         {
             boolean idisint=isInt(sid);
             if(!idisint)
             {
                String erridisint="You did not enter the number for sid";
             allvalid.add(erridisint); 
             
             }
             else
             {
              
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="please enter your name";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="please choose your department";
             allvalid.add(errdepartmentisnotnull);
         }
         
         return allvalid;
     }
   
     
    

   public void addSTD() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("INSERT INTO `mat` (`cid`, `className`, `department`, `level`, `Teacher`, `classNum`) VALUES ( "+ this.cid + " , '" + this.className+ "','" + this.department + "','" + this.level + "','" + this.Teacher + "','" + this.classNum + "')");
               
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }

    public void updateStd() {
        try {
            DBConnect db = new DBConnect();
             
            
             
            db.excuteDml("update mat  set  className= '" + this.className + "',department='"+this.department+"',level='"+this.level+"',teacher='"+this.Teacher+"',classNum='"+this.classNum+"' where cid=" + this.cid);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void deleletSt()
            
    {
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("delete  from mat   where cid=" + this.cid);
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
       ResultSet rs =db.excuteSelect("SELECT * FROM mat where cid="+this.cid);
       rs.next();
         this.className =rs.getString(2);
         this.department =rs.getString(3);
         this.level =rs.getString(4);
         this.Teacher =rs.getString(5);
            this.classNum =rs.getString(6);
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
       ResultSet rs =db.excuteSelect("SELECT * FROM `mat` ORDER BY `mat`.`department` ASC , `cid` ASC ,`className` ASC , `Teacher` ASC");
               
       int i=0;
        while(rs.next())
        {                
            
         ClassInfo st=new ClassInfo();
         st.cid=rs.getInt(1);    
         st.className =rs.getString(2);
         st.department =rs.getString(3);
         st.level =rs.getString(4);
         st.Teacher =rs.getString(5);
         st.classNum =rs.getString(6);
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
                            "FROM `mat`"+
                            "WHERE `className` LIKE '%"+search+"%'"+
                            "OR `department` LIKE '%"+search+"%'"+
                     "OR `cid` LIKE '%"+search+"%'"+
                            "OR `level` LIKE '%"+search+"%'"+
                            "OR `Teacher` LIKE '%"+search+"%'";
       ResultSet rs =db.excuteSelect(query);
               
       int i=0;
        while(rs.next())
        {                
            
         ClassInfo st=new ClassInfo();
         st.cid=rs.getInt(1);    
         st.className =rs.getString(2);
         st.department =rs.getString(3);
         st.level =rs.getString(4);
         st.Teacher =rs.getString(5);
          st.classNum =rs.getString(6);
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
