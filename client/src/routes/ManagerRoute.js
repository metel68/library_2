import { Route, Redirect } from 'react-router-dom';
import React from 'react';
import { isAuthorized, isManager } from '../utils';

export const ManagerRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={props =>
      (isAuthorized() && isManager() ? (
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
