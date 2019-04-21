package university.timetable.scheduling.data.initialization;

import java.util.ArrayList;
import java.util.Arrays;

import university.timetable.scheduling.pojo.Course;
import university.timetable.scheduling.pojo.Department;
import university.timetable.scheduling.pojo.Instructor;
import university.timetable.scheduling.pojo.MeetingTime;
import university.timetable.scheduling.pojo.Room;

public class Data {
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<Instructor> instructors=new ArrayList<Instructor>();
	private ArrayList<Course> courses = new ArrayList<Course>();;
	private ArrayList<Department> depts=new ArrayList<Department>();;
	private ArrayList<MeetingTime> meetingTimes=new ArrayList<MeetingTime>();
	private int numberOfClasses=0;
	
	
	
	public Data() {
	
	}


	public Data initialize() {
		
		Room room1= new Room("Room1",25);
		Room room2= new Room("Room2",45);
		Room room3= new Room("Room3",35);
		rooms=new ArrayList<Room>(Arrays.asList(room1,room2,room3));
		
		MeetingTime meetingTime1=new MeetingTime("MT1", "MWF 09:00 - 10:00");
		MeetingTime meetingTime2=new MeetingTime("MT2", "MWF 10:00 - 11:00");
		MeetingTime meetingTime3=new MeetingTime("MT3", "TTH 09:00 - 10:30");
		MeetingTime meetingTime4=new MeetingTime("MT4", "TTH 10:30 - 12:00");
		meetingTimes=new ArrayList<MeetingTime>(Arrays.asList(meetingTime1,meetingTime2,meetingTime3,meetingTime4));
		
		Instructor instructor1= new Instructor("I1", "kal");
		Instructor instructor2= new Instructor("I2", "Robin");
		Instructor instructor3= new Instructor("I3", "vishal");
		Instructor instructor4= new Instructor("I4", "yusuf");
		instructors=new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4));
		
		Course course1=new Course("c1", "INFO6100", 25, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)));
		Course course2=new Course("c2", "INFO6200", 35, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3)));
		Course course3=new Course("c3", "INFO6300", 25, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2)));
		Course course4=new Course("c4", "INFO6400", 30, new ArrayList<Instructor>(Arrays.asList(instructor3,instructor4)));
		Course course5=new Course("c5", "INFO6500", 35, new ArrayList<Instructor>(Arrays.asList(instructor4)));
		Course course6=new Course("c6", "INFO6600", 45, new ArrayList<Instructor>(Arrays.asList(instructor1,instructor3)));
		Course course7=new Course("c7", "INFO6700", 45, new ArrayList<Instructor>(Arrays.asList(instructor2,instructor4)));
		courses=new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5,course6,course7));
		
		Department dept1= new Department("MIS", new ArrayList<Course>(Arrays.asList(course1,course3)));
		Department dept2= new Department("CSE", new ArrayList<Course>(Arrays.asList(course2,course4,course5)));
		Department dept3= new Department("EM", new ArrayList<Course>(Arrays.asList(course6,course7)));
		depts=new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3));
		
		
		depts.forEach(x -> numberOfClasses += x.getCourses().size());
		
		return this;
	}


	public ArrayList<Room> getRooms() {
		return rooms;
	}


	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}


	public ArrayList<Course> getCourses() {
		return courses;
	}


	public ArrayList<Department> getDepts() {
		return depts;
	}


	public ArrayList<MeetingTime> getMeetingTimes() {
		return meetingTimes;
	}


	public int getNumberOfClasses() {
		return numberOfClasses;
	}
	
	public void addRoom(String name, int capacity) {
		//rooms=new ArrayList<>();
	    rooms.add(new Room(name,capacity));
	}
	
	public void addInstructor(String name,String id) {
		//instructors=new ArrayList<>();
		this.instructors.add(new Instructor(name,id));
	}
	
	public void addCourse(String number, String name, int maxNumberOfStudents, ArrayList<Instructor> instructors) {
		//courses=new ArrayList<>();
		 this.courses.add(new Course(number,name,maxNumberOfStudents,instructors));
	}
	
	public void addMeetingTime(String ID,String Time) {
		//meetingTimes=new ArrayList<>();
		MeetingTime m=new MeetingTime(ID, Time);
		meetingTimes.add(m);
	}
	
	public void addDepartment(String name, ArrayList<Course> courses) {
		//depts=new ArrayList<>();
		Department d=new Department(name, courses);
		depts.add(d);
	}
}
