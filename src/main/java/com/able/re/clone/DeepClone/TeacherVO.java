package com.able.re.clone.DeepClone;

public class TeacherVO implements Cloneable{

    private int id;

    private String teacherName;

    private Course course;


    public TeacherVO() {
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", course ='" + course + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        TeacherVO teacher = null;
        try{
            teacher = (TeacherVO) super.clone();  //浅复制
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        teacher.course = (Course) course.clone(); //深复制
        return teacher;
    }
}
