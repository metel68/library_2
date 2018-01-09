import { Route, Redirect } from 'react-router-dom';
import React from 'react';
import { isAuthorized } from '../utils';

export const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      (isAuthorized() ? (
        <Component {...props} />
      ) : (
        <Redirect
          to={{
            pathname: '/auth',
            state: { from: props.location },
          }}
        />
      ))
    }
  />
);
