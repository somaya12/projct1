
package StudentTable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
  public final  class ClassInfo {
    private int cid;
    private String className;
    private String department;
    private String level;
    private String Teacher;
    private String mark;
    private int sid;
     private String classNum;
   
    private int r = (int) (Math.random()*(1000-1))+1;
    public  ClassInfo ()
    {}

    public int getR() {
        return r;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getClassNum() {
        return classNum;
    }

    public ClassInfo( String className, String department, String level, String Teacher, String mark, int sid, String classNum) {
        
        this.className = className;
        this.department = department;
        this.level = level;
        this.Teacher = Teacher;
        this.mark = mark;
        this.sid = sid;
        this.classNum = classNum;
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

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public String getMark() {
        return mark;
    }

    public int getSid() {
        return sid;
    }

 
  
     public  class genRandom{
           
         
         Random rand = new Random();
         
     }
   
   
    private static boolean IdIsUsed (int id)
    {
           DBConnect db = new DBConnect();
           int i=0;
            try
                    {
                ResultSet rs =db.excuteSelect("SELECT * FROM sttable where sid="+id);
                while(rs.next())
                {
                    i++;
                }


                    db.close();
                    }catch(Exception ex)
                    {
                        System.out.print(ex);
                    }
            if(i>=5)
            {
                return false;
            }
            else
            {
                return true;
            }
    }
     private static boolean IdIsUsed2 (int id2)
    {
           DBConnect db = new DBConnect();
           int i=0;
            try
                    {
                ResultSet rs =db.excuteSelect("SELECT * FROM sttable where classNum="+id2);
                while(rs.next())
                {
                    i++;
                }


                    db.close();
                    }catch(Exception ex)
                    {
                        System.out.print(ex);
                    }
            if(i>15)
            {
                return false;
            }
            else
            {
                return true;
            }
    }
     public static ArrayList isValid(String sid,String classNum)
     {
         ArrayList allvalid=new ArrayList();
        
            boolean idisused=IdIsUsed(Integer.parseInt(sid));
                 if( !idisused )
                 {
                     String erridisused="Your table is full";
             allvalid.add(erridisused); 
                 }
             else
             {
                 boolean idisused2=IdIsUsed2(Integer.parseInt(classNum));
                 if( !idisused2 )
                 {
                     String erridisused="the Class is full";
             allvalid.add(erridisused); 
                 }
             }
         
         
         
         
         return allvalid;
     }
   
    
   
   
     
    

  public void addSTD() {
        try {
            DBConnect db = new DBConnect();
            db.excuteDml("INSERT INTO `sttable`(`cid`, `cname`, `department`, `level`, `Teacher`, `mark`, `sid`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7]) (" + this.cid + " , '" + this.className+ "', '" + this.department+ "', '" + this.level+ "','" + this.Teacher  + "','" + this.mark + "','" + this.sid + "')");
               
            db.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }

    }

  public void updateStd() {
        try {
           DBConnect db = new DBConnect();
             
            
             
            db.excuteDml ("insert into sttable values (" + this.cid + " , '" + this.className+ "', '" + this.department+ "', '" + this.level+ "','" + this.Teacher  + "','" + this.mark + "','" + this.sid + "','" + this.classNum + "')");
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
       ResultSet rs =db.excuteSelect("SELECT * FROM mat ");
               
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
                            "FROM `sttable`"+
                            "WHERE `sid` LIKE '%"+search+"%'";
         ;
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
          st.mark =rs.getString(6);
           st.sid =rs.getInt(7);
            st.classNum =rs.getString(8);
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
                            "FROM `mat`"+
                            "WHERE `className` LIKE '%"+search+"%'"+
                            "OR `department` LIKE '%"+search+"%'"+
                     "OR `cid` LIKE '%"+search+"%'"+
                            "OR `level` LIKE '%"+search+"%'"+
                            "OR `Teacher` LIKE '%"+search+"%'"+ "ORDER BY `mat`.`department` ASC ,`cid` ASC ";
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
