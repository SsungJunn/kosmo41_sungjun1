class Tv2 {
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channelUP() { ++channel; }
	void channelDown() { --channel; }
}

class VCR {
	boolean power;
	int counter = 0;
	void power() { power = !power; }
	void play() { /* 내용 생략 */ }
	void stop() { /* 내용 생략 */ }
	void rew() { /* 내용 생략 */ }
	void ff() { /* 내용 생략 */ }
}

class TVCR extends Tv2 {
	VCR vcr = new VCR();
	int counter = vcr.counter;
	
	void play() {
		vcr.play();
	}
	
	void stop() {
		vcr.stop();
	}
	
	void rew() {
		vcr.rew();
	}
	
	void ff() {
		vcr.ff();
	}
}