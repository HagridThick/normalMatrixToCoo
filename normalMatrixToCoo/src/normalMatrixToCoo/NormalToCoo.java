package normalMatrixToCoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class NormalToCoo {

	static int row_number = 0;
	// int column_number = 0;
	static ArrayList<Integer> row = new ArrayList<Integer>();
	static ArrayList<Integer> column = new ArrayList<Integer>();
	static ArrayList<Double> value = new ArrayList<Double>();

	public static void change(String normal, String coo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(normal));
		String line = null;
		while ((line = br.readLine()) != null) {
			String temp[] = line.split(" ");
			for (int i = 0; i < temp.length; i++) {
				if (!temp[i].equals("0")) {
					put(row_number, i, Double.parseDouble(temp[i]));
				}
			}
			row_number += 1;
		}
        BufferedWriter bw = new BufferedWriter(new FileWriter(coo));
        java.util.Iterator<Integer> it1 = row.iterator();
        java.util.Iterator<Integer> it2 = column.iterator();
        java.util.Iterator<Double> it3 = value.iterator();
        while(it1.hasNext()){
        	bw.write(it1.next()+" ");
        }
        bw.newLine();
        bw.newLine();
        while(it2.hasNext()){
        	bw.write(it2.next()+" ");
        }
        bw.newLine();
        bw.newLine();
        while(it3.hasNext()){
        	bw.write(it3.next()+" ");
        }
        bw.close();
	}

	private static void put(int a, int b, double c) {
		row.add(a);
		column.add(b);
		value.add(c);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NormalToCoo.change("normal", "coo");
	}

}
