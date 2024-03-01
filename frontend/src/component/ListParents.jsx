import React, { useState, useEffect } from 'react';

function ParentsList() {
    const [parents, setParents] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchParents = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/parents');
                if (response.ok) {
                    const data = await response.json();
                    setParents(data);
                    setError(null);
                } else {
                    throw new Error('Failed to fetch parents');
                }
            } catch (error) {
                setError(error.message);
            }
        };

        fetchParents();
    }, []);

    return (
        <div>
            <h2>Parents List</h2>
            {error && <div>Error: {error}</div>}
            <ul>
                {parents.map(parent => (
                    <li key={parent.id}>
                        <strong>{parent.name}</strong> - {parent.age} years old
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ParentsList;
