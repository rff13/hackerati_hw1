import java.io.File;
//import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
//import com.drew.imaging.ImageProcessingException;
//import com.drew.imaging.jpeg.JpegSegmentData;
import com.drew.metadata.*;

public class Consumer extends Thread{

	private String dataString = "";
	public void run(){

		synchronized(Buffer.photos){
			
			if(!Buffer.photos.isEmpty()){
				for(File f: Buffer.photos){
					//get metadata to show in web ui
					
					try {
						Metadata metadata = ImageMetadataReader.readMetadata(f);
						
						for (Directory directory : metadata.getDirectories()) {
						    for (Tag tag : directory.getTags()) {
//						        System.out.println(tag);
						    	dataString += tag.toString();
						    }
						}
						
					} 
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					
					Buffer.photos.remove(f);
				}
			}
		}
	}
	
	public String getDataString(){
		return dataString;
	}
}