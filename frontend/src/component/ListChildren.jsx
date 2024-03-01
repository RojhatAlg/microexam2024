import React, { useState, useEffect } from 'react';

function ChildrenList() {
    const [children, setChildren] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchChildren = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/children');
                if (!response.ok) {
                    throw new Error('Failed to fetch children');
                }
                const data = await response.json();
                setChildren(data);
                setLoading(false);
            } catch (error) {
                setError(error.message);
                setLoading(false);
            }
        };

        fetchChildren();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h2>Children List</h2>
            <ul>
                {children.map(child => (
                    <li key={child.id}>{child.name} - Age: {child.age}</li>
                ))}
            </ul>
        </div>
    );
}

export default ChildrenList;
