package n2exercici1;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

public class LongitudEsIgualA extends FeatureMatcher<String, Integer> {

    public LongitudEsIgualA(Matcher<Integer> subMatcher, String featureDescription, String featureName) {
        super(subMatcher, featureDescription, featureName);
    }

    @Override
    protected Integer featureValueOf(String actual) {
        return actual.length();
    }
}
