package de.hpi.nlp;


import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesMultinomial;
import weka.classifiers.misc.InputMappedClassifier;
import weka.core.Instances;

public class Classification
{

    public static void main( String[] args )
    {
        Instances trainingdata = new LoadData("/training").getInstance();
        Instances testdata = new LoadData("/test").getInstance();

        try {
        InputMappedClassifier classifier =  new InputMappedClassifier();
        classifier.setClassifier(new NaiveBayes());

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
