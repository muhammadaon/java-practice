import java.util.Arrays;

public class SentimentAnalyzer {
    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length]; // output

        int value = 0;

        review = review.toLowerCase();

        for (int i =0; i < featureSet.length; i++){
            for (int j=0; j < featureSet[i].length; j++){


                        value = getOpinionOnFeature(review, featureSet[i][j], posOpinionWords, negOpinionWords);

                        if (value != 0 ){
                            featureOpinions[i] = value;
                            continue;
                        }

            }
        }

        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int opinionValue =0;
        opinionValue = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if (opinionValue == 0){
            opinionValue = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }

        return opinionValue;
    }

    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        String[] sentences = review.split("\\.");

        for (String sentence: sentences) {

            if (sentence.contains(pattern)) {

                // check positive opinion in the sentence
                for (String posOpinion : posOpinionWords) {
                    if (sentence.contains(posOpinion)) {
                        opinion = 1;
                    }
                }

                // check negative opinion in the sentence
                for (String negOpinion : negOpinionWords) {
                    if (sentence.contains(negOpinion)) {
                        opinion = -1;
                    }
                }

            }
        }

        return opinion;
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        String[] sentences2 = review.split("\\.");
        int opinion2 = 0;

        for (String sentence: sentences2 ){

            if (sentence.contains(feature)){

                // check positive opinion in the sentence
                for (String posOpinion: posOpinionWords){
                    if (sentence.contains(posOpinion)){
                        opinion2 = 1;
                    }
                }

                // check negative opinion in the sentence
                for (String negOpinion: negOpinionWords){
                    if (sentence.contains(negOpinion)){
                        opinion2 = -1;
                    }
                }

            }

        }

        return opinion2;
    }

    public static void main(String[] args) {
//        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome", "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}