public class IRUtil {

    /**
     *
     * @param term
     * @param doc
     * @return
     */

    public static int getFrequencyCount(String term, String doc) {
        term = term.toLowerCase(); // step 1
        doc = doc.toLowerCase(); // step 1

        int frequencyCount = 0; // step 2

        int index = doc.indexOf(term); // step 3

        while (index >= 0) { // step 4
            frequencyCount++; // step 5
            doc = doc.substring(index + term.length()); // step 6
            index = doc.indexOf(term); // step 7
        }

        return frequencyCount;
    }

    public static double termFrequency(String term, String doc) {
        int frequencyCount = getFrequencyCount(term, doc); // step 1
        int totalTermCount = doc.split(" ").length; // step 2

        System.out.println("\nFinding term frequency for " + term);
        System.out.println(frequencyCount);
        System.out.println(totalTermCount);

        return (double) frequencyCount/totalTermCount; // step 3
    }

    public static void main(String[] args) {
        String doc = "Every time there is a new COVID wave, a few medicines become popular. The desperation to save family members or avoid severe forms of the infection makes hapless people opt for the ‘promising’ drugs. Currently, people are made aware of one such drug called ‘Monoclonal Antibodies Cocktail’, which costs around ₹60,000. However, several doctors from Telangana have underscored that the antibodies cocktail, available in India, are not effective against the Omicron variant. They have also stressed that 93% to 95% of the current COVID cases are of Omicron variant. Even if it is Delta variant, the drug cocktail has to be given within seven days of onset of the infection, and it is ineffective if the patient is in a severe stage of infection. Doctors said Remdesivir is suggested for patients with Omicron, after examining infection severity, presence of co-morbidities, immunity levels, and other factors.";

        System.out.println(termFrequency("infection", doc));
        System.out.println(termFrequency("covid", doc));
    }
}