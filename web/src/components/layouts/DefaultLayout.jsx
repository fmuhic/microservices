import "./defaultLayout.css"
import React from 'react'
import { NavLink, Outlet } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBitcoin } from '@fortawesome/free-brands-svg-icons'
import {
    faRightFromBracket,
    faUser,
    faHouse,
    faWallet
} from '@fortawesome/free-solid-svg-icons'


export default function DefaultLayout() {
    return (
        <div className="default-layout">
            <nav className='header-navbar'>
                <div className='header-navbar-content'>
                    <div className='header-navbar-left'>
                        <FontAwesomeIcon className='logo-icon' icon={faBitcoin} />
                    </div>
                    <div className='header-navbar-right'>
                        <FontAwesomeIcon className='nav-icon' icon={faRightFromBracket} />
                        <FontAwesomeIcon className='nav-icon' icon={faUser} />
                    </div>
                </div>
            </nav>
            <nav className='page-navbar'>
                <NavLink className='nav-link' to='/'>
                    <FontAwesomeIcon className='nav-link-icon' icon={faHouse} />
                    <div>Home</div>
                </NavLink>
                <NavLink className='nav-link' to='/transactions'>
                    <FontAwesomeIcon className='nav-link-icon' icon={faWallet} />
                    <div>Transactions</div>
                </NavLink>
            </nav>
            <Outlet />
        </div>
    )
}
