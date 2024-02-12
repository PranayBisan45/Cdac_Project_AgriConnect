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
import AboutUs from "../AboutUs";
import Contact from "../Contact";
import PageNotFound from "../PageNotFound";

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
      <Route path="*" element={<PageNotFound />} />
    </Routes>
  );
};

export default AllRoutes;
