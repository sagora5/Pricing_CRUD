import React, {useState} from "react";

const GridTable = ({gridData, setGridData}) => {
    const [editingCell, setEditingCell] = useState({rowIdx: null, colIdx: null});

    const handleCellChange = (rowIdx, colIdx, value) => {
        const updated = {...gridData};
        updated.prices[rowIdx].values[colIdx] = Number(value);
        setGridData(updated);
    };

    const handleCellClick = (rowIdx, colIdx) => {
        setEditingCell({rowIdx, colIdx});
    };

    const handleInputBlur = () => {
        setEditingCell({rowIdx: null, colIdx: null});
    };

    const handleAddColumn = () => {
        const newWidth = prompt("Enter new Width value:");
        if (newWidth) {
            const updated = {...gridData};
            updated.widths.push(Number(newWidth));
            updated.prices.forEach(row => {
                row.values.push(0);
            });
            autoSortColumns(updated);
            setGridData(updated);
        }
    };

    const handleAddRow = () => {
        const newHeight = prompt("Enter new Height value:");
        if (newHeight) {
            const updated = {...gridData};
            updated.heights.push(Number(newHeight));
            updated.prices.push({
                height: Number(newHeight),
                values: Array(updated.widths.length).fill(0),
            });
            autoSortRows(updated);
            setGridData(updated);
        }
    };

    const autoSortColumns = (updated) => {
        const widthWithIndex = updated.widths.map((w, idx) => ({width: w, idx}));
        widthWithIndex.sort((a, b) => a.width - b.width);
        const newWidths = widthWithIndex.map((w) => w.width);
        const columnOrder = widthWithIndex.map((w) => w.idx);

        updated.widths = newWidths;
        updated.prices.forEach((row) => {
            row.values = columnOrder.map((i) => row.values[i]);
        });
    };

    const autoSortRows = (updated) => {
        const pricesSorted = updated.prices.sort((a, b) => a.height - b.height);
        updated.prices = pricesSorted;
        updated.heights = pricesSorted.map((row) => row.height);
    };

    return (
        <div className="table-container">
            <div className="controls-top">
                <button onClick={handleAddColumn} className="add-btn">
                    ➕ Add Column
                </button>
            </div>
            <table className="pricing-table">
                <thead>
                <tr>
                    <th className="height-to-header" rowSpan="2" colSpan={2}>
                        WIDTH TO
                    </th>
                    {gridData.widths.map((width, idx) => (
                        <th key={idx} className="width-header">{width}"</th>
                    ))}
                </tr>
                </thead>
                <tbody>
                <th className="height-to-header" colSpan={1} rowSpan={gridData.prices.length + 1}>
                    <div className="vertical-text">HEIGHT TO</div>
                </th>
                {gridData.prices.map((row, rowIdx) => (
                    <tr key={rowIdx}>
                        <th className="height-header">{row.height}""</th>
                        {row.values.map((price, colIdx) => (
                            <td
                                key={colIdx}
                                onClick={() => handleCellClick(rowIdx, colIdx)}
                                className="price-cell"
                            >
                                {editingCell.rowIdx === rowIdx && editingCell.colIdx === colIdx ? (
                                    <input
                                        type="number"
                                        value={price}
                                        autoFocus
                                        onChange={(e) => handleCellChange(rowIdx, colIdx, e.target.value)}
                                        onBlur={handleInputBlur}
                                        onKeyDown={(e) => {
                                            if (e.key === "Enter") handleInputBlur();
                                        }}
                                        style={{
                                            width: "50px",
                                            padding: "2px",
                                            fontSize: "14px",
                                        }}
                                    />
                                ) : (
                                    `$${price}`
                                )}
                            </td>
                        ))}
                    </tr>
                ))}
                </tbody>
            </table>
            <div className="controls-bottom">
                <button onClick={handleAddRow} className="add-btn">
                    ➕ Add Row
                </button>
            </div>
        </div>
    );
};

export default GridTable;
