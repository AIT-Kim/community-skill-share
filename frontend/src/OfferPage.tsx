import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

interface Offer {
    id: number;
    skill: string;
    user: string;
    description: string;
}

const OfferPage: React.FC = () => {
    const { id } = useParams<{ id: string }>();
    const [offer, setOffer] = useState<Offer | null>(null);

    useEffect(() => {
        fetch(`/api/skill-offers/${id}`)
            .then((response) => response.json())
            .then((data: Offer) => setOffer(data))
            .catch((error) => console.error("Failed to fetch data:", error));
    }, [id]);

    return (
        <div>
            <h1>Skill Offer</h1>
            {offer ? (
                <div>
                    <h2>{offer.skill}</h2>
                    <p>Offered by: {offer.user}</p>
                    <p>{offer.description}</p>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
};

export default OfferPage;