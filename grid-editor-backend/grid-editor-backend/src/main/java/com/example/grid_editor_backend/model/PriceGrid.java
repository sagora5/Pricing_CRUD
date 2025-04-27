package com.example.grid_editor_backend.model;

import java.util.List;

public class PriceGrid {
    private List<Integer> widths;
    private List<Integer> heights;
    private List<PriceRow> prices;

    public PriceGrid() {}

    public PriceGrid(List<Integer> widths, List<Integer> heights, List<PriceRow> prices) {
        this.widths = widths;
        this.heights = heights;
        this.prices = prices;
    }

    // not used since we are setting static here and sending data from frontend
    public List<Integer> getWidths() {
        return widths;
    }

    public void setWidths(List<Integer> widths) {
        this.widths = widths;
    }

    public List<Integer> getHeights() {
        return heights;
    }

    public void setHeights(List<Integer> heights) {
        this.heights = heights;
    }

    public List<PriceRow> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceRow> prices) {
        this.prices = prices;
    }
}
