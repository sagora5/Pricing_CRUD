package com.example.grid_editor_backend.controller;

import com.example.grid_editor_backend.model.PriceGrid;
import com.example.grid_editor_backend.service.GridService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prices")
public class GridController {

    private final GridService gridService;

    public GridController(GridService gridService) {
        this.gridService = gridService;
    }

    @GetMapping
    public PriceGrid getGrid() {
        return gridService.getPriceGrid();
    }

    @PutMapping("/update-grid")
    public void updateGrid(@RequestBody PriceGrid updatedGrid) {
        gridService.updatePriceGrid(updatedGrid);
    }

}
