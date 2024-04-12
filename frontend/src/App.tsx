// App.tsx
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './HomePage';
import SkillOffersPage from "./SkillOffersPage";
import UserPage from "./UserPage";
import OfferPage from "./OfferPage";
import Login from './Login';
import { Link } from 'react-router-dom';

interface User {
    username: string;
    email: string;
    jwtToken: string;
}


const App: React.FC = () => {
    const [user, setUser] = useState<User | null>(null);

    const handleLogin = (email: string, password: string) => {
        // Call your API here
        fetch('/api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        })
        .then(response => response.json())
        .then((data: User) => {
            // Handle the response from the API
            setUser(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    };

    return (
        <Router>
            <nav>
                {user ? (
                    <Link to={`/user/${user.username}`}>{user.username}</Link>
                ) : (
                    <Login onLogin={handleLogin} />
                )}
            </nav>
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