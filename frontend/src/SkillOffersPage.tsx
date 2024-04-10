import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

interface SkillOffer {
    id: number;
    skill: string;
    user: string;
    user_id: number;
    skill_id: number;
    description: string;
}

const SkillOffersPage: React.FC = () => {
    const [offers, setOffers] = useState<SkillOffer[] | null>(null);

    useEffect(() => {
        fetch('/api/skill-offers')
            .then((response) => response.json())
            .then((data: SkillOffer[]) => setOffers(data))
            .catch((error) => console.error("Failed to fetch data:", error));
    }, []);

    return (
        <div>
            <h1>Skill Offers</h1>
            {offers ? (
                <ul>
                    {offers.map((offer, index) => (
                        <li key={index}>
                            <h2><Link to={`/offer/${offer.id}`}>{offer.description}</Link></h2>
                            <p>Offered by: <Link to={`/user/${offer.user_id}`}>{offer.user}</Link></p>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
};

export default SkillOffersPage;