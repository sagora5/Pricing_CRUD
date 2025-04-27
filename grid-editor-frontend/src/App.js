import React, {useEffect, useRef, useState} from "react";
import GridTable from "./components/GridTable";
import {fetchGridData, updateGrid} from "./services/gridService";


const App = () => {
  const [gridData, setGridData] = useState(null);

  useEffect(() => {
     loadGrid();
  }, []);

  useEffect(() => {
    if (gridData) {
      updateGrid(gridData).then(r => {
      });
    }
  }, [gridData]);

  const loadGrid = async () => {
    const data = await fetchGridData();
    setGridData(data);
  };


  return (
    <div className="app-container">
      <h1>Price Grid Editor</h1>
      {gridData && (
        <>
          <GridTable gridData={gridData} setGridData={setGridData} />
        </>
      )}
    </div>
  );
};

export default App;
