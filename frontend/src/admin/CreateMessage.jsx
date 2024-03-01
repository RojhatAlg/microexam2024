import React, { useState } from 'react';

function MessageForm({ onSubmit }) {
    const [message, setMessage] = useState('');

    const handleChange = (event) => {
        setMessage(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/messages', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ message: message })
            });
            if (response.ok) {
                console.log('Message sent successfully');
                onSubmit();
                setMessage('');
            } else {
                console.error('Failed to send message:', response.statusText);
            }
        } catch (error) {
            console.error('Error sending message:', error.message);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <textarea
                value={message}
                onChange={handleChange}
                placeholder="Type your message here..."
                rows={4}
                cols={50}
            />
            <br />
            <button type="submit">Submit</button>
        </form>
    );
}

export default MessageForm;
