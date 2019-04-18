package university.timetable.scheduling.components;

import java.util.ArrayList;
import java.util.stream.IntStream;

import university.timetable.scheduling.data.initialization.Data;


public class Population {
	private ArrayList<Schedule> schedules;
	
	public Population(int size,Data data) {
		this.schedules = new ArrayList<Schedule>(size);
		IntStream.range(0,size).forEach(x -> schedules.add(new Schedule(data).initialize()));
	}


	public ArrayList<Schedule> getSchedules() {
		return schedules;
	}
	
	public Population sortByFitness() {
		schedules.sort((schedule1,schedule2) ->{
			int returnValue= 0;
			if(schedule1.getFitness()>schedule2.getFitness()) {returnValue = -1;}
			else if(schedule1.getFitness()<schedule2.getFitness()) {returnValue=1;}
			return returnValue;
		});
		return this;
	}
}
