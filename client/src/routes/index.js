import React, {Component} from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';

import Home from './Home';
import Book from './Book';
import CreateBook from './CreateBook';
import EditBook from './EditBook';
import Registration from './Registration';
import Authorization from './Authorizations';
import {PrivateRoute} from './PrivateRoute';
import {AdminRoute} from './AdminRoute';
import {AuthRoute} from './AuthRoute';
import Profile from './Profile';
import UserAdmin from "./UserAdmin";
import {ManagerRoute} from "./ManagerRoute";

export default class Main extends Component {
  componentDidMount() {
    document.title = "АБИС им. Юрия Мищенко";
  }

  render() {
    return (<BrowserRouter>
      <Switch>
        <AuthRoute path="/" exact component={Authorization}/>
        <PrivateRoute path="/books/list" component={Home}/>
        <AuthRoute path="/auth" component={Authorization}/>
        <AuthRoute path="/registration" component={Registration}/>
        <PrivateRoute path="/book/view/:bookId" component={Book}/>
        <PrivateRoute path="/user/current" component={Profile}/>
        <AdminRoute path="/user/:id" component={Profile}/>
        <AdminRoute path="/users/list" component={UserAdmin}/>
        <ManagerRoute path="/book/create" component={CreateBook}/>
        <ManagerRoute path="/book/edit/:bookId" component={EditBook}/>
      </Switch>
    </BrowserRouter>);
  }
}
