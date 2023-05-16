package com.adriancasantos.acetime.data.model;

import androidx.annotation.Nullable;

public class Marcador {

    @Nullable
    public String home_set1;
    @Nullable
    public String home_set2;
    @Nullable
    public String home_set3;
    @Nullable
    public String home_set4;
    @Nullable
    public String home_set5;
    @Nullable
    public String away_set1;
    @Nullable
    public String away_set2;
    @Nullable
    public String away_set3;
    @Nullable
    public String away_set4;
    @Nullable
    public String away_set5;

    @Nullable
    public String result_description;

    public Marcador(@Nullable String home_set1, @Nullable String home_set2,
            @Nullable String home_set3,
            @Nullable String home_set4, @Nullable String home_set5, @Nullable String away_set1,
            @Nullable String away_set2, @Nullable String away_set3, @Nullable String away_set4,
            @Nullable String away_set5, @Nullable String result_description) {
        this.home_set1 = home_set1;
        this.home_set2 = home_set2;
        this.home_set3 = home_set3;
        this.home_set4 = home_set4;
        this.home_set5 = home_set5;
        this.away_set1 = away_set1;
        this.away_set2 = away_set2;
        this.away_set3 = away_set3;
        this.away_set4 = away_set4;
        this.away_set5 = away_set5;
        this.result_description = result_description;
    }

    @Nullable
    public String getHome_set1() {
        return home_set1;
    }

    public void setHome_set1(@Nullable String home_set1) {
        this.home_set1 = home_set1;
    }

    @Nullable
    public String getHome_set2() {
        return home_set2;
    }

    public void setHome_set2(@Nullable String home_set2) {
        this.home_set2 = home_set2;
    }

    @Nullable
    public String getHome_set3() {
        return home_set3;
    }

    public void setHome_set3(@Nullable String home_set3) {
        this.home_set3 = home_set3;
    }

    @Nullable
    public String getHome_set4() {
        return home_set4;
    }

    public void setHome_set4(@Nullable String home_set4) {
        this.home_set4 = home_set4;
    }

    @Nullable
    public String getHome_set5() {
        return home_set5;
    }

    public void setHome_set5(@Nullable String home_set5) {
        this.home_set5 = home_set5;
    }

    @Nullable
    public String getAway_set1() {
        return away_set1;
    }

    public void setAway_set1(@Nullable String away_set1) {
        this.away_set1 = away_set1;
    }

    @Nullable
    public String getAway_set2() {
        return away_set2;
    }

    public void setAway_set2(@Nullable String away_set2) {
        this.away_set2 = away_set2;
    }

    @Nullable
    public String getAway_set3() {
        return away_set3;
    }

    public void setAway_set3(@Nullable String away_set3) {
        this.away_set3 = away_set3;
    }

    @Nullable
    public String getAway_set4() {
        return away_set4;
    }

    public void setAway_set4(@Nullable String away_set4) {
        this.away_set4 = away_set4;
    }

    @Nullable
    public String getAway_set5() {
        return away_set5;
    }

    public void setAway_set5(@Nullable String away_set5) {
        this.away_set5 = away_set5;
    }

    @Nullable
    public String getResult_description() {
        return result_description;
    }

    public void setResult_description(@Nullable String result_description) {
        this.result_description = result_description;
    }
}
