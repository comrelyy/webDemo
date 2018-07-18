package com.able.re.IO;

import com.able.re.clone.DeepClone.Person;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestDemo {
    public static void main(String[] args) throws  Exception{
//        FileOutputStream fos = new FileOutputStream("d://demo.txt");
        //ObjectOutputStream oos = new ObjectOutputStream(fos);
//        Person p = new Person();
//        oos.writeObject(p);
//        oos.flush();
        FileInputStream fis = new FileInputStream("d://demo.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        if(o instanceof Person ) {
            System.out.println("我是一个Persond对象");
        }else{
            System.out.println("我不知道我是谁");
        }
    }
}
