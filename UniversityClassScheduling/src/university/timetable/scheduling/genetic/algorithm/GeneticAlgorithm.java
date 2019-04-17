package university.timetable.scheduling.genetic.algorithm;
import java.util.ArrayList;
import java.util.stream.IntStream;
import university.timetable.scheduling.components.*;
import university.timetable.scheduling.pojo.*;
import university.timetable.scheduling.data.*;
import javax.xml.crypto.Data;
import university.timetable.scheduling.main.UniversityTimetableScheduling;


public class GeneticAlgorithm {
	
	private Data data;

	public GeneticAlgorithm(Data data) {
		this.data = data;
	}
	
	public Population evolve(Population population) {
		return mutatePopulation(crossOverPopulation(population));
	}
	
	public Population crossOverPopulation(Population population) {
		Population crossOverPopulation=new Population(population.getSchedules().size(),data);
		IntStream.range(0,UniversityTimetableScheduling.NUM_OF_ELITE_SCHEDULES).forEach(x -> crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
		
		IntStream.range(UniversityTimetableScheduling.NUM_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x -> {
			if(Driver.CROSSOVER_RATE > Math.random()) {
				Schedule schedule1=selectClassPopulation(population).sortByFitness().getSchedules().get(0);
				Schedule schedule2=selectClassPopulation(population).sortByFitness().getSchedules().get(0);
				crossOverPopulation.getSchedules().set(x,crossOverSchedule(schedule1, schedule2));
			}else crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x));
		});
		return crossOverPopulation;
	}
	
	public Schedule crossOverSchedule(Schedule schedule1,Schedule schedule2) {
		Schedule crossoverSchedule= new Schedule(data).initialize();
		IntStream.range(0, crossoverSchedule.getClasses().size()).forEach(x -> {
			if(Math.random()>0.5) crossoverSchedule.getClasses().set(x,schedule1.getClasses().get(x));
			else crossoverSchedule.getClasses().set(x,schedule2.getClasses().get(x));
		});
		return crossoverSchedule;
	}
	
	
	public Population selectClassPopulation(Population population) {
		Population classPopulation= new Population(UniversityTimetableScheduling.CLASS_SELECTION_SIZE, data);
		IntStream.range(0, UniversityTimetableScheduling.CLASS_SELECTION_SIZE).forEach(x -> {
			classPopulation.getSchedules().set(x, population.getSchedules().get((int) (Math.random()*population.getSchedules().size())));
		});
		return classPopulation;
	}
	

	public Population mutatePopulation(Population population) {
		Population mutatePopulation= new Population(population.getSchedules().size(), data);
		ArrayList<Schedule> schedules=mutatePopulation.getSchedules();
		IntStream.range(0,UniversityTimetableScheduling.NUM_OF_ELITE_SCHEDULES).forEach(x -> schedules.set(x, population.getSchedules().get(x)));
		IntStream.range(UniversityTimetableScheduling.NUM_OF_ELITE_SCHEDULES,population.getSchedules().size()).forEach(x->{
			schedules.set(x, mutateSchedule(population.getSchedules().get(x)));
		});
		return mutatePopulation;
	}
	

	public Schedule mutateSchedule(Schedule mutateSchedule) {
		Schedule schedule=new  Schedule(data).initialize();
		IntStream.range(0,mutateSchedule.getClasses().size()).forEach(x-> {
			if(Driver.MUTATION_RATE>Math.random()) {mutateSchedule.getClasses().set(x, schedule.getClasses().get(x));}
		});
		return mutateSchedule;
	}
	
}
