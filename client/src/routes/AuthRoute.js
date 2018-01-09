import { Route, Redirect } from 'react-router-dom';
import React from 'react';
import { isAuthorized } from '../utils';

export const AuthRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      (!isAuthorized() ? (
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
