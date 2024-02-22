import React, { useContext, useState, useEffect } from "react";
import style from "../CSS/Navbar.module.css";
import { FaSearch } from "react-icons/fa";
import { FaUserCircle } from "react-icons/fa"; // Changed from CiUser
import { FaShoppingCart } from "react-icons/fa"; // Changed from FaCartShopping
import { NavLink } from "react-router-dom";
import { ContextApi } from "../Context/AgriConnectContext";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { IoOptionsOutline } from "react-icons/io5";
import AgriLogoC from "../Images/AgriLogoC.jpg";
import Sidebar from "./SlideBar/Sidebar";

const Navbar = () => {
  const [state, setState] = useState("");
  const [search, setSearch] = useState("");
  const [showSidebar, setShowSidebar] = useState(false);

  const { cart } = useContext(ContextApi);
  const { auth, setAuth } = useContext(ContextApi);
  const navigate = useNavigate();

  const handleClick = async () => {
    // try {
    //   const response = await fetch(
    //     `http://localhost:8080/Search?ItemName=${state}`
    //   );
    //   if (!response.ok) {
    //     throw new Error("Network response was not ok");
    //   }
    //   const data = await response.json();
    //   const { pid } = data;
    //   navigate(`/plant/${pid}`);
    // } catch (error) {
    //   console.error("Error fetching data:", error);
    //   // Handle the error, e.g., show a message to the user
    // }
    if (state.length <= 10) {
      // navigate("/");
      setSearch("Invalid Search");
      setTimeout(() => {
        setSearch("");
      }, 2000);
    } else {
      navigate("/plant");
    }
  };

  useEffect(() => {
    console.log(auth);
  }, [auth]);

  const handleLogout = async () => {
    try {
      const response = await axios.get("http://localhost:8080/Logout");
      console.log(response.data);
      setAuth(false);
      navigate("/");
    } catch (error) {
      console.error("Error logging out:", error);
    }
  };

  const selectOption = (option) => {
    switch (option) {
      case 1:
        navigate("/ShowProfile");
        break;
      case 2:
        navigate("/EditAddress");
        break;
      case 3:
        navigate("/Orders");
        break;
      default:
        navigate("/");
    }
  };

  const toggleSidebar = (isOpen) => {
    setShowSidebar(isOpen);
    console.log(isOpen);
  };

  return (
    <div id={style.navbar}>
      {auth && <Sidebar isOpen={showSidebar} toggleMenu={toggleSidebar} />}
      <div style={{ display: "flex", gap: "50px" }}>
        <img
          className={style.navImage}
          src={AgriLogoC}
          alt="webLogo"
          onClick={() => {
            navigate("/");
          }}
        />
        <div style={{ display: "flex", flexDirection: "column" }}>
          <div className={style.searchDiv}>
            <input
              onChange={(e) => {
                setState(e.target.value);
              }}
              className={style.searchInput}
              type="text"
              placeholder="What are you looking for?"
              list="title"
            />
            <button className={style.searchButton} onClick={handleClick}>
              <FaSearch />
            </button>
          </div>
          <h5 style={{ color: "red", textAlign: "center" }}>{search}</h5>
          <div id={style.belowSection}>
            <NavLink className={style.link} to="/">
              Home
            </NavLink>
            <NavLink className={style.link} to="/plant">
              Plants
            </NavLink>
            <NavLink className={style.link} to="/potplants">
              PotPlants
            </NavLink>
            <NavLink className={style.link} to="/plantfood">
              PlantsFood
            </NavLink>
            <NavLink className={style.link} to="/pumpspray">
              PumpSprays
            </NavLink>
            <NavLink className={style.link} to="/contact">
              Contact
            </NavLink>
            <NavLink className={style.link} to="/aboutus">
              AboutUs
            </NavLink>
          </div>
        </div>

        <div>
          {auth ? (
            <button className={style.loginButton} onClick={handleLogout}>
              Logout
            </button>
          ) : (
            <NavLink to="/login">
              <button className={style.loginButton}>Login</button>
            </NavLink>
          )}
        </div>
        <div style={{ marginTop: "11px", marginLeft: "5px" }}>
          <div className={style.searchDiv}>
            <div className={style.buttonContainer}>
              <button className={style.quantity}>{cart.length}</button>
              <NavLink to="/cart">
                <button className={style.cartButton}>
                  <FaShoppingCart size={33} />
                </button>
              </NavLink>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
