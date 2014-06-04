package smartSweeper;

public class sVector2D {
//double x, y;
	public double x, y;
	public sVector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

//	
//	SVector2D(double a = 0.0f, double b = 0.0f):x(a),y(b){}
	public sVector2D (){
		x = 0.0;
		y = 0.0;
	}
	public sVector2D(sVector2D in){
		x = in.x;
		y = in.y;
	}
//
//
//	//we need some overloaded operators
//	SVector2D &operator+=(const SVector2D &rhs)
//	{
	public sVector2D plusEquals (sVector2D rhs){
//		x += rhs.x;
		x += rhs.x;
//		y += rhs.y;
		y += rhs.y;
//
//		return *this;
		return this;
//	}
	}
//
//	SVector2D &operator-=(const SVector2D &rhs)
//	{
	public sVector2D minusEquals(sVector2D rhs){
//		x -= rhs.x;
		x -= rhs.x;
//		y -= rhs.y;
		y -= rhs.y;
//
//		return *this;
		return this;
//	}
	}
//
//	SVector2D &operator*=(const double &rhs)
//	{
	public sVector2D timesEquals (double rhs){
//		x *= rhs;
		x *= rhs;
//		y *= rhs;
		y *= rhs;
//
//		return *this;
		return this;
//	}
	}
//
//  	SVector2D &operator/=(const double &rhs)
	public sVector2D divideEquals(double rhs){
//	{
//		x /= rhs;
		x /= rhs;
//		y /= rhs;
		y /= rhs;
//
//		return *this;
		return this;
//	}
	}
	
//	inline SVector2D operator*(const SVector2D &lhs, double rhs)
//	{
	static public sVector2D times(sVector2D lhs, double rhs){
//	  SVector2D result(lhs);
		sVector2D result = new sVector2D(lhs.x, lhs.y);
//	  result *= rhs;
		result.timesEquals(rhs);
//	  return result;
		return result;
//	}
	}
//
//	inline SVector2D operator*(double lhs, const SVector2D &rhs)
//	{
	static public sVector2D times(double lhs, sVector2D rhs){
//	  SVector2D result(rhs);
		sVector2D result = new sVector2D(rhs);
//	  result *= lhs;
		result.timesEquals(lhs);
//	  return result;
		return result;
//	}
	}
//
//	//overload the - operator
//	inline SVector2D operator-(const SVector2D &lhs, const SVector2D &rhs)
//	{
	static public sVector2D minus(sVector2D lhs, sVector2D rhs){
//	  SVector2D result(lhs);
		sVector2D result = new sVector2D(lhs);
//	  result.x -= rhs.x;
//	  result.y -= rhs.y;
		result.minusEquals(rhs);
//	  
//	  return result;
		return result;
//	}
	}
//	//------------------------- Vec2DLength -----------------------------
//	//
////		returns the length of a 2D vector
//	//--------------------------------------------------------------------
//	inline double Vec2DLength(const SVector2D &v)
//	{
	static public double Vec2DLength(sVector2D v){
//		return sqrt(v.x * v.x + v.y * v.y);
		return Math.sqrt(v.x * v.x + v.y * v.y);
//	}
	}
//
//	//------------------------- Vec2DNormalize -----------------------------
//	//
////		normalizes a 2D Vector
//	//--------------------------------------------------------------------
//	inline void Vec2DNormalize(SVector2D &v)
//	{
	static public void Vec2DNormalize (sVector2D v){
//		double vector_length = Vec2DLength(v);
		double vector_length = Vec2DLength(v);
//
//		v.x = v.x / vector_length;
		v.x = v.x / vector_length;
//		v.y = v.y / vector_length;
		v.y = v.y / vector_length;
//	}
	}
//
//	//------------------------- Vec2DDot --------------------------
//	//
////		calculates the dot product
//	//--------------------------------------------------------------------
//	inline double Vec2DDot(SVector2D &v1, SVector2D &v2)
//	{
	static public double Vec2DDot (sVector2D v1, sVector2D v2){
//		return v1.x*v2.x + v1.y*v2.y;
		return v1.x*v2.x + v1.x*v2.y;
//	}
	}
//
//	//------------------------ Vec2DSign --------------------------------
//	//
//	//  returns positive if v2 is clockwise of v1, minus if anticlockwise
//	//-------------------------------------------------------------------
//	inline int Vec2DSign(SVector2D &v1, SVector2D &v2)
//	{
	static public int Vec2DSign (sVector2D v1, sVector2D v2){
//	  if (v1.y*v2.x > v1.x*v2.y)
//	  {
		if (v1.y*v2.x > v1.x * v2.y){
//	    return 1;
			return 1;
//	  }
		}
//	  else 
//	  {
//	    return -1;
		return -1;
//	  }
//	}
	}
}
