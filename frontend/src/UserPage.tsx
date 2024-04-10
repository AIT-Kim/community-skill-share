import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

interface User {
    id: number;
    email: string;
    name: string;
}

const UserPage: React.FC = () => {
    const { id } = useParams<{ id: string }>();
    const [user, setUser] = useState<User | null>(null);

    useEffect(() => {
        fetch(`/api/users/${id}`)
            .then((response) => response.json())
            .then((data: User) => setUser(data))
            .catch((error) => console.error("Failed to fetch data:", error));
    }, [id]);

    return (
        <div>
            <h1>User Profile</h1>
            {user ? (
                <div>
                    <h2>{user.name}</h2>
                    <p>Email: {user.email}</p>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
};

export default UserPage;