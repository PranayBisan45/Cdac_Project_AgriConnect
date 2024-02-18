import React, { useState } from 'react';
import PriceRangeSlider from './PriceRangeSlider';

const PriceRangeSlider2 = () => {
  const [minPrice, setMinPrice] = useState(0);
  const [maxPrice, setMaxPrice] = useState(100000);

  const handleRangeChange = (newRange) => {
    setMinPrice(newRange[0]);
    setMaxPrice(newRange[1]);
  };

  return (
    <div>
      <h1>AgriConnect</h1>
      <PriceRangeSlider
        minPrice={0}
        maxPrice={100000}
        onRangeChange={handleRangeChange}
      />
      {/* Other components of your shopping portal */}
    </div>
  );
};

export default PriceRangeSlider2;
