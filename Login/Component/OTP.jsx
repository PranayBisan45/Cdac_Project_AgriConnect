import React from 'react';
import Style from '../CSS/OTP.css'; // Make sure to provide the correct path to your CSS file

const OTP = () => {
  return (
    <div className="d-flex justify-content-center align-items-center container">
      <div className="card py-5 px-3">
      <h5 className="m-0">Mobile phone verification</h5>
        <span className="mobile-text">
          Enter the code we just sent on your mobile phone{' '}
          <b className="text-danger">+91 9552007193</b>
        </span>
        <div className="d-flex flex-row mt-5">
          <input type="text" className="form-control" autoFocus />
          <input type="text" className="form-control" />
          <input type="text" className="form-control" />
          <input type="text" className="form-control" />
          <input type="text" className="form-control" />
          <input type="text" className="form-control" />
        </div>
        <div className="row justify-content-end">
                <div className="form-group col-sm-6">
                  <button type="submit" className="btn-block btn-primary">Submit</button>
                </div>
              </div>
        <div className="text-center mt-5">
          <span className="d-block mobile-text">
            Don't receive the code?
            </span>
          <span className="font-weight-bold text-danger cursor">Resend</span>
        </div>
      </div>
    </div>
  );
};

export default OTP;
