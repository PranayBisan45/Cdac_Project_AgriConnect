import React, { useState } from "react";
import Slider from "rc-slider";
import "rc-slider/assets/index.css";
import style from "../CSS/Plants.module.css";
const PriceRangeSlider = ({ minPrice, maxPrice, onRangeChange }) => {
  const [range, setRange] = useState([minPrice, maxPrice]);

  const handleSliderChange = (newRange) => {
    setRange(newRange);
    onRangeChange(newRange);
  };
  const trackStyle = {
    backgroundColor: "rgb(48,90,54)",
  };
  return (
    <div className={style.price_range_slider}>
      <Slider
        range
        min={minPrice}
        max={maxPrice}
        value={range}
        onChange={handleSliderChange}
        trackStyle={[trackStyle]}
      />
      <div className={style.price_range_values}>
        <button>Min: ₹{range[0]} </button>
        <button> Max: ₹{range[1]}</button>
      </div>
    </div>
  );
};

export default PriceRangeSlider;
