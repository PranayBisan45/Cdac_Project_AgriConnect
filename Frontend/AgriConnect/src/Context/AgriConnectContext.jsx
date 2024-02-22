import { createContext, useState } from "react";

export let ContextApi = createContext();

const CustomContextProvider = ({ children }) => {
  let [cart, setCart] = useState([]);
  let [auth, setAuth] = useState(false);
  let [useDetail, setUserDetail] = useState({ mobileno: "", userid: "" });
  return (
    <ContextApi.Provider
      value={{ cart, setCart, auth, setAuth, useDetail, setUserDetail }}
    >
      {children}
    </ContextApi.Provider>
  );
};

export default CustomContextProvider;
