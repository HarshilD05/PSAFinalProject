package university.timetable.scheduling.test;

import static org.junit.Assert.*;
import university.timetable.scheduling.data.initialization.Data;
import university.timetable.scheduling.genetic.algorithm.GeneticAlgorithm;
import university.timetable.scheduling.components.Population;

import org.junit.Test;

public class GeneticAlgorithmTest {

	@Test
	public void testMutate() throws Exception {
		
		Data data = new Data();
		data.addRoom("A1", 15);
		data.addRoom("B1", 20);
		data.addMeetingTime("MT1","Tue 9:00 - 11:00");
		data.addMeetingTime("MT2","Tue 13:00 - 15:00");
		data.addInstructor("I1","proftest1" );
		data.addInstructor("I2","proftest2" );		
		data.addCourse("c1", "325K", 25, data.getInstructors());		
		data.addCourse("c2", "319K", 35, data.getInstructors());
		data.addDepartment("Maths", data.getCourses());
		data.addDepartment("EE", data.getCourses());
		
		GeneticAlgorithm ga = new GeneticAlgorithm(data,2,5,0,2,0);
		Population population = new Population(2,data);
		population.sortByFitness();
		int generation=1;
		String s1, s2, s1m, s2m;
		System.out.println("======Before Mutation=========");
		s1=population.getSchedules().get(0).toString();
		s2=population.getSchedules().get(1).toString();
	    System.out.println(s1);
        System.out.println(s2);
        Population p =ga.crossOverPopulation(population);
        Population p1 = ga.mutatePopulation(p);
        System.out.println("======After Mutation=========");
        s1m=p1.getSchedules().get(0).toString();
        s2m=p1.getSchedules().get(1).toString();
        System.out.println(s1m);
        System.out.println(s2m);
        population.sortByFitness();
        generation++;
        p1.getSchedules().get(0).getFitness();
        System.out.println(s1.compareTo(s1m));
        System.out.println(s2.compareTo(s2m));
        assert !s2.equals(s2m) : "mute failed";   

	}

}
