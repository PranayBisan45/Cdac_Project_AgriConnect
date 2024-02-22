import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "../Home";
import Plant from "../Plants";
import PotPlants from "../PotPlants";
import SeedsBulbs from "../SeedsBulbs";
import PlantFood from "../PlantsFood";
import ArtificialPlants from "../ArtificialPlants";
import PumpSpray from "../PumpSpray";
import PlantCare from "../PlantCare";
// import AboutUs from "../AboutUs";
import Contact from "../Contact";
import PlantsDetails from "../PlantDetails";
import Pebbles from "../Pebbles";
import PageNotFound from "../PageNotFound";
import Cart from "../Cart";
import Otp from "../Login/Component/Otp";
import Login from "../Login/Component/Login";
import Registeration from "../Login/Component/Registeration";
import ForgetPassword from "../Login/Component/ForgetPassword";
import NewPassword from "../Login/Component/NewPassword";
import PaymentGateway from "../PaymentGateway";
import Final from "../Final";
import PotPlantsDetail from "../PotPlantsDetail";
import PlantsFoodDetail from "../PlantsFoodDetail";
import ShowProfile from "../SlideBar/ShowProfile";
import EditAddress from "../SlideBar/EditAddress";
import Orders from "../SlideBar/Orders";
import OrderProducts from "../SlideBar/OrderProducts";
import AboutUs from "../Policy/AboutUs";
import ShippingPolicy from "../Policy/ShippingPolicy";
import PrivacyPolicy from "../Policy/PrivacyPolicy";
import RefundPolicy from "../Policy/RefundPolicy";
import TermsOfService from "../Policy/TermOfService";
const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/plant" element={<Plant />} />
      <Route path="/potplants" element={<PotPlants />} />
      <Route path="/seedbulbs" element={<SeedsBulbs />} />
      <Route path="/plantfood" element={<PlantFood />} />
      <Route path="/artificialplants" element={<ArtificialPlants />} />
      <Route path="/pumpspray" element={<PumpSpray />} />
      <Route path="/plantcare" element={<PlantCare />} />
      <Route path="/aboutus" element={<AboutUs />} />
      <Route path="/contact" element={<Contact />} />
      <Route path="/cart" element={<Cart />} />
      <Route path="/pebbles" element={<Pebbles />} />
      <Route path="/login" element={<Login />} />
      <Route path="/final" element={<Final />} />
      <Route path="/sp" element={<ShippingPolicy />} />
      <Route path="/rp" element={<RefundPolicy />} />
      <Route path="/tp" element={<TermsOfService />} />
      <Route path="/pp" element={<PrivacyPolicy />} />
      <Route path="/registration" element={<Registeration />} />
      <Route path="/forgotpassword" element={<ForgetPassword />} />
      <Route path="/otp" element={<Otp />} />
      <Route path="/newpassword" element={<NewPassword />} />
      <Route path="/plantsdetails/:pid" element={<PlantsDetails />} />
      <Route path="/potplantsdetails/:pid" element={<PotPlantsDetail />} />
      <Route path="/plantsfooddetails/:pid" element={<PlantsFoodDetail />} />
      <Route path="/paymentgateway" element={<PaymentGateway />} />
      <Route path="/EditAddress" element={<EditAddress />} />
      <Route path="/Orders" element={<Orders />} />
      {/* <Route path="/aboutus" element={<AboutUs />} /> */}
      <Route path="/OrderProducts/:orderId" element={<OrderProducts />} />
      <Route path="/ShowProfile" element={<ShowProfile />} />
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
};

export default AllRoutes;
