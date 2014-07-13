package de.hpi.nlp;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.TextDirectoryLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LoadData {

    TextDirectoryLoader text;
    String directoryname;

    public LoadData (String directory) {
        this.text = new TextDirectoryLoader();
        this.directoryname = directory;

    }


    public void getDirectoryName ()  {
        try {

            URL resource = getClass().getResource(directoryname);
            text.setDirectory( new File(resource.toURI()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Instances FilterData (Instances unfiltered_instance) {

        try {
            StringToWordVector filter = new StringToWordVector();
            filter.setInputFormat(unfiltered_instance);
            Instances filtered_instance = Filter.useFilter(unfiltered_instance, filter);
            return filtered_instance;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Instances getInstance ()  {

    try {
        getDirectoryName();
        Instances unfiltered_instance = text.getDataSet();
        Instances filtered_instance = FilterData(unfiltered_instance);
        System.out.println("Read and filtered data from folder:" + directoryname);

        return filtered_instance;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;

    }





}
