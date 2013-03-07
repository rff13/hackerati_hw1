import java.io.File;
import java.io.IOException;


public class Producer extends Thread{
	
	public void run(){
		
		synchronized(Buffer.photos){
			
			//scan files then add to buffer
			
			for(File f: Buffer.files){
				String fileName;
				try {
					fileName = f.getCanonicalPath();
					if(fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")){  
						Buffer.photos.add(f);
					} 
					
				} 
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				 
				  
			}
			
//			System.out.println(Buffer.photos);
		}
	}
}
