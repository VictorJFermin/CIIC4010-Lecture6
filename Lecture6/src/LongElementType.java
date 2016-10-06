
public class LongElementType extends ElementType {
	
	private long theNumber;
	
	public LongElementType(long i){
		theNumber = i;
	}
	
	public boolean greaterThan(ElementType e){
//		LongElementType eLong = (LongElementType) e; //casting(vuelve a e en un LongElementType
//		return(this.theNumber > eLong.theNumber);
		return (this.valueOf() > e.valueOf());
	}
	
	public long valueOf(){
		return this.theNumber;
	}
	
	public boolean equals(ElementType e){
		return (this.valueOf() == e.valueOf());
	}
}
