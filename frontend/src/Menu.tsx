import React from 'react';
import styles from './HomePage.module.css';
import { Link } from 'react-router-dom';
import { User } from './App';

interface MenuProps {
    user: User | null;
}

const Menu: React.FC<MenuProps> = ({ user }) => {
    return (
        <nav className={styles.nav}>
            <ul className={styles.menu}>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/skill-offers">Skill Offers</Link></li>
                {user && <li><Link to="/account">Account</Link></li>}
                <li>About</li>
                <li>Services</li>
                <li>Contact</li>
            </ul>
        </nav>
    );
};

export default Menu;