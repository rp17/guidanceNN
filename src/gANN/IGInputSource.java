package gANN;

public interface IGInputSource {
	abstract float getOutput();
	abstract void backProp(float target, float generated);
}
