package pl.ap.dao;

import org.joda.time.DateTime;
import pl.ap.domain.*;
import pl.ap.domain.enums.CourseLevelEnum;
import pl.ap.domain.enums.DayEnum;
import pl.ap.domain.enums.GenderEnum;
import pl.ap.domain.enums.ObjectStateEnum;

import static pl.ap.service.util.SidUtils.generate;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class TestDomainObjectFactory {

    public static Role getRole() {
        Role role = new Role();
        role.setName("Administrator");
        return role;
    }

    public static User getUser(Role role) {
        User user = new User();
        user.setSid(generate());
        user.setObjectState(ObjectStateEnum.ACTIVE);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmail("contact@makfilm.com");
        user.setLogin("login");
        user.setPassword("VeryLongPassword");
        user.setRole(role);
        return user;
    }

    public static Instructor getInstructor() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("Andrzej");
        instructor.setLastName("Adamski");
        instructor.setSid(generate());
        instructor.setObjectState(ObjectStateEnum.ACTIVE);
        return instructor;
    }

    public static Authority getAuthority() {
        Authority authority = new Authority();
        authority.setKey("SCHEDULE_VIEW");
        return authority;
    }

    public static AuthorityRoleRelation getAuthorityRoleRelation(Authority authority, Role role) {
        AuthorityRoleRelation relation = new AuthorityRoleRelation();
        relation.setRole(role);
        relation.setAuthority(authority);
        return relation;
    }

    public static CourseCategory getCourseCategory() {
        CourseCategory category = new CourseCategory();
        category.setSid(generate());
        category.setObjectState(ObjectStateEnum.ACTIVE);
        category.setCode("solo");
        category.setName("Zajęcia solo");
        return category;
    }

    public static CourseStyle getCourseStyle(CourseCategory category) {
        CourseStyle style = new CourseStyle();
        style.setSid(generate());
        style.setObjectState(ObjectStateEnum.ACTIVE);
        style.setCategory(category);
        style.setName("Hip-hop");
        return style;
    }

    public static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setSid(generate());
        customer.setObjectState(ObjectStateEnum.ACTIVE);
        customer.setFirstName("Andrzej");
        customer.setMobile("987654321");
        customer.setGender(GenderEnum.MALE);
        return customer;
    }

    public static InstructorDescription getInstructorDescription(Instructor instructor) {
        InstructorDescription description = new InstructorDescription();
        description.setSid(generate());
        description.setObjectState(ObjectStateEnum.ACTIVE);
        description.setInstructor(instructor);
        description.setDescription("Bardzo fajny instruktor");
        return description;
    }

    public static News getNews() {
        News news = new News();
        news.setSid(generate());
        news.setObjectState(ObjectStateEnum.ACTIVE);
        news.setTitle("Jakiś tytuł");
        news.setContent("Treść bardzo ważnego ogłoszenia");
        news.setCreatedAt("2014-08-21 16:06");
        news.setImageSrc("assets/img/image.jpg");
        news.setImageAlt("Opis obrazka");
        return news;

    }

    public static Room getRoom() {
        Room room = new Room();
        room.setSid(generate());
        room.setObjectState(ObjectStateEnum.ACTIVE);
        room.setCode("m");
        room.setName("Mała sala");
        return room;
    }

    public static Course getCourse(CourseStyle style, Instructor instructor, Room room) {
        Course course = new Course();
        course.setSid(generate());
        course.setObjectState(ObjectStateEnum.ACTIVE);
        course.setStyle(style);
        course.setInstructor(instructor);
        course.setRoom(room);
        course.setStartTime("15:30");
        course.setEndTime("16:30");
        course.setCanJoin(true);
        course.setCanRegister(false);
        course.setInProgress(true);
        course.setComment("Start 15.09");
        course.setLevel(CourseLevelEnum.BEGINNER);
        course.setDay(DayEnum.CZ);
        return course;
    }

    public static CourseUnit getCourseUnit(Course course) {
        CourseUnit unit = new CourseUnit();
        unit.setCourse(course);
        unit.setDateTime(new DateTime());
        return unit;
    }

    public static CustomerPresence getCustomerPresence(Customer customer, CourseUnit unit) {
        CustomerPresence presence = new CustomerPresence();
        presence.setCustomer(customer);
        presence.setLesson(unit);
        presence.setPresent(true);
        return presence;
    }

    public static CustomerSubscription getCustomerSubscription(Customer customer, Course course) {
        CustomerSubscription subscription = new CustomerSubscription();
        subscription.setCustomer(customer);
        subscription.setCourse(course);
        return subscription;
    }
}
