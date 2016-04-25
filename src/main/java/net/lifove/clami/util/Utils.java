package net.lifove.clami.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import com.google.common.primitives.Doubles;

import weka.core.Instances;

public class Utils {
	
	/**
	 * Load Instances from arff file. Last attribute will be set as class attribute
	 * @param path arff file path
	 * @return Instances
	 */
	public static Instances loadArff(String path,String classAttributeName){
		Instances instances=null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			instances = new Instances(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		instances.setClassIndex(instances.attribute(classAttributeName).index());

		return instances;
	}
	
	static public double getMedian(ArrayList<Double> values){
		return StatUtils.percentile(getDoublePrimitive(values),50);
	}
	
	public static double[] getDoublePrimitive(ArrayList<Double> values) {
		return Doubles.toArray(values);
	}

}
