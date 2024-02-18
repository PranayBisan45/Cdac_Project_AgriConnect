// import React, { useState } from 'react';
// import style from "../CSS/ForgotPassword.css";
// import { noConflict } from 'jquery';

// const ForgotPassword = () => {
//   const [Wno, setWno] = useState('');
//   const [Uid, setUid] = useState('');

//   const handleWnoChange = (e) => {
//     setWno(e.target.value);
//   };
//   const handleUidChange = (e) => {
//     setUid(e.target.value);
//   };

//   const handleResetPassword = () => {
//     // Add logic to handle password reset
//     console.log(`Reset password for Wno: ${Wno}`);
//   };

//   return (
//     <div className="card text-center" style={{ width: '450px', height:'580px' ,opacity: 0.88 }}>
//       <div className="card-header h5 text-white bg-green">Send OTP</div>
//       <div className="card-body px-5">
//         <p className="card-text py-2">
//           Enter your Whatsapp Number and User Id and we'll send you an OTP to reset your password.
//         </p>
//         <div className="form-outline">
//          <span><b>Whatsapp No.:</b></span> <input
//             type="text"
//             id="number"
//             className="form-control my-3"
//             value={Wno}
//             onChange={handleWnoChange}
//           />
//         <span><b> User Id: </b></span><input
//             type="text"
//             id="uid"
//             className="form-control my-3"
//             value={Uid}
//             onChange={handleUidChange}
//           />
//         </div>
//         <button className="btn btn-green w-100" onClick={handleResetPassword}>
//           Send OTP
//         </button>
//         <div className="d-flex justify-content-between mt-4">
//           <a href="Login">Login</a>
//           <a href="Register">Register</a>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default ForgotPassword;
