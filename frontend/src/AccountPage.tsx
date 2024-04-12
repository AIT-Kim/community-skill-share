import React, { useEffect, useState } from 'react';
import { User } from './App';
import api from './api';

interface AccountPageProps {
    user: User | null;
    onUnauthorized: () => void;
}

const AccountPage: React.FC<AccountPageProps> = ({ user, onUnauthorized }) => {
    const [accountInfo, setAccountInfo] = useState<User | null>(null);

    useEffect(() => {
        if (user) {
            api.get('/users/me', {
                headers: {
                    'Authorization': `Bearer ${user.jwtToken}`
                }
            })
                .then(response => response.data)
                .then(data => setAccountInfo(data))
                .catch(error => {
                    if (error.message === 'Unauthorized') {
                        onUnauthorized();
                    } else {
                        console.error('Error:', error);
                    }
                });
        }
    }, [user, onUnauthorized]);

    return (
        <div>
            {accountInfo && (
                <div>
                    <h1>{accountInfo.username}</h1>
                    <p>{accountInfo.email}</p>
                </div>
            )}
        </div>
    );
};

export default AccountPage;