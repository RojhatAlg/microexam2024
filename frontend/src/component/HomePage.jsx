import React from 'react';
import { Link } from 'react-router-dom';
import './HomePage.css'; // Import the CSS file

function HomePage() {
    return (
        <div className="home-page" style={{ marginTop: '100px' }}>
            <header>
                <div className="header-container">
                    <Link to="/" className="logo-link">
                        <h1>Oslo Kindergarten</h1>
                    </Link>
                    <nav>
                        <Link to="/login" className="login-button">Login</Link>
                        <span className="navbar-margin"></span>
                        <Link to="/signup" className="signup-link">Sign Up</Link>
                    </nav>
                </div>
            </header>
            <main>
                <h2>Welcome to Oslo Kindergarten</h2>
                <p>This is the best place for your child to learn and grow!</p>
            </main>
        </div>
    );
}

export default HomePage;
