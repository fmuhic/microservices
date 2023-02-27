import React from "react";
import './navbar.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { light, regular, solid } from '@fortawesome/fontawesome-svg-core/import.macro'

function Navbar() {
    return (
        <div className="my-navbar">
            <div className="navbar-title"><FontAwesomeIcon icon={solid('building-columns')} /> Banka</div>
            <div id="navbar-bars"><FontAwesomeIcon icon={solid('bars')} /></div>
        </div>
    );
}

export default Navbar;