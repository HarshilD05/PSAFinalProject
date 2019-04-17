package university.timetable.scheduling.data.initialization;

import java.util.ArrayList;
import java.util.Arrays;

import university.timetable.scheduling.pojo.Course;
import university.timetable.scheduling.pojo.Department;
import university.timetable.scheduling.pojo.Instructor;
import university.timetable.scheduling.pojo.MeetingTime;
import university.timetable.scheduling.pojo.Room;

public class Data {
	private ArrayList<Room> rooms;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;
	private ArrayList<Department> depts;
	private ArrayList<MeetingTime> meetingTimes;
	private int numberOfClasses=0;
	
	
	
	public Data() {
		initialize();
	}


	private Data initialize() {
		
		Room room1= new Room("Room1",11);
		Room room2= new Room("Room2",22);
		Room room3= new Room("Room3",33);
		rooms=new ArrayList<Room>(Arrays.asList(room1,room2,room3));
		
		MeetingTime meetingTime1=new MeetingTime("MT1", "MWF 09:00 - 10:00");
		MeetingTime meetingTime2=new MeetingTime("MT2", "MWF 10:00 - 11:00");
		MeetingTime meetingTime3=new MeetingTime("MT3", "TTH 09:00 - 10:30");
		MeetingTime meetingTime4=new MeetingTime("MT4", "TTH 10:30 - 12:00");
		meetingTimes=new ArrayList<MeetingTime>(Arrays.asList(meetingTime1,meetingTime2,meetingTime3,meetingTime4));
		
		Instructor instructor1= new Instructor("I1", "Kal");
		Instructor instructor2= new Instructor("I2", "Robin");
		Instructor instructor3= new Instructor("I3", "Vishal");
		Instructor instructor4= new Instructor("I4", "Yusuf");
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
}
