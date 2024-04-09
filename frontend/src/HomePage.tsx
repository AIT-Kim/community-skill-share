import React, { useEffect, useState } from 'react';

interface Feature {
    message: string;
    features: string[];
}

const HomePage: React.FC = () => {
    const [data, setData] = useState<Feature | null>(null);

    useEffect(() => {
        fetch('/api/home')
            .then((response) => response.json())
            .then((data: Feature) => setData(data))
            .catch((error) => console.error("Failed to fetch data:", error));
    }, []);

    return (
        <div>
            <header>
                <h1>{data ? data.message : 'Loading...'}</h1>
            </header>
            <nav>
                <ul>
                    <li>Home</li>
                    <li>About</li>
                    <li>Services</li>
                    <li>Contact</li>
                </ul>
            </nav>
            <main>
                {data && data.features.map((feature, index) => (
                    <section key={index}>
                        <h2>{feature}</h2>
                        <p>description.</p>
                    </section>
                ))}
            </main>
            <footer>
                <p>&copy; 2024 Your Website Name</p>
            </footer>
        </div>
    );
};

export default HomePage;
