package com.able.re.clone.DeepClone;

public class DeepCloneBySerializable {

    public static void main(String[] args){

        Email email = new Email(1,"请与今天12:30到二会议室参加会议...");

        Person person1 =  new Person("张三",email);
        Person person2 = (Person) CloneUtils.clone(person1);
        person2.setName("王五");
        Person person3 = (Person) CloneUtils.clone(person1);
        person3.setName("李四");
        person3.getEmail().setContent("请与今天12:00到二会议室参加会议...");

        System.out.println(person1.getName() + "的邮件内容是：" + person1.getEmail().getContent());
        System.out.println(person2.getName() + "的邮件内容是：" + person2.getEmail().getContent());
        System.out.println(person3.getName() + "的邮件内容是：" + person3.getEmail().getContent());
    }
}
