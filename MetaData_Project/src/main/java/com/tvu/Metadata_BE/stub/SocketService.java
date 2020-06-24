package com.tvu.Metadata_BE.stub;

import java.io.File;

import org.springframework.stereotype.Service;


@Service
public class SocketService {

	public String mergeChunks(String cmdPath, String bucketName, String localSytemPath, String path,
			String starttimestamp, String endtimestamp, String filename) {
		// TODO Auto-generated method stub
		try {
			String command =  cmdPath +" "+ bucketName + " "+ localSytemPath +" "+path+ " "+starttimestamp+ " "+ endtimestamp+ " "+filename;
			System.out.println(command);
			Runtime run  = Runtime.getRuntime();
			Process proc = run.exec(command);
			int pgr = 1;
			while (proc.isAlive()) {
				Thread.sleep(2000);   
				if(pgr < 90)
				{
					System.out.println("Process is Alive ..."+pgr);
					pgr = pgr +2;
				} else {
					System.out.println("Process is Alive ..."+pgr);
				}
			}
			File file = new File(filename);
			if(file.exists())
			{
				System.out.println("Progress:100");
				return "Progress:100";
			}
			else {
				System.out.println("Progress:Failed");
			}
			return "Progress:Failed";
		}catch (Exception err) {
			err.printStackTrace();
		}
		return "File Download completed..";
	}
}
