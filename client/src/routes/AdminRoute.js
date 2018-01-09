import { Route, Redirect } from 'react-router-dom';
import React from 'react';
import { isAuthorized, isAdmin } from '../utils';

export const AdminRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      (isAuthorized() && isAdmin() ? (
        <Component {...props} />
      ) : (
        <Redirect
          to={{
            pathname: '/books/list',
            state: { from: props.location },
          }}
        />
      ))
    }
  />
);
