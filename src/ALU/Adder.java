package ALU;

public class Adder {
	public boolean carry_out;
	public boolean overflow;

	private boolean ctrl;
	private boolean[] res;
	
	public Adder() {
		carry_out=false;
		ctrl = false;
		res=null;
		
	}
	private void add(boolean[] A, boolean[] B, boolean ci) {
		boolean c = ci;
		boolean b;
		for (int i=0;i<32;i++) {
			b=ctrl ? B[i]^true:B[i];
			res[i]= A[i] ^ b ^ c;
			c = (A[i] && b) || (A[i] && c) || (b && c);
		}
		carry_out=c;
		overflow=(!A[31] && !(B[31] ^ ctrl) && res[31]) || (A[31] && B[31] && !res[31]);
	}
	public void flush() {
		carry_out=false;
		overflow=false;
		res=null;
		ctrl=false;
	}
	public boolean[] run(boolean[] A, boolean[] B, boolean ctrl) {
		flush();
		this.ctrl=ctrl;
		res=new boolean[32];
		add(A,B,ctrl);
		
		return res;
	}
}
