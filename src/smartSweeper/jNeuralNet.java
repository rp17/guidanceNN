package smartSweeper;

import java.util.Iterator;
import java.util.Vector;
import java.math.*;

import smartSweeper.utils;
import smartSweeper.jParams;

public class jNeuralNet {
//	//-------------------------------------------------------------------
////	define neuron struct
////-------------------------------------------------------------------
//struct SNeuron
//{
	private class SNeuron{
//	//the number of inputs into the neuron
//	int				      m_NumInputs;
		public int m_NumInputs;
//
//	//the weights for each input
//	vector<double>	m_vecWeight;
		Vector<Double> m_vecWeight;
//
//
//	//ctor
//	SNeuron(int NumInputs);
		public SNeuron(int NumInputs){
//			//we need an additional weight for the bias hence the +1
//			for (int i=0; i<NumInputs+1; ++i)
//			{
//				//set up the weights with an initial random value
//				m_vecWeight.push_back(RandomClamped());
//			}
			m_NumInputs = NumInputs;
			m_vecWeight = new Vector<Double>(NumInputs);
			System.out.print("Building neuron. NumInputs = ");
			System.out.println(m_NumInputs);
			for (int i = 0; i<NumInputs; ++i){
				m_vecWeight.add(new Double(utils.RandomClamped()));
			}
		}
//};
	}
//
//
////---------------------------------------------------------------------
////	struct to hold a layer of neurons.
////---------------------------------------------------------------------
//
//struct SNeuronLayer
	private class SNeuronLayer{
//{
//	//the number of neurons in this layer
//	int					      m_NumNeurons;
		public int m_NumNeurons;
//
//	//the layer of neurons
//	vector<SNeuron>		m_vecNeurons;
		public Vector<SNeuron> m_vecNeurons;
//
//	SNeuronLayer(int NumNeurons, 
//				       int NumInputsPerNeuron);
		public SNeuronLayer(int NumNeurons, int NumInputsPerNeuron){
			m_NumNeurons = NumNeurons;
			m_vecNeurons = new Vector<SNeuron>(m_NumNeurons);
//			for (int i=0; i<NumNeurons; ++i)
//
//				m_vecNeurons.push_back(SNeuron(NumInputsPerNeuron));
			for (int i = 0; i<NumNeurons; ++i){
				m_vecNeurons.add(new SNeuron(NumInputsPerNeuron));
			}
		}
//};
	}
//
//
////----------------------------------------------------------------------
////	neural net class
////----------------------------------------------------------------------
//
//class CNeuralNet
//{
		
//	
//private:
//	
//	int					m_NumInputs;
		private int m_NumInputs;
//
//	int					m_NumOutputs;
		private int m_NumOutputs;
//
//	int					m_NumHiddenLayers;
		private int m_NumHiddenLayers;
//
//	int					m_NeuronsPerHiddenLyr;
		private int m_NeuronsPerHiddenLyr;
//
//	//storage for each layer of neurons including the output layer
//	vector<SNeuronLayer>	m_vecLayers;
		private Vector<SNeuronLayer> m_vecLayers;
//
//public:
//
//	CNeuralNet();
		public jNeuralNet(){
//				          =	CParams::iNumInputs;
			m_NumInputs = jParams.iNumInputs;
//			m_NumOutputs		      =	CParams::iNumOutputs;
			System.out.print("Neural Net constructed. Number of inputs: ");
			System.out.println(m_NumInputs);
			System.out.print("Input number parameter from file: ");
			System.out.println(jParams.iNumInputs);
			m_NumOutputs = jParams.iNumOutputs;
//			m_NumHiddenLayers	    =	CParams::iNumHidden;
			m_NumHiddenLayers = jParams.iNumHidden;
//			m_NeuronsPerHiddenLyr =	CParams::iNeuronsPerHiddenLayer;
			m_NeuronsPerHiddenLyr = jParams.iNeuronsPerHiddenLayer;
//
//			CreateNet();
			CreateNet();
		}
//
//	void			      CreateNet();
		private void CreateNet(){
			m_vecLayers = new Vector<SNeuronLayer>(m_NumHiddenLayers + 1);
//			//create the layers of the network
//			if (m_NumHiddenLayers > 0)
//			{
			if (m_NumHiddenLayers > 0){
//				//create first hidden layer
//			  m_vecLayers.push_back(SNeuronLayer(m_NeuronsPerHiddenLyr, m_NumInputs));
				m_vecLayers.add(new SNeuronLayer(m_NeuronsPerHiddenLyr, m_NumInputs));
//		    
//		    for (int i=0; i<m_NumHiddenLayers-1; ++i)
//		    {
				for (int i = 0; i < m_NumHiddenLayers - 1; ++i){
//
//					m_vecLayers.push_back(SNeuronLayer(m_NeuronsPerHiddenLyr,
//		                                         m_NeuronsPerHiddenLyr));
					m_vecLayers.add(new SNeuronLayer(m_NeuronsPerHiddenLyr, m_NeuronsPerHiddenLyr));
//		    }
				}
//
//		    //create output layer
//			  m_vecLayers.push_back(SNeuronLayer(m_NumOutputs, m_NeuronsPerHiddenLyr));
				m_vecLayers.add(new SNeuronLayer(m_NumOutputs, m_NeuronsPerHiddenLyr));
//			}
			}
			else{
//
//		  else
//		  {
//			  //create output layer
//			  m_vecLayers.push_back(SNeuronLayer(m_NumOutputs, m_NumInputs));
				m_vecLayers.add(new SNeuronLayer(m_NumOutputs, m_NumInputs));
//		  }
			}
		}
//
//	//gets the weights from the NN
//	vector<double>	GetWeights()const;
		public Vector<Double> GetWeights(){
//			//this will hold the weights
//			vector<double> weights;
			Vector<Double> weights = new Vector<Double>();
//			
//			//for each layer
//			for (int i=0; i<m_NumHiddenLayers + 1; ++i)
//			{
			for (SNeuronLayer layer : m_vecLayers){
//
//				//for each neuron
//				for (int j=0; j<m_vecLayers[i].m_NumNeurons; ++j)
//				{
				for (SNeuron neuron : layer.m_vecNeurons){
//					//for each weight
//					for (int k=0; k<m_vecLayers[i].m_vecNeurons[j].m_NumInputs; ++k)
//					{
					for(Double weight : neuron.m_vecWeight){
//						weights.push_back(m_vecLayers[i].m_vecNeurons[j].m_vecWeight[k]);
						weights.add(weight);
//					}
					}
//				}
				}
//			}
			}
//
//			return weights;
			return weights;
		}
//
//	//returns total number of weights in net
//	int				      GetNumberOfWeights()const;
		public int GetNumberOfWeights(){
//			int weights = 0;
			int weights = 0;
//			
//			//for each layer
//			for (int i=0; i<m_NumHiddenLayers + 1; ++i)
//			{
			for (SNeuronLayer layer : m_vecLayers){
//
//				//for each neuron
//				for (int j=0; j<m_vecLayers[i].m_NumNeurons; ++j)
//				{
				for (SNeuron neuron : layer.m_vecNeurons){
//					//for each weight
//					for (int k=0; k<m_vecLayers[i].m_vecNeurons[j].m_NumInputs; ++k)
//					
//						weights++;
					weights += neuron.m_NumInputs;
//					
//				}
				}
//			}
			}
//
//			return weights;
			return weights;
		}
//
//	//replaces the weights with new ones
//	void			      PutWeights(vector<double> &weights);
		public void PutWeights(Vector<Double> weights){
//			int cWeight = 0;
			int cWeight = 0;
//			
			SNeuronLayer layer;
			SNeuron neuron;

			for (int i = 0; i < m_vecLayers.size(); i++){
				layer = m_vecLayers.get(i);
				for (int j = 0; j < layer.m_vecNeurons.size(); j+=2){
					neuron = layer.m_vecNeurons.get(j);
					for (int k = 0; k < neuron.m_vecWeight.size(); k++){
						neuron.m_vecWeight.set(k, weights.get(cWeight));
						cWeight++;
					}
				}
			}
//
//			return;
//		}			
		}
//
//	//calculates the outputs from a set of inputs
//	vector<double>	Update(vector<double> &inputs);
		public Vector<Double> Update(Vector<Double> inputs){
//			//stores the resultant outputs from each layer
//			vector<double> outputs;
			Vector<Double> outputs = new Vector<Double>(m_NumOutputs);
//
//			int cWeight = 0;
			int cWeight = 0;
//			
//			//first check that we have the correct amount of inputs
//			if (inputs.size() != m_NumInputs)
//		  {
			if (inputs.size() != m_NumInputs){
//				//just return an empty vector if incorrect.
//				return outputs;
				System.out.print("NeuralNet Update found wrong number of inputs. Expected size: ");
				System.out.println(m_NumInputs);
				return outputs;
//		  }
			}
//			
//			//For each layer....
//			for (int i=0; i<m_NumHiddenLayers + 1; ++i)
//			{
			for (int i = 0; i < m_NumHiddenLayers + 1; ++i){
				//System.out.println("NN.update has accessed a layer.");
//				if ( i > 0 )
				if (i > 0){
//		    {
//					inputs = outputs;
					inputs = outputs;
//		    }
				}
//
//				outputs.clear();
				outputs.clear();
//				
//				cWeight = 0;
				cWeight = 0;
//
//				//for each neuron sum the (inputs * corresponding weights).Throw 
//				//the total at our sigmoid function to get the output.
//				for (int j=0; j<m_vecLayers[i].m_NumNeurons; ++j)
//				{
				for (SNeuron neuron : m_vecLayers.get(i).m_vecNeurons){
					//System.out.println("NN.update is reading a neuron");
//					double netinput = 0;
					double netinput = 0;
//
//					int	NumInputs = m_vecLayers[i].m_vecNeurons[j].m_NumInputs;
					int NumInputs = neuron.m_NumInputs;
//					
//					//for each weight
//					for (int k=0; k<NumInputs - 1; ++k)
//					{
					for (Double weight : neuron.m_vecWeight){
						//System.out.println("NN.update is considering a weight.");
//						//sum the weights x inputs
//						netinput += m_vecLayers[i].m_vecNeurons[j].m_vecWeight[k] * 
//		                    inputs[cWeight++];
						if (cWeight < inputs.size())
							netinput += (weight * inputs.get(cWeight));
						cWeight++;
//					}
					}
//
//					//add in the bias
//					netinput += m_vecLayers[i].m_vecNeurons[j].m_vecWeight[NumInputs-1] * 
//		                  CParams::dBias;
					netinput += 
							(neuron.m_vecWeight.lastElement()
							* jParams.dBias);
//
//					//we can store the outputs from each layer as we generate them. 
//		      //The combined activation is first filtered through the sigmoid 
//		      //function
//					outputs.push_back(Sigmoid(netinput,
//		                                CParams::dActivationResponse));
					outputs.add(Sigmoid(netinput, 1.0));
//
//					cWeight = 0;
					cWeight = 0;
//				}
				}
//			}
			}
			if (outputs.size() != m_NumOutputs){
				System.out.print("NeuralNet.update made a boo boo. Number of outputs: ");
				System.out.println(outputs.size());
				System.out.print("Should have been: ");
				System.out.println(m_NumOutputs);
			}
//
//			return outputs;
			return outputs;
		}
//
//	//sigmoid response curve
//	inline double	  Sigmoid(double activation, double response);
		private static Double Sigmoid(double netinput, double response){
//			return ( 1 / ( 1 + exp(-netinput / response)));
			return (1 / (1 + Math.pow(2.71828, (-netinput/response))) - 0.5);
		}
		
		public void updateWeights(){
			SNeuronLayer layer;
			SNeuron neuron;
			
//			for (SNeuronLayer layer : m_vecLayers){
//				for(SNeuron neuron: layer.m_vecNeurons){
//					for(Double weight : neuron.m_vecWeight){
//						newWeights.add(weight + 0.1);
//					}
//				}
//			}
			
			for (int i = 0; i < m_vecLayers.size(); i++){
				layer = m_vecLayers.get(i);
				for (int j = 0; j < layer.m_vecNeurons.size(); j+=2){
					neuron = layer.m_vecNeurons.get(j);
					for (int k = 0; k < neuron.m_vecWeight.size(); k++){
						Double oldWeight = neuron.m_vecWeight.get(k);
						neuron.m_vecWeight.set(k, (oldWeight + 0.1));
						System.out.print(neuron.m_vecWeight.get(k) + "...");
					}
					System.out.println();
				}
			}
		}
//
//};

}
