import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import style from "../CSS/NewPassword.module.css";

const NewPassword = () => {
  const [newPassword, setNewPassword] = useState("");
  const [userId, setUserId] = useState("");
  const [response, setResponse] = useState(null);

  const navigate = useNavigate(); // Import useNavigate hook from 'react-router-dom'

  const handleUpdatePassword = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch(
        `http://localhost:8080/Update_Password?newPassword=${newPassword}&userId=${userId}`,
        {
          method: "GET",
        }
      );

      if (response.ok) {
        const responseData = await response.json();
        setResponse(responseData);
        if (responseData) {
          navigate("/login"); // Navigate to the "/login" page if response is true
        }
      } else {
        console.error("Failed to update password");
        setResponse(false);
      }
    } catch (error) {
      console.error("Error updating password:", error);
      setResponse(false);
    }
  };

  return (
    <div className={style.ParentNP}>
      <div
        style={{
          width: "300px",
          margin: "auto",
          padding: "20px",
          border: "1px solid #ccc",
          borderRadius: "5px",
          marginTop: "30px",
          marginBottom: "30px",
        }}
      >
        <h2>Update Password</h2>
        <form
          onSubmit={handleUpdatePassword}
          style={{ display: "flex", flexDirection: "column" }}
        >
          <label style={{ marginBottom: "10px" }}>
            New Password:
            <input
              type="password"
              pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&])[A-Za-z\d!@#$%^&]{8,}$"
              title="Password must contain at least one lowercase letter, one uppercase letter, one digit, one special character, and have a minimum length of 8 characters."
              required
              value={newPassword}
              onChange={(e) => setNewPassword(e.target.value)}
              style={{
                marginBottom: "10px",
                padding: "5px",
                border: "1px solid #ccc",
                borderRadius: "5px",
              }}
            />
          </label>
          <label style={{ marginBottom: "10px" }}>
            User ID:
            <input
              type="text"
              value={userId}
              onChange={(e) => setUserId(e.target.value)}
              style={{
                marginBottom: "10px",
                padding: "5px",
                border: "1px solid #ccc",
                borderRadius: "5px",
              }}
            />
          </label>
          <button
            type="submit"
            style={{
              padding: "10px",
              backgroundColor: "#007bff",
              color: "#fff",
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
              transition: "background-color 0.3s ease",
            }}
          >
            Update Password
          </button>
        </form>
        {response !== null && (
          <p>
            {response
              ? "Password updated successfully"
              : "Failed to update password. Please try again"}
          </p>
        )}
      </div>
    </div>
  );
};

export default NewPassword;
