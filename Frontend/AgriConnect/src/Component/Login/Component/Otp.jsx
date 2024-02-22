import React, { useState } from "react";
import { useNavigate } from "react-router";
import style from "../CSS/Otp.module.css";
const Otp = () => {
  let [state, setState] = useState({
    num1: "",
    num2: "",
    num3: "",
    num4: "",
    num5: "",
    num6: "",
  });
  let navigate = useNavigate();

  const handleChange = (e) => {
    const { value, name } = e.target;
    setState((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    let ans =
      state.num1 +
      state.num2 +
      state.num3 +
      state.num4 +
      state.num5 +
      state.num6;
    console.log(ans);
    console.log(typeof ans);
    console.log(state);

    var data = await fetch(`http://localhost:8080/Verify_Otp?OTP=${ans}`);
    var response = await data.json();
    console.log(response);
    if (response) {
      navigate("/newpassword");
    }
    setState({
      num1: " ",
      num2: " ",
      num3: " ",
      num4: " ",
      num5: " ",
      num6: " ",
    });
  };

  return (
    <div className={style.ParentOtp}>
      <div
        className={style.ChildOtp}
        style={{
          height: "300px",
          width: "450px",

          textAlign: "center",
        }}
      >
        <h1 style={{ color: "white", marginTop: "100px" }}>OTP</h1>
        <form onSubmit={handleSubmit}>
          <div
            style={{
              display: "flex",
              gap: "20px",
              justifyContent: "center",
              marginTop: "30px",
            }}
          >
            <input
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              name="num1"
              onChange={handleChange}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
            <input
              name="num2"
              onChange={handleChange}
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
            <input
              name="num3"
              onChange={handleChange}
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
            <input
              name="num4"
              onChange={handleChange}
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
            <input
              name="num5"
              onChange={handleChange}
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
            <input
              name="num6"
              onChange={handleChange}
              style={{
                height: "40px",
                width: "40px",
                borde: "none",
                borderRadius: "5px",
                boxshadow:
                  "rgba(50, 50, 93, 0.25) 0px 6px 12px -2px, rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;",
              }}
              type="text"
              minLength={1}
              maxLength={1}
              required
            />
          </div>
          <button
            style={{
              marginTop: "60px",
              width: "60%",
              height: "40px",
              cursor: "pointer",
              color: "rgb(116,193,20)",
              boxshadow:
                "rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px",
              borderradius: "5px",
              backgroundColor: "white",
              borderRadius: "10px",
            }}
          >
            Submit
          </button>
        </form>
      </div>
    </div>
  );
};

export default Otp;
