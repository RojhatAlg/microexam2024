import React, { useContext, useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FaUsers,  FaPlus, FaInbox } from 'react-icons/fa';
import { useLogout } from '../component/Logout';
import './navigation-bar.css';

function Navigation() {

    const { logout } = useLogout();

    const logOutHandler = () => {
        logout();
    };

    return (
        <header>
            <div className="container">
                <Link  style={{ fontFamily: "serif", fontWeight: 'bold', textDecoration: 'none', color: 'black' }}  to="/"><h4>Oslo Kindergarden</h4></Link>
                    <div className="admin-menu">
                        <span className="email">#user name#</span>
                        <div className="dropdown" title="Lists" id="adminMenu">
                            <button className="dropbtn">Admin Menu</button>
                            <div className="dropdown-content">
                                <Link to="/components/ChildrenForEachParent">Children in Kindergarden</Link>

                                <Link to="/userslist">
                                    <FaUsers/> Parents List
                                </Link>
                                <Link to="/admin/createChild">
                                    <FaPlus/> Create Child
                                </Link>
                                <Link to="/admin/Message">
                                    <FaInbox/> Send messages to all parents
                                </Link>
                                <Link to="/admin/feedbacks">
                                    <FaInbox/> See feedbacks from parents
                                </Link>
                            </div>
                            <button onClick={logOutHandler} className="logout-btn" style={{
                                backgroundColor: 'transparent',
                                border: 'none',
                                color: 'black',
                                cursor: 'pointer'
                            }}>
                                Logout
                            </button>
                        </div>
                    </div>

            </div>
        </header>
    );
}

export default Navigation;