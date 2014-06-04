package smartSweeper;

//------------------------------------------------------------------------
//
//	Name: CController.h
//
//Author: Mat Buckland 2002
//
//Desc: Controller class for the 'Smart Sweeper' example 
//
//------------------------------------------------------------------------
//#include <vector>
import java.util.Vector;
//#include <sstream>
//#include <string>
//#include <fstream>
//#include <windows.h>
//
//#include "CMinesweeper.h"
//#include "CGenAlg.h"
//#include "utils.h"
//#include "C2DMatrix.h"
//#include "SVector2D.h"
//#include "CParams.h"
import smartSweeper.*;

public class jController {
//	private:
//
//		//storage for the population of genomes
//		vector<SGenome>	     m_vecThePopulation;
	private Vector<jGenAlg.SGenome> m_vecThePopulation = new Vector<jGenAlg.SGenome>();
//
//		//and the minesweepers
//	  vector<CMinesweeper> m_vecSweepers;
	private Vector<jMineSweeper> m_vecSweepers;
//
//		//and the mines
//		vector<SVector2D>	   m_vecMines;
	private Vector<sVector2D> m_vecMines;
//
//		//pointer to the GA
//		CGenAlg*		         m_pGA;
	private jGenAlg m_pGA;
//
//		int					         m_NumSweepers;
	private int m_NumSweepers;
//
//		int					         m_NumMines;
	private int m_NumMines;
//
//		int					         m_NumWeightsInNN;
	private int m_NumWeightsInNN;
//
//		//vertex buffer for the sweeper shape's vertices
//		vector<SPoint>		   m_SweeperVB;
	private Vector<SPoint> m_SweeperVB;
//
//		//vertex buffer for the mine shape's vertices
//		vector<SPoint>		   m_MineVB;
	private Vector<SPoint> m_MineVB;
//
//		//stores the average fitness per generation for use 
//		//in graphing.
//		vector<double>		   m_vecAvFitness;
	private Vector<Double> M_vecAvFitness;
//
//		//stores the best fitness per generation
//		vector<double>		   m_vecBestFitness;
	private Vector<Double> m_vecBestFitness;
//
//
//
//		//pens we use for the stats
//		HPEN				m_RedPen;
//		HPEN				m_BluePen;
//		HPEN				m_GreenPen;
//		HPEN				m_OldPen;
//		
//		//handle to the application window
//		HWND				m_hwndMain;
//
//		//toggles the speed at which the simulation runs
//		bool				m_bFastRender;
//		
//		//cycles per generation
//		int					m_iTicks;
//
//		//generation counter
//		int					m_iGenerations;
	private int m_iGenerations;
//
//	  //window dimensions
//	  int         cxClient, cyClient;
//
//	  //this function plots a graph of the average and best fitnesses
//	  //over the course of a run
//	  void   PlotStats(HDC surface);
//
//	public:
//
//		CController(HWND hwndMain);
	public jController(){
//		CController::CController(HWND hwndMain): m_NumSweepers(CParams::iNumSweepers), 
//        m_pGA(NULL),
//        m_bFastRender(false),
//        m_iTicks(0),
//        m_NumMines(CParams::iNumMines),
//        m_hwndMain(hwndMain),
//        m_iGenerations(0),
//cxClient(CParams::WindowWidth),
//cyClient(CParams::WindowHeight)
		m_pGA = null;
		m_NumMines = jParams.iNumMines;
		m_iGenerations = 0;
//{
////let's create the mine sweepers
//for (int i=0; i<m_NumSweepers; ++i)
//{
		for(int i = 0; i<m_NumSweepers; ++i){
//m_vecSweepers.push_back(CMinesweeper());
			m_vecSweepers.add(new jMineSweeper());
//}
		}
//
////get the total number of weights used in the sweepers
////NN so we can initialise the GA
//m_NumWeightsInNN = m_vecSweepers[0].GetNumberOfWeights();
		m_NumWeightsInNN = m_vecSweepers.get(0).GetNumberOfWeights();
//
////initialize the Genetic Algorithm class
//m_pGA = new CGenAlg(m_NumSweepers,
//CParams::dMutationRate,
//CParams::dCrossoverRate,
//m_NumWeightsInNN);
		m_pGA = new jGenAlg(m_NumSweepers, jParams.dMutationRate,
				jParams.dCrossoverRate, m_NumWeightsInNN);
		
//
////Get the weights from the GA and insert into the sweepers brains
//m_vecThePopulation = m_pGA->GetChromos();
		m_vecThePopulation = m_pGA.GetChromos();
//
//for (i=0; i<m_NumSweepers; i++)
//
//m_vecSweepers[i].PutWeights(m_vecThePopulation[i].vecWeights);
		for (int i = 0; i<m_NumSweepers; i++){
			m_vecSweepers.get(i).PutWeights((m_vecThePopulation.get(i).vecWeights));
		}
//
////initialize mines in random positions within the application window
//for (i=0; i<m_NumMines; ++i)
//{
		for (int i = 0; i<m_NumMines; ++i){
//m_vecMines.push_back(SVector2D(RandFloat() * cxClient,
//RandFloat() * cyClient));
			m_vecMines.add(new sVector2D(utils.RandFloat(), utils.RandFloat()));
//}
		}
//
////create a pen for the graph drawing
//m_BluePen  = CreatePen(PS_SOLID, 1, RGB(0, 0, 255));
//m_RedPen   = CreatePen(PS_SOLID, 1, RGB(255, 0, 0));
//m_GreenPen = CreatePen(PS_SOLID, 1, RGB(0, 150, 0));
//
//m_OldPen	= NULL;
//
////fill the vertex buffers
//for (i=0; i<NumSweeperVerts; ++i)
//{
		for(int i = 0; i<16; ++i){
//m_SweeperVB.push_back(sweeper[i]);

//}
		}
//
//for (i=0; i<NumMineVerts; ++i)
//{
//m_MineVB.push_back(mine[i]);
//}
//
//}
	}
//
//		~CController();
//
//		void		Render(HDC surface);
//
//		void		WorldTransform(vector<SPoint> &VBuffer,
//	                         SVector2D      vPos);
//		
//		bool		Update();
//
//
//		//accessor methods
//		bool		FastRender()const	  {return m_bFastRender;}
//		void		FastRender(bool arg){m_bFastRender = arg;}
//		void		FastRenderToggle()  {m_bFastRender = !m_bFastRender;}

}
