import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './HomePage';
import SkillOffersPage from "./SkillOffersPage.tsx";
import UserPage from "./UserPage.tsx";
import OfferPage from "./OfferPage.tsx";

const App: React.FC = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/skill-offers" element={<SkillOffersPage />} />
                <Route path="/user/:id" element={<UserPage />} />
                <Route path="/offer/:id" element={<OfferPage />} />
            </Routes>
        </Router>
    );
};

export default App;
