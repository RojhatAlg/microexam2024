import React, { useState, useEffect } from 'react';

const MessageList = () => {
    const [messages, setMessages] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchMessages = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/feedbacks');
                if (!response.ok) {
                    throw new Error('Failed to fetch messages');
                }
                const data = await response.json();
                setMessages(data);
                setLoading(false);
            } catch (error) {
                setError('Error fetching messages');
                setLoading(false);
            }
        };

        fetchMessages();
    }, []);

    const handleButtonClick = () => {
        // Add your button click logic here
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    return (
        <div>
            <div className="chatbox">
                {messages.map((message, index) => (
                    <p key={index} className="message">{message.messageToAdmin}</p>
                ))}
            </div>
            <button onClick={handleButtonClick} className="button">Add Message</button>
            <div className="text-below-messages">
                <textarea/>
            </div>
        </div>
    );
};

export default MessageList;
