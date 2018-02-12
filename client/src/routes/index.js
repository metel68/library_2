import React from 'react';
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

export default () => (
  <BrowserRouter>
    <Switch>
      <AuthRoute path="/" exact component={Authorization} />
      <PrivateRoute path="/books/list" component={Home} />
      <AuthRoute path="/auth" component={Authorization} />
      <AuthRoute path="/registration" component={Registration} />
      <PrivateRoute path="/book/view/:bookId" component={Book} />
      <PrivateRoute path="/user" component={Profile} />
      <AdminRoute path="/book/create" component={CreateBook} />
      <AdminRoute path="/book/edit/:bookId" component={EditBook} />
    </Switch>
  </BrowserRouter>
);
