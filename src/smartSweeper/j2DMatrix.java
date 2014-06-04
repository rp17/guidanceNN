package smartSweeper;

//#ifndef C2DMATRIX_H
//#define C2DMATRIX_H
//
////------------------------------------------------------------------------
////
////	Name: C2DMatrix.h
////
////  Author: Mat Buckland 2002
////
////  Desc: Matrix class 
////
////------------------------------------------------------------------------
//
//#include <stdlib.h>
//#include <math.h>
//#include <iostream>
//#include <vector>
//
//#include "utils.h"
import smartSweeper.utils;
import java.util.Vector;
//
//struct SPoint;
class SPoint{
	public double x;
	public double y;
}
//
//using namespace std;
//
//
//class C2DMatrix
//{
class j2DMatrix{
//private:
//  
//  struct S2DMatrix
//  {
	private class s2DMatrix{
//
//	  double _11, _12, _13;
		public double _11, _12, _13;
//	  double _21, _22, _23;
		public double _21, _22, _23;
//	  double _31, _32, _33;
		public double _31, _32, _33;
//
//    S2DMatrix()
//	  {
		public void s2DMatrix(){
//		  _11=0; _12=0; _13=0;
			_11=0; _12=0; _13=0;
//		  _21=0; _22=0; _23=0;
			_21=0; _22=0; _23=0;
//		  _31=0; _32=0; _33=0;
			_31=0; _32=0; _33=0;
//	  }
		}
//
//    friend ostream &operator<<(ostream& os, const S2DMatrix &rhs)
//	  {
		public void print(){
//		  os << "\n" << rhs._11 << "  " << rhs._12 << "  " << rhs._13;
//
//		  os << "\n" << rhs._21 << "  " << rhs._22 << "  " << rhs._23;
//
//		  os << "\n" << rhs._31 << "  " << rhs._32 << "  " << rhs._33;
//
//		  return os;
			System.out.println();
			System.out.print(_11);
			System.out.print(_12);
			System.out.print(_13);
			System.out.println();
			System.out.print(_21);
			System.out.print(_22);
			System.out.print(_23);
			System.out.println();
			System.out.print(_31);
			System.out.print(_32);
			System.out.print(_33);
//	  }
		}
//  };
	}
//
//  S2DMatrix m_Matrix;
	
	private s2DMatrix m_Matrix = new s2DMatrix();
//
//  //multiplies m_Matrix with mIn
//  inline void  S2DMatrixMultiply(S2DMatrix &mIn);
	private void s2DMatrixMultiply(s2DMatrix mIn){
//		S2DMatrix mat_temp;
		s2DMatrix mat_temp = new s2DMatrix();
//		
//		//first row
//		mat_temp._11 = (m_Matrix._11*mIn._11) + (m_Matrix._12*mIn._21) + (m_Matrix._13*mIn._31);
		mat_temp._11 = (m_Matrix._11*mIn._11) + (m_Matrix._12*mIn._21) + (m_Matrix._13*mIn._31);
//		mat_temp._12 = (m_Matrix._11*mIn._12) + (m_Matrix._12*mIn._22) + (m_Matrix._13*mIn._32);
		mat_temp._12 = (m_Matrix._11*mIn._12) + (m_Matrix._12*mIn._22) + (m_Matrix._13*mIn._32);
//		mat_temp._13 = (m_Matrix._11*mIn._13) + (m_Matrix._12*mIn._23) + (m_Matrix._13*mIn._33);
		mat_temp._13 = (m_Matrix._11*mIn._13) + (m_Matrix._12*mIn._23) + (m_Matrix._13*mIn._33);
//
//		//second
//		mat_temp._21 = (m_Matrix._21*mIn._11) + (m_Matrix._22*mIn._21) + (m_Matrix._23*mIn._31);
		mat_temp._21 = (m_Matrix._21*mIn._11) + (m_Matrix._22*mIn._21) + (m_Matrix._23*mIn._31);
//		mat_temp._22 = (m_Matrix._21*mIn._12) + (m_Matrix._22*mIn._22) + (m_Matrix._23*mIn._32);
		mat_temp._22 = (m_Matrix._21*mIn._12) + (m_Matrix._22*mIn._22) + (m_Matrix._23*mIn._32);
//		mat_temp._23 = (m_Matrix._21*mIn._13) + (m_Matrix._22*mIn._23) + (m_Matrix._23*mIn._33);
		mat_temp._23 = (m_Matrix._21*mIn._13) + (m_Matrix._22*mIn._23) + (m_Matrix._23*mIn._33);
//
//		//third
//		mat_temp._31 = (m_Matrix._31*mIn._11) + (m_Matrix._32*mIn._21) + (m_Matrix._33*mIn._31);
		mat_temp._31 = (m_Matrix._31*mIn._11) + (m_Matrix._32*mIn._21) + (m_Matrix._33*mIn._31);
//		mat_temp._32 = (m_Matrix._31*mIn._12) + (m_Matrix._32*mIn._22) + (m_Matrix._33*mIn._32);
		mat_temp._32 = (m_Matrix._31*mIn._12) + (m_Matrix._32*mIn._22) + (m_Matrix._33*mIn._32);
//		mat_temp._33 = (m_Matrix._31*mIn._13) + (m_Matrix._32*mIn._23) + (m_Matrix._33*mIn._33);
		mat_temp._33 = (m_Matrix._31*mIn._13) + (m_Matrix._32*mIn._23) + (m_Matrix._33*mIn._33);
//
//		m_Matrix = mat_temp;
		m_Matrix = mat_temp;
	}
//
//public:
//
//  C2DMatrix()
//  {
	public void s2DMatric(){
//    //initialize the matrix to an identity matrix
//    Identity();
		Identity();
//  }
	}
//
//  //create an identity matrix
//  void Identity();
	public void Identity(){
		m_Matrix._11 = 1; m_Matrix._12 = 0; m_Matrix._13 = 0;

		m_Matrix._21 = 0; m_Matrix._22 = 1; m_Matrix._23 = 0;

		m_Matrix._31 = 0; m_Matrix._32 = 0; m_Matrix._33 = 1;
	}
//  
//  //create a transformation matrix
//  void	Translate(double x, double y);
	public void Translate(double x, double y){
		s2DMatrix mat = new s2DMatrix();
		
		mat._11 = 1; mat._12 = 0; mat._13 = 0;
		
		mat._21 = 0; mat._22 = 1; mat._23 = 0;
		
		mat._31 = x;    mat._32 = y;    mat._33 = 1;
		
		//and multiply
		s2DMatrixMultiply(mat);
	}
//
//  //create a scale matrix
//  void	Scale(double xScale, double yScale);
	public void Scale(double xScale, double yScale){
		s2DMatrix mat = new s2DMatrix();
		
		mat._11 = xScale; mat._12 = 0; mat._13 = 0;
		
		mat._21 = 0; mat._22 = yScale; mat._23 = 0;
		
		mat._31 = 0; mat._32 = 0; mat._33 = 1;
		
		//and multiply
		s2DMatrixMultiply(mat);
	}
//
//  //create a rotation matrix
//  void Rotate(double rotation);
	public void Rotate(double rotation){
		s2DMatrix mat = new s2DMatrix();

		double Sin = Math.sin(rotation);
		double Cos = Math.cos(rotation);
		
		mat._11 = Cos;  mat._12 = Sin; mat._13 = 0;
		
		mat._21 = -Sin; mat._22 = Cos; mat._23 = 0;
		
		mat._31 = 0; mat._32 = 0;mat._33 = 1;
		
		//and multiply
		s2DMatrixMultiply(mat);
	}
//
//   //applys a transformation matrix to a std::vector of points
//  inline void TransformSPoints(vector<SPoint> &vPoints);
	public void TransformSPoints(Vector<SPoint> vPoints){
//		for (int i=0; i<vPoint.size(); ++i)
		for (SPoint point : vPoints){
//			{
//				double tempX =(m_Matrix._11*vPoint[i].x) + (m_Matrix._21*vPoint[i].y) + (m_Matrix._31);
			double tempX = ((m_Matrix._11*point.x) + (m_Matrix._21*point.y) + (m_Matrix._31));
		//
//				double tempY = (m_Matrix._12*vPoint[i].x) + (m_Matrix._22*vPoint[i].y) + (m_Matrix._32);
			double tempY = ((m_Matrix._12*point.x) + (m_Matrix._22*point.y) + (m_Matrix._32));
		//	
//				vPoint[i].x = tempX;
			point.x = tempX;
		//
//				vPoint[i].y = tempY;
			point.y = tempY;
		//
//			}
		}
	}
//
//};
//
////multiply two matrices together
//inline void C2DMatrix::S2DMatrixMultiply(S2DMatrix &mIn)
//{
//	S2DMatrix mat_temp;
//	
//	//first row
//	mat_temp._11 = (m_Matrix._11*mIn._11) + (m_Matrix._12*mIn._21) + (m_Matrix._13*mIn._31);
//	mat_temp._12 = (m_Matrix._11*mIn._12) + (m_Matrix._12*mIn._22) + (m_Matrix._13*mIn._32);
//	mat_temp._13 = (m_Matrix._11*mIn._13) + (m_Matrix._12*mIn._23) + (m_Matrix._13*mIn._33);
//
//	//second
//	mat_temp._21 = (m_Matrix._21*mIn._11) + (m_Matrix._22*mIn._21) + (m_Matrix._23*mIn._31);
//	mat_temp._22 = (m_Matrix._21*mIn._12) + (m_Matrix._22*mIn._22) + (m_Matrix._23*mIn._32);
//	mat_temp._23 = (m_Matrix._21*mIn._13) + (m_Matrix._22*mIn._23) + (m_Matrix._23*mIn._33);
//
//	//third
//	mat_temp._31 = (m_Matrix._31*mIn._11) + (m_Matrix._32*mIn._21) + (m_Matrix._33*mIn._31);
//	mat_temp._32 = (m_Matrix._31*mIn._12) + (m_Matrix._32*mIn._22) + (m_Matrix._33*mIn._32);
//	mat_temp._33 = (m_Matrix._31*mIn._13) + (m_Matrix._32*mIn._23) + (m_Matrix._33*mIn._33);
//
//	m_Matrix = mat_temp;
//}
//
////applies a 2D transformation matrix to a std::vector of SPoints
//inline void C2DMatrix::TransformSPoints(vector<SPoint> &vPoint)
//{
//	for (int i=0; i<vPoint.size(); ++i)
//	{
//		double tempX =(m_Matrix._11*vPoint[i].x) + (m_Matrix._21*vPoint[i].y) + (m_Matrix._31);
//
//		double tempY = (m_Matrix._12*vPoint[i].x) + (m_Matrix._22*vPoint[i].y) + (m_Matrix._32);
//	
//		vPoint[i].x = tempX;
//
//		vPoint[i].y = tempY;
//
//	}
//}
}
//
//#endif