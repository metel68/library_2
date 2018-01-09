import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Home from './Home';
import Book from './Book';
import CreateBook from './CreateBook';
import Registration from './Registration';
import Authorization from './Authorizations';
import { PrivateRoute } from './PrivateRoute';
import { AdminRoute } from './AdminRoute';
import { AuthRoute } from './AuthRoute';

export default () => (
  <BrowserRouter>
    <Switch>
      <AuthRoute path="/" exact component={Authorization} />
      <PrivateRoute path="/books/list" component={Home} />
      <AuthRoute path="/auth" component={Authorization} />
      <AuthRoute path="/registration" component={Registration} />
      <PrivateRoute path="/book/view/:bookId" component={Book} />
      <AdminRoute path="/book/create" component={CreateBook} />
    </Switch>
  </BrowserRouter>
);
