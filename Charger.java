import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Charger implements Serializable{
	Case[][] plateau;
	
	private ObjectInputStream ois;

	public Charger() {
		
	}
	
	public Case[][] charge(String f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			plateau = (Case[][])ois.readObject();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
				e.printStackTrace();
		}
		return plateau;
	}

}
