package com.yunjun.cloudcommon.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

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

    private static ConcurrentHashMap<Object,Object> dataMap  = new ConcurrentHashMap<Object,Object>();
    private final static String DATA_PATH = "data.bat";

    //初始化加载数据到map中提高查询效率
    static {
        Node  node = (Node) readObjectFromFile();
        if(null!=node){
            dataMap.put(node.key,node);
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
        Node node;
        if(0 != expire){
           Long expireTime = System.currentTimeMillis() + expire*1000L;
           node = new Node(key,expireTime,s);
       }else {
            node = new Node(key,s);
        }
        dataMap.put(key,node);
        //应该写定时任务后台写数据到文件去持久化
        writeObjectToFile(node);
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
        // 判断是否过期
        if(null!=node){
            if ( node.expire != null && System.currentTimeMillis() > node.expire) {
                dataMap.remove(key);
                return null;
            }
            return node.value;
        }
        return null;
    }

    public static void writeObjectToFile(Object obj)
    {
        File file =new File(DATA_PATH);

        FileOutputStream out;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
            //System.out.println("write object success!");
        } catch (Exception e) {
           // System.out.println("write object failed");
           // e.printStackTrace();
        }
    }

    public static Object readObjectFromFile()
    {
        Object temp=null;
        File file =new File(DATA_PATH);
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
           // System.out.println("read object success!");
        } catch (IOException e) {
            //System.out.println("read object failed");
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        return temp;
    }

    class Node implements Serializable{
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
    }

    public static void main(String[] args) {
        unitest();
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



class Student
{
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

class Clazz {
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
class School {
    String name;
    String address;
    public School(String name, String address)
    {
        this.name = name;
        this.address = address;
    }
}