package university.timetable.scheduling.domain;

import university.timetable.scheduling.pojo.Course;
import university.timetable.scheduling.pojo.Department;
import university.timetable.scheduling.pojo.Instructor;
import university.timetable.scheduling.pojo.MeetingTime;
import university.timetable.scheduling.pojo.Room;

public class Class {
	private int classId;
	private Department department;
	private Course course;
	private Instructor instructor;
	private MeetingTime meetingTime;
	private Room room;
	
	
	public Class(int id, Department dept, Course course) {
		this.classId = id;
		this.department = dept;
		this.course = course;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void setMeetingTime(MeetingTime meetingTime) {
		this.meetingTime = meetingTime;
	}

	public void setRoom(Room room) {
		this.room = room;
	}


	public int getClassId() {
		return classId;
	}

	public Department getDepartment() {
		return department;
	}


	public Course getCourse() {
		return course;
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public MeetingTime getMeetingTime() {
		return meetingTime;
	}


	public Room getRoom() {
		return room;
	}
	
	public String toString() {
		return department.getName()+", "+ course.getNumber()+", "+room.getRoomnumber()+", "+ instructor.getName()+", "+meetingTime.getId();
		
	}
}
