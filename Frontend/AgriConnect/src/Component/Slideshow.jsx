import React from "react";
import style from "../CSS/Home.module.css";
import { NavLink } from "react-router-dom";
const Slideshow = () => {
  return (
    <div id={style.displayPoster}>
      {/* <img src={Slideimg1} alt="image4" width={"100%"} height={"450px"} /> */}
      <NavLink to="/plant">
        <button>Shop Now</button>
      </NavLink>
    </div>
  );
};

export default Slideshow;
