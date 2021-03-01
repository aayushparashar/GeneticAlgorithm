package geneticAlgorithm;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneticAlgorithm gg = new GeneticAlgorithm();
		Population pp = new Population(100);
		pp.initialize();
		int currGeneration = 0;
		while (pp.getFittestIndividual().getFitness() < Constants.maxFitness) {
			currGeneration++;
			System.out.println(
					"Current Generation: " + currGeneration + " with max fitness: " + pp.getFittestIndividual().getFitness()+" with individual: "+pp.getFittestIndividual());
			pp = gg.evolvePopulation(pp);
		}
		System.out.println(
				"Acheived most fit population at " + currGeneration + " with fitness " + pp.getFittestIndividual().getFitness()+" and individual: "+pp.getFittestIndividual());
	}

}
