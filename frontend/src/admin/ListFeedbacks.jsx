import React, { useState, useEffect } from 'react';

function ListFeedback() {
    const [feedbacks, setFeedbacks] = useState([]);

    useEffect(() => {
        // Fetch feedback messages from the server when the component mounts
        fetchFeedbacks();
    }, []);

    const fetchFeedbacks = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/feedbacks');
            if (response.ok) {
                const data = await response.json();
                console.log(data);
                setFeedbacks(data); // Set the feedbacks state with the fetched data
            } else {
                console.error('Failed to fetch feedbacks:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching feedbacks:', error.message);
        }
    };

    return (
        <div>
            <h2>List of Feedbacks</h2>
            <ul>
                {feedbacks.map((feedback, index) => (
                    <li key={index}>
                        <div>
                            <p>Message: {feedback.messageToAdmin}</p>
                            <p>Email: {feedback.email}</p>
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ListFeedback;
