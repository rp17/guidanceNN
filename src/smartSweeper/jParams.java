package smartSweeper;

import java.io.FileReader;
import java.io.*;

//#ifndef CPARAMS_H
//#define CPARAMS_H
////------------------------------------------------------------------------
////
////	Name: CParams.h
////
////  Author: Mat Buckland 2002
////
////  Desc: Class to hold all the parameters used in this project. The values
////        are loaded in from an ini file when an instance of the class is
////        created.
////       
////
////------------------------------------------------------------------------
//#include <fstream>
//#include <windows.h>
//
//using namespace std;	
//
//
//
//class CParam
//{

public class jParams {

//
//public:
//
//  //------------------------------------general parameters
//  static double dPi;
	public static double dPi  = 3.14159265358979;
//  static double dHalfPi;
	public static double dHalfPi = dPi/2;
//  static double dTwoPi;
	public static double dTwoPi = dPi*2;
	
	public static boolean loaded = false;
//
//  static int    WindowWidth;
//  static int    WindowHeight;
//
//  static int    iFramesPerSecond;
//
//  
//  //-------------------------------------used for the neural network
//  static int    iNumInputs;
	public static int iNumInputs;
//  static int    iNumHidden;
	public static int iNumHidden;
//  static int    iNeuronsPerHiddenLayer;
	public static int iNeuronsPerHiddenLayer;
//  static int    iNumOutputs;
	public static int iNumOutputs;
//
//  //for tweeking the sigmoid function
//  static double dActivationResponse;
	public static double dActivationResponse;
//  //bias value
//  static double dBias;
	public static double dBias;
//
//  //--------------------------------------used to define the sweepers
//
//  //limits how fast the sweepers can turn
//  static double dMaxTurnRate;
	public static double dMaxTurnRate;
//
//  static double dMaxSpeed;
	public static double dMaxSpeed;
//
//  //for controlling the size
//  static int   iSweeperScale;
	public static int iSweeperScale;
//
//
//  //--------------------------------------controller parameters
//  static int    iNumSweepers;
	public static int iNumSweepers;
//
//  static int    iNumMines;
	public static int iNumMines;
//
//  //number of time steps we allow for each generation to live
//  static int    iNumTicks;
	public static int iNumTicks;
//
//  //scaling factor for mines
//  static double dMineScale;
	public static double dMineScale;
//
//  //---------------------------------------GA parameters
//  static double dCrossoverRate;
	public static double dCrossoverRate;
//  static double dMutationRate;
	public static double dMutationRate;
//
//  //the maximum amount the ga may mutate each weight by
//  static double dMaxPerturbation;
	public static double dMaxPerturbation;
//
//  //used for elitism
//  static int    iNumElite;
	public static int iNumElite;
//  static int    iNumCopiesElite;
	public static int iNumCopiesElite;
//
//  //ctor
//  CParams()
//  {
	public jParams(){
//    if(!LoadInParameters("params.ini"))
//    {
		if(!LoadInParameters("params.ini")){
//      MessageBox(NULL, "Cannot find ini file!", "Error", 0);
			System.out.println("----------------Cannot find ini file!----------------");
//    }
		}
//
//  }
	}
//
//  bool LoadInParameters(char* szFileName);
	public static boolean LoadInParameters(String szFileName){
		if(loaded) return true;
		System.out.println("Loading params");
//		ifstream grab(szFileName);
		FileInputStream file;
		BufferedReader grab;
		try{
			file = new FileInputStream(szFileName);
			grab = new BufferedReader(new InputStreamReader(file));
			if(!grab.ready()){
				System.out.println("Reader not ready");
				file.close();
				grab.close();
				return false;
			}
		} catch(Exception e){
			System.out.println("Error thrown by reader.");
			return false;}
		
//
//		  //check file exists
//		  if (!grab)
//		  {
//		    return false;
//		  }
//
//		  //load in from the file
//		  char ParamDescription[40];
		char[] ParamDescription;
		char[] inputString;
//
//		  grab >> ParamDescription;
		try{
			//ParamDescription = new char[40];
			//inputString = new char[100];
			grab.readLine();
//		  grab >> iFramesPerSecond;
			grab.readLine();
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumInputs;
			iNumInputs = Integer.parseInt(new String(grab.readLine()));
			System.out.print("Number of inputs: ");
			System.out.println(iNumInputs);
//		  grab >> ParamDescription;
			System.out.println(grab.readLine());
//		  grab >> iNumHidden;
			iNumHidden = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			System.out.println(grab.readLine());
//		  grab >> iNeuronsPerHiddenLayer;
			iNeuronsPerHiddenLayer = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumOutputs;
			iNumOutputs = Integer.parseInt(new String(grab.readLine()));
			System.out.print("Number of output: ");
			System.out.println(iNumOutputs);
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dActivationResponse;
			dActivationResponse = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dBias;
			dBias = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dMaxTurnRate;
			dMaxTurnRate = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dMaxSpeed;
			dMaxSpeed = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iSweeperScale;
			iSweeperScale = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumMines;
			iNumMines = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumSweepers;
			iNumSweepers = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumTicks;
			grab.readLine();
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dMineScale;
			dMineScale = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dCrossoverRate;
			dCrossoverRate = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dMutationRate;
			dMutationRate = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> dMaxPerturbation;
			dMaxPerturbation = Double.parseDouble(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumElite;
			iNumElite = Integer.parseInt(new String(grab.readLine()));
//		  grab >> ParamDescription;
			grab.readLine();
//		  grab >> iNumCopiesElite;
			iNumCopiesElite = Integer.parseInt(new String(grab.readLine()));
			file.close();
			grab.close();
		}catch(Exception e){
			System.out.println("Error thrown while reading file");
			System.out.println(e.getCause());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e);
		}
		
		loaded = true;
//
//		  return true;
		return true;
	}
//};
//
//
//
//
//
//
//#endif
	
}

