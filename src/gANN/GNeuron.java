package gANN;

import java.util.Vector;

public class GNeuron implements IGInputSource{
	private class inputSource{
		private IGInputSource source;
		private float value;
		private float weight;
		
		public inputSource(IGInputSource source, float weight){
			this.source = source;
			this.weight = weight;
			value = 0.0f;
		}
	}
	private Vector<inputSource> inputs;
	
	public GNeuron(){
		inputs = new Vector<inputSource>();
	}

	@Override
	public float getOutput() {
		float weightedInput = 0.0f;
		
		for (inputSource input: inputs){
			input.value = input.source.getOutput();
			weightedInput += input.value * input.weight;
		}
		
		return weightedInput<0.5f?0.0f:1.0f;
	}
	
	public void backProp(float target, float generated){
		if (target == generated) return;
		for (inputSource input: inputs){
			input.weight -= (input.value - target)/input.weight * 0.5;
			if(input.weight == 0.0f) input.weight = 0.000000001f;
			input.source.backProp(target, input.value);
		}
	}
	
	public void addInput(IGInputSource newInput){
		if(newInput == null) return;
		System.out.println("connecting new neuron ");
		inputs.addElement(new inputSource(newInput, 0.5f));
	}
}
