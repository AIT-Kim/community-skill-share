import React, { useEffect, useState } from 'react';
import styles from './HomePage.module.css';
import Footer from './Footer';
import api from './api';

interface Feature {
    message: string;
    features: string[];
}

const HomePage: React.FC = () => {
    const [data, setData] = useState<Feature | null>(null);

    useEffect(() => {
        api.get('/home')
            .then((response) => response.data)
            .then((data: Feature) => setData(data))
            .catch((error) => console.error("Failed to fetch data:", error));
    }, []);

    return (
        <div className={styles.container}>
            <header className={styles.header}>
                <h1>{data ? data.message : 'Loading...'}</h1>
            </header>
            <main className={styles.main}>
                <h2>Features</h2>
                {data && data.features.map((feature, index) => (
                    <section className={styles.feature} key={index}>
                        <h3>{feature}</h3>
                        <p>Description of the feature.</p>
                    </section>
                ))}
            </main>
            <Footer />
        </div>
    );
};

export default HomePage;
