package pl.ap.domain;

/**
 * Created by parado on 2014-09-30.
 */
public class CourseInstructorRelation
{
   private Course course;

   private Instructor instructor;

   public Course getCourse()
   {
      return course;
   }

   public void setCourse(Course course)
   {
      this.course = course;
   }

   public Instructor getInstructor()
   {
      return instructor;
   }

   public void setInstructor(Instructor instructor)
   {
      this.instructor = instructor;
   }
}
