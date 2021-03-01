package geneticAlgorithm;

public class Population {
	private Individual[] individuals;

	Population(int size) {
		individuals = new Individual[size];
	}

	public void initialize() {
		for (int i = 0; i < individuals.length; i++) {
			Individual newIndividual = new Individual();
			newIndividual.generateIndividual();
			this.individuals[i] = newIndividual;
		}
	}

	public Individual getFittestIndividual() {
		Individual bestIndividual = this.individuals[0];
		for (int i = 1; i < individuals.length; i++) {
			if (individuals[i].getFitness() > bestIndividual.getFitness())
				bestIndividual = individuals[i];
		}
		return bestIndividual;
	}

	public Individual getIndividual(int index) {
		return this.individuals[index];
	}

	public void setIndividual(int index, Individual newIndividual) {
		this.individuals[index] = newIndividual;
	}

	public int size() {
		return this.individuals.length;
	}

}
