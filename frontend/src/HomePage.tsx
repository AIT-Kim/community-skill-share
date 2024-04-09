import React, { useEffect, useState } from 'react';
import styles from './HomePage.module.css';

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
        <div className={styles.container}>
            <header className={styles.header}>
                <h1>{data ? data.message : 'Loading...'}</h1>
            </header>
            <nav className={styles.nav}>
                <ul className={styles.menu}>
                    <li>Home</li>
                    <li>About</li>
                    <li>Services</li>
                    <li>Contact</li>
                </ul>
            </nav>
            <main className={styles.main}>
                {data && data.features.map((feature, index) => (
                    <section className={styles.feature} key={index}>
                        <h2>{feature}</h2>
                        <p>Description of the feature.</p>
                    </section>
                ))}
            </main>
            <footer className={styles.footer}>
                <p>&copy; 2024 </p>
            </footer>
        </div>
    );
};

export default HomePage;
