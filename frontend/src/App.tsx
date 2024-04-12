// App.tsx
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './HomePage';
import SkillOffersPage from "./SkillOffersPage";
import ProfilePage from "./ProfilePage.tsx";
import OfferPage from "./OfferPage";
import Login from './Login';
import { Link } from 'react-router-dom';
import AccountPage from "./AccountPage.tsx";
import Menu from './Menu';



export interface User {
    username: string;
    email: string;
    jwtToken: string;
}

const App: React.FC = () => {
    const [user, setUser] = useState<User | null>(null);

    useEffect(() => {
        const savedUser = localStorage.getItem('user');
        if (savedUser) {
            setUser(JSON.parse(savedUser));
        }
    }, []);

    const handleLogin = (email: string, password: string) => {
        fetch('/api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        })
        .then(response => response.json())
        .then((data: User) => {
            setUser(data);
            localStorage.setItem('user', JSON.stringify(data));
        })
        .catch(error => {
            console.error('Error:', error);
        });
    };

    const handleLogout = () => {
        setUser(null);
        localStorage.removeItem('user');
    };

    const handleUnauthorized = () => {
        setUser(null);
        localStorage.removeItem('user');
    };

    return (
        <Router>
            <nav>
                {user ? (
                    <>
                        <Link to={`/user/${user.username}`}>{user.username}</Link>
                        <button onClick={handleLogout}>Logout</button>
                    </>
                ) : (
                    <Login onLogin={handleLogin}/>
                )}
            </nav>
            <Menu user={user} />
            <Routes>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/skill-offers" element={<SkillOffersPage/>}/>
                <Route path="/users/:id" element={<ProfilePage jwtToken={user?.jwtToken || null}/>}/>
                <Route path="/offer/:id" element={<OfferPage/>}/>
                <Route path="/account" element={<AccountPage user={user} onUnauthorized={handleUnauthorized}/>}/>
            </Routes>
        </Router>
    );
};

export default App;