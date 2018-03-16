package com.able.re.clone.DeepClone;

public class Course implements Cloneable{

    private String subject;

    public Course() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Course{" +
                "subject='" + subject + '\'' +
                '}';
    }

    @Override
    public Object clone(){
        Course course = null;

        try{
            course = (Course)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return course;
    }

}
