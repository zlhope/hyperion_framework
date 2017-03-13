package demo;

import org.sikuli.script.Finder;
import org.sikuli.basics.*;
import java.io.*;

public class ImgCompare {
        public static void main(String[] args) throws IOException {
                try{
                	if(args.length<3)
                	{
                		System.out.print("PARAM_ERROR");
                		return;
                	}
                	File img1=new File(args[0]);
                	File img2=new File(args[1]);
                	if((!img1.exists())||(!img2.exists()))
                	{
                		System.out.print("FILE_NOT_EXIST");
                		return;
                	}
                	Settings.MinSimilarity=Double.parseDouble(args[2]);
                	Finder f=new Finder(args[0]);
                	f.find(args[1]);
                	if(f.hasNext())
                	{
                		System.out.print("MATCH");
                	}else
                	{
                		System.out.print("DISMATCH");
                	}
                }
                catch(Exception e){
                        //e.printStackTrace();
                        System.out.print("EXCEPTION");
                }
        }
}