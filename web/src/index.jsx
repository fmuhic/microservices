import './index.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import {
    createBrowserRouter,
    RouterProvider
} from 'react-router-dom';
import DefaultLayout from './components/layouts/DefaultLayout'
import Home from './components/home/Home'
import Transactions from './components/transactions/Transactions'

const router2 = createBrowserRouter([
    {
        path: '/',
        element: <DefaultLayout />,
        children: [
            {
                path: '/',
                element: <Home />
            },
            {
                path: '/transactions',
                element: <Transactions />
            }
        ]
    }
])

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <RouterProvider router={router2} />
    </React.StrictMode>
);
