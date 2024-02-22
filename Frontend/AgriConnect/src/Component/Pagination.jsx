import React, { useState } from "react";
import { TbPlayerTrackNextFilled } from "react-icons/tb";
import { TbPlayerTrackPrevFilled } from "react-icons/tb";
import style from "../CSS/Pagination.module.css";

const Pagination = ({ HandleIncrement, HandleDecrement, page }) => {
  return (
    <div id={style.Pagination}>
      <button onClick={HandleDecrement} disabled={page <= 1}>
        <TbPlayerTrackPrevFilled color="rgb(48,90,54)" />
      </button>
      {/* <button>{page}</button> */}
      <button onClick={HandleIncrement} disabled={page == 8}>
        <TbPlayerTrackNextFilled color="rgb(48,90,54)" />
      </button>
    </div>
  );
};

export default Pagination;
