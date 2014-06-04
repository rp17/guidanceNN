package smartSweeper;

//------------------------------------------------------------------------
//
//	Name: CMineSweeper.h
//
//Author: Mat Buckland 2002
//
//Desc: Class to create a minesweeper object 
//
//------------------------------------------------------------------------
//#include <vector>
import java.util.Vector;
//#include <math.h>
//
//#include "CNeuralNet.h"
//#include "utils.h"
//#include "C2DMatrix.h"
//#include "SVector2D.h"
//#include "CParams.h"
import smartSweeper.*;

public class jMineSweeper {
//	private:
//
//		  //the minesweeper's neural net
//		  CNeuralNet		m_ItsBrain;
	private jNeuralNet m_ItsBrain = new jNeuralNet();
//
//			//its position in the world
//			SVector2D		m_vPosition;
	private sVector2D m_vPosition;
//
//			//direction sweeper is facing
//			SVector2D		m_vLookAt;
	private sVector2D m_vLookAt = new sVector2D();
//
//			//its rotation (surprise surprise)
//			double			m_dRotation;
	private double m_dRotation;
//
//			double			m_dSpeed;
	private double m_dSpeed;
//
//			//to store output from the ANN
//			double			m_lTrack, m_rTrack;
	private double m_lTrack, m_rTrack;
//
//			//the sweeper's fitness score 
//			double			m_dFitness;
	private double m_dFitness;
//
//			//the scale of the sweeper when drawn
//			double			m_dScale;
	private double m_dScale;
//
//		  //index position of closest mine
//		  int         m_iClosestMine;
	private sVector2D m_iClosestMine;
//		  
//
//		public:
//
//
//			CMinesweeper();
	public jMineSweeper(){
		//		CMinesweeper::CMinesweeper():
		//            m_dRotation(RandFloat()*CParams::dTwoPi),
		//            m_lTrack(0.16),
		//            m_rTrack(0.16),
		//            m_dFitness(0),
		//			               m_dScale(CParams::iSweeperScale),
		//            m_iClosestMine(0)
		//
		//{
		////create a random start position
		//m_vPosition = SVector2D((RandFloat() * CParams::WindowWidth), 
		//	                (RandFloat() * CParams::WindowHeight));
		//
		//}
		m_dRotation = utils.RandFloat()*jParams.dTwoPi;
		m_lTrack = 0.16;
		m_rTrack = 0.16;
		m_dFitness = 0;
		m_dScale = jParams.iSweeperScale;
		m_iClosestMine = new sVector2D(0,0);
		
		m_vPosition = new sVector2D(utils.RandFloat(), utils.RandFloat());
		
	}
//			
//			//updates the ANN with information from the sweepers enviroment
//			bool			Update(vector<SVector2D> &mines);
	public boolean Update (Vector<sVector2D> mines){
//		//this will store all the inputs for the NN
//		vector<double> inputs;
		Vector<Double> inputs = new Vector<Double>();
//
//		//get vector to closest mine
//		SVector2D vClosestMine = GetClosestMine(mines);
		sVector2D vClosestMine = GetClosestMine(mines);
//	  
//		//normalise it
//	  Vec2DNormalize(vClosestMine);
		sVector2D.Vec2DNormalize(vClosestMine);
//	  
//	  //add in vector to closest mine
//		inputs.push_back(vClosestMine.x);
		inputs.add(vClosestMine.x);
//		inputs.push_back(vClosestMine.y);
		inputs.add(vClosestMine.y);
//
//		//add in sweepers look at vector
//		inputs.push_back(m_vLookAt.x);
		inputs.add(m_vLookAt.x);
//		inputs.push_back(m_vLookAt.y);
		inputs.add(m_vLookAt.y);
//
//	  
//		//update the brain and get feedback
//		vector<double> output = m_ItsBrain.Update(inputs);
		Vector<Double> output = m_ItsBrain.Update(inputs);
//
//		//make sure there were no errors in calculating the 
//		//output
//		if (output.size() < CParams::iNumOutputs) 
		if (output.size() < jParams.iNumOutputs){
//	  {
//	    return false;
			return false;
//	  }
		}
//
//		//assign the outputs to the sweepers left & right tracks
//		m_lTrack = output[0];
		m_lTrack = output.get(0);
//		m_rTrack = output[1];
		m_rTrack = output.get(1);
//
//		//calculate steering forces
//		double RotForce = m_lTrack - m_rTrack;
		double RotForce = m_lTrack - m_rTrack;
//
//		//clamp rotation
//		Clamp(RotForce, -CParams::dMaxTurnRate, CParams::dMaxTurnRate);
		utils.Clamp(RotForce, jParams.dMaxTurnRate, jParams.dMaxTurnRate);
//
//	  m_dRotation += RotForce;
		m_dRotation += RotForce;
//		
//		m_dSpeed = (m_lTrack + m_rTrack);
		m_dSpeed = (m_lTrack + m_lTrack);
//
//		//update Look At 
//		m_vLookAt.x = -sin(m_dRotation);
		m_vLookAt.x = -Math.sin(m_dRotation);
//		m_vLookAt.y = cos(m_dRotation);
		m_vLookAt.y = Math.cos(m_dRotation);
//
//		//update position
//	  m_vPosition += (m_vLookAt * m_dSpeed);
		m_vPosition.plusEquals(sVector2D.times(m_vLookAt,m_dSpeed));
//
//		//wrap around window limits
//		if (m_vPosition.x > CParams::WindowWidth) m_vPosition.x = 0;
//		if (m_vPosition.x < 0) m_vPosition.x = CParams::WindowWidth;
//		if (m_vPosition.y > CParams::WindowHeight) m_vPosition.y = 0;
//		if (m_vPosition.y < 0) m_vPosition.y = CParams::WindowHeight;
//
//		return true;
		return true;
	}
//
//			//used to transform the sweepers vertices prior to rendering
//		  void			WorldTransform(vector<SPoint> &sweeper);
	public void WorldTransform(Vector<SPoint> sweeper){
//		//create the world transformation matrix
//		C2DMatrix matTransform;
		j2DMatrix matTransform = new j2DMatrix();
//		
//		//scale
//		matTransform.Scale(m_dScale, m_dScale);
		matTransform.Scale(m_dScale, m_dScale);
//		
//		//rotate
//		matTransform.Rotate(m_dRotation);
		matTransform.Rotate(m_dRotation);
//		
//		//and translate
//		matTransform.Translate(m_vPosition.x, m_vPosition.y);
		matTransform.Translate(m_vPosition.x, m_vPosition.y);
//		
//		//now transform the ships vertices
//		matTransform.TransformSPoints(sweeper);
		matTransform.TransformSPoints(sweeper);
	}
//
//			//returns a vector to the closest mine
//		  SVector2D	GetClosestMine(vector<SVector2D> &objects);
	public sVector2D GetClosestMine(Vector<sVector2D> mines){
//		double			closest_so_far = 99999;
		double closest_so_far = 99999;
//
//		SVector2D		vClosestObject(0, 0);
		sVector2D vClosestObject = new sVector2D(0,0);
//
//		//cycle through mines to find closest
//		for (int i=0; i<mines.size(); i++)
//		{
		for (sVector2D mine : mines){
//			double len_to_object = Vec2DLength(mines[i] - m_vPosition);
			double len_to_object = 
					sVector2D.Vec2DLength(sVector2D.minus(mine, m_vPosition));
//
//			if (len_to_object < closest_so_far)
//			{
			if (len_to_object < closest_so_far){
//				closest_so_far	= len_to_object;
//				
				closest_so_far = len_to_object;
//				vClosestObject	= m_vPosition - mines[i];
				vClosestObject = sVector2D.minus(m_vPosition, mine);
//
//	      m_iClosestMine = i;
				m_iClosestMine = mine;
//			}
			}
//		}
		}
//
//		return vClosestObject;
		return vClosestObject;
	}
//
//		  //checks to see if the minesweeper has 'collected' a mine
//		  int       CheckForMine(vector<SVector2D> &mines, double size);
	public sVector2D CheckForMine(Vector<sVector2D> mines, double size){
//		SVector2D DistToObject = m_vPosition - mines[m_iClosestMine];
		sVector2D DistToObject = sVector2D.minus(m_vPosition, m_iClosestMine);
//		
//		if (Vec2DLength(DistToObject) < (size + 5))
//		{
		if (sVector2D.Vec2DLength(DistToObject) < (size + 5)){
//				return m_iClosestMine;
			return m_iClosestMine;
//	  }
		}
//
//	  return -1;
		return new sVector2D(-1, -1);
	}
//
//			void			Reset();
	public void Reset(){
//		//reset the sweepers positions
//		m_vPosition = SVector2D((RandFloat() * CParams::WindowWidth), 
//						                (RandFloat() * CParams::WindowHeight));
		m_vPosition = new sVector2D (utils.RandFloat(), utils.RandFloat());
//		
//		//and the fitness
//		m_dFitness = 0;
		m_dFitness = 0;
//
//	  //and the rotation
//	  m_dRotation = RandFloat()*CParams::dTwoPi;
		m_dRotation = utils.RandFloat() * jParams.dTwoPi;
//
//		return;
		return;
	}
//		  
//
//			//-------------------accessor functions
//			SVector2D	Position()const{return m_vPosition;}
	public sVector2D Position(){return m_vPosition;}
//
//			void			IncrementFitness(){++m_dFitness;}
	public void IncrementFitness(){++m_dFitness;};
//
//			double		Fitness()const{return m_dFitness;}
	public double Fitness(){return m_dFitness;}
//		  
//		  void      PutWeights(vector<double> &w){m_ItsBrain.PutWeights(w);}
	public void PutWeights(Vector<Double> w){m_ItsBrain.PutWeights(w);}
//
//		  int       GetNumberOfWeights()const{return m_ItsBrain.GetNumberOfWeights();}
	public int GetNumberOfWeights(){return m_ItsBrain.GetNumberOfWeights();}
}
