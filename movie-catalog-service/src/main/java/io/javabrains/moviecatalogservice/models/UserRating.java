package io.javabrains.moviecatalogservice.models;

import java.util.List;
import java.util.Arrays;

public class UserRating {

    private List<Rating> userRating;
    //external api
    private String userId;




    public List<Rating> getUserRating() {

        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {

        this.userRating = userRating;
    }
    //external api
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
