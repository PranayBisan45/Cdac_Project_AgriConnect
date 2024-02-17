import React from 'react';
// import '../CSS/Login.css'; // Import your CSS file
import style from "../CSS/Login.css";
const Login = () => {
  return (
    <div className="container">
      <div className="screen">
        <div className="screen__content">
        <img src="/logo.png" alt="Logo" className="logo" />

<form className="login">
  <div className="login__field">
    <i className="login__icon fas fa-user"></i>
    <input type="text" className="login__input" placeholder="User ID" />
  </div>
  <div className="login__field">
    <i className="login__icon fas fa-lock"></i>
    <input type="password" className="login__input" placeholder="Password" />
  </div>
  <button className="button login__submit">
    <span className="button__text">Log In Now</span>
    <i className="button__icon fas fa-chevron-right"></i>
  </button>
</form>

<div className="additional-options">
  <a href="ForgotPassword" className="forgot-password">Forgot Password?</a>
  <span className="divider">|</span>
  New User? <a href="Register" className="register">Register</a>
</div>
</div>
        <div className="screen__background">
          <span className="screen__background__shape screen__background__shape4"></span>
          <span className="screen__background__shape screen__background__shape3"></span>
          <span className="screen__background__shape screen__background__shape2"></span>
          <span className="screen__background__shape screen__background__shape1"></span>
        </div>
      </div>
    </div>
  );
};

export default Login;
