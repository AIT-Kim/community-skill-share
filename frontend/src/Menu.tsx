import React from 'react';
import styles from './HomePage.module.css';
import { Link } from 'react-router-dom';

const Menu: React.FC = () => {
    return (
        <nav className={styles.nav}>
            <ul className={styles.menu}>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/skill-offers">Skill Offers</Link></li>
                <li>About</li>
                <li>Services</li>
                <li>Contact</li>
            </ul>
        </nav>


)
    ;
};

export default Menu;