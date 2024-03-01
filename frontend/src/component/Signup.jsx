import React, { useState } from 'react';

function SignUpForm({ onSignUp }) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, password })
            });
            if (response.ok) {
                setError('');
                onSignUp(email); // Assuming you want to pass the email of the signed-up user
            } else {
                const errorData = await response.json();
                setError(errorData.message || 'Failed to sign up. Please try again.');
            }
        } catch (error) {
            setError('Failed to sign up. Please try again.');
        }
    };

    return (
        <div style={{ textAlign: 'center', padding: '20px' }}> {/* Apply home-page style */}
            <h2>Sign Up</h2>
            {error && <div>{error}</div>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        style={{ width: '20%', padding: '10px', marginBottom: '15px', border: '1px solid #ccc', borderRadius: '5px' }} // Apply inline styles
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        style={{ width: '20%', padding: '10px', marginBottom: '15px', border: '1px solid #ccc', borderRadius: '5px' }} // Apply inline styles
                        required
                    />
                </div>
                <button type="submit" style={{ width: '20%', padding: '10px', backgroundColor: '#007bff', color: '#fff', border: 'none', borderRadius: '5px', cursor: 'pointer' }}>Sign Up</button> {/* Apply inline styles */}
            </form>
        </div>
    );
}

export default SignUpForm;
