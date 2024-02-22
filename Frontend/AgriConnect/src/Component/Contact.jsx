import React from "react";
import style from "../CSS/Contact.module.css";

const Contact = () => {
  return (
    <div>
      <div id={style.contactPoster}>
        <h1>Contact Us</h1>
        <h4>
          Got a question or need to get in touch? Just fill out the form below
          and we'll be in touch soon – we're here to help and eager to hear from
          you!
        </h4>
      </div>
      <div id={style.ContactForm}>
        <h2>Contact Us</h2>
        <form action="https://formspree.io/f/myyreqjv" method="POST">
          <label for="username">UserName</label>
          <input
            type="text"
            id="username"
            name="username"
            required
            autoComplete="off"
          />
          <label for="email">Email</label>
          <input
            type="email"
            id="email"
            name="email"
            required
            autoComplete="off"
          />
          <label for="message">Message</label>
          <textarea
            type="text"
            name="message"
            id="message"
            cols={30}
            rows={10}
            autoComplete="off"
            required
          ></textarea>
          <button>Submit</button>
        </form>
      </div>
    </div>
  );
};

export default Contact;
