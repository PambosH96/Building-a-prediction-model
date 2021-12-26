package ry;
import java.io.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main{
	
	private static Map<String,Integer> yearMap = new TreeMap<String,Integer>();
	
	private static void parseData(String line) throws Exception{
		String year;
		if(line != null &&( !(line.isEmpty()))&&(line.length()>6)){
			year=line.substring(0,6);
			if(year.equals("<year>")){
				year=line.substring(6,10);				
				
				if (yearMap.containsKey(year)) {
					yearMap.put(year, yearMap.get(year) + 1);
				} else {
					yearMap.put(year, 1);
				}
				
			}
		}
	}

public static void main(String[] args) throws IOException {
	
	
	try{
        FileReader fileReader=new FileReader("C:\\Users\\Admin\\OneDrive\\Documents\\Panepistimio\\Analisi dedomenon\\dblp-2020-04-01.xml");
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        FileWriter fileWriter=new FileWriter("output.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        PrintWriter printWriter=new PrintWriter(bufferedWriter);
        try{
        	String line;
            line=bufferedReader.readLine();
            while(line!=null){
                parseData(line);
                line=bufferedReader.readLine();
            }            
            
            for (Entry<String, Integer> entry : yearMap.entrySet()) {
            	printWriter.println(entry.getKey() + "\t" + entry.getValue());
            }                
        }
        finally{
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}