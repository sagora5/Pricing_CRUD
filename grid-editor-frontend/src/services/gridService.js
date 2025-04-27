import axios from "axios";

export const fetchGridData = async () => {
  const response = await axios.get("http://localhost:8080/api/prices");
  return response.data;
};

export async function updateGrid(priceGrid) {
  try {
    const response = await axios.put('http://localhost:8080/api/prices/update-grid', priceGrid);
  } catch (error) {
    console.error('Error updating grid:', error);
  }
}
