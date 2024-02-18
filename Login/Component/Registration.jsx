// import React, { useState } from 'react';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import style from "../CSS/Registration.css";

// const Registration = () => {
//   const [formData, setFormData] = useState({
//     fname: '',
//     lname: '',
//     email: '',
//     ladd: '',
//     lpin: '',
//     lstate: '',
//     gender: '',
//     mob: '',
//     pass: ''
//   });

//   const handleChange = (e) => {
//     const { name, value } = e.target;
//     setFormData({ ...formData, [name]: value });
//   };

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     // Add your form submission logic here
//     console.log('Form submitted:', formData);
//   };

//   const validate = (fieldNumber) => {
//     // Add your validation logic here if needed
//     console.log(`Validating field ${fieldNumber}`);
//   };

//   return (
//     <div className="container-fluid px-5 py-5 mx-auto">
//       <div className="row d-flex justify-content-center">
//       <div className="col-xl-7 col-lg-8 col-md-9 col-11 text-center">

//           <br />
//           <br />
//           <br />
//           <img src="/logo.png" alt="Logo" className="logo" />
//           <h3>AgriConnect</h3>
//           <br />
//           <p className="blue-text">"Unlock exclusive benefits and personalized experiences by completing our quick registration form<br/> – your gateway to a tailored user journey awaits!"</p>
//           <div className="card">
//             <h5 className="text-center mb-4">Connect with us!</h5>
//             <form className="form-card" onSubmit={handleSubmit}>
//               <div className="row justify-content-between text-left">
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">First Name<span className="text-danger"> *</span></label>
//                   <input type="text" id="fname" name="fname" placeholder="Enter your first name" onBlur={() => validate(1)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Last Name<span className="text-danger"> *</span></label>
//                   <input type="text" id="lname" name="lname" placeholder="Enter your last name" onBlur={() => validate(2)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Business Email<span className="text-danger"> *</span></label>
//                   <input type="text" id="email" name="email" placeholder="Enter your Email" onBlur={() => validate(3)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Address<span className="text-danger"> *</span></label>
//                   <input type="text" id="ladd" name="ladd" placeholder="Enter your Address" onBlur={() => validate(4)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Pincode<span className="text-danger"> *</span></label>
//                   <input type="text" id="lpin" name="lpin" placeholder="Enter your Pincode" onBlur={() => validate(5)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">State<span className="text-danger"> *</span></label>
//                   <input type="text" id="lstate" name="lstate" placeholder="Enter your State name" onBlur={() => validate(6)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Gender<span className="text-danger"> *</span></label>
//                   <input type="text" id="gender" name="gender" placeholder="Enter your Gender" onBlur={() => validate(7)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Whatsapp Number<span className="text-danger"> *</span></label>
//                   <input type="text" id="mob" name="mob" placeholder="Enter your Whatsapp Number" onBlur={() => validate(8)} onChange={handleChange} />
//                 </div>
//                 <div className="form-group col-sm-6 flex-column d-flex">
//                   <label className="form-control-label px-3">Password<span className="text-danger"> *</span></label>
//                   <input type="password" id="pass" name="pass" placeholder="Enter your Password" onBlur={() => validate(9)} onChange={handleChange} />
//                 </div>
//               </div>
//               <div className="row justify-content-end">
//                 <div className="form-group col-sm-6">
//                   <button type="submit" className="btn-block btn-primary">Submit</button>
//                 </div>
//               </div>
//             </form>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

// export default Registration;
