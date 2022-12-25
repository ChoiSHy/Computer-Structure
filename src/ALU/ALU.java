package ALU;

public class ALU {
	public boolean zero;
	public boolean overflow;
	public boolean negative;

	private boolean carry;
	private boolean[] res;
	private boolean[] ALU_ctrl;
	
	Adder adder;
	Logic logic;
	
	public ALU() {
		res=null;
		
		zero=false;
		overflow=false;
		carry=false;
		negative=false;
		ALU_ctrl=null;
		
		adder=new Adder();
		logic=new Logic();
	}
	public void flush() {
		res=null;
		
		zero=false;
		overflow=false;
		carry=false;
		negative=false;
		ALU_ctrl=null;
		
		adder.flush();
		logic.flush();
	}
	
	private boolean is_zero() {
		boolean ret=false;
		for(int i=0;i<32;i++) {
			ret|=res[i];
			if(ret)
				return false;
		}
		return true;
	}
	
	public boolean[] run(boolean[] A, boolean[] B, boolean[] ctrl) {
		flush();
		ALU_ctrl=ctrl;
		// or, and
		if(!ctrl[0]) {
			res = logic.run(A, B, ctrl[1]);
			System.out.println(BitFormatter.b2i(A)+(ctrl[1]?" OR ":" AND ")+BitFormatter.b2i(B)+" = "+BitFormatter.b2i(res));
			System.out.println(BitFormatter.toString(res));
		}
		// add, sub
		else {
			res=adder.run(A, B, ctrl[1]);
			System.out.println(BitFormatter.b2i(A)+(ctrl[1]?" - ":" + ")+BitFormatter.b2i(B)+" = "+BitFormatter.b2i(res));
			System.out.println(BitFormatter.toString(res));
			
			carry=adder.carry_out;
			overflow=adder.overflow;
		}
		negative=res[31];
		zero=is_zero();
		return res;
	}
}
