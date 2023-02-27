import React from "react";
import './navbar.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid, regular, brands, icon } from '@fortawesome/fontawesome-svg-core/import.macro' // <-- import styles to be used

function Navbar() {
    return (
        <div className="my-navbar">
            <div className="navbar-title">
                <FontAwesomeIcon icon={solid('building-columns')} /> Banka
            </div>
        </div>
    );
}

export default Navbar;