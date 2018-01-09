import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Home from './Home';
import Book from './Book';
import CreateBook from './CreateBook';
import Registration from './Registration';

export default () => (
  <BrowserRouter>
    <Switch>
      <Route path="/" exact component={Home} />
      <Route path="/registration" exact component={Registration} />
      <Route path="/book/view/:bookId" component={Book} />
      <Route path="/book/create" component={CreateBook} />
    </Switch>
  </BrowserRouter>
);
