package ALU;

public class Logic {
	private boolean[] res;
	private boolean ctrl;
	
	public Logic() {
		res=null;
		ctrl=false;
	}
	public void flush() {
		res=null;
		ctrl=false;
	}
	private void and_(boolean[] A, boolean[] B) {
		for(int i=0;i<32;i++)
			res[i] = A[i] && B[i];
	}
	private void or_(boolean[] A, boolean[] B) {
		for(int i=0;i<32;i++)
			res[i] = A[i] || B[i];
	}
	boolean[] run(boolean[] A, boolean[] B, boolean ctrl) {
		res=null;
		this.ctrl=ctrl;
		res=new boolean[32];
		
		if(ctrl)
			or_(A,B);
		else
			and_(A,B);
		
		return res;
	}
}
