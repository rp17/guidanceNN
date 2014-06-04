package smartSweeper;

import java.util.Collections;
import java.util.Vector;

//import raven.game.outputs;
import smartSweeper.utils;
import smartSweeper.jParams;

public class jGenAlg {
//	struct SGenome
//	{
	public class SGenome implements Comparable<SGenome>{
//		vector <double>	vecWeights;
		public Vector<Double> vecWeights;
//
//		double          dFitness;
		public double dFitness;
//
//		SGenome():dFitness(0){}
		public SGenome(){
			dFitness = 0;
		}
//
//		SGenome( vector <double> w, double f): vecWeights(w), dFitness(f){}
		public SGenome(Vector<Double> w, double f){
			vecWeights = w;
			dFitness = f;
		}
//
//		//overload '<' used for sorting
//		friend bool operator<(const SGenome& lhs, const SGenome& rhs)
//		{
		public boolean lessThan(SGenome rhs){
//			return (lhs.dFitness < rhs.dFitness);
			return dFitness < rhs.dFitness;
//		}
		}
//	};
		@Override
		public int compareTo(SGenome arg0) {
			return (int) (dFitness - arg0.dFitness);
		}
	}
	
	public SGenome createGenome(Vector<Double> w, double f){
		return this.new SGenome(w, f);
	}
//
//	//-----------------------------------------------------------------------
//	//
////		the genetic algorithm class
//	//-----------------------------------------------------------------------
//	class CGenAlg
//	{
//	private:
//		
//		//this holds the entire population of chromosomes
//		vector <SGenome>	 m_vecPop;
	Vector<SGenome> m_vecPop;
//
//		//size of population
//		int m_iPopSize;
	private int m_iPopSize;
//		
//		//amount of weights per chromo
//		int m_iChromoLength;
	private int m_iChromoLength;
//
//		//total fitness of population
//		double m_dTotalFitness;
	private double m_dTotalFitness;
//
//		//best fitness this population
//		double m_dBestFitness;
	private double m_dBestFitness;
//
//		//average fitness
//		double m_dAverageFitness;
	private double m_dAverageFitness;
//
//		//worst
//		double m_dWorstFitness;
	private double m_dWorstFitness;
//
//		//keeps track of the best genome
//		int		m_iFittestGenome;
	private SGenome m_iFittestGenome;
//
//		//probability that a chromosones bits will mutate.
//		//Try figures around 0.05 to 0.3 ish
//		double m_dMutationRate;
	private double m_dMutationRate;
//
//		//probability of chromosones crossing over bits
//		//0.7 is pretty good
//		double m_dCrossoverRate;
	private double m_dCrossoverRate;
//
//		//generation counter
//		int	  m_cGeneration;
	private int m_cGeneration;
	
	private Vector<Double> baby1, baby2;
	
//
//
//		void    Crossover(const vector<double> &mum,
//	                    const vector<double> &dad,
//	                    vector<double>       &baby1,
//	                    vector<double>       &baby2);
	private void Crossover (Vector<Double> mum, Vector<Double> dad){
//		//just return parents as offspring dependent on the rate
//		//or if parents are the same
//		if ( (RandFloat() > m_dCrossoverRate) || (mum == dad)) 
//		{
		if ((utils.RandFloat() > m_dCrossoverRate) || (mum == dad)){
//			baby1 = mum;
			baby1 = mum;
//			baby2 = dad;
			baby2 = dad;
//
//			return;
			//System.out.println("Size of baby leaving Crossover: " + baby1.size());
			return;
//		}
		}
//
//		//determine a crossover point
//		int cp = RandInt(0, m_iChromoLength - 1);
		int cp = utils.RandInt(0,m_iChromoLength - 1);
//
//		//create the offspring
//		for (int i=0; i<cp; ++i)
//		{
		for (int i = 0; i<cp; ++i){
//			baby1.push_back(mum[i]);
			baby1.add(mum.get(i));
//			baby2.push_back(dad[i]);
			baby2.add(dad.get(i));
//		}
		}
//
//		for (i=cp; i<mum.size(); ++i)
//		{
		for (int i = cp; i < mum.size(); ++i){
//			baby1.push_back(dad[i]);
			baby1.add(dad.get(i));
//			baby2.push_back(mum[i]);
			baby2.add(mum.get(i));
//		}
		}
//		
//		
//		return;
		//System.out.println("Size of baby leaving Crossover: " + baby1.size());
		return;
	}
//		
//
//		void    Mutate(vector<double> &chromo);
	public void Mutate(Vector<Double> chromo){
//		//traverse the chromosome and mutate each weight dependent
//		//on the mutation rate
//		for (int i=0; i<chromo.size(); ++i)
//		{
		//System.out.print("Number of weights sent to Mutate: ");
		//System.out.println(chromo.size());
		for (int i = 0; i < chromo.size(); i++){
//			//do we perturb this weight?
//			if (RandFloat() < m_dMutationRate)
//			{
			if (utils.RandFloat() < m_dMutationRate){
//				//add or subtract a small value to the weight
//				chromo[i] += (RandomClamped() * CParams::dMaxPerturbation);
				double oldWeight = chromo.get(i);
				chromo.set(i, oldWeight + (utils.RandomClamped() * 0.1));
//				System.out.print("Weight is now: ");
//				System.out.println(weight);
//			}
			}
//		}
		}
	}
//		
//		SGenome	GetChromoRoulette();
	public SGenome GetChromoRoulette(){
//		//generate a random number between 0 & total fitness count
//		double Slice = (double)(RandFloat() * m_dTotalFitness);
		double Slice = utils.RandFloat() * m_dTotalFitness;
//
//		//this will be set to the chosen chromosome
//		SGenome TheChosenOne;
		SGenome TheChosenOne = new SGenome();
//		
//		//go through the chromosones adding up the fitness so far
//		double FitnessSoFar = 0;
		double FitnessSoFar = 0;
//		
//		for (int i=0; i<m_iPopSize; ++i)
//		{
		for (int i = 0; i < m_vecPop.size(); i++){
//			FitnessSoFar += m_vecPop[i].dFitness;
			FitnessSoFar += m_vecPop.get(i).dFitness;
//			
//			//if the fitness so far > random number return the chromo at 
//			//this point
//			if (FitnessSoFar >= Slice)
//			{
			if (FitnessSoFar >= Slice){
//				TheChosenOne = m_vecPop[i];
				TheChosenOne = m_vecPop.get(i);
//
//	      break;
				return TheChosenOne;
//			}
			}
//			
//		}
		}
//
//		return TheChosenOne;
		return TheChosenOne;
	}
//
//		//use to introduce elitism
//	  void CGenAlg::GrabNBest(int	            NBest,
//    	const int	      NumCopies,
//    	vector<SGenome>	&Pop)
	private void GrabNBest(int NBest, int NumCopies, Vector<SGenome> Pop){
//		//add the required amount of copies of the n most fittest 
//		//to the supplied vector
//		while(NBest--)
//		{
		while(NBest > 0){
			NBest--;
//			for (int i=0; i<NumCopies; ++i)
//			{
			for (int i = 0; i < NumCopies; ++i){
			//for (SGenome )
//				Pop.push_back(m_vecPop[(m_iPopSize - 1) - NBest]);
				Pop.add(m_vecPop.get((m_iPopSize - 1) - NBest));
//		  }
			}
//		}
		}
	}
//
//
//		void	  CalculateBestWorstAvTot();
	private void CalculateBestWorstAvTot(){
//		m_dTotalFitness = 0;
		m_dTotalFitness = 0;
//		
//		double HighestSoFar = 0;
		double HighestSoFar = 0;
//		double LowestSoFar  = 9999999;
		double LowestSoFar = 9999999;
//		
//		for (int i=0; i<m_iPopSize; ++i)
//		{
		for (SGenome pop : m_vecPop){
//			//update fittest if necessary
//			if (m_vecPop[i].dFitness > HighestSoFar)
//			{
			if (pop.dFitness > HighestSoFar){
//				HighestSoFar	 = m_vecPop[i].dFitness;
				HighestSoFar = pop.dFitness;
//				
//				m_iFittestGenome = i;
				m_iFittestGenome = pop;
//
//				m_dBestFitness	 = HighestSoFar;
//			}
			}
//			
//			//update worst if necessary
//			if (m_vecPop[i].dFitness < LowestSoFar)
//			{
			if (pop.dFitness < LowestSoFar){
//				LowestSoFar = m_vecPop[i].dFitness;
				LowestSoFar = pop.dFitness;
//				m_dWorstFitness = LowestSoFar;
				m_dWorstFitness = LowestSoFar;
//			}
			}
//			
//			m_dTotalFitness	+= m_vecPop[i].dFitness;
			m_dTotalFitness += pop.dFitness;
//			
//			
//		}//next chromo
		}
//		
//		m_dAverageFitness = m_dTotalFitness / m_iPopSize;
		m_dAverageFitness = m_dTotalFitness / m_iPopSize;
	}
//
//		void	  Reset();
	private void Reset(){
		m_dTotalFitness		= 0;
		m_dBestFitness		= 0;
		m_dWorstFitness		= 9999999;
		m_dAverageFitness	= 0;
	}
//
//
//
//	public:
//			
//		CGenAlg(int 		popsize,
//				    double	MutRat,
//				    double	CrossRat,
//				    int	  	numweights);
	public jGenAlg(int popsize, double MutRat, double CrossRat, int numweights){
		m_dCrossoverRate = CrossRat;
		m_dMutationRate = MutRat;
		m_iChromoLength = numweights;
		m_dTotalFitness = 0;
		m_cGeneration = 0;
		m_iFittestGenome = new SGenome();
		m_dBestFitness = 0;
		m_dWorstFitness = 9999999;
		m_dAverageFitness = 0;
		
		m_vecPop = new Vector<SGenome>(m_iPopSize);
		
//		for (int i=0; i<m_iPopSize; ++i)
//		{
		for (int i = 0; i < m_iPopSize; i++){
//			m_vecPop.push_back(SGenome());
//
			m_vecPop.add(new SGenome());
//			for (int j=0; j<m_iChromoLength; ++j)
//			{
			for (int j = 0; j<m_iChromoLength; ++i){
//				m_vecPop[i].vecWeights.push_back(RandomClamped());
				m_vecPop.get(i).vecWeights.add(utils.RandomClamped());
//			}
			}
//		}
		}
	}
//
//		//this runs the GA for one generation.
//		vector<SGenome>	Epoch(vector<SGenome> &old_pop);
	public Vector<SGenome> Epoch(Vector<SGenome> old_pop){
//		//assign the given population to the classes population
//		  m_vecPop = old_pop;
		m_vecPop = old_pop;
		//System.out.println("Old population size sent to Epoch: " + m_vecPop.size());
//
//		  //reset the appropriate variables
//		  Reset();
		Reset();
//
//		  //sort the population (for scaling and elitism)
//		  sort(m_vecPop.begin(), m_vecPop.end());
		Collections.sort(m_vecPop);
//
//		  //calculate best, worst, average and total fitness
//			CalculateBestWorstAvTot();
		CalculateBestWorstAvTot();
//		  
//		  //create a temporary vector to store new chromosones
//			vector <SGenome> vecNewPop;
		Vector<SGenome> vecNewPop = new Vector<SGenome>();
//
//			//Now to add a little elitism we shall add in some copies of the
//			//fittest genomes. Make sure we add an EVEN number or the roulette
//		  //wheel sampling will crash
//			if (!(CParams::iNumCopiesElite * CParams::iNumElite % 2))
//			{
			if ((jParams.iNumElite * jParams.iNumElite % 2) != 0){
//				GrabNBest(CParams::iNumElite, CParams::iNumCopiesElite, vecNewPop);
				GrabNBest(jParams.iNumElite, jParams.iNumCopiesElite, vecNewPop);
//			}
			}
//			
//
//			//now we enter the GA loop
//			
//			//repeat until a new population is generated
//			while (vecNewPop.size() < m_iPopSize)
//			{
			while (vecNewPop.size() < m_vecPop.size()){
//				//grab two chromosones
//				SGenome mum = GetChromoRoulette();
				SGenome mum = GetChromoRoulette();
//				SGenome dad = GetChromoRoulette();
				SGenome dad = GetChromoRoulette();
//
//				//create some offspring via crossover
//				vector<double>		baby1, baby2;
				baby1 = new Vector<Double>(); baby2 = new Vector<Double>();
//
//				Crossover(mum.vecWeights, dad.vecWeights, baby1, baby2);
				Crossover(mum.vecWeights, dad.vecWeights);
				//System.out.println("Size of baby returned by crossover: " + baby1.size());
//
//				//now we mutate
//				Mutate(baby1);
				Mutate(baby1);
//				Mutate(baby2);
				Mutate(baby2);
//
//				//now copy into vecNewPop population
//				vecNewPop.push_back(SGenome(baby1, 0));
				//System.out.println("Adding babies to newPop in Epoch");
				vecNewPop.add(new SGenome(baby1, 0));
//				vecNewPop.push_back(SGenome(baby2, 0));
				vecNewPop.add(new SGenome(baby2, 0));
//			}
			}
//
//			//finished so assign new pop back into m_vecPop
			if (vecNewPop.size() == 0){
				System.out.println("Trouble in epoch. new pop is 0.");
				Mutate(old_pop.firstElement().vecWeights);
				vecNewPop.add(old_pop.firstElement());
			}
//			m_vecPop = vecNewPop;
			m_vecPop = vecNewPop;
			
			//System.out.println("New population size leaving Epoch: " + m_vecPop.size());
			//System.out.println("Number of weights in genome leaving epoch: " + m_vecPop.firstElement().vecWeights.size());
//
//			return m_vecPop;
			return m_vecPop;
	}
//
//
//		//-------------------accessor methods
//		vector<SGenome>	GetChromos()const{return m_vecPop;}
		Vector<SGenome> GetChromos(){return m_vecPop;}
//		double			    AverageFitness()const{return m_dTotalFitness / m_iPopSize;}
		double AverageFitness(){return m_dTotalFitness / m_iPopSize;}
//		double		    	BestFitness()const{return m_dBestFitness;}
		double BestFitness(){return m_dBestFitness;}
//
//		
//	};
}
