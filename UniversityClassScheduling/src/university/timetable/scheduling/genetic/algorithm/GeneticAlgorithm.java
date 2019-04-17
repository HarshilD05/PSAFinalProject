package university.timetable.scheduling.genetic.algorithm;
import java.util.stream.IntStream;


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
		IntStream.range(0,Driver.NUM_OF_ELITE_SCHEDULES).forEach(x -> crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
		
		IntStream.range(Driver.NUM_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x -> {
			if(Driver.CROSSOVER_RATE > Math.random()) {
				Schedule schedule1=selectClassPopulation(population).sortByFitness().getSchedules().get(0);
				Schedule schedule2=selectClassPopulation(population).sortByFitness().getSchedules().get(0);
				crossOverPopulation.getSchedules().set(x,crossOverSchedule(schedule1, schedule2));
			}else crossOverPopulation.getSchedules().set(x,population.getSchedules().get(x));
		});
		return crossOverPopulation;
	}

}
