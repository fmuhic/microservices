import React from "react";
import './navbar.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid } from '@fortawesome/fontawesome-svg-core/import.macro'
// import Button from 'react-bootstrap/Button';
import { showTime } from "../..";

function Navbar() {
    return (
        <div className="my-navbar">
            <div className="navbar-title">
                <FontAwesomeIcon icon={solid('building-columns')} />
                <div className="navbar-title-bank">Banka</div>
            </div>

            <div className="navbar-right-side">
                <div className="navbar-options">
                    <div className="navbar-option">Transakcije</div>
                    <div className="navbar-option">Proizvodi</div>
                    <div className="navbar-option">Alati</div>
                </div>

                <div className="navbar-profile">
                    <div className="navbar-profile-item last-login">Last login: {showTime}</div>
                    <div className="navbar-profile-item navbar-profile-messages"><FontAwesomeIcon icon={solid('envelope')} /></div>
                    <div className="navbar-profile-item navbar-profile-user"><FontAwesomeIcon icon={solid('user')} /></div>
                </div>
            </div>

        </div>
    );
}

export default Navbar;