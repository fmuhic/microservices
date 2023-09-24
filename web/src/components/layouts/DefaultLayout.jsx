import React from 'react'
import { NavLink, Outlet } from 'react-router-dom'

export default function DefaultLayout() {
    return (
        <div className="default-layout">
            <header>
                <nav>
                    <NavLink to='/'>Home</NavLink>
                    <NavLink to='/transactions'>Transactions</NavLink>
                </nav>
            </header>
            <main>
                <Outlet />
            </main>
        </div>
    )
}
