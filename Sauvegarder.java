
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Sauvegarder implements Serializable{
	
	public Sauvegarder() {
		
	}
	
	public void sauvegarde(Case[][] a) {
		try {
			FileOutputStream fos = new FileOutputStream("sauvegarde");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
			} 
		catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
