import React, { useState } from "react";
import style from "../CSS/Registration.module.css";
const Registration = () => {
  const [formData, setFormData] = useState({
    Firstname: "",
    Lastname: "",
    EMailid: "",
    Address: "",
    Pincode: "",
    State: "",
    Gender: "",
    WhatsApp_Number: "",
    UserPassword: "",
  });
  const [warning, setWarning] = useState(false);
  const [userId, setUserId] = useState("");
  const [error, setError] = useState("");
  const [mob, setMob] = useState(0);
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
    setMob(formData.WhatsApp_Number);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const formBody = Object.keys(formData)
      .map(
        (key) =>
          encodeURIComponent(key) + "=" + encodeURIComponent(formData[key])
      )
      .join("&");

    fetch("http://localhost:8080/upload", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: formBody,
    })
      .then((response) => response.text())
      .then((data) => {
        if (data.startsWith("Registration_Failed")) {
          setError(data);
          setUserId("");
          setWarning(true);
          setTimeout(() => {
            setWarning(false);
          }, 2000);
        } else {
          setError("");
          setUserId(data);

          // myFunction(data, mob);
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        setError("An error occurred while processing your request.");
        setUserId("");
      });
    setFormData({
      Firstname: "",
      Lastname: "",
      EMailid: "",
      Address: "",
      Pincode: "",
      State: "",
      Gender: "",
      WhatsApp_Number: "",
      UserPassword: "",
    });
  };

  return (
    <div className={style.ParentReg}>
      <div className={style.LoginContainer}>
        <h1>Registration</h1>
        <form onSubmit={handleSubmit} className={style.formContainer}>
          <div className={style.inputLabel}>
            <label for="firstname">First Name:</label>
            <input
              value={formData.Firstname}
              onChange={handleChange}
              type="text"
              id="firstname"
              required
              name="Firstname"
              pattern="^[A-Z][a-zA-Z]+$"
              title="Name must begin with upperCase letter"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="lastname">Last Name:</label>
            <input
              value={formData.Lastname}
              onChange={handleChange}
              type="text"
              id="lastname"
              required
              name="Lastname"
              pattern="^[A-Z][a-zA-Z]+$"
              title="Name must begin with upperCase letter"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="email">EmailId:</label>
            <input
              value={formData.EMailid}
              onChange={handleChange}
              type="email"
              id="email"
              required
              name="EMailid"
              pattern="^[^@]+@(gmail|yahoo)\.com$"
              title="Please enter valid email"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="address">Address:</label>
            <input
              value={formData.Address}
              onChange={handleChange}
              type="text"
              id="address"
              required
              name="Address"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="pincode">PinCode:</label>
            <input
              value={formData.Pincode}
              onChange={handleChange}
              type="text"
              id="pincode"
              required
              name="Pincode"
              pattern="^[1-9][0-9]{5}$"
              title="Enter a valid 6 digit pincode"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="state">State:</label>
            <input
              type="text"
              id="state"
              required
              name="State"
              value={formData.State}
              onChange={handleChange}
            />
          </div>
          <div className={style.inputLabel}>
            <label for="gender">Select Gender:</label>
            <select
              name="Gender"
              value={formData.Gender}
              onChange={handleChange}
            >
              Select Gender :
              <option value="select gender"> Select Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>
          </div>
          <div className={style.inputLabel}>
            <label for="WhatsAppNumber">WhatsAppNumber:</label>
            <input
              name="WhatsApp_Number"
              value={formData.WhatsApp_Number}
              onChange={handleChange}
              type="number"
              id="WhatsAppNumber"
              required
              pattern="^[6-9]\d{9}$"
              title="Please enter a valid indian mobile number"
            />
          </div>
          <div className={style.inputLabel}>
            <label for="password">Password:</label>
            <input
              name="UserPassword"
              value={formData.UserPassword}
              onChange={handleChange}
              type="password"
              id="password"
              pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&])[A-Za-z\d!@#$%^&]{8,}$"
              title="Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and have a minimum length of 8 characters."
              required
              placeholder="Password"
            />
          </div>
          <button>Register</button>
        </form>
        <div>
          {warning ? error && <p>{error}</p> : ""}
          {userId && <p>User ID: {userId}</p>}
        </div>
      </div>
    </div>
  );
};

export default Registration;
