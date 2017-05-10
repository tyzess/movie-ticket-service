package com.zuehlke;

/**
 * Created by urzy on 10.05.2017.
 */
public class Rating {
    private final String source;
    private final String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public static Rating from(RatingResponse ratingResponse) {
        return new Rating(ratingResponse.getSource(), ratingResponse.getValue());
    }

    public String getValue() {
        return value;
    }

    public String getSource() {
        return source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (!source.equals(rating.source)) return false;
        return value.equals(rating.value);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
