package com.yunjun.productone.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 面试题：我们知道文件存储可以存储一些数据，我们现在想要利用文件存储的方法，来构建一类类似于redis的持久化存储类。
 * 它可以存储不同类型的对象，并且可以设置过期时间，当过期时间到达时，对象会被自动删除或不可访问。
 * 注意，这里的存储对象期望可以是尽可能支持广泛类型的对象，而不仅仅是特定的类型的对象。
 * 请实现以下的DataSave类的save和load方法以实现我们的目标，并保证unitest方法中的测试通过。（可以添加其他的辅助方法及类）
 *
 * 提示：实现以下问题的方法很多，并没有唯一答案，请尽可能提供简洁的实现。我们重点关注代码的可读性和可维护性及思路。
 *
 * 提交格式：请提供实现的代码，并且提供运行结果的截图。
 */
public class DataSave {

    public static ConcurrentHashMap<Object,Object> dataMap  = new ConcurrentHashMap<Object,Object>();
    public static  Queue<Node> queue = new ConcurrentLinkedQueue<>();
    private final static String DATA_PATH = "data.bat";

    //初始化加载数据到map中提高查询效率
    static {
        Node node = (Node) readObjectFromFile();
        if(null!=node) {
            dataMap.put(node.key, node);
        }
    }
    //请实现持久化存储函数（使用文件存储相关方法）
    /**
     * @param key 存储的key
     * @param s 存储的对象
     * @param expire 过期时间，单位秒，如果为0则表示永不过期
     */
    void save(String key,Object s,int expire)
    {
        /**
         * 你的代码
         */
        /**
         * 1、先将数据存储到缓存map中去（类似aof）
         * 2、定时存map中将数据持久化到文件中(rdb)
         */
        Node node = new Node(key,s);
        if(expire > 0){
            //设置过期时间
            node.setExpire(System.currentTimeMillis() + expire*1000L);
        }
        dataMap.put(key,node);
        queue.add(node);
        //后台定时任务去执行
        //writeObjectToFile(node);
    }

    //请实现持久化数据的取出
    /**
     * @param key 存储的key
     * @return 存储的对象
     */
    Object load(String key)
    {
        /**
         * 你的代码
         */
        Node node = (Node) dataMap.get(key);
        if(null != node.expire){
            if(-1 == node.expire){
                //已过期的
                return null;
            }else {
                //设置了过期时间 判断是否已到期
                if (System.currentTimeMillis() <= node.expire) {
                    return node.value;
                }
                //采用惰性删除(过期时间未-1 表示删除)
                node.setExpire(-1L);
                dataMap.put(key, node);
                queue.add(node);
            }
        }else {
            return node.value;
        }
        return null;
    }

    public static void writeObjectToFile(Object obj)
    {
        File file =new File(DATA_PATH);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
           // System.out.println("write object success!");
        } catch (Exception e) {
            //System.out.println("write object failed");
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile()
    {
        Object temp=null;
        File file =new File(DATA_PATH);
        if(!file.exists()){
            return null;
        }
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            //System.out.println("read object success!");
        } catch (IOException e) {
            //System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public static void main(String[] args) {
        unitest();
        Timer timer = new Timer();
        timer.schedule(new WriterObj(),0,2);
    }

    static void unitest()
    {
        School sc=new School("wuhan","wuhan location");
        Clazz c=new Clazz("1",30,2,sc);
        Student s=new Student("zhangsan",18,c);
        Student s0=new Student("lisi",22,c);

        //存储和取出学生对象
        DataSave sds=new DataSave();
        sds.save("student",s,0);
        Student s2=(Student)(sds.load("student"));
        System.out.println("age:"+s2.age);
        System.out.println("grade:"+s2.clazz.grade);
        System.out.println("address:"+s2.clazz.school.address);

        //存储和取出班级对象
        sds.save("clazz",c,0);
        Clazz c2=(Clazz)(sds.load("clazz"));
        System.out.println("grade:"+c2.grade);
        System.out.println("address:"+c2.school.address);

        //存储和取出学校对象
        sds.save("school",sc,0);
        School sc2=(School)(sds.load("school"));
        System.out.println("address:"+sc2.address);

        //存储和取出学生列表
        ArrayList<Student> students=new ArrayList<Student>();
        students.add(s);
        students.add(s0);
        sds.save("students",students,0);
        ArrayList<Student> students2=(ArrayList<Student>)(sds.load("students"));
        System.out.println("students size:"+students2.size());
        System.out.println("students1 age:"+students2.get(0).age);



        //存储和取出学生对象，过期时间为10秒
        sds.save("school_test",sc,10);
        School sc3=(School)(sds.load("school_test"));
        System.out.println("未过期时，school:"+sc3);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        School sc4=(School)(sds.load("school_test"));
        System.out.println("已过期时，school:"+(sc4==null));

    }
}

class WriterObj extends TimerTask{
    @Override
    public void run() {
        Node poll = DataSave.queue.poll();
        if(null!=poll && DataSave.dataMap.containsKey(poll.key)) {
            DataSave.writeObjectToFile(DataSave.queue.poll());
        }
    }
}
class Node implements Serializable{

    @Serial
    private static final long serialVersionUID = 7135696493277822453L;
    String key;

    Long expire;

    Object value;

    public Node(String key, Object value) {
        this.key = key;
        this.value = value;
    }
    public Node(String key, Long expire, Object value) {
        this.key = key;
        this.expire = expire;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}

class Student implements Serializable
{
    @Serial
    private static final long serialVersionUID = 7417175484581818150L;
    String name;
    int age;
    Clazz clazz;
    public Student(String name, int age, Clazz clazz)
    {
        this.name = name;
        this.age = age;
        this.clazz = clazz;
    }
}

class Clazz implements Serializable {
    @Serial
    private static final long serialVersionUID = 540231296107348091L;
    String grade;
    int studentNumbers;
    int teacherNumbers;
    School school;
    public Clazz(String grade, int studentNumbers, int teacherNumbers, School school)
    {
        this.grade = grade;
        this.studentNumbers = studentNumbers;
        this.teacherNumbers = teacherNumbers;
        this.school = school;
    }
}
class School implements Serializable {
    @Serial
    private static final long serialVersionUID = 7239526057998847013L;
    String name;
    String address;
    public School(String name, String address)
    {
        this.name = name;
        this.address = address;
    }
}