import React, { useContext, useState } from "react";
import style from "../CSS/Login.module.css";
import { FaUserCircle } from "react-icons/fa";
import { NavLink, useSearchParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { ContextApi } from "../../../Context/AgriConnectContext";

const Login = () => {
  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });
  let [invalid, setInvalid] = useState(false);
  let { auth, setAuth } = useContext(ContextApi);
  let navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    var data = await fetch(
      `http://localhost:8080/Login?UseriD=${formData.username}&Upass=${formData.password}`
    );
    var response = await data.json();
    console.log(response);
    console.log(formData);
    if (response) {
      localStorage.setItem("userid", formData.username);
      navigate("/");
      setAuth(true);
    } else {
      setAuth(false);
      setInvalid(true);
      setTimeout(() => {
        setInvalid(false);
      }, 3000);
    }

    console.log(auth);
    setFormData({
      username: "",
      password: "",
    });
  };

  return (
    <div className={style.ParentLogin}>
      <div className={style.LoginContainer}>
        <FaUserCircle size={"40px"} />
        <h1 style={{ marginTop: "5px", marginBottom: "10px" }}>LOGIN</h1>
        <div className={style.formContainer}>
          <form onSubmit={handleSubmit}>
            <div className={style.inputLabel}>
              <label for="user_id"> User ID:</label>
              <input
                type="text"
                id="user_id"
                name="username"
                required
                placeholder="User Id"
                value={formData.username}
                onChange={handleChange}
              />
            </div>
            <div className={style.inputLabel}>
              <label for="password">Password:</label>
              <input
                type="password"
                id="password"
                name="password"
                pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&])[A-Za-z\d!@#$%^&]{8,}$"
                title="Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and have a minimum length of 8 characters."
                required
                placeholder="Password"
                value={formData.password}
                onChange={handleChange}
              />
            </div>
            <button>Submit</button>
          </form>
          {invalid ? (
            <h4 style={{ color: "red", textAlign: "center" }}>
              Invalid Crendential
            </h4>
          ) : (
            ""
          )}
        </div>
        <div className={style.Link}>
          <div>
            <NavLink to="/registration">Registration</NavLink>
          </div>
          <div>
            <NavLink to="/forgotpassword">Forget Password</NavLink>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
