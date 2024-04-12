import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import Footer from "./Footer.tsx";
import api from './api';

interface ProfilePageProps {
    jwtToken: string | null;
}

interface ProfileInfo {
    username: string;
    email: string;
}

const ProfilePage: React.FC<ProfilePageProps> = ({ jwtToken }) => {
    const {id} = useParams<{ id: string }>();
    const [profile, setProfile] = useState<ProfileInfo | null>(null);

    useEffect(() => {
        if (jwtToken) {
            api.get(`/users/${id}`, {
                headers: {
                    'Authorization': `Bearer ${jwtToken}`
                }
            })
                .then((response) => response.data)
                .then((data: ProfileInfo) => setProfile(data))
                .catch((error) => console.error("Failed to fetch data:", error));
        }
    }, [id, jwtToken]);

    return (
        <div>
            <h1>User Profile</h1>
            {profile ? (
                <div>
                    <h2>{profile.username}</h2>
                    <p>Email: {profile.email}</p>
                </div>
            ) : (
                <p>Loading...</p>
            )}
            <Footer/>
        </div>
    );
};

export default ProfilePage;