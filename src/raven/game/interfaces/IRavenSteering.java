package raven.game.interfaces;

import raven.math.Vector2D;

public interface IRavenSteering {
	public Vector2D calculate();
	public Vector2D force();
	//RavenSteering(RavenGame, RavenBot)
	public void renderFeelers();
	public void wallAvoidanceOn();
	public void separationOn();
	public void seekOn();
	public void setTarget(Vector2D t);
	public void seekOff();
	public void arriveOn();
	public void arriveOff();
	public void wanderOn();
	public void wanderOff();
}