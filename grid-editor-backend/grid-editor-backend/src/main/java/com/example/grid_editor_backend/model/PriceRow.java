package com.example.grid_editor_backend.model;

import java.util.List;

public class PriceRow {
    private int height;
    private List<Double> values;

    public PriceRow() {}

    public PriceRow(int height, List<Double> values) {
        this.height = height;
        this.values = values;
    }

    // not used since we are setting static here and sending data from frontend
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
