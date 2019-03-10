import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class PhoneDynamics {
    private ArrayList<JTextArea> jtArea;
    String array[][] = new String[26][2];
    private ArrayList<String> alphabet;
    private int arrayIndex;
    
    
    
    public PhoneDynamics() {
        arrayIndex = 0;
        UIManager.put("Panel.background", new Color(231,230,230));
		UIManager.put("OptionPane.background", new Color(231,230,230));
        jtArea = new ArrayList<>();
        alphabet = new ArrayList();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        alphabet.add("g");
        alphabet.add("h");
        alphabet.add("i");
        alphabet.add("j");
        alphabet.add("k");
        alphabet.add("l");
        alphabet.add("m");
        alphabet.add("n");
        alphabet.add("o");
        alphabet.add("p");
        alphabet.add("q");
        alphabet.add("r");
        alphabet.add("s");
        alphabet.add("t");
        alphabet.add("u");
        alphabet.add("v");
        alphabet.add("w");
        alphabet.add("y");
        alphabet.add("x");
        alphabet.add("z");
        
        // the method to get col length array[2].length
        
        setUpScenario();
        printArray();
        //System.out.println("Array size col" + array[2].length);
        //printArray();
    }
    
    public void getAll() {
    	//our output


    	jtArea = new ArrayList<>();
    	ArrayList<JTextArea> arrayList = new ArrayList<>();
        jtArea = arrayList;
    
           //check all only for the given starting char
           for(int row = 0 ; row < 26 ; row++) {
            	for(int col = 0 ; col < arrayIndex  ; col++) { 
            		  
     	    		  JTextArea jtOut = new JTextArea();
     	    		  jtOut.setBorder(new LineBorder(Color.BLACK));
     				  Font font = new Font("Calibri", Font.BOLD, 20);
     				  jtOut.setFont(font);
     				  jtOut.setEditable(false);
     				  jtOut.setText(array[row][col]);
     	    		  //add to list
     				  if(!(jtOut.getText().equals(""))) {
     					  arrayList.add(jtOut);
     				  }
            		  
	            	
            	}
            	
            }
            
    	}
    	
    	    	
    
    
    
    
    public void searchMatch(String input) {
    	//our output
    	try {
    		
    		//if user doesnt enter anything but still searches
    		if(input.equals(null) || input.equals("")) {
    			return;
    		}
    	input.replace(" ", "");
    	jtArea = new ArrayList<>();
    	ArrayList<JTextArea> arrayList = new ArrayList<>();
        jtArea = arrayList;
    	//what we need
    	String firstChar = input.toLowerCase().trim().substring(0, 1);
    	//where to look for it
    	int whereToLook = 0;
    	
    	// match the right char
    	for(String s : alphabet) {
    		//if yes then find the the char and the matching names e.g Dan etc
            if(s.equals(firstChar)) {
            	//check all only for the given starting char
            	for(int col = 0 ; col < arrayIndex ; col++) {
            		//if contains  this sequence
            		if(array[whereToLook][col].toLowerCase().trim().contains(input.toLowerCase().trim().replace(" ", ""))) {
            			//cretae new jt area and supply the list
            			
     	    		  JTextArea jtOut = new JTextArea();
     	    		  jtOut.setBorder(new LineBorder(Color.BLACK));
     				  Font font = new Font("Calibri", Font.BOLD, 20);
     				  jtOut.setFont(font);
     				  jtOut.setEditable(false);
     				  jtOut.setText(array[whereToLook][col]);
     	    		  //add to list
     	    		  arrayList.add(jtOut);
     	    	   }
	            	
            	}
            	
            	
            }
            {
            	//incr the index till we find the char we want
            	whereToLook++;
            }
            
    	}
    	
    	}
    	catch(NullPointerException e) {
    	
    		System.out.println("reached end of entries : ");
    	}
    	    	
    }
    
    
    public void setUpScenario() {
    	
        addToArray("Alice Cooper", "06267189290");
        addToArray("Alicia Reed", "06267189290");
        addToArray("Amy Summers", "011127122330");
        addToArray("Amy Lee", "01027100220");
        addToArray("Abbie May", "08188116262");
        addToArray("Beatrix Potter", "03676678111");
        addToArray("Becca Lee", "09912998112");
        //big amount here to show off the JScrollPane
        addToArray("Calvin Lee", "01276612301");
        addToArray("Cem Salih", "09181616161");
        addToArray("Chloe Anne", "01276612301");
        addToArray("Caroline Green", "09913771231");
        addToArray("Caroline Green", "01821123231");
        addToArray("Celine Tree", "09223990123");
        addToArray("Connie Dee", "01982123112");
        addToArray("Cyndey Cele", "01821178112");
        addToArray("Carrie Bloom", "01912181811");
        addToArray("Connor Rhodes", "01821167121");
        addToArray("Cameran Freeman", "01981918211");
        
        addToArray("Daniel Knight", "01234678901");
        addToArray("Darren Masters","06934162778");
        addToArray("Donnie Glen","052671929891");
        addToArray("Eddie Van Halen", "06182378199");
        addToArray("Emily Meek", "07712819892");
        addToArray("Elizabeth Anne", "07712819892");
        addToArray("Danny White", "0611131199");
        addToArray("Frances Pepper", "01252131315");
        addToArray("Francis Bean", "01222818921");
        addToArray("Frank Douglas", "09912111232");
        addToArray("Gerald Long", "01156622301");
        addToArray("Gary Green", "06671121342");
        addToArray("Gus Ahr", "01828111812");
        addToArray("Harry Lane", "01288712301");
        addToArray("Henry Tree", "09112998711");
        addToArray("Irelia Winters", "01178127821");
        addToArray("Joey Bead", "01882829811");
        addToArray("Joe Broad", "09123123323");
        addToArray("Joe Broad", "09112816721");
        addToArray("Joe Nolan", "01898917211");
        addToArray("Kevin Johnson", "01277888301");
        addToArray("Kelly Johnson", "08812222333");
        addToArray("Luke Coleman", "01218172301");
        addToArray("Le Carver", "01912712121");
        addToArray("Mario Ajax", "01823222231");
        addToArray("Micheal Hillier", "01898119231");
        addToArray("Noah George", "01772012819");
        addToArray("Nancy B", "01921124312");
        addToArray("Olivia Lee", "01214414152");
        addToArray("Oriana Peep", "02183717121");
        addToArray("Peter Giano", "01772172899");
        addToArray("Quinn Topper", "01223889901");
        addToArray("Rupert Green", "01286177292");
        addToArray("Samantha Jones", "06676718291");
        addToArray("Sarah Jones", "01921881712");
        addToArray("Sarah Jones", "01928719121");
        addToArray("Sarah Jones", "01723018281");
        addToArray("Terry Cay", "01881001231");
        addToArray("Ursa He", "01991828910");
        addToArray("Vicky Scott", "01882901301");
        addToArray("Valerie Scott", "0192799101");
        addToArray("Wendy Ferry", "01198162121");
        addToArray("Yolanda Ike", "01116919322");
        addToArray("Xerath Johnson", "01666655501");
        addToArray("Xayah Icarus", "01882817721");
        addToArray("Zara Briggs", "08876882301");
        addToArray("Zed Rooney ","052671929891");
    }
    
    public boolean addToArray(String name , String phone) {
        //lower case check first char.
        String firstChar = name.toLowerCase().substring(0, 1).replaceAll("[0-9]", "");;
        //the position in alphabet.
        int pos = 0;
        boolean testCon = true;
        //sort the position out.
        for(String s : alphabet) {
                if(s.equals(firstChar)) {
                 int index = 0;
                 try{
                     while (testCon){
                    
                        String isNull = array[pos][index];
                        if(isNull == null){
                            array[pos][index] = name.trim().replaceAll("[0-9]", "") + " - " + phone.trim();
                            return true;
                        }
                         //TODO make new array copy contents and extend col by 1.
                   
                          index ++;
                       }

                  }  
                    catch(ArrayIndexOutOfBoundsException e){
                        index++;
                        arrayIndex = index * 2;
                        newArray(index);
                        array[pos][index - 1] = name.trim().replaceAll("[0-9]", "") + " - " + phone.trim();
                    }
                //add to array in the part of alphabet equal to the letter e.g 0 = a and d = 3 < 26, 0-25.
                
            }
            //increment.
            pos ++;
            
        }
        return false;
    }
    
    public boolean delArrayIndex(String name , String phone) {
        //lower case check first char.
        String firstChar = name.toLowerCase().substring(0, 1);
        //the position in alphabet.
        int pos = 0;
        boolean testCon = true;
        //sort the position out.
        for(String s : alphabet) {
                if(s.equals(firstChar)) {
                 int index = 0;
                 try{
                     while (testCon){
                    
                        String del = array[pos][index];
                        String splitPhone1 = del.replaceAll(".*?-", "");
                        String splitPhone = splitPhone1.replaceAll(" ", "");
                        String splitName1 = del.replaceAll("-", "");
                        String splitName2 = splitName1.replaceAll("[0-9]", "");
                        String splitName = splitName2.replace(" ", "");
                        
                        String cleanName = name.replace(" ", "");
                        String cleanPhone = phone.replace(" ", "");
                        
                        
                        System.out.println(cleanName.trim().toLowerCase());
                        System.out.println(splitName.trim().toLowerCase());
                        //System.out.println(phone);
                        System.out.println("");
                        System.out.println(cleanPhone.trim().toLowerCase());
                        System.out.println(splitPhone.trim().toLowerCase());
                        //System.out.println(name);
                        System.out.println("");
                        if(splitName.trim().toLowerCase().equals(cleanName.trim().toLowerCase()) && splitPhone.trim().toLowerCase().equals(cleanPhone.trim().toLowerCase())){
                            array[pos][index] = "";
                            return true;
                        }
                         //TODO make new array copy contents and extend col by 1.
                   
                          index ++;
                       }
                     
                     	
                  }  
                    catch(Exception e){
                        System.out.println("Doesnt exist");
                        return false;
                    }
                //add to array in the part of alphabet equal to the letter e.g 0 = a and d = 3 < 26, 0-25.
                
            }
            //increment.
            pos ++;
            
        }
        return false;
    }
    
    
   
    
    public void printArray() {
        for(int row = 0; row < 26; row++) {
            for(int col = 0 ; col < arrayIndex ; col++) {
                if(array[row][col] == null) {                   
                    //checks if the place is filled
                    System.out.println(alphabet.get(row));
                }
                else {
                    System.out.println(array[row][col]);
                }
                
            }
        }
    }
    
    public void newArray(int index) {
        //new array
    	System.out.println("original array" + array[0].length);
        String arrayNew[][] = new String[26][index * 2];
        for(int row = 0; row < 26; row++) {
            for(int col = 0 ; col < index - 1; col++) {
                if(!(col >= index)){
                arrayNew[row][col] = array[row][col];
              }
                //System.out.println(arrayNew[row][col]);
            }
        }
        //System.out.println(arrayNew[2].length);
        array = arrayNew;
        //System.out.println("new array ");
        //System.out.println(arrayNew[2].length);
        //System.out.println("array" + array[2].length);
        System.out.println("new array" + array[0].length);
    }
    
    public int getNumber() {
        return jtArea.size();
    }
    
    public ArrayList<JTextArea> addToo(){
         
         return jtArea;
    }
    

    
    
}