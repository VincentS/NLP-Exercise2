package de.hpi.nlp;


import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instances;
import weka.classifiers.bayes.NaiveBayes;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class Classification
{

    public static void main( String[] args )
    {
        Instances trainingdata = new LoadData("/training").getInstance();
        Instances testdata = new LoadData("/test").getInstance();

        try {
        Classifier classifier =  new NaiveBayesUpdateable();

        classifier.buildClassifier(trainingdata);
        Evaluation eval = new Evaluation(trainingdata);
        eval.evaluateModel(classifier, testdata);
        System.out.println(eval.toSummaryString());
        System.out.println(eval.toClassDetailsString());
        System.out.println("Evaluation Concluded");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
