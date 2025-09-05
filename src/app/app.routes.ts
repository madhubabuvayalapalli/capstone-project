import { Routes } from '@angular/router';
import { Login } from './pages/login/login';
import { Adminlist } from './pages/adminlist/adminlist';
import { Customerlist } from './pages/customerlist/customerlist';
import { Loanapplicationlist } from './pages/loanapplicationlist/loanapplicationlist';
import { Newloanform } from './pages/newloanform/newloanform';
import { Registerc } from './pages/registerc/registerc';
import { Home } from './pages/home/home';

export const routes: Routes = [

    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path:'home',
        component:Home
    },
    {
        path:'login',
        component:Login
    },
    {
        path:'adminlist',
         component:Loanapplicationlist
    
    },
    {
        path:'customerlist',
        component:Customerlist
    },
    {
        path:'loanapplicationslist',
        component:Loanapplicationlist
    },
    {
        path:'new-loan',
        component:Newloanform
    },
    {
        path:'registerc',
        component:Registerc
    }
];
