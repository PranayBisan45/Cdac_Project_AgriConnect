import React, { useState } from "react";
import Slider from "rc-slider";

const PriceSlider = () => {
  const [priceRange, setPriceRange] = useState([100, 10000]);

  const handlePriceChange = (value) => {
    setPriceRange(value);
  };

  return (
    <div style={{ margin: "20px" }}>
      <h3>Price Range:</h3>
      <Slider.Range
        min={100}
        max={10000}
        defaultValue={[100, 10000]}
        value={priceRange}
        onChange={handlePriceChange}
      />
      <div style={{ marginTop: "10px" }}>
        ${priceRange[0]} - ${priceRange[1]}
      </div>
    </div>
  );
};

export default PriceSlider;
