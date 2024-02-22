import React, { useState, useContext } from "react";
import { myFunction } from "./Sendotp";
import { NavLink, useNavigate } from "react-router-dom";
import { ContextApi } from "../../../Context/AgriConnectContext";
import style from "../CSS/ForgetPassword.module.css";
const ForgetPassword = () => {
  let [state, setState] = useState({ contact: "", userid: "" });
  let { useDetail, setUserDetail } = useContext(ContextApi);

  const navigate = useNavigate();
  const handleChange = (e) => {
    const { name, value } = e.target;
    setState((prevState) => ({
      ...prevState,
      [name]: value,
    }));
    setUserDetail({ mobileno: state.contact, userid: state.userid });
  };
  const handleSubmit = async (e) => {
    e.preventDefault();
    e.preventDefault();
    const { contact, userid } = state;
    setUserDetail({ mobileno: contact, userid });
    try {
      await myFunction(contact, userid);
      setState({ contact: "", userid: "" });
      navigate("/otp");
    } catch (error) {
      console.error("Error in handleSubmit:", error);
    }
  };
  return (
    <div className={style.ParentFor}>
      <div className={style.LoginContainer}>
        <div className={style.formContainer}>
          <h1
            style={{
              marginTop: "5px",
              marginBottom: "20px",
              color: "rgb(48,90,54)",
            }}
          >
            Forget Password
          </h1>
          <form onSubmit={handleSubmit}>
            <div className={style.inputLabel}>
              <label for="mobile"> Mobile:</label>
              <input
                id="mobile"
                type="number"
                placeholder="mobile"
                onChange={handleChange}
                name="contact"
              />
            </div>
            <div className={style.inputLabel}>
              <label>User ID:</label>
              <input
                type="text"
                placeholder="user Id"
                onChange={handleChange}
                name="userid"
              />
            </div>
            <button>Send OTP</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default ForgetPassword;
