import React, { useState } from 'react';
import './CrateChild.css'; // Import CSS file for styling

function CreateChildForm() {
    const [childName, setChildName] = useState('');
    const [childAge, setChildAge] = useState('');
    const [parent, setParent] = useState(''); // Update state variable name to 'parent'
    const [successMessage, setSuccessMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleChange = (event) => {
        const { name, value } = event.target;
        if (name === 'name') {
            setChildName(value);
        } else if (name === 'age') {
            setChildAge(value);
        } else if (name === 'parent') { // Update condition for 'parent'
            setParent(value); // Update state variable name to 'parent'
        }
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/api/children/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name: childName, age: childAge, parent: parent }) // Update variable name to 'parent'
            });
            if (response.ok) {
                setSuccessMessage('Child created successfully!');
                setErrorMessage('');
                // Clear form fields after successful submission
                setChildName('');
                setChildAge('');
            } else {
                const errorData = await response.json();
                setErrorMessage(errorData.message);
                setSuccessMessage('');
            }
        } catch (error) {
            console.error('Error creating child:', error);
            setErrorMessage('Failed to create child. Please try again.');
            setParent(''); // Update state variable name to 'parent'
            setSuccessMessage('');
        }
    };

    return (
        <div className="create-child-form-container">
            <h2>Create Child</h2>
            {successMessage && <div className="success-message">{successMessage}</div>}
            {errorMessage && <div className="error-message">{errorMessage}</div>}
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>Name:</label>
                    <input
                        type="text"
                        name="name"
                        value={childName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Age:</label>
                    <input
                        type="number"
                        name="age"
                        value={childAge}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="form-group">
                    <label>Parent:</label>
                    <input
                        type="text"
                        name="parent"
                        value={parent}
                        onChange={handleChange}
                        required
                    />
                </div>
                <button type="submit" className="submit-button">Create Child</button>
            </form>
        </div>
    );
}

export default CreateChildForm;
