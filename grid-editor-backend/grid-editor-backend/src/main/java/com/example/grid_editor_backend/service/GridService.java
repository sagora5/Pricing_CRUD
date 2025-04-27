package com.example.grid_editor_backend.service;

import com.example.grid_editor_backend.model.PriceGrid;
import com.example.grid_editor_backend.model.PriceRow;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GridService {

    private PriceGrid priceGrid;

    public GridService() {
        this.priceGrid = new PriceGrid(
                Arrays.asList(24, 30, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144, 156, 168, 174), // Widths
                Arrays.asList(36, 48, 60, 72, 84, 96, 108, 120, 132, 144),         // Heights
                Arrays.asList(
                        new PriceRow(36, Arrays.asList(239.0, 269.0, 307.0, 377.0, 450.0, 517.0, 594.0, 664.0, 735.0, 810.0, 877.0, 946.0, 1017.0, 1121.0, 1143.0)),
                        new PriceRow(48, Arrays.asList(272.0, 312.0, 357.0, 447.0, 536.0, 621.0, 711.0, 868.0, 883.0, 1055.0, 1060.0, 1230.0, 1236.0, 1365.0, 1393.0)),
                        new PriceRow(60, Arrays.asList(310.0, 359.0, 415.0, 514.0, 621.0, 732.0, 840.0, 1030.0, 1055.0, 1260.0, 1266.0, 1471.0, 1478.0, 1632.0, 1666.0)),
                        new PriceRow(72, Arrays.asList(344.0, 406.0, 467.0, 584.0, 701.0, 846.0, 967.0, 1184.0, 1216.0, 1451.0, 1461.0, 1698.0, 1703.0, 1886.0, 1923.0)),
                        new PriceRow(84, Arrays.asList(381.0, 450.0, 516.0, 662.0, 795.0, 954.0, 1095.0, 1347.0, 1388.0, 1660.0, 1669.0, 1948.0, 1956.0, 2169.0, 2212.0)),
                        new PriceRow(96, Arrays.asList(418.0, 496.0, 577.0, 735.0, 892.0, 1064.0, 1227.0, 1513.0, 1553.0, 1867.0, 1888.0, 2197.0, 2211.0, 2449.0, 2499.0)),
                        new PriceRow(108, Arrays.asList(455.0, 542.0, 626.0, 809.0, 987.0, 1163.0, 1344.0, 1658.0, 1704.0, 2049.0, 2070.0, 2413.0, 2428.0, 2694.0, 2748.0)),
                        new PriceRow(120, Arrays.asList(492.0, 586.0, 683.0, 887.0, 1083.0, 1276.0, 1484.0, 1830.0, 1876.0, 2277.0, 2288.0, 2673.0, 2683.0, 2981.0, 3041.0)),
                        new PriceRow(132, Arrays.asList(530.0, 674.0, 794.0, 1035.0, 1268.0, 1509.0, 1745.0, 1997.0, 2210.0, 2486.0, 2692.0, 2963.0, 3167.0, 3504.0, 3521.0)),
                        new PriceRow(144, Arrays.asList(562.0, 675.0, 795.0, 1038.0, 1272.0, 1513.0, 1750.0, 2162.0, 2218.0, 2686.0, 2701.0, 3161.0, 3177.0, 3520.0, 3526.0))
                )
        );
    }

    public PriceGrid getPriceGrid() {
        return priceGrid;
    }

    public void updatePriceGrid(PriceGrid updatedGrid) {
        this.priceGrid = updatedGrid;
    }
}
