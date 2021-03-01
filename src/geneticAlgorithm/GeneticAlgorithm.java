package geneticAlgorithm;

import java.util.Random;

public class GeneticAlgorithm {
	Random rand;

	public GeneticAlgorithm() {
		// TODO Auto-generated constructor stub
		this.rand = new Random();
	}

	public Population evolvePopulation(Population population) {
		Population newPopulation = new Population(population.size());
		for (int i = 0; i < population.size(); i++) {
			Individual firstIndividual = randomSelection(population);
			Individual secondIndividual = randomSelection(population);
			Individual crossoverIndividual = crossover(firstIndividual, secondIndividual);
			newPopulation.setIndividual(i, crossoverIndividual);

		}
		for (int i = 0; i < population.size(); i++) {
			mutation(population.getIndividual(i));
		}
		return newPopulation;
	}

	private void mutation(Individual individual) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Constants.chromosomeLength; i++) {
			if (Math.random() <= Constants.mutationRate)
				individual.setGene(i, (int)(Math.random()*10));
		}

	}

	private Individual crossover(Individual firstIndividual, Individual secondIndividual) {
		// TODO Auto-generated method stub
		Individual newIndividual = new Individual();
		for (int i = 0; i < Constants.chromosomeLength; i++) {
			if (Math.random() <= Constants.crossoverRate)
				newIndividual.setGene(i, firstIndividual.getGene(i));
			else
				newIndividual.setGene(i, secondIndividual.getGene(i));
		}
		return newIndividual;
	}

	private Individual randomSelection(Population population) {
		// TODO Auto-generated method stub
		Population temp = new Population(Constants.tournamentSize);
		for (int i = 0; i < temp.size(); i++) {
			int randomIndex = (int)(Math.random()*population.size());
			temp.setIndividual(i, population.getIndividual(randomIndex));
		}

		return temp.getFittestIndividual();
	}

}
