import React from "react";
import style from "../CSS/Navbar.module.css";
import { FaSearch } from "react-icons/fa";
import { CiUser } from "react-icons/ci";
import { FaCartShopping } from "react-icons/fa6";
import { NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav id={style.navbar}>
      <section id={style.upperSection}>
        {/* <img src="AgriConnect-logos.jpeg" alt="webLogo" /> */}
        <img
          className={style.navImage}
          src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR7IX4u2CC61VqeUvaNEOj6zyXXJPRHbJa4g&usqp=CAU"
          alt="webLogo"
        />

        <div className={style.searchDiv}>
          <input
            className={style.searchInput}
            type="text"
            placeholder="What are you looking for?"
          />
          <button className={style.searchButton}>
            <FaSearch />
          </button>
        </div>

        <div className={style.searchDiv}>
          <CiUser size={30} />
          <button className={style.loginButton}>Login</button>
        </div>

        <div className={style.searchDiv}>
          <div className={style.buttonContainer}>
            {" "}
            <button className={style.quantity}>0</button>
            <button className={style.cartButton}>
              <FaCartShopping size={33} />
            </button>
          </div>
        </div>
      </section>

      <section id={style.belowSection}>
        <NavLink className={style.link} to="/">
          Home
        </NavLink>
        <NavLink className={style.link} to="/plant">
          Plants
        </NavLink>
        <NavLink className={style.link} to="/potplants">
          PotPlants
        </NavLink>
        <NavLink className={style.link} to="/seedbulbs">
          Seeds&Bulbs
        </NavLink>
        <NavLink className={style.link} to="/plantfood">
          PlantsFood
        </NavLink>
        <NavLink className={style.link} to="/artificialpants">
          ArtificialPlants
        </NavLink>
        <NavLink className={style.link} to="/pumpspray">
          Pump&Sprays
        </NavLink>
        <NavLink className={style.link} to="/plantcare">
          PlantCare
        </NavLink>
        <NavLink className={style.link} to="/aboutus">
          AboutUs
        </NavLink>
        <NavLink className={style.link} to="/contact">
          Contact
        </NavLink>
      </section>
    </nav>
  );
};

export default Navbar;
