package pl.ap.dao;

import org.joda.time.DateTime;
import pl.ap.domain.*;
import pl.ap.domain.enums.*;
import pl.ap.service.util.SidUtils;

import static pl.ap.service.util.SidUtils.generate;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 10.09.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class TestDomainObjectFactory extends CommonTestDomainObjectFactory {

    public static Role getRole() {
        Role role = new Role();
        role.setObjectState(ObjectStateEnum.ACTIVE);
        role.setSid(generate());
        role.setName(buildLongString(16));
        return role;
    }

    public static User getUser(Role role) {
        User user = new User();
        user.setSid(generate());
        user.setObjectState(ObjectStateEnum.ACTIVE);
        user.setFirstName(buildLongString(20));
        user.setLastName(buildLongString(30));
        user.setEmail("test@mail.com");
        user.setLogin(buildLongString(8));
        user.setPassword(buildLongString(16));
        user.setRole(role);
        return user;
    }

    public static Instructor getInstructor() {
        Instructor instructor = new Instructor();
        instructor.setFirstName(buildLongString(14));
        instructor.setLastName(buildLongString(20));
        instructor.setSid(generate());
        instructor.setObjectState(ObjectStateEnum.ACTIVE);
        return instructor;
    }

    public static Authority getAuthority() {
        Authority authority = new Authority();
        authority.setKey(buildLongString(64));
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
        category.setCode(buildLongString(6));
        category.setName(buildLongString(16));
        return category;
    }

    public static CourseStyle getCourseStyle(CourseCategory category) {
        CourseStyle style = new CourseStyle();
        style.setSid(generate());
        style.setObjectState(ObjectStateEnum.ACTIVE);
        style.setCategory(category);
        style.setName(buildLongString(12));
        return style;
    }

    public static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setSid(generate());
        customer.setObjectState(ObjectStateEnum.ACTIVE);
        customer.setFirstName(buildLongString(14));
        customer.setGender(GenderEnum.MALE);
        return customer;
    }

    public static InstructorDescription getInstructorDescription(Instructor instructor) {
        InstructorDescription description = new InstructorDescription();
        description.setSid(generate());
        description.setObjectState(ObjectStateEnum.ACTIVE);
        description.setInstructor(instructor);
        description.setDescription(buildLongString(50));
        return description;
    }

    public static News getNews() {
        News news = new News();
        news.setSid(generate());
        news.setObjectState(ObjectStateEnum.ACTIVE);
        news.setTitle(buildLongString(16));
        news.setContent(buildLongString(200));
        news.setCreatedAt(buildLongString(16));
        news.setImageSrc(buildLongString(20));
        news.setImageAlt(buildLongString(11));
        return news;

    }

    public static Room getRoom() {
        Room room = new Room();
        room.setSid(generate());
        room.setObjectState(ObjectStateEnum.ACTIVE);
        room.setCode(buildLongString(2));
        room.setName(buildLongString(16));
        return room;
    }

    public static Course getCourse(CourseStyle style, Instructor instructor, Room room) {
        Course course = new Course();
        course.setSid(generate());
        course.setObjectState(ObjectStateEnum.ACTIVE);
        course.setStyle(style);
        course.setInstructor(instructor);
        course.setRoom(room);
        course.setStartTime(buildLongString(5));
        course.setEndTime(buildLongString(5));
        course.setCanJoin(true);
        course.setCanRegister(false);
        course.setInProgress(true);
        course.setComment(buildLongString(16));
        course.setLevel(CourseLevelEnum.BEGINNER);
        course.setDay(DayEnum.CZ);
        return course;
    }

    public static CourseLesson getCourseUnit(Course course) {
        CourseLesson unit = new CourseLesson();
        unit.setCourse(course);
        unit.setDateTime(new DateTime());
        return unit;
    }

    public static CustomerPresence getCustomerPresence(Customer customer, CourseLesson unit) {
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

    public static Ticket getPass(Customer customer) {
        Ticket ticket = new Ticket();
        ticket.setSid(SidUtils.generate());
        ticket.setObjectState(ObjectStateEnum.ACTIVE);
        ticket.setCustomer(customer);
        ticket.setPurchaseDate(new DateTime());
        ticket.setEntrancePool(8);
        ticket.setEntrancesUsed(4);
        ticket.setStyleName("Joga");
        ticket.setType(TicketTypeEnum.ADULT_8_ENTRANCES_MONTH);
        return ticket;
    }

    public static TicketTypeGroup getTicketTypeGroup() {
        TicketTypeGroup group = new TicketTypeGroup();
        group.setSid(SidUtils.generate());
        group.setObjectState(ObjectStateEnum.ACTIVE);
        group.setName("Dorośli");
        return group;
    }
}
