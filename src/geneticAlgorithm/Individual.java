package geneticAlgorithm;

import java.util.Random;

public class Individual {
	private int[] genes;
	private Random rand;
	private int fitness;

	public Individual() {
		// TODO Auto-generated constructor stub
		rand = new Random();
		genes = new int[Constants.chromosomeLength];
	}

	public void setGene(int index, int val) {
		this.genes[index] = val;
	}

	public int getGene(int index) {
		return this.genes[index];
	}

	public void generateIndividual() {
		int[] newGenes = new int[Constants.chromosomeLength];
		for (int i = 0; i < newGenes.length; i++)
			newGenes[i] = rand.nextInt(10);
		this.genes = newGenes;

	}

	public int getFitness() {
		if (fitness == 0) {
			int val = 0;
			for (int i = 0; i < Constants.chromosomeLength; i++) {
				if (genes[i] == Constants.solutionSequence[i])
					val++;
			}
			this.fitness = val;
		}
		return fitness;
	}

	@Override
	public String toString() {
		String str = "";
		for (int gene : this.genes)
			str += gene;
		return str;
	}

}
