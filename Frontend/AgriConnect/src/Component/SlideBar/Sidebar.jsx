import React from "react";
import { slide as Menu } from "react-burger-menu";
import { useNavigate } from "react-router-dom";
import "./Sidebar.css";
import style from "../../CSS/Navbar.module.css";
import AgriLogoC from "../../Images/AgriLogoC.jpg";

const Sidebar = ({ isOpen, toggleMenu }) => {
  const navigate = useNavigate();

  const selectOption = (option) => {
    if (option === 1) {
      navigate("/ShowProfile");
    } else if (option === 2) {
      navigate("/EditAddress");
    } else {
      navigate("/Orders");
    }
  };

  return (
    <Menu isOpen={isOpen} onStateChange={(state) => toggleMenu(state.isOpen)}>
      <img
        className="Logo"
        src={AgriLogoC}
        alt="webLogo"
        onClick={() => {
          navigate("/");
        }}
      />
      <div
        style={{
          display: "flex",
          gap: "30px",
          flexDirection: "column",
          marginRight: "65px",
        }}
      >
        <div>
          <button
            style={{
              width: "200px",
              height: "48px",
              backgroundColor: "rgb(232,168,80)",
              color: "rgb(46,80,53)",
              border: "none",
              fontWeight: 700,
              cursor: "pointer",
            }}
            onClick={() => selectOption(1)}
          >
            Show Profile
          </button>
        </div>
        <div>
          {" "}
          <button
            style={{
              width: "200px",
              height: "48px",
              backgroundColor: "rgb(232,168,80)",
              color: "rgb(46,80,53)",
              border: "none",
              fontWeight: 700,
              cursor: "pointer",
            }}
            onClick={() => selectOption(2)}
          >
            Edit Address
          </button>
        </div>

        <div>
          <button
            style={{
              width: "200px",
              height: "48px",
              backgroundColor: "rgb(232,168,80)",
              color: "rgb(46,80,53)",
              border: "none",
              fontWeight: 700,
              cursor: "pointer",
            }}
            onClick={() => selectOption(3)}
          >
            Your Orders
          </button>
        </div>
      </div>
      <div>
        <h6
          style={{
            textAlign: "center",
            color: "rgb(44,80,53)",
            marginTop: "120px",
          }}
        >
          {" "}
          AgriConnect © 2024. All Rights Reserved
        </h6>
      </div>
    </Menu>
  );
};

export default Sidebar;
