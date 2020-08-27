/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anas
 */

package Mark;
import java.sql.ResultSet;
import java.util.ArrayList;
public final  class StudentInfo {
    private int cid;
    private String cname;
    private String department;
    private String level;
    private String teacher;
    private String Mark ; 
    private String sid;
       private String num;
    public  StudentInfo ()
    {}

    public StudentInfo(int cid, String cname, String department, String level, String teacher, String Mark, String sid, String num) {
        this.cid = cid;
        this.cname = cname;
        this.department = department;
        this.level = level;
        this.teacher = teacher;
        this.Mark = Mark;
        this.sid = sid;
        this.num = num;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public String getDepartment() {
        return department;
    }

    public String getLevel() {
        return level;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getMark() {
        return Mark;
    }

    public String getSid() {
        return sid;
    }

    public String getNum() {
        return num;
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
    
    private static boolean isInt (String cid)
    {
        String t=cid;
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
                ResultSet rs =db.excuteSelect("SELECT * FROM sttable where cid="+id);
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
     public static ArrayList isValid(String cid,String name,String department)
     {
         ArrayList allvalid=new ArrayList();
         boolean idisnotnull=isNotNull(cid);
         if(!idisnotnull)
         {
             String erridisnotnull="please enter your sid";
             allvalid.add(erridisnotnull);
         }
         else
         {
             boolean idisint=isInt(cid);
             if(!idisint)
             {
                String erridisint="";
             allvalid.add(erridisint); 
             
             }
             else
             {
                 boolean idisused=IdIsUsed(Integer.parseInt(cid));
                 if( !idisused )
                 {
                     String erridisused="";
             allvalid.add(erridisused); 
                 }
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="please choose your department";
             allvalid.add(errdepartmentisnotnull);
         }
         
         return allvalid;
     }
   
     public static ArrayList isValidForUpdata(String cid,String name,String department)
     {
         ArrayList allvalid=new ArrayList();
         boolean idisnotnull=isNotNull(cid);
         if(!idisnotnull)
         {
             String erridisnotnull="";
             allvalid.add(erridisnotnull);
         }
         else
         {
             boolean idisint=isInt(cid);
             if(!idisint)
             {
                String erridisint="";
             allvalid.add(erridisint); 
             
             }
             else
             {
              
             }
         }
         
         boolean nameisnotnull=isNotNull(name);
         
         if(!nameisnotnull)
         {
             String errnameisnotnull="";
             allvalid.add(errnameisnotnull);
         }
         
         if(department.equals("ch"))
         {
             String errdepartmentisnotnull="";
             allvalid.add(errdepartmentisnotnull);
         }
         
         return allvalid;
     }
   
    

   public void addSTD() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("insert into 'sttable' values (" + this.cid + " , '" + this.cname+ "','" + this.department + "','" + this.level + "','" + this.teacher + "','" + this.Mark + "','" + this.sid + "','" + this.num + "')");
               
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }

    public void updateStd() {
        try {
            DBConnect db = new DBConnect();
             
            
             
            db.excuteDml("update sttable  set  cname= '" + this.cname + "',department='"+this.department+"',level='"+this.level+"',Teacher='"+this.teacher+"',mark='"+this.Mark+"' where cid=" + this.cid);
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void deleletSt()
            
    {
       try {
            DBConnect db = new DBConnect();
            db.excuteDml("delete  from sttable   where cid=" + this.cid);
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
       ResultSet rs =db.excuteSelect("SELECT * FROM sttable where cid="+this.cid+";");
       rs.next();
         this.cname =rs.getString(2);
         this.department =rs.getString(3);
         this.level =rs.getString(4);
         this.teacher =rs.getString(5);
         this.Mark =rs.getString(6);
            this.sid =rs.getString(7);
                this.num =rs.getString(8);
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
       ResultSet rs =db.excuteSelect("SELECT * FROM sttable");
               
       int i=0;
        while(rs.next())
        {                
            
         StudentInfo st=new StudentInfo();
         st.cid=rs.getInt(1);    
         st.cname =rs.getString(2);
         st.department =rs.getString(3);
         st.level =rs.getString(4);
         st.teacher =rs.getString(5);
         st.Mark =rs.getString(6);
          st.sid =rs.getString(7);
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
 
    
        public static ArrayList SearchStudent(String search)
    {
         DBConnect db = new DBConnect();
         ArrayList allStd=new ArrayList();
         try
         {
             String query="SELECT *"+
                            "FROM `sttable`"+
                            "WHERE `cname` LIKE '%"+search+"%'"+
                            "OR `department` LIKE '%"+search+"%'"+
                            "OR `level` LIKE '%"+search+"%'"+
                            "OR `Teacher` LIKE '%"+search+"%'" +
                            "OR `Mark` LIKE '%"+search+"%'"+
              "OR `sid` LIKE '%"+search+"%' ORDER BY `sttable`.`cname` ASC ,`sid` ASC";
       ResultSet rs =db.excuteSelect(query);
               
       int i=0;
        while(rs.next())
        {                
            
         StudentInfo st=new StudentInfo();
         st.cid=rs.getInt(1);    
         st.cname =rs.getString(2);
         st.department =rs.getString(3);
        st.level =rs.getString(4);
         st.teacher =rs.getString(5);
          st.Mark =rs.getString(6);
           st.sid =rs.getString(7);
           st.num =rs.getString(8);
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
