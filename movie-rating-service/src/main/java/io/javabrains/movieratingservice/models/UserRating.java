package io.javabrains.movieratingservice.models;

import java.util.Arrays;
import java.util.List;

public class UserRating {
    //external api
    private String userId;
    private List<Rating> userRating;



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
    public void initData(String userId) {
        this.setUserId(userId);
        this.setUserRating(Arrays.asList(
                new Rating("550", 3),
                new Rating("200", 4)
        ));
    }
}
