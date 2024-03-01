import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Using useNavigate for navigation
import './Login.css'; // Import CSS file

function LoginForm({ onLogin }) {
    const navigate = useNavigate(); // Access to navigation function

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            // Fetch all users from the database
            const response = await fetch('http://localhost:8080/api/users');
            if (!response.ok) {
                throw new Error('Failed to fetch users');
            }
            const users = await response.json();

            // Find the user attempting to log in
            const userToLogin = users.find(user => user.email === email && user.password === password);

            if (userToLogin) {
                // User exists in the database
                if (userToLogin.role === 'admin') {
                    // Redirect to the dashboard page if the user's role is admin
                    navigate('/screen/navigation-bar');
                } else {
                    navigate('/components/messageFromAdmin');

                }
                // Clear form fields and errors
                setEmail('');
                setPassword('');
                setError('');
            } else {
                // If user does not exist, display an error message
                setError('User does not exist or invalid credentials. Please try again.');
            }
        } catch (error) {
            // If an error occurs during the fetch operation, display an error message
            setError('Failed to log in. Please try again.');
        }
    };

    return (
        <div className="form-container">
            <h2>Login</h2>
            {error && <div className="error-message">{error}</div>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    );
}

export default LoginForm;
