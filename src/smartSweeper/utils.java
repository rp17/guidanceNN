package smartSweeper;

import java.util.Random;;

public class utils {
//	//----------------------------------------------------------------------------
////	some random number functions.
////----------------------------------------------------------------------------
//
////returns a random integer between x and y
//inline int	  RandInt(int x,int y) {return rand()%(y-x+1)+x;}
	private static Random rand = new Random();
	
	public static int RandInt(int x, int y){
		return rand.nextInt()%(y-x+1) + x;
	}
//
////returns a random float between zero and 1
//inline double RandFloat()		   {return (rand())/(RAND_MAX+1.0);}
	public static double RandFloat(){
		return rand.nextDouble();
	}
//
////returns a random bool
//inline bool   RandBool()
//{
	public static boolean RandBool(){
//	if (RandInt(0,1)) return true;
		return rand.nextBoolean();
//
//	else return false;
//}
	}
//
////returns a random float in the range -1 < n < 1
//inline double RandomClamped()	   {return RandFloat() - RandFloat();}
	public static double RandomClamped(){
		return rand.nextDouble() - rand.nextDouble();
	}
//
//
////-----------------------------------------------------------------------
////	
////	some handy little functions
////-----------------------------------------------------------------------
//
////converts an integer to a std::string
//string itos(int arg);
	public static String itos (int arg){
		return Integer.toString(arg);
	}
//
////converts an float to a std::string
//string ftos (float arg);
	public static String ftos (float arg){
		return Float.toString(arg);
	}
//
////	clamps the first argument between the second two
//void Clamp(double &arg, double min, double max);
	public static void Clamp (double arg, double min, double max){
//		if (arg < min)
//		{
//			arg = min;
//		}
		if(arg < min) arg = min;
//
//		if (arg > max)
//		{
//			arg = max;
//		}
		if (arg > max) arg = max;
	}
//
///////////////////////////////////////////////////////////////////////
////
////	Point structure
////
///////////////////////////////////////////////////////////////////////
//struct SPoint
//{
	public class SPoint{
//	float x, y;
		float x, y;
//	
//	SPoint(){}
		public SPoint(){}
//	SPoint(float a, float b):x(a),y(b){}
		public SPoint(float x, float y){
			this.x = x;
			this.y = y;
		}
//};
	}

}
