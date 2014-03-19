

public class Entier implements Cloneable {
	private int i;
	
	public Entier(int i)
	{
		this.i = i;
	}
	
	public int get(){return i;}
	public void set(int e){this.i = e;}
	
	public Object clone()
	{
		Entier r = null;
		
		try
		{
			r = (Entier) super.clone();
			r.set(this.i);
		}
		catch(Exception e) { }
		
		return (Object)r;
	}
}
