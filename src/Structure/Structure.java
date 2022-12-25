package Structure;

import ALU.*;
public class Structure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ALU alu = new ALU();
		int A = 12;
		int B = 10;

		boolean[] a = BitFormatter.i2b(A);
		boolean[] b = BitFormatter.i2b(B);
		System.out.println(BitFormatter.b2i(a));
		System.out.println(BitFormatter.toString(a));
		System.out.println(BitFormatter.b2i(b));
		System.out.println(BitFormatter.toString(b));

		boolean[] code = {true, false};
		boolean[] c = alu.run(a, b, code ); 

	}

}
