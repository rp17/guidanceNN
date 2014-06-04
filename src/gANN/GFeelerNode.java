package gANN;

import java.util.List;

import raven.game.RavenBot;
import raven.math.Geometry;
import raven.math.Vector2D;
//import java.util.Vector;
import raven.math.Wall2D;

public class GFeelerNode implements IGInputSource{
	
	private Vector2D feeler;
	private List<Wall2D> walls;
	private RavenBot ravenBot;
	private HasHit hasHit;
	
	public GFeelerNode(RavenBot ravenBot){
		//this.walls = walls;
		this.ravenBot = ravenBot;
	}
	
	@Override
	public float getOutput() {
		Double DistToThisIP    = 0.0;
		double DistToClosestIP = Double.MAX_VALUE;
		Vector2D point = new Vector2D();
		int ClosestWall = -1;
		Vector2D ClosestPoint=new Vector2D();
		
		for (int w=0; w<walls.size(); ++w)
		{
			if (Geometry.lineIntersection2D(ravenBot.pos(),
					feeler,
					walls.get(w).from(),
					walls.get(w).to(),
					DistToThisIP,
					point))
			{
				//is this the closest found so far? If so keep a record
						if (DistToThisIP < DistToClosestIP)
						{
							DistToClosestIP = DistToThisIP;

							ClosestWall = w;

							ClosestPoint = point;
						}
			}
		}//next wall
		if (ClosestWall >=0){
			hasHit.value = true;
			return 1.0f;
		}
		else return 0.0f;
	}
	public void setFeeler(Vector2D feeler){
		this.feeler = feeler;
	}
	
	public void setWalls(List<Wall2D> walls){
		this.walls = walls;
	}
	
	public void setHasHit(HasHit hasHit){
		this.hasHit = hasHit;
	}

	@Override
	public void backProp(float target, float generated) {
		return;
	}
	
	public boolean getHasHit(){
		return hasHit.value;
	}

}
