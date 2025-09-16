package com.joit.tab.dtos;

public class CalculationResponse {

    private String result;

    public CalculationResponse (double result) {
        if (result == (long) result) {
            this.result = String.valueOf((long) result);
        } else {
            this.result = String.valueOf(result);
        }
    }

    public String getResult () {
        return result;
    }
}
