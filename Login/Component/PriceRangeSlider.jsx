import React, { useState } from 'react';
import Slider from 'rc-slider';
import 'rc-slider/assets/index.css';

const PriceRangeSlider = ({ minPrice, maxPrice, onRangeChange }) => {
  const [range, setRange] = useState([minPrice, maxPrice]);

  const handleSliderChange = (newRange) => {
    setRange(newRange);
    onRangeChange(newRange);
  };

  return (
    <div className="price-range-slider">
      <Slider
        range
        min={minPrice}
        max={maxPrice}
        value={range}
        onChange={handleSliderChange}
      />
      <div className="price-range-values">
        <span>Min: ₹{range[0]} </span>
        <span> Max: ₹{range[1]}</span>
      </div>
    </div>
  );
};

export default PriceRangeSlider;
